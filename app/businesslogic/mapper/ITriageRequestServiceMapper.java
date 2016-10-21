package businesslogic.mapper;

import java.util.List;

import businesslogic.bo.TriageRequestBO;
import dao.entity.TriageRequest;

public interface ITriageRequestServiceMapper {

	public TriageRequest mapEntityFromBO(TriageRequestBO triageRequestBO);

	public TriageRequestBO mapBOFromEntity(TriageRequest triageRequest);
	
	public List<TriageRequestBO> mapBOListFromEntityList(List<TriageRequest> triageRequests);

}
