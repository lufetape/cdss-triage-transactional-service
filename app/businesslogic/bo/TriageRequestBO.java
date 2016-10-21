package businesslogic.bo;

import java.io.Serializable;
import java.util.Date;

public class TriageRequestBO implements Serializable {

	private static final long serialVersionUID = 8472381671973923024L;

	private long id;

	private Date registerDate;

	private RequestStatusBO status;
	
	private HECRequestBO hecRequest;

	public TriageRequestBO() {
		super();
	}

	public TriageRequestBO(int id) {
		super();
		this.id = id;
	}

	public TriageRequestBO(long id, Date registerDate, RequestStatusBO status, HECRequestBO hecRequest) {
		super();
		this.id = id;
		this.registerDate = registerDate;
		this.status = status;
		this.hecRequest = hecRequest;
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

	public RequestStatusBO getStatus() {
		return status;
	}

	public void setStatus(RequestStatusBO status) {
		this.status = status;
	}
	
	public HECRequestBO getHecRequest() {
		return hecRequest;
	}

	public void setHecRequest(HECRequestBO hecRequest) {
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
		TriageRequestBO other = (TriageRequestBO) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TriageRequestBO [id=" + id + ", registerDate=" + registerDate + ", status=" + status + ", hecRequest="
				+ hecRequest + "]";
	}
}
