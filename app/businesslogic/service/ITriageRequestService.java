package businesslogic.service;

import java.util.List;

import businesslogic.bo.TriageRequestBO;
import exceptions.TransactionalServiceException;

public interface ITriageRequestService {

	public TriageRequestBO get(Long id) throws TransactionalServiceException;

	public List<TriageRequestBO> list() throws TransactionalServiceException;

	public TriageRequestBO insert(TriageRequestBO triageRequestBO) throws TransactionalServiceException;

	public void delete(Long id) throws TransactionalServiceException;

}
