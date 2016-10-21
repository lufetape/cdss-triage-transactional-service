package businesslogic.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import businesslogic.bo.EHRRequestBO;
import businesslogic.mapper.IEHRRequestServiceMapper;
import businesslogic.mapper.IHECRequestServiceMapper;
import businesslogic.mapper.IRequestStatusServiceMapper;
import dao.entity.EHRRequest;

public class EHRRequestServiceMapper implements IEHRRequestServiceMapper {

	@Inject
	private IHECRequestServiceMapper hecRequestServiceMapper;
	
	@Inject
	private IRequestStatusServiceMapper requestStatusMapper;

	
	@Override
	public EHRRequest mapEntityFromBO(EHRRequestBO ehrRequestBO) {

		EHRRequest ehrRequest = new EHRRequest();

		if (ehrRequestBO != null) {

			ehrRequest.setId(ehrRequestBO.getId());
			ehrRequest.setRegisterDate(ehrRequestBO.getRegisterDate());

			if (ehrRequestBO.getStatus() != null) {

				ehrRequest.setStatus(requestStatusMapper.mapEntityFromBO(ehrRequestBO.getStatus()));
			}

			if (ehrRequestBO.getHecRequest() != null) {

				ehrRequest.setHecRequest(hecRequestServiceMapper.mapEntityFromBO(ehrRequestBO.getHecRequest()));
			}
		}

		return ehrRequest;
	}

	@Override
	public EHRRequestBO mapBOFromEntity(EHRRequest ehrRequest) {

		EHRRequestBO ehrRequestBO = null;

		if (ehrRequest != null) {

			ehrRequestBO = new EHRRequestBO();
			ehrRequestBO.setId(ehrRequest.getId());
			ehrRequestBO.setRegisterDate(ehrRequest.getRegisterDate());

			if (ehrRequest.getStatus() != null) {

				ehrRequestBO.setStatus(requestStatusMapper.mapBOFromEntity(ehrRequest.getStatus()));
			}

			if (ehrRequest.getHecRequest() != null) {

				ehrRequestBO.setHecRequest(hecRequestServiceMapper.mapBOFromEntity(ehrRequest.getHecRequest()));
			}

		}

		return ehrRequestBO;
	}

	@Override
	public List<EHRRequestBO> mapBOListFromEntityList(List<EHRRequest> ehrRequests) {
		List<EHRRequestBO> ehrRequestBOs = null;

		if (ehrRequests != null) {
			ehrRequestBOs = new ArrayList<>();
			for (EHRRequest ehrRequest : ehrRequests) {

				ehrRequestBOs.add(mapBOFromEntity(ehrRequest));
			}
		}

		return ehrRequestBOs;
	}
	

}
