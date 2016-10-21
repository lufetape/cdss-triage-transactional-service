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
@Table(name = "hec_request")
public class HECRequest extends Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2656957284392577885L;

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

	public HECRequest() {
		super();
	}

	public HECRequest(Long id) {
		super();
		this.id = id;
	}

	public HECRequest(Long id, Date registerDate, RequestStatus status) {
		super();
		this.id = id;
		this.registerDate = registerDate;
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

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
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
		HECRequest other = (HECRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "HECRequest [id=" + id + ", registerDate=" + registerDate + ", status=" + status + "]";
	}



	public static Finder<Long, HECRequest> find = new Finder<Long, HECRequest>(HECRequest.class);

}
