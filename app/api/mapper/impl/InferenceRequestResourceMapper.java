package api.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import api.dto.InferenceRequestDTO;
import api.mapper.IHECRequestResourceMapper;
import api.mapper.IInferenceRequestResourceMapper;
import api.mapper.IRequestStatusResourceMapper;
import businesslogic.bo.InferenceRequestBO;

public class InferenceRequestResourceMapper implements IInferenceRequestResourceMapper {

	

	@Inject
	private IRequestStatusResourceMapper requestStatusMapper;

	@Inject
	private IHECRequestResourceMapper hecRequestMapper;

	@Override
	public InferenceRequestBO mapBOFromDTO(InferenceRequestDTO inferenceRequestDTO) {

		InferenceRequestBO inferenceRequestBO = new InferenceRequestBO();

		if (inferenceRequestDTO != null) {

			inferenceRequestBO.setId(inferenceRequestDTO.getId());
			inferenceRequestBO.setRegisterDate(inferenceRequestDTO.getRegisterDate());

			if (inferenceRequestDTO.getStatus() != null) {

				inferenceRequestBO.setStatus(requestStatusMapper.mapBOFromDTO(inferenceRequestDTO.getStatus()));
			}

			if (inferenceRequestDTO.getHecRequest() != null) {

				inferenceRequestBO.setHecRequest(hecRequestMapper.mapBOFromDTO(inferenceRequestDTO.getHecRequest()));
			}
		}

		return inferenceRequestBO;
	}

	@Override
	public InferenceRequestDTO mapDTOFromBO(InferenceRequestBO inferenceRequestBO) {
		InferenceRequestDTO inferenceRequestDTO = null;

		if (inferenceRequestBO != null) {
			inferenceRequestDTO = new InferenceRequestDTO();
			inferenceRequestDTO.setId(inferenceRequestBO.getId());
			inferenceRequestDTO.setRegisterDate(inferenceRequestBO.getRegisterDate());

			if (inferenceRequestBO.getStatus() != null) {

				inferenceRequestDTO.setStatus(requestStatusMapper.mapDTOFromBO(inferenceRequestBO.getStatus()));
			}

			if (inferenceRequestBO.getHecRequest() != null) {

				inferenceRequestDTO.setHecRequest(hecRequestMapper.mapDTOFromBO(inferenceRequestBO.getHecRequest()));
			}
		}

		return inferenceRequestDTO;
	}

	@Override
	public List<InferenceRequestDTO> mapDTOListFromBOList(List<InferenceRequestBO> inferenceRequestBOs) {
		List<InferenceRequestDTO> inferenceRequestDTOs = null;

		if (inferenceRequestBOs != null) {
			inferenceRequestDTOs = new ArrayList<>();
			for (InferenceRequestBO inferenceRequestBO : inferenceRequestBOs) {

				inferenceRequestDTOs.add(mapDTOFromBO(inferenceRequestBO));
			}
		}

		return inferenceRequestDTOs;
	}

}
