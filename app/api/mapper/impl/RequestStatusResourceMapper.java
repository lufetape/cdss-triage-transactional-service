package api.mapper.impl;

import api.dto.RequestStatusDTO;
import api.mapper.IRequestStatusResourceMapper;
import businesslogic.bo.RequestStatusBO;

public class RequestStatusResourceMapper implements IRequestStatusResourceMapper {

	@Override
	public RequestStatusBO mapBOFromDTO(RequestStatusDTO requestStatusDTO) {

		RequestStatusBO requestStatusBO = new RequestStatusBO();

		if (requestStatusDTO != null) {
			
			requestStatusBO.setId(requestStatusDTO.getId());
			requestStatusBO.setDescription(requestStatusDTO.getDescription());
		}

		return requestStatusBO;

	}

	@Override
	public RequestStatusDTO mapDTOFromBO(RequestStatusBO requestStatusBO) {

		RequestStatusDTO requestStatusDTO = new RequestStatusDTO();

		if (requestStatusDTO != null) {
			
			requestStatusDTO.setId(requestStatusBO.getId());
			requestStatusDTO.setDescription(requestStatusBO.getDescription());
		}

		return requestStatusDTO;
	}

}
