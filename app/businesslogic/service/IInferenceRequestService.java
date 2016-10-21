package businesslogic.service;

import java.util.List;

import businesslogic.bo.InferenceRequestBO;
import exceptions.TransactionalServiceException;

public interface IInferenceRequestService {
	
	public InferenceRequestBO insert(InferenceRequestBO inferenceRequestBO) throws TransactionalServiceException;

	public InferenceRequestBO get(Long id) throws TransactionalServiceException;

	public List<InferenceRequestBO> list() throws TransactionalServiceException;
	
	public void delete(Long id) throws TransactionalServiceException;

}
