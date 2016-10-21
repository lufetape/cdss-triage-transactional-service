package api.dto.response;

import java.io.Serializable;

import api.dto.InferenceRequestDTO;

public class ResponseInferenceRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -146214671293102972L;

	private InferenceRequestDTO inferenceRequest;
	private ResponseStatusDTO status;

	public ResponseInferenceRequestDTO() {
		super();
	}

	public ResponseInferenceRequestDTO(InferenceRequestDTO inferenceRequest) {
		super();
		this.inferenceRequest = inferenceRequest;
	}

	public ResponseInferenceRequestDTO(InferenceRequestDTO inferenceRequest, ResponseStatusDTO status) {
		super();
		this.inferenceRequest = inferenceRequest;
		this.status = status;
	}

	public InferenceRequestDTO getInferenceRequest() {
		return inferenceRequest;
	}

	public void setInferenceRequest(InferenceRequestDTO inferenceRequest) {
		this.inferenceRequest = inferenceRequest;
	}

	public ResponseStatusDTO getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseInferenceRequestDTO [inferenceRequest=" + inferenceRequest + ", status=" + status + "]";
	}

}
