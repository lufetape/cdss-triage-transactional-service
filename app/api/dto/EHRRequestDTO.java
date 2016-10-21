package api.dto;

import java.util.Date;

public class EHRRequestDTO {

	private Long id;
	private RequestStatusDTO status;
	private Date registerDate;
	private HECRequestDTO hecRequest;

	public RequestStatusDTO getStatus() {
		return status;
	}

	public void setStatus(RequestStatusDTO status) {
		this.status = status;
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

	public HECRequestDTO getHecRequest() {
		return hecRequest;
	}

	public void setHecRequest(HECRequestDTO hecRequest) {
		this.hecRequest = hecRequest;
	}

}
