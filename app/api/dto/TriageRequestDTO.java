package api.dto;

import java.io.Serializable;
import java.util.Date;

public class TriageRequestDTO implements Serializable {
	
	private static final long serialVersionUID = -6381133512300868523L;
	
	private long id;
	private Date registerDate;
	private RequestStatusDTO status;
	private HECRequestDTO hecRequest;

	public TriageRequestDTO() {
		super();
	}

	public TriageRequestDTO(int id) {
		super();
		this.id = id;
	}

	public TriageRequestDTO(long id, Date registerDate, RequestStatusDTO status, HECRequestDTO hecRequest) {
		super();
		this.id = id;
		this.registerDate = registerDate;
		this.status = status;
		this.hecRequest = hecRequest;
	}

	public RequestStatusDTO getStatus() {
		return status;
	}

	public void setStatus(RequestStatusDTO status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TriageRequestDTO other = (TriageRequestDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TriageRequestDTO [id=" + id + ", registerDate=" + registerDate + ", status=" + status + ", hecRequest="
				+ hecRequest + "]";
	}
}
