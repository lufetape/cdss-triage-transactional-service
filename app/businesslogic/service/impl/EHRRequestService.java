package businesslogic.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import businesslogic.bo.EHRRequestBO;
import businesslogic.bo.HECRequestBO;
import businesslogic.bo.RequestStatusBO;
import businesslogic.mapper.IEHRRequestServiceMapper;
import businesslogic.service.IEHRRequestService;
import businesslogic.service.IHECRequestService;
import businesslogic.service.IRequestStatusService;
import dao.entity.EHRRequest;
import dao.service.IEHRRequestDAO;
import exceptions.TransactionalServiceException;

public class EHRRequestService implements IEHRRequestService {

	@Inject
	private IEHRRequestDAO ehrRequestDAO;

	@Inject
	private IRequestStatusService requestStatusService;

	@Inject
	private IHECRequestService hecRequestService;

	@Inject
	private IEHRRequestServiceMapper ehrRequestServiceMapper;

	public static final Long REQUEST_STATUS_REGISTERED = 1L;

	@Override
	public List<EHRRequestBO> list() throws TransactionalServiceException {

		try {

			// List entity
			List<EHRRequest> ehrRequests = ehrRequestDAO.list();

			return (ehrRequestServiceMapper.mapBOListFromEntityList(ehrRequests));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding all EHR Requests", e);
		}

	}

	@Override
	public EHRRequestBO get(Long id) throws TransactionalServiceException {

		try {

			// find TriageRequest
			EHRRequest ehrRequest = this.ehrRequestDAO.get(id);

			return (ehrRequestServiceMapper.mapBOFromEntity(ehrRequest));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding EHR Request by id", e);
		}

	}

	@Override
	public EHRRequestBO insert(EHRRequestBO ehrRequestBO) throws TransactionalServiceException {

		// Validations

		if (ehrRequestBO == null) {

			throw new TransactionalServiceException("Expected a EHRRequestBO object");
		}

		if (ehrRequestBO.getHecRequest() == null || ehrRequestBO.getHecRequest().getId() <= 0) {

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

			hecRequestBO = hecRequestService.get(ehrRequestBO.getHecRequest().getId());

		} catch (Exception e) {

			throw new TransactionalServiceException("Error trying to find the HEC Request", e);
		}

		if (hecRequestBO == null || hecRequestBO.getId() <= 0) {

			throw new TransactionalServiceException(
					String.format("HEC Request with id %s not found", ehrRequestBO.getHecRequest().getId()));
		}

		// End validations

		// set defaults
		ehrRequestBO.setStatus(requestStatusBO);
		ehrRequestBO.setRegisterDate(new Date());

		// Persist
		try {

			EHRRequest ehrRequest = ehrRequestServiceMapper.mapEntityFromBO(ehrRequestBO);
			return (ehrRequestServiceMapper.mapBOFromEntity(ehrRequestDAO.insert(ehrRequest)));

		} catch (Exception e) {
			throw new TransactionalServiceException("Error creating EHR Request", e);
		}
	}

	@Override
	public void delete(Long id) throws TransactionalServiceException {

		// Validations

		EHRRequestBO ehrRequestBO = null;
		try {

			ehrRequestBO = get(id);

		} catch (Exception e) {

			throw new TransactionalServiceException("Error trying to find the EHR Request", e);
		}

		if (ehrRequestBO == null || ehrRequestBO.getId() <= 0) {

			throw new TransactionalServiceException(String.format("EHR Request with id %s not found", id));
		}

		// Persist
		try {

			ehrRequestDAO.delete(id);

		} catch (Exception e) {

			throw new TransactionalServiceException("Error deleting EHR Request", e);
		}
	}

}
