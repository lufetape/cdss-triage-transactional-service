package api.service;

import java.util.List;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import api.dto.PatientDTO;
import api.dto.response.ResponsePatientDTO;
import api.dto.response.ResponsePatientListDTO;
import api.dto.response.ResponseStatusDTO;
import api.mapper.IPatientResourceMapper;
import businesslogic.bo.PatientBO;
import businesslogic.service.IPatientService;
import exceptions.TransactionalServiceException;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * This controller contains an action to handle HTTP requests to the
 * Patient Resource
 */
public class PatientResource  extends Controller {
	
	@Inject
	private IPatientService patientService;

	@Inject
	private IPatientResourceMapper patientResourceMapper;
	
	public Result list() {

		response().setHeader("Access-Control-Allow-Origin", "*");

		try {

			List<PatientBO> patientBOLst = patientService.list();
			List<PatientDTO> patientDTOLst = patientResourceMapper
					.mapDTOListFromBOList(patientBOLst);

			return ok(Json.toJson(new ResponsePatientListDTO(patientDTOLst,
					ResponseStatusDTO.createOkRequestResponse("Patient listed"))));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponsePatientListDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponsePatientListDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}

	}
	
	public Result get(long id) {

		try {

			PatientDTO patientDTO =  patientResourceMapper.mapDTOFromBO(patientService.get(id));

			if (patientDTO == null || patientDTO.getId() <= 0) {

				return ok(Json.toJson(new ResponsePatientDTO(null,
						ResponseStatusDTO.createWarnRequestResponse(103, "Patient not found"))));
			}

			return ok(Json.toJson(patientDTO));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponsePatientDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponsePatientDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}
	}
	
	public Result insert() {

		response().setHeader("Access-Control-Allow-Origin", "*");

		PatientDTO patientDTO = null;

		try {

			JsonNode json = request().body().asJson();
			patientDTO = Json.fromJson(json, PatientDTO.class);

		} catch (Exception ex) {

			return ok(Json.toJson(new ResponsePatientDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(101, "Bad Request", ex))));
		}

		try {

			PatientBO patientBO = patientResourceMapper.mapBOFromDTO(patientDTO);
			PatientDTO responsePatientDTO = patientResourceMapper.mapDTOFromBO(
					patientService.insert(patientBO));

			return ok(Json.toJson(new ResponsePatientDTO(responsePatientDTO,
					ResponseStatusDTO.createOkRequestResponse("Patient created successfully"))));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponsePatientDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponsePatientDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}

	}
	
	public Result delete(long id) {

		response().setHeader("Access-Control-Allow-Origin", "*");

		try {

			patientService.delete(id);
			return ok(Json.toJson(ResponseStatusDTO.createOkRequestResponse("Patient deleted successfully")));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex)));

		} catch (Exception e) {

			return ok(Json.toJson(ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e)));
		}

	}

	
	

}
