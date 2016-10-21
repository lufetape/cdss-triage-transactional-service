package api.mapper;

import java.util.List;

import api.dto.InferenceRequestDTO;
import businesslogic.bo.InferenceRequestBO;

public interface IInferenceRequestResourceMapper {
	
	public List<InferenceRequestDTO> mapDTOListFromBOList(List<InferenceRequestBO> inferenceRequestBOLst);

	public InferenceRequestBO mapBOFromDTO(InferenceRequestDTO inferenceRequestDTO);

	public InferenceRequestDTO mapDTOFromBO(InferenceRequestBO inferenceRequestBO);

}
