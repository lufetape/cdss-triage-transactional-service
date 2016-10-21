package api.service;

import java.util.List;

import javax.inject.Inject;

import api.dto.EHRRequestDTO;
import api.dto.response.ResponseEHRRequestDTO;
import api.dto.response.ResponseEHRRequestListDTO;
import api.dto.response.ResponseStatusDTO;
import api.mapper.IEHRRequestResourceMapper;
import businesslogic.bo.EHRRequestBO;
import businesslogic.service.IEHRRequestService;
import exceptions.TransactionalServiceException;

import com.fasterxml.jackson.databind.JsonNode;

import play.mvc.*;
import play.libs.Json;

public class EHRRequestResource extends Controller {

	@Inject
	private IEHRRequestService ehrRequestService;

	@Inject
	private IEHRRequestResourceMapper ehrRequestResourceMapper;

	public Result list() {

		response().setHeader("Access-Control-Allow-Origin", "*");

		try {

			List<EHRRequestBO> ehrRequestBOLst = ehrRequestService.list();
			List<EHRRequestDTO> ehrRequestDTOLst = ehrRequestResourceMapper.mapDTOListFromBOList(ehrRequestBOLst);

			return ok(Json.toJson(new ResponseEHRRequestListDTO(ehrRequestDTOLst,
					ResponseStatusDTO.createOkRequestResponse("EHR Requests listed"))));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseEHRRequestListDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseEHRRequestListDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}

	}

	public Result get(long id) {

		try {

			EHRRequestDTO ehrRequestDTO = ehrRequestResourceMapper.mapDTOFromBO(ehrRequestService.get(id));

			if (ehrRequestDTO == null || ehrRequestDTO.getId() <= 0) {

				return ok(Json.toJson(new ResponseEHRRequestDTO(null,
						ResponseStatusDTO.createWarnRequestResponse(103, "EHR Request not found"))));
			}

			return ok(Json.toJson(ehrRequestDTO));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseEHRRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseEHRRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}
	}

	public Result insert() {

		response().setHeader("Access-Control-Allow-Origin", "*");

		EHRRequestDTO ehrRequestDTO = null;

		try {

			JsonNode json = request().body().asJson();
			ehrRequestDTO = Json.fromJson(json, EHRRequestDTO.class);

		} catch (Exception ex) {

			return ok(Json.toJson(new ResponseEHRRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(101, "Bad Request", ex))));
		}

		try {

			EHRRequestBO ehrRequestBO = ehrRequestResourceMapper.mapBOFromDTO(ehrRequestDTO);
			EHRRequestDTO responseEHRRequestDTO = ehrRequestResourceMapper
					.mapDTOFromBO(ehrRequestService.insert(ehrRequestBO));

			return ok(Json.toJson(new ResponseEHRRequestDTO(responseEHRRequestDTO,
					ResponseStatusDTO.createOkRequestResponse("EHR Request created successfully"))));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseEHRRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseEHRRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}

	}

	public Result delete(long id) {

		response().setHeader("Access-Control-Allow-Origin", "*");

		try {

			ehrRequestService.delete(id);
			return ok(Json.toJson(ResponseStatusDTO.createOkRequestResponse("EHR Request deleted successfully")));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex)));

		} catch (Exception e) {

			return ok(Json.toJson(ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e)));
		}

	}

}
