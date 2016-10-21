package businesslogic.mapper;

import java.util.List;

import businesslogic.bo.HECRequestBO;
import dao.entity.HECRequest;

public interface IHECRequestServiceMapper {

	public HECRequest mapEntityFromBO(HECRequestBO hecRequestBO);

	public HECRequestBO mapBOFromEntity(HECRequest hecRequest);

	public List<HECRequestBO> mapBOListFromEntityList(List<HECRequest> hecRequestLst);

}
