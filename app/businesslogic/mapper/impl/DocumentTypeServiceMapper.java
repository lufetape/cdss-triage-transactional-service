package businesslogic.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import businesslogic.bo.DocumentTypeBO;
import businesslogic.mapper.IDocumentTypeServiceMapper;
import dao.entity.DocumentType;

public class DocumentTypeServiceMapper implements IDocumentTypeServiceMapper {

	@Override
	public DocumentType mapEntityFromBO(DocumentTypeBO documentTypeBO) {

		DocumentType documentType = new DocumentType();

		if (documentTypeBO != null) {

			documentType.setId(documentTypeBO.getId());
			documentType.setDescription(documentTypeBO.getDescription());
		}

		return documentType;
	}

	@Override
	public DocumentTypeBO mapBOFromEntity(DocumentType documentType) {

		DocumentTypeBO documentTypeBO = null;

		if (documentType != null) {

			documentTypeBO = new DocumentTypeBO();
			documentTypeBO.setId(documentType.getId());
			documentTypeBO.setDescription(documentType.getDescription());
		}

		return documentTypeBO;

	}

	@Override
	public List<DocumentTypeBO> mapBOListFromEntityList(List<DocumentType> documentTypes) {
		
		List<DocumentTypeBO> documentTypeBOs = null;

		if (documentTypes != null) {
			
			documentTypeBOs = new ArrayList<>();
			
			for (DocumentType documentType : documentTypes) {

				documentTypeBOs.add(mapBOFromEntity(documentType));
			}
		}

		return documentTypeBOs;
		
	}

}
