package businesslogic.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import businesslogic.bo.HECRequestBO;
import businesslogic.bo.RequestStatusBO;
import businesslogic.bo.TriageRequestBO;
import businesslogic.mapper.ITriageRequestServiceMapper;
import businesslogic.service.IHECRequestService;
import businesslogic.service.IRequestStatusService;
import businesslogic.service.ITriageRequestService;
import dao.entity.TriageRequest;
import dao.service.ITriageRequestDAO;
import exceptions.TransactionalServiceException;

public class TriageRequestService implements ITriageRequestService {

	@Inject
	private ITriageRequestDAO triageRequestDAO;

	@Inject
	private IHECRequestService hecRequestService;

	@Inject
	private IRequestStatusService requestStatusService;

	@Inject
	private ITriageRequestServiceMapper triageRequestServiceMapper;
	
	public static final Long REQUEST_STATUS_REGISTERED = 1L;

	@Override
	public List<TriageRequestBO> list() throws TransactionalServiceException {

		try {

			// List entity
			List<TriageRequest> triageRequests = triageRequestDAO.list();

			return (triageRequestServiceMapper.mapBOListFromEntityList(triageRequests));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding all Triage Requests", e);
		}

	}

	@Override
	public TriageRequestBO get(Long id) throws TransactionalServiceException {

		try {

			// find TriageRequest
			TriageRequest triageRequest = this.triageRequestDAO.get(id);

			return (triageRequestServiceMapper.mapBOFromEntity(triageRequest));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding Triage Request by id", e);
		}

	}

	@Override
	public TriageRequestBO insert(TriageRequestBO triageRequestBO) throws TransactionalServiceException {

		// Validations
		
		if (triageRequestBO == null) {

			throw new TransactionalServiceException("Expected a TriageRequestBO object");
		}

		if (triageRequestBO.getHecRequest() == null || triageRequestBO.getHecRequest().getId() <= 0) {

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

			hecRequestBO = hecRequestService.get(triageRequestBO.getHecRequest().getId());

		} catch (Exception e) {
			
			throw new TransactionalServiceException("Error trying to find the HEC Request", e);
		}

		if (hecRequestBO == null || hecRequestBO.getId() <= 0) {

			throw new TransactionalServiceException(
					String.format("HEC Request with id %s not found", triageRequestBO.getHecRequest().getId()));
		}
		
		// End validations

		// set defaults
		triageRequestBO.setStatus(requestStatusBO);
		triageRequestBO.setRegisterDate(new Date()); 
		
		// Persist
		try {
			
			TriageRequest triageRequest = triageRequestServiceMapper.mapEntityFromBO(triageRequestBO);
			return (triageRequestServiceMapper.mapBOFromEntity(triageRequestDAO.insert(triageRequest)));
			
		} catch (Exception e) {
			throw new TransactionalServiceException("Error creating Triage Request", e);
		}
	}

	@Override
	public void delete(Long id) throws TransactionalServiceException {

		//Validations
		
		TriageRequestBO triageRequestBO = null;
		try {

			triageRequestBO = get(id);

		} catch (Exception e) {
			
			throw new TransactionalServiceException("Error trying to find the Triage Request", e);
		}

		if (triageRequestBO == null || triageRequestBO.getId() <= 0) {

			throw new TransactionalServiceException(
					String.format("Triage Request with id %s not found", id));
		}
		
		// Persist
		try {
			
			triageRequestDAO.delete(id);

		} catch (Exception e) {
			
			throw new TransactionalServiceException("Error deleting Triage Request", e);
		}
	}

}
