package businesslogic.service.impl;

import java.util.List;

import javax.inject.Inject;


import businesslogic.bo.RequestStatusBO;
import businesslogic.mapper.IRequestStatusServiceMapper;
import businesslogic.service.IRequestStatusService;
import dao.entity.RequestStatus;
import dao.service.IRequestStatusDAO;
import exceptions.TransactionalServiceException;

public class RequestStatusService implements IRequestStatusService {

	@Inject
	private IRequestStatusDAO requestStatusDAO;
	
	@Inject
	private IRequestStatusServiceMapper requestStatusServiceMapper;
	
	

	@Override
	public RequestStatusBO insertStatus(RequestStatusBO requestStatusBO) throws TransactionalServiceException {

		// Validations
		if (requestStatusBO == null) {

			throw new TransactionalServiceException("Expected a RequestStatusBO object");
		}

		// End validations

		// Persist
		try {

			RequestStatus requestStatus = requestStatusServiceMapper.mapEntityFromBO(requestStatusBO);
			return (requestStatusServiceMapper.mapBOFromEntity(requestStatusDAO.insert(requestStatus)));

		} catch (Exception e) {
			throw new TransactionalServiceException("Error creating Request Status", e);
		}
		

	}

	@Override
	public RequestStatusBO getStatus(Long id) throws TransactionalServiceException {

		try {
			RequestStatus requestStatus = this.requestStatusDAO.get(id);
			return (requestStatusServiceMapper.mapBOFromEntity(requestStatus));
		} catch (Exception e) {
			throw new TransactionalServiceException("Error finding Request Status by id",e);
		}
	}

	@Override
	public List<RequestStatusBO> listStatus() throws TransactionalServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
