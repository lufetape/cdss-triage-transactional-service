package api.mapper;

import java.util.List;

import api.dto.EHRRequestDTO;
import businesslogic.bo.EHRRequestBO;

public interface IEHRRequestResourceMapper {

	public List<EHRRequestDTO> mapDTOListFromBOList(List<EHRRequestBO> ehrRequestBOLst);

	public EHRRequestBO mapBOFromDTO(EHRRequestDTO ehrRequestDTO);

	public EHRRequestDTO mapDTOFromBO(EHRRequestBO ehrRequestBO);

}
