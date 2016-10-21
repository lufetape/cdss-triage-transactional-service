package businesslogic.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import businesslogic.bo.InferenceRequestBO;
import businesslogic.mapper.IHECRequestServiceMapper;
import businesslogic.mapper.IInferenceRequestServiceMapper;
import businesslogic.mapper.IRequestStatusServiceMapper;
import dao.entity.InferenceRequest;

public class InferenceRequestServiceMapper implements IInferenceRequestServiceMapper {
	
	@Inject
	private IHECRequestServiceMapper hecRequestServiceMapper;
	
	@Inject
	private IRequestStatusServiceMapper requestStatusMapper;


	@Override
	public InferenceRequest mapEntityFromBO(InferenceRequestBO inferenceRequestBO) {

		InferenceRequest inferenceRequest = new InferenceRequest();

		if (inferenceRequestBO != null) {

			inferenceRequest.setId(inferenceRequestBO.getId());
			inferenceRequest.setRegisterDate(inferenceRequestBO.getRegisterDate());

			if (inferenceRequestBO.getStatus() != null) {

				inferenceRequest.setStatus(requestStatusMapper.mapEntityFromBO(inferenceRequestBO.getStatus()));
			}

			if (inferenceRequestBO.getHecRequest() != null) {

				inferenceRequest.setHecRequest(hecRequestServiceMapper.mapEntityFromBO(inferenceRequestBO.getHecRequest()));
			}
		}

		return inferenceRequest;
	}

	@Override
	public InferenceRequestBO mapBOFromEntity(InferenceRequest inferenceRequest) {

		InferenceRequestBO inferenceRequestBO = null;

		if (inferenceRequest != null) {

			inferenceRequestBO = new InferenceRequestBO();
			inferenceRequestBO.setId(inferenceRequest.getId());
			inferenceRequestBO.setRegisterDate(inferenceRequest.getRegisterDate());

			if (inferenceRequest.getStatus() != null) {

				inferenceRequestBO.setStatus(requestStatusMapper.mapBOFromEntity(inferenceRequest.getStatus()));
			}

			if (inferenceRequest.getHecRequest() != null) {

				inferenceRequestBO.setHecRequest(hecRequestServiceMapper.mapBOFromEntity(inferenceRequest.getHecRequest()));
			}

		}

		return inferenceRequestBO;
	}

	@Override
	public List<InferenceRequestBO> mapBOListFromEntityList(List<InferenceRequest> inferenceRequests) {
		List<InferenceRequestBO> inferenceRequestBOs = null;

		if (inferenceRequests != null) {
			inferenceRequestBOs = new ArrayList<>();
			for (InferenceRequest inferenceRequest : inferenceRequests) {

				inferenceRequestBOs.add(mapBOFromEntity(inferenceRequest));
			}
		}

		return inferenceRequestBOs;
	}

}
