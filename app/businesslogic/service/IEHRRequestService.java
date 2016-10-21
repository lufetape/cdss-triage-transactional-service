package businesslogic.service;

import java.util.List;

import businesslogic.bo.EHRRequestBO;
import exceptions.TransactionalServiceException;

public interface IEHRRequestService {

	public EHRRequestBO insert(EHRRequestBO ehrRequestBO) throws TransactionalServiceException;

	public EHRRequestBO get(Long id) throws TransactionalServiceException;

	public List<EHRRequestBO> list() throws TransactionalServiceException;
	
	public void delete(Long id) throws TransactionalServiceException;

}
