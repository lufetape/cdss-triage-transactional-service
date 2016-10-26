package api.mapper;

import java.util.List;

import api.dto.DocumentTypeDTO;
import businesslogic.bo.DocumentTypeBO;

public interface IDocumentTypeResourceMapper {
	
	public DocumentTypeBO mapBOFromDTO(DocumentTypeDTO documentTypeDTO);
	
	public DocumentTypeDTO mapDTOFromBO(DocumentTypeBO documentTypeBO);
	
	public List<DocumentTypeDTO> mapDTOListFromBOList(List<DocumentTypeBO> documentTypeBOs);

}
