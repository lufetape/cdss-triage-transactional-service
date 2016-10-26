package businesslogic.service;

import java.util.List;

import businesslogic.bo.DocumentTypeBO;
import exceptions.TransactionalServiceException;

public interface IDocumentTypeService {
	
	public DocumentTypeBO get(Long id) throws TransactionalServiceException;

	public List<DocumentTypeBO> list() throws TransactionalServiceException;

	public DocumentTypeBO insert(DocumentTypeBO documentTypeBO) throws TransactionalServiceException;

	public void delete(Long id) throws TransactionalServiceException;

}
