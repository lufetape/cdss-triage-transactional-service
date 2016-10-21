package businesslogic.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import businesslogic.bo.HECRequestBO;
import businesslogic.bo.InferenceRequestBO;
import businesslogic.bo.RequestStatusBO;
import businesslogic.mapper.IInferenceRequestServiceMapper;
import businesslogic.service.IHECRequestService;
import businesslogic.service.IInferenceRequestService;
import businesslogic.service.IRequestStatusService;
import dao.entity.InferenceRequest;
import dao.service.IInferenceRequestDAO;
import exceptions.TransactionalServiceException;

public class InferenceRequestService implements IInferenceRequestService {

	@Inject
	private IInferenceRequestDAO inferenceRequestDAO;

	@Inject
	private IRequestStatusService requestStatusService;

	@Inject
	private IHECRequestService hecRequestService;

	@Inject
	private IInferenceRequestServiceMapper inferenceRequestServiceMapper;

	public static final Long REQUEST_STATUS_REGISTERED = 1L;

	@Override
	public List<InferenceRequestBO> list() throws TransactionalServiceException {

		try {

			// List entity
			List<InferenceRequest> inferenceRequests = inferenceRequestDAO.list();

			return (inferenceRequestServiceMapper.mapBOListFromEntityList(inferenceRequests));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding all Inference Requests", e);
		}

	}

	@Override
	public InferenceRequestBO get(Long id) throws TransactionalServiceException {

		try {

			// find TriageRequest
			InferenceRequest inferenceRequest = inferenceRequestDAO.get(id);

			return (inferenceRequestServiceMapper.mapBOFromEntity(inferenceRequest));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding Inference Request by id", e);
		}

	}

	@Override
	public InferenceRequestBO insert(InferenceRequestBO inferenceRequestBO) throws TransactionalServiceException {

		// Validations

		if (inferenceRequestBO == null) {

			throw new TransactionalServiceException("Expected a InferenceRequestBO object");
		}

		if (inferenceRequestBO.getHecRequest() == null || inferenceRequestBO.getHecRequest().getId() <= 0) {

			throw new TransactionalServiceException("A HEC Request is expected");
		}

		RequestStatusBO requestStatusBO = null;
		try {

			requestStatusBO = requestStatusService.getStatus(REQUEST_STATUS_REGISTERED);

		} catch (Exception e) {

			throw new TransactionalServiceException("Error trying to get the REGISTERED status", e);
		}

		if (requestStatusBO == null || requestStatusBO.getId() <= 0) {

			throw new TransactionalServiceException(
					String.format("Request Status with id %s not found", REQUEST_STATUS_REGISTERED));
		}

		HECRequestBO hecRequestBO = null;
		try {

			hecRequestBO = hecRequestService.get(inferenceRequestBO.getHecRequest().getId());

		} catch (Exception e) {

			throw new TransactionalServiceException("Error trying to find the HEC Request", e);
		}

		if (hecRequestBO == null || hecRequestBO.getId() <= 0) {

			throw new TransactionalServiceException(
					String.format("HEC Request with id %s not found", inferenceRequestBO.getHecRequest().getId()));
		}

		// End validations

		// set defaults
		inferenceRequestBO.setStatus(requestStatusBO);
		inferenceRequestBO.setRegisterDate(new Date());

		// Persist
		try {

			InferenceRequest inferenceRequest = inferenceRequestServiceMapper.mapEntityFromBO(inferenceRequestBO);
			return (inferenceRequestServiceMapper.mapBOFromEntity(inferenceRequestDAO.insert(inferenceRequest)));

		} catch (Exception e) {
			throw new TransactionalServiceException("Error creating Inference Request", e);
		}
	}

	@Override
	public void delete(Long id) throws TransactionalServiceException {

		// Validations

		InferenceRequestBO inferenceRequestBO = null;
		try {

			inferenceRequestBO = get(id);

		} catch (Exception e) {

			throw new TransactionalServiceException("Error trying to find the Inference Request", e);
		}

		if (inferenceRequestBO == null || inferenceRequestBO.getId() <= 0) {

			throw new TransactionalServiceException(String.format("Inference Request with id %s not found", id));
		}

		// Persist
		try {

			inferenceRequestDAO.delete(id);

		} catch (Exception e) {

			throw new TransactionalServiceException("Error deleting Inference Request", e);
		}
	}

}
