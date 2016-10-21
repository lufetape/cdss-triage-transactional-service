package businesslogic.service;

import java.util.List;

import businesslogic.bo.HECRequestBO;
import exceptions.TransactionalServiceException;

public interface IHECRequestService {

	public HECRequestBO insert(HECRequestBO hecRequestBO) throws TransactionalServiceException;

	public HECRequestBO get(Long id) throws TransactionalServiceException;

	public List<HECRequestBO> list() throws TransactionalServiceException;
	
	public void delete(Long id) throws TransactionalServiceException;

}
