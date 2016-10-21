package api.service;

import com.fasterxml.jackson.databind.JsonNode;

import api.dto.HECRequestDTO;
import api.dto.response.ResponseHECRequestDTO;
import api.dto.response.ResponseHECRequestListDTO;
import api.dto.response.ResponseStatusDTO;
import api.dto.response.ResponseTriageRequestDTO;
import api.mapper.IHECRequestResourceMapper;
import businesslogic.bo.HECRequestBO;
import businesslogic.service.IHECRequestService;
import exceptions.TransactionalServiceException;

import java.util.List;

import javax.inject.Inject;
import play.mvc.*;
import play.libs.Json;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HECRequestResource extends Controller {

	/**
	 * An action that renders an HTML page with a welcome message. The
	 * configuration in the <code>routes</code> file means that this method will
	 * be called when the application receives a <code>GET</code> request with a
	 * path of <code>/</code>.
	 */

	@Inject
	private IHECRequestService hecRequestService;

	@Inject
	private IHECRequestResourceMapper hecRequestResourceMapper;

	public Result list() {

		response().setHeader("Access-Control-Allow-Origin", "*");

		try {

			List<HECRequestBO> hecRequestBOLst = hecRequestService.list();
			List<HECRequestDTO> hecRequestDTOLst = hecRequestResourceMapper.mapDTOListFromBOList(hecRequestBOLst);

			return ok(Json.toJson(new ResponseHECRequestListDTO(hecRequestDTOLst,
					ResponseStatusDTO.createOkRequestResponse("HEC Requests listed"))));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseHECRequestListDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseHECRequestListDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}

	}

	public Result get(long id) {

		try {

			HECRequestDTO hecRequestDTO = hecRequestResourceMapper.mapDTOFromBO(hecRequestService.get(id));

			if (hecRequestDTO == null || hecRequestDTO.getId() <= 0) {

				return ok(Json.toJson(new ResponseHECRequestDTO(null,
						ResponseStatusDTO.createWarnRequestResponse(103, "HEC Request not found"))));
			}

			return ok(Json.toJson(hecRequestDTO));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseHECRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseHECRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}
	}

	public Result insert() {

		response().setHeader("Access-Control-Allow-Origin", "*");

		HECRequestDTO hecRequestDTO = null;

		try {

			JsonNode json = request().body().asJson();
			hecRequestDTO = Json.fromJson(json, HECRequestDTO.class);

		} catch (Exception ex) {

			return ok(Json.toJson(new ResponseTriageRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(101, "Bad Request", ex))));
		}

		try {

			HECRequestBO hecRequestBO = hecRequestResourceMapper.mapBOFromDTO(hecRequestDTO);
			HECRequestDTO responseHECRequestDTO = hecRequestResourceMapper
					.mapDTOFromBO(hecRequestService.insert(hecRequestBO));

			return ok(Json.toJson(new ResponseHECRequestDTO(responseHECRequestDTO,
					ResponseStatusDTO.createOkRequestResponse("HEC Request created successfully"))));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(new ResponseHECRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex))));

		} catch (Exception e) {

			return ok(Json.toJson(new ResponseHECRequestDTO(null,
					ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e))));
		}

	}

	public Result delete(long id) {

		response().setHeader("Access-Control-Allow-Origin", "*");

		try {

			hecRequestService.delete(id);
			return ok(Json.toJson(ResponseStatusDTO.createOkRequestResponse("HEC Request deleted successfully")));

		} catch (TransactionalServiceException ex) {

			return ok(Json.toJson(ResponseStatusDTO.createErrorRequestResponse(102, ex.getMessage(), ex)));

		} catch (Exception e) {

			return ok(Json.toJson(ResponseStatusDTO.createErrorRequestResponse(999, "Unexpected ERROR", e)));
		}

	}

}
