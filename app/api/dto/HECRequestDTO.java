package api.dto;

import java.util.Date;

public class HECRequestDTO {
	
	private Long     id;
	private Date    registerDate;
	private RequestStatusDTO  status;
	
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
	
	

}
