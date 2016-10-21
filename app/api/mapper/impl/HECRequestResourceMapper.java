package api.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import api.dto.HECRequestDTO;
import api.mapper.IHECRequestResourceMapper;
import api.mapper.IRequestStatusResourceMapper;
import businesslogic.bo.HECRequestBO;

public class HECRequestResourceMapper implements IHECRequestResourceMapper {

	@Inject
	private IRequestStatusResourceMapper requestStatusMapper;

	@Override
	public HECRequestBO mapBOFromDTO(HECRequestDTO hecRequestDTO) {

		HECRequestBO hecRequestBO = new HECRequestBO();

		if (hecRequestDTO != null) {

			hecRequestBO.setId(hecRequestDTO.getId());
			hecRequestBO.setRegisterDate(hecRequestDTO.getRegisterDate());

			if (hecRequestDTO.getStatus() != null) {

				hecRequestBO.setStatus(requestStatusMapper.mapBOFromDTO(hecRequestDTO.getStatus()));
			}

		}

		return hecRequestBO;
	}

	@Override
	public HECRequestDTO mapDTOFromBO(HECRequestBO hecRequestBO) {
		HECRequestDTO hecRequestDTO = null;

		if (hecRequestBO != null) {
			hecRequestDTO = new HECRequestDTO();
			hecRequestDTO.setId(hecRequestBO.getId());
			hecRequestDTO.setRegisterDate(hecRequestBO.getRegisterDate());

			if (hecRequestBO.getStatus() != null) {

				hecRequestDTO.setStatus(requestStatusMapper.mapDTOFromBO(hecRequestBO.getStatus()));
			}

		}

		return hecRequestDTO;
	}

	@Override
	public List<HECRequestDTO> mapDTOListFromBOList(List<HECRequestBO> hecRequestBOs) {
		List<HECRequestDTO> hecRequestDTOs = null;

		if (hecRequestBOs != null) {
			hecRequestDTOs = new ArrayList<>();
			for (HECRequestBO hecRequestBO : hecRequestBOs) {

				hecRequestDTOs.add(mapDTOFromBO(hecRequestBO));
			}
		}

		return hecRequestDTOs;
	}

}
