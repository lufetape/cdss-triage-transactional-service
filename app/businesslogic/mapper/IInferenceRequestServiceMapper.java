package businesslogic.mapper;

import java.util.List;

import businesslogic.bo.InferenceRequestBO;
import dao.entity.InferenceRequest;


public interface IInferenceRequestServiceMapper {
	
	public InferenceRequestBO mapBOFromEntity(InferenceRequest inferenceRequest);
	
	public InferenceRequest mapEntityFromBO(InferenceRequestBO inferenceRequestBO); 

	public List<InferenceRequestBO> mapBOListFromEntityList(List<InferenceRequest> inferenceRequestLst);

}
