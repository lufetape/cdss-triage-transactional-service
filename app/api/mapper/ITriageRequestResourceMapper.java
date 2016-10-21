package api.mapper;

import java.util.List;

import api.dto.TriageRequestDTO;
import businesslogic.bo.TriageRequestBO;

public interface ITriageRequestResourceMapper {
	
	public TriageRequestBO mapBOFromDTO(TriageRequestDTO triageRequestDTO);
	
	public TriageRequestDTO mapDTOFromBO(TriageRequestBO triageRequestBO);
	
	public List<TriageRequestDTO> mapDTOListFromBOList(List<TriageRequestBO> triageRequestBOs);

}
