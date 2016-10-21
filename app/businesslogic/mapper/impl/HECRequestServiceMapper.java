package businesslogic.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import businesslogic.bo.HECRequestBO;
import businesslogic.mapper.IHECRequestServiceMapper;
import businesslogic.mapper.IRequestStatusServiceMapper;
import dao.entity.HECRequest;

public class HECRequestServiceMapper implements IHECRequestServiceMapper {

	@Inject
	private IRequestStatusServiceMapper requestStatusMapper;

	@Override
	public HECRequest mapEntityFromBO(HECRequestBO hecRequestBO) {

		HECRequest hecRequest = new HECRequest();

		if (hecRequestBO != null) {

			hecRequest.setId(hecRequestBO.getId());
			hecRequest.setRegisterDate(hecRequestBO.getRegisterDate());

			if (hecRequestBO.getStatus() != null) {

				hecRequest.setStatus(requestStatusMapper.mapEntityFromBO(hecRequestBO.getStatus()));
			}

		}

		return hecRequest;
	}

	@Override
	public HECRequestBO mapBOFromEntity(HECRequest hecRequest) {

		HECRequestBO hecRequestBO = null;

		if (hecRequest != null) {

			hecRequestBO = new HECRequestBO();
			hecRequestBO.setId(hecRequest.getId());
			hecRequestBO.setRegisterDate(hecRequest.getRegisterDate());

			if (hecRequest.getStatus() != null) {

				hecRequestBO.setStatus(requestStatusMapper.mapBOFromEntity(hecRequest.getStatus()));
			}

		}

		return hecRequestBO;
	}

	@Override
	public List<HECRequestBO> mapBOListFromEntityList(List<HECRequest> hecRequests) {
		List<HECRequestBO> hecRequestBOs = null;

		if (hecRequests != null) {
			hecRequestBOs = new ArrayList<>();
			for (HECRequest hecRequest : hecRequests) {

				hecRequestBOs.add(mapBOFromEntity(hecRequest));
			}
		}

		return hecRequestBOs;
	}

}
