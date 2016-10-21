package businesslogic.bo;

import java.util.Date;

public class EHRRequestBO {

	private Long id;

	private RequestStatusBO status;

	private Date registerDate;

	private HECRequestBO hecRequest;

	public HECRequestBO getHecRequest() {
		return hecRequest;
	}

	public void setHecRequest(HECRequestBO hecRequest) {
		this.hecRequest = hecRequest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public RequestStatusBO getStatus() {
		return status;
	}

	public void setStatus(RequestStatusBO status) {
		this.status = status;
	}

}
