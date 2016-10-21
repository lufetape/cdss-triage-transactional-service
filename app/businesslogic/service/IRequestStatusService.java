package businesslogic.service;

import java.util.List;

import businesslogic.bo.RequestStatusBO;
import exceptions.TransactionalServiceException;

public interface IRequestStatusService {

	public RequestStatusBO insertStatus(RequestStatusBO requestStatusBO) throws TransactionalServiceException;

	public RequestStatusBO getStatus(Long id) throws TransactionalServiceException;

	public List<RequestStatusBO> listStatus() throws TransactionalServiceException;



}
