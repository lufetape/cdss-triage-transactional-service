package api.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import api.dto.TriageRequestDTO;
import api.mapper.IHECRequestResourceMapper;
import api.mapper.IRequestStatusResourceMapper;
import api.mapper.ITriageRequestResourceMapper;
import businesslogic.bo.TriageRequestBO;

public class TriageRequestResourceMapper implements ITriageRequestResourceMapper {

	@Inject
	private IRequestStatusResourceMapper requestStatusMapper;

	@Inject
	private IHECRequestResourceMapper hecRequestMapper;

	@Override
	public TriageRequestBO mapBOFromDTO(TriageRequestDTO triageRequestDTO) {

		TriageRequestBO triageRequestBO = new TriageRequestBO();

		if (triageRequestDTO != null) {

			triageRequestBO.setId(triageRequestDTO.getId());
			triageRequestBO.setRegisterDate(triageRequestDTO.getRegisterDate());

			if (triageRequestDTO.getStatus() != null) {

				triageRequestBO.setStatus(requestStatusMapper.mapBOFromDTO(triageRequestDTO.getStatus()));
			}

			if (triageRequestDTO.getHecRequest() != null) {

				triageRequestBO.setHecRequest(hecRequestMapper.mapBOFromDTO(triageRequestDTO.getHecRequest()));
			}
		}

		return triageRequestBO;
	}

	@Override
	public TriageRequestDTO mapDTOFromBO(TriageRequestBO triageRequestBO) {
		TriageRequestDTO triageRequestDTO = null;

		if (triageRequestBO != null) {
			triageRequestDTO = new TriageRequestDTO();
			triageRequestDTO.setId(triageRequestBO.getId());
			triageRequestDTO.setRegisterDate(triageRequestBO.getRegisterDate());

			if (triageRequestBO.getStatus() != null) {

				triageRequestDTO.setStatus(requestStatusMapper.mapDTOFromBO(triageRequestBO.getStatus()));
			}

			if (triageRequestBO.getHecRequest() != null) {

				triageRequestDTO.setHecRequest(hecRequestMapper.mapDTOFromBO(triageRequestBO.getHecRequest()));
			}
		}

		return triageRequestDTO;
	}

	@Override
	public List<TriageRequestDTO> mapDTOListFromBOList(List<TriageRequestBO> triageRequestBOs) {
		List<TriageRequestDTO> triageRequestDTOs = null;

		if (triageRequestBOs != null) {
			triageRequestDTOs = new ArrayList<>();
			for (TriageRequestBO triageRequestBO : triageRequestBOs) {

				triageRequestDTOs.add(mapDTOFromBO(triageRequestBO));
			}
		}

		return triageRequestDTOs;
	}

}
