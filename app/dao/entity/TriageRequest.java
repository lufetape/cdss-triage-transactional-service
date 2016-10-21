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
@Table(name = "triage_request")
public class TriageRequest extends Model implements Serializable {

	private static final long serialVersionUID = -644972720428727100L;

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

	public TriageRequest() {
		super();
	}

	public TriageRequest(Long id) {
		super();
		this.id = id;
	}

	public TriageRequest(Long id, Date registerDate, RequestStatus status, HECRequest hecRequest) {
		super();
		this.id = id;
		this.registerDate = registerDate;
		this.status = status;
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

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public HECRequest getHecRequest() {
		return hecRequest;
	}

	public void setHecRequest(HECRequest hecRequest) {
		this.hecRequest = hecRequest;
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
		TriageRequest other = (TriageRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TriageRequest [id=" + id + ", registerDate=" + registerDate + ", status=" + status + ", hecRequest="
				+ hecRequest + "]";
	}

	public static Finder<Long, TriageRequest> find = new Finder<Long, TriageRequest>(TriageRequest.class);

}
