package businesslogic.mapper.impl;

import businesslogic.bo.RequestStatusBO;
import businesslogic.mapper.IRequestStatusServiceMapper;
import dao.entity.RequestStatus;

public class RequestStatusServiceMapper implements IRequestStatusServiceMapper {

	@Override
	public RequestStatus mapEntityFromBO(RequestStatusBO requestStatusBO) {

		RequestStatus requestStatus = new RequestStatus();

		if (requestStatusBO != null) {
			
			requestStatus.setId(requestStatusBO.getId());
			requestStatus.setDescription(requestStatusBO.getDescription());
		}

		return requestStatus;

	}

	@Override
	public RequestStatusBO mapBOFromEntity(RequestStatus requestStatus) {

		RequestStatusBO requestStatusBO = new RequestStatusBO();

		if (requestStatus != null) {
			
			requestStatusBO.setId(requestStatus.getId());
			requestStatusBO.setDescription(requestStatus.getDescription());
		}

		return requestStatusBO;
	}

}
