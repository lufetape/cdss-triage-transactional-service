package businesslogic.mapper;

import businesslogic.bo.RequestStatusBO;
import dao.entity.RequestStatus;

public interface IRequestStatusServiceMapper {

	public RequestStatus mapEntityFromBO(RequestStatusBO requestStatusBO);

	public RequestStatusBO mapBOFromEntity(RequestStatus requestStatus);
}
