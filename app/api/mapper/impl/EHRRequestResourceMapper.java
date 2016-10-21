package api.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import api.dto.EHRRequestDTO;
import api.mapper.IEHRRequestResourceMapper;
import api.mapper.IHECRequestResourceMapper;
import api.mapper.IRequestStatusResourceMapper;
import businesslogic.bo.EHRRequestBO;

public class EHRRequestResourceMapper implements IEHRRequestResourceMapper {

	@Inject
	private IRequestStatusResourceMapper requestStatusMapper;

	@Inject
	private IHECRequestResourceMapper hecRequestMapper;

	@Override
	public EHRRequestBO mapBOFromDTO(EHRRequestDTO ehrRequestDTO) {

		EHRRequestBO ehrRequestBO = new EHRRequestBO();

		if (ehrRequestDTO != null) {

			ehrRequestBO.setId(ehrRequestDTO.getId());
			ehrRequestBO.setRegisterDate(ehrRequestDTO.getRegisterDate());

			if (ehrRequestDTO.getStatus() != null) {

				ehrRequestBO.setStatus(requestStatusMapper.mapBOFromDTO(ehrRequestDTO.getStatus()));
			}

			if (ehrRequestDTO.getHecRequest() != null) {

				ehrRequestBO.setHecRequest(hecRequestMapper.mapBOFromDTO(ehrRequestDTO.getHecRequest()));
			}
		}

		return ehrRequestBO;
	}

	@Override
	public EHRRequestDTO mapDTOFromBO(EHRRequestBO ehrRequestBO) {
		EHRRequestDTO ehrRequestDTO = null;

		if (ehrRequestBO != null) {
			ehrRequestDTO = new EHRRequestDTO();
			ehrRequestDTO.setId(ehrRequestBO.getId());
			ehrRequestDTO.setRegisterDate(ehrRequestBO.getRegisterDate());

			if (ehrRequestBO.getStatus() != null) {

				ehrRequestDTO.setStatus(requestStatusMapper.mapDTOFromBO(ehrRequestBO.getStatus()));
			}

			if (ehrRequestBO.getHecRequest() != null) {

				ehrRequestDTO.setHecRequest(hecRequestMapper.mapDTOFromBO(ehrRequestBO.getHecRequest()));
			}
		}

		return ehrRequestDTO;
	}

	@Override
	public List<EHRRequestDTO> mapDTOListFromBOList(List<EHRRequestBO> ehrRequestBOs) {
		List<EHRRequestDTO> ehrRequestDTOs = null;

		if (ehrRequestBOs != null) {
			ehrRequestDTOs = new ArrayList<>();
			for (EHRRequestBO ehrRequestBO : ehrRequestBOs) {

				ehrRequestDTOs.add(mapDTOFromBO(ehrRequestBO));
			}
		}

		return ehrRequestDTOs;
	}

}
