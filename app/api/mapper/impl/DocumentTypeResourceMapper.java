package api.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import api.dto.DocumentTypeDTO;
import api.mapper.IDocumentTypeResourceMapper;
import businesslogic.bo.DocumentTypeBO;

public class DocumentTypeResourceMapper implements IDocumentTypeResourceMapper {

	@Override
	public DocumentTypeBO mapBOFromDTO(DocumentTypeDTO documentTypeDTO) {

		DocumentTypeBO documentTypeBO = new DocumentTypeBO();

		if (documentTypeDTO != null) {

			documentTypeBO.setId(documentTypeDTO.getId());
			documentTypeBO.setDescription(documentTypeDTO.getDescription());
		}

		return documentTypeBO;

	}

	@Override
	public DocumentTypeDTO mapDTOFromBO(DocumentTypeBO documentTypeBO) {
		
		DocumentTypeDTO documentTypeDTO = null;

		if (documentTypeBO != null) {
			
			documentTypeDTO = new DocumentTypeDTO();
			documentTypeDTO.setId(documentTypeBO.getId());
			documentTypeDTO.setDescription(documentTypeBO.getDescription());
		}

		return documentTypeDTO;
		
	}

	@Override
	public List<DocumentTypeDTO> mapDTOListFromBOList(List<DocumentTypeBO> documentTypeBOs) {
		
		
		List<DocumentTypeDTO> documentTypeDTOs = null;

		if (documentTypeBOs != null) {
			documentTypeDTOs = new ArrayList<>();
			for (DocumentTypeBO documentTypeBO : documentTypeBOs) {

				documentTypeDTOs.add(mapDTOFromBO(documentTypeBO));
			}
		}

		return documentTypeDTOs;
		
	}

}
