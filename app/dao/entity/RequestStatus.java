package dao.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.avaje.ebean.Model;


@Entity
@Table(name = "request_status")
public class RequestStatus extends Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3361547601944791053L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id")
	private Long id;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "description")
	private String description;
	
	public RequestStatus() {
		super();
	}
	
	public RequestStatus(Long id) {
		super();
		this.id = id;
	}
	
	public RequestStatus(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		RequestStatus other = (RequestStatus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "RequestStatus [id=" + id + ", description=" + description + "]";
	}




	public static Finder<Long, RequestStatus> find = new Finder<Long, RequestStatus>(RequestStatus.class);

}
