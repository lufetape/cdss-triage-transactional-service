package businesslogic.service.impl;

import java.util.List;

import javax.inject.Inject;

import businesslogic.bo.DocumentTypeBO;
import businesslogic.mapper.IDocumentTypeServiceMapper;
import businesslogic.service.IDocumentTypeService;
import dao.entity.DocumentType;
import dao.service.IDocumentTypeDAO;
import exceptions.TransactionalServiceException;

public class DocumentTypeService implements IDocumentTypeService {

	@Inject
	private IDocumentTypeDAO documentTypeDAO;

	@Inject
	private IDocumentTypeServiceMapper documentTypeServiceMapper;

	@Override
	public List<DocumentTypeBO> list() throws TransactionalServiceException {

		try {

			// List entity
			List<DocumentType> documentTypes = documentTypeDAO.list();

			return (documentTypeServiceMapper.mapBOListFromEntityList(documentTypes));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding all Document Types", e);
		}

	}

	@Override
	public DocumentTypeBO get(Long id) throws TransactionalServiceException {

		try {

			// find DocumentType
			DocumentType documentType = this.documentTypeDAO.get(id);

			return (documentTypeServiceMapper.mapBOFromEntity(documentType));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding Document Type by id", e);
		}
	}

	@Override
	public DocumentTypeBO insert(DocumentTypeBO documentTypeBO) throws TransactionalServiceException {

		// Validations

		if (documentTypeBO == null) {

			throw new TransactionalServiceException("Expected a DocumentTypeBO object");
		}

		// End validations

		// Persist
		try {

			DocumentType documentType = documentTypeServiceMapper.mapEntityFromBO(documentTypeBO);
			return (documentTypeServiceMapper.mapBOFromEntity(documentTypeDAO.insert(documentType)));

		} catch (Exception e) {
			throw new TransactionalServiceException("Error creating Document Type", e);
		}

	}

	@Override
	public void delete(Long id) throws TransactionalServiceException {

		// Validations

		DocumentTypeBO documentTypeBO = null;
		
		try {

			documentTypeBO = get(id);

		} catch (Exception e) {

			throw new TransactionalServiceException("Error trying to find the Document Type", e);
		}

		if (documentTypeBO == null || documentTypeBO.getId() <= 0) {

			throw new TransactionalServiceException(String.format("Document Type with id %s not found", id));
		}

		// Persist
		try {

			documentTypeDAO.delete(id);

		} catch (Exception e) {

			throw new TransactionalServiceException("Error deleting Triage Request", e);
		}

	}

}
