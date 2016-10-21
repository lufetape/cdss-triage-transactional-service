package api.dto.response;

import java.io.Serializable;

import api.dto.EHRRequestDTO;

public class ResponseEHRRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3853849659290838345L;

	private EHRRequestDTO ehrRequest;
	private ResponseStatusDTO status;

	public EHRRequestDTO getEhrRequest() {
		return ehrRequest;
	}

	public void setEhrRequest(EHRRequestDTO ehrRequest) {
		this.ehrRequest = ehrRequest;
	}

	public ResponseStatusDTO getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}

	public ResponseEHRRequestDTO() {
		super();
	}

	public ResponseEHRRequestDTO(ResponseStatusDTO status) {
		super();
		this.status = status;
	}

	public ResponseEHRRequestDTO(EHRRequestDTO ehrRequest, ResponseStatusDTO status) {
		super();
		this.ehrRequest = ehrRequest;
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseEHRRequestDTO [ehrRequest=" + ehrRequest + ", status=" + status + "]";
	}

}
