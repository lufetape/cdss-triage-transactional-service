package api.mapper;

import java.util.List;

import api.dto.HECRequestDTO;
import businesslogic.bo.HECRequestBO;

public interface IHECRequestResourceMapper {

	public HECRequestBO mapBOFromDTO(HECRequestDTO hecRequestDTO);

	public HECRequestDTO mapDTOFromBO(HECRequestBO hecRequestBO);

	public List<HECRequestDTO> mapDTOListFromBOList(List<HECRequestBO> hecRequestBOLst);

}
