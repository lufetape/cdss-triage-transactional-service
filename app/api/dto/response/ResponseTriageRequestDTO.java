package api.dto.response;

import java.io.Serializable;

import api.dto.TriageRequestDTO;

public class ResponseTriageRequestDTO implements Serializable {

	private static final long serialVersionUID = -6732508045622154050L;

	private TriageRequestDTO triageRequest;
	private ResponseStatusDTO status;

	public ResponseTriageRequestDTO() {
		super();
	}

	public ResponseTriageRequestDTO(ResponseStatusDTO status) {
		super();
		this.status = status;
	}

	public ResponseTriageRequestDTO(TriageRequestDTO triageRequest, ResponseStatusDTO status) {
		super();
		this.triageRequest = triageRequest;
		this.status = status;
	}

	public TriageRequestDTO getTriageRequest() {
		return triageRequest;
	}

	public void setTriageRequest(TriageRequestDTO triageRequest) {
		this.triageRequest = triageRequest;
	}

	public ResponseStatusDTO getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseTriageRequestDTO [triageRequest=" + triageRequest + ", status=" + status + "]";
	}

}
