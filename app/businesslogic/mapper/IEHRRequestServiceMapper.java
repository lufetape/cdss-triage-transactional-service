package businesslogic.mapper;

import java.util.List;

import businesslogic.bo.EHRRequestBO;
import dao.entity.EHRRequest;

public interface IEHRRequestServiceMapper {

	public EHRRequestBO mapBOFromEntity(EHRRequest ehrRequest);
	
	public EHRRequest mapEntityFromBO(EHRRequestBO ehrRequestBO);

	public List<EHRRequestBO> mapBOListFromEntityList(List<EHRRequest> ehrRequestLst);
	

}
