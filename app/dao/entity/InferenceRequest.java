package dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.avaje.ebean.Model;

@Entity
@Table(name = "inference_request")
public class InferenceRequest extends Model implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7014250588328611269L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id")
	private Long id;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "register_date")
	private Date registerDate;

	@JoinColumn(name = "status_id", referencedColumnName = "id")
	@ManyToOne
	private RequestStatus status;

	@JoinColumn(name = "hec_request_id", referencedColumnName = "id")
	@ManyToOne
	private HECRequest hecRequest;
	
	
	
	public InferenceRequest() {
		super();
	}
	
	

	public InferenceRequest(Long id) {
		super();
		this.id = id;
	}

	public InferenceRequest(Long id, Date registerDate, RequestStatus status, HECRequest hecRequest) {
		super();
		this.id = id;
		this.registerDate = registerDate;
		this.status = status;
		this.hecRequest = hecRequest;
	}



	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	
	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public HECRequest getHecRequest() {
		return hecRequest;
	}

	public void setHecRequest(HECRequest hecRequest) {
		this.hecRequest = hecRequest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		InferenceRequest other = (InferenceRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	



	@Override
	public String toString() {
		return "InferenceRequest [id=" + id + ", registerDate=" + registerDate + ", status=" + status + ", hecRequest="
				+ hecRequest + "]";
	}



	public static Finder<Long, InferenceRequest> find = new Finder<Long, InferenceRequest>(InferenceRequest.class);

}
