package api.dto.response;

import java.io.Serializable;

import api.dto.HECRequestDTO;

public class ResponseHECRequestDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4721257114927971976L;
	
	
	private HECRequestDTO hecRequest;
	private ResponseStatusDTO status;
	
	public ResponseHECRequestDTO() {
		super();
	}

	public ResponseHECRequestDTO(ResponseStatusDTO status) {
		super();
		this.status = status;
	}

	public ResponseHECRequestDTO(HECRequestDTO hecRequest, ResponseStatusDTO status) {
		super();
		this.hecRequest = hecRequest;
		this.status = status;
	}

	public HECRequestDTO getHecRequest() {
		return hecRequest;
	}

	public void setHecRequest(HECRequestDTO hecRequest) {
		this.hecRequest = hecRequest;
	}

	public ResponseStatusDTO getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseHECRequestDTO [hecRequest=" + hecRequest + ", status=" + status + "]";
	}
	
	
	
	
	
	

}
