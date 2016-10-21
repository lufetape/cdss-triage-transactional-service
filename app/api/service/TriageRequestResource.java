package api.service;

import java.util.List;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import api.dto.TriageRequestDTO;
import api.dto.response.ResponseStatusDTO;
import api.dto.response.ResponseTriageRequestDTO;
import api.dto.response.ResponseTriageRequestListDTO;
import api.mapper.ITriageRequestResourceMapper;
import businesslogic.bo.TriageRequestBO;
import businesslogic.service.ITriageRequestService;
import exceptions.TransactionalServiceException;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests to the
 * TriageRequest Resource
 */
public class TriageRequestResource extends Controller {

	@Inject
	private ITriageRequestService triageRequestService;

	@Inject
	private ITriageRequestResourceMapper triageRequestResourceMapper;

	public Result list() {

		response().setHeader("Access-Control-Allow-Origin", "*");

		try {

			List<TriageRequestBO> triageRequestBOLst = triageRequestService.list();
			List<TriageRequestDTO> triageRequestDTOLst = triageRequestResourceMapper
					.mapDTOListFromBOList(triageRequestBOLst);

			return ok(Json.toJson(new ResponseTriageRequestListDTO(triageRequestDTOLst,
					ResponseStatusDTO.createOkRequestResponse("Triage Requests listed"))));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseTriageRequestListDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseTriageRequestListDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}

	}

	public Result get(long id) {

		try {

			TriageRequestDTO triageRequestDTO = triageRequestResourceMapper.mapDTOFromBO(triageRequestService.get(id));

			if (triageRequestDTO == null || triageRequestDTO.getId() <= 0) {

				return ok(Json.toJson(new ResponseTriageRequestDTO(null,
						ResponseStatusDTO.createWarnRequestResponse(103, "Triage Request not found"))));
			}

			return ok(Json.toJson(triageRequestDTO));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseTriageRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseTriageRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}
	}

	public Result insert() {

		response().setHeader("Access-Control-Allow-Origin", "*");

		TriageRequestDTO triageRequestDTO = null;

		try {

			JsonNode json = request().body().asJson();
			triageRequestDTO = Json.fromJson(json, TriageRequestDTO.class);

		} catch (Exception ex) {

			return ok(Json.toJson(new ResponseTriageRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(101, "Bad Request", ex))));
		}

		try {

			TriageRequestBO triageRequestBO = triageRequestResourceMapper.mapBOFromDTO(triageRequestDTO);
			TriageRequestDTO responseTriageRequestDTO = triageRequestResourceMapper.mapDTOFromBO(
					triageRequestService.insert(triageRequestBO));

			return ok(Json.toJson(new ResponseTriageRequestDTO(responseTriageRequestDTO,
					ResponseStatusDTO.createOkRequestResponse("Triage Request created successfully"))));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseTriageRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseTriageRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}

	}

	public Result delete(long id) {

		response().setHeader("Access-Control-Allow-Origin", "*");

		try {

			triageRequestService.delete(id);
			return ok(Json.toJson(ResponseStatusDTO.createOkRequestResponse("Triage Request deleted successfully")));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex)));

		} catch (Exception e) {

			return ok(Json.toJson(ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e)));
		}

	}
}
