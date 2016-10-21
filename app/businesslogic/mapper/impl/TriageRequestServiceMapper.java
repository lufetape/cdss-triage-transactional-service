package businesslogic.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import businesslogic.bo.TriageRequestBO;
import businesslogic.mapper.IHECRequestServiceMapper;
import businesslogic.mapper.IRequestStatusServiceMapper;
import businesslogic.mapper.ITriageRequestServiceMapper;
import dao.entity.TriageRequest;

public class TriageRequestServiceMapper implements ITriageRequestServiceMapper {

	@Inject
	private IRequestStatusServiceMapper requestStatusMapper;

	@Inject
	private IHECRequestServiceMapper hecRequestServiceMapper;

	@Override
	public TriageRequest mapEntityFromBO(TriageRequestBO triageRequestBO) {

		TriageRequest triageRequest = new TriageRequest();

		if (triageRequestBO != null) {

			triageRequest.setId(triageRequestBO.getId());
			triageRequest.setRegisterDate(triageRequestBO.getRegisterDate());

			if (triageRequestBO.getStatus() != null) {

				triageRequest.setStatus(requestStatusMapper.mapEntityFromBO(triageRequestBO.getStatus()));
			}

			if (triageRequestBO.getHecRequest() != null) {

				triageRequest.setHecRequest(hecRequestServiceMapper.mapEntityFromBO(triageRequestBO.getHecRequest()));
			}
		}

		return triageRequest;
	}

	@Override
	public TriageRequestBO mapBOFromEntity(TriageRequest triageRequest) {

		TriageRequestBO triageRequestBO = null;

		if (triageRequest != null) {

			triageRequestBO = new TriageRequestBO();
			triageRequestBO.setId(triageRequest.getId());
			triageRequestBO.setRegisterDate(triageRequest.getRegisterDate());

			if (triageRequest.getStatus() != null) {

				triageRequestBO.setStatus(requestStatusMapper.mapBOFromEntity(triageRequest.getStatus()));
			}

			if (triageRequest.getHecRequest() != null) {

				triageRequestBO.setHecRequest(hecRequestServiceMapper.mapBOFromEntity(triageRequest.getHecRequest()));
			}

		}

		return triageRequestBO;
	}

	@Override
	public List<TriageRequestBO> mapBOListFromEntityList(List<TriageRequest> triageRequests) {
		List<TriageRequestBO> triageRequestBOs = null;

		if (triageRequests != null) {
			triageRequestBOs = new ArrayList<>();
			for (TriageRequest triageRequest : triageRequests) {

				triageRequestBOs.add(mapBOFromEntity(triageRequest));
			}
		}

		return triageRequestBOs;
	}

}
