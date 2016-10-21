package api.service;

import java.util.List;

import api.dto.InferenceRequestDTO;
import api.dto.response.ResponseInferenceRequestDTO;
import api.dto.response.ResponseInferenceRequestListDTO;
import api.dto.response.ResponseStatusDTO;
import api.mapper.IInferenceRequestResourceMapper;
import businesslogic.bo.InferenceRequestBO;
import businesslogic.service.IInferenceRequestService;
import exceptions.TransactionalServiceException;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import play.mvc.*;
import play.libs.Json;

public class InferenceRequestResource extends Controller {

	@Inject
	private IInferenceRequestService inferenceRequestService;

	@Inject
	private IInferenceRequestResourceMapper inferenceRequestResourceMapper;
	
	
	public Result list() {

		response().setHeader("Access-Control-Allow-Origin", "*");

		try {

			List<InferenceRequestBO> inferenceRequestBOLst = inferenceRequestService.list();
			List<InferenceRequestDTO> inferenceRequestDTOLst = inferenceRequestResourceMapper
					.mapDTOListFromBOList(inferenceRequestBOLst);

			return ok(Json.toJson(new ResponseInferenceRequestListDTO(inferenceRequestDTOLst,
					ResponseStatusDTO.createOkRequestResponse("Inference Requests listed"))));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseInferenceRequestListDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseInferenceRequestListDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}

	}
	
	public Result get(long id) {

		try {

			InferenceRequestDTO inferenceRequestDTO = inferenceRequestResourceMapper.mapDTOFromBO(inferenceRequestService.get(id));

			if (inferenceRequestDTO == null || inferenceRequestDTO.getId() <= 0) {

				return ok(Json.toJson(new ResponseInferenceRequestDTO(null,
						ResponseStatusDTO.createWarnRequestResponse(103, "Inference Request not found"))));
			}

			return ok(Json.toJson(inferenceRequestDTO));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseInferenceRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseInferenceRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}
	}
	
	public Result insert() {

		response().setHeader("Access-Control-Allow-Origin", "*");

		InferenceRequestDTO inferenceRequestDTO = null;

		try {

			JsonNode json = request().body().asJson();
			inferenceRequestDTO = Json.fromJson(json, InferenceRequestDTO.class);

		} catch (Exception ex) {

			return ok(Json.toJson(new ResponseInferenceRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(101, "Bad Request", ex))));
		}

		try {

			InferenceRequestBO inferenceRequestBO = inferenceRequestResourceMapper.mapBOFromDTO(inferenceRequestDTO);
			InferenceRequestDTO responseInferenceRequestDTO = inferenceRequestResourceMapper.mapDTOFromBO(
					inferenceRequestService.insert(inferenceRequestBO));

			return ok(Json.toJson(new ResponseInferenceRequestDTO(responseInferenceRequestDTO,
					ResponseStatusDTO.createOkRequestResponse("Inference Request created successfully"))));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseInferenceRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseInferenceRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}

	}

	public Result delete(long id) {

		response().setHeader("Access-Control-Allow-Origin", "*");

		try {

			inferenceRequestService.delete(id);
			return ok(Json.toJson(ResponseStatusDTO.createOkRequestResponse("Inferebce Request deleted successfully")));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex)));

		} catch (Exception e) {

			return ok(Json.toJson(ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e)));
		}

	}
	

	

}
