package api.mapper;

import api.dto.RequestStatusDTO;
import businesslogic.bo.RequestStatusBO;

public interface IRequestStatusResourceMapper {

	public RequestStatusBO mapBOFromDTO(RequestStatusDTO requestStatusDTO);

	public RequestStatusDTO mapDTOFromBO(RequestStatusBO requestStatusBO);
}
