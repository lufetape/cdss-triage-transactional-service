package businesslogic.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import businesslogic.bo.HECRequestBO;
import businesslogic.bo.RequestStatusBO;
import businesslogic.mapper.IHECRequestServiceMapper;
import businesslogic.service.IHECRequestService;
import businesslogic.service.IRequestStatusService;
import dao.entity.HECRequest;
import dao.service.IHECRequestDAO;
import exceptions.TransactionalServiceException;

public class HECRequestService implements IHECRequestService {

	@Inject
	private IHECRequestDAO hecRequestDAO;

	@Inject
	private IRequestStatusService requestStatusService;

	@Inject
	private IHECRequestServiceMapper hecRequestServiceMapper;

	public static final Long REQUEST_STATUS_REGISTERED = 1L;

	@Override
	public HECRequestBO insert(HECRequestBO hecRequestBO) throws TransactionalServiceException {

		// Validations

		if (hecRequestBO == null) {

			throw new TransactionalServiceException("Expected a HECRequestBO object");
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

		// End validations

		// set defaults
		hecRequestBO.setStatus(requestStatusBO);
		hecRequestBO.setRegisterDate(new Date());

		// Persist
		try {

			HECRequest hecRequest = hecRequestServiceMapper.mapEntityFromBO(hecRequestBO);
			return (hecRequestServiceMapper.mapBOFromEntity(hecRequestDAO.insert(hecRequest)));

		} catch (Exception e) {
			throw new TransactionalServiceException("Error creating HEC Request", e);
		}

	}

	@Override
	public HECRequestBO get(Long id) throws TransactionalServiceException {

		try {

			// find HECRequest
			HECRequest hecRequest = this.hecRequestDAO.get(id);

			return (hecRequestServiceMapper.mapBOFromEntity(hecRequest));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding HEC Request by id", e);
		}

	}

	@Override
	public List<HECRequestBO> list() throws TransactionalServiceException {

		try {

			// List entity
			List<HECRequest> hecRequests = hecRequestDAO.list();

			return (hecRequestServiceMapper.mapBOListFromEntityList(hecRequests));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding all HEC Requests", e);
		}

	}
	
	
	@Override
	public void delete(Long id) throws TransactionalServiceException {

		//Validations
		
		HECRequestBO hecRequestBO = null;
		try {

			hecRequestBO = get(id);

		} catch (Exception e) {
			
			throw new TransactionalServiceException("Error trying to find the HEC Request", e);
		}

		if (hecRequestBO == null || hecRequestBO.getId() <= 0) {

			throw new TransactionalServiceException(
					String.format("HEC Request with id %s not found", id));
		}
		
		// Persist
		try {
			
			hecRequestDAO.delete(id);

		} catch (Exception e) {
			
			throw new TransactionalServiceException("Error deleting HEC Request", e);
		}
	}

}
