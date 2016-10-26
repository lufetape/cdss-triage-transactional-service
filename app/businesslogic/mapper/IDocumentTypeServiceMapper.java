package businesslogic.mapper;

import java.util.List;

import businesslogic.bo.DocumentTypeBO;
import dao.entity.DocumentType;


public interface IDocumentTypeServiceMapper {
	
	public DocumentType mapEntityFromBO(DocumentTypeBO documentTypeBO);

	public DocumentTypeBO mapBOFromEntity(DocumentType documentType);
	
	public List<DocumentTypeBO> mapBOListFromEntityList(List<DocumentType> documentTypes);

}
