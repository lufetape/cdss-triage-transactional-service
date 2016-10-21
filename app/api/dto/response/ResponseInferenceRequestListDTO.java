package api.dto.response;

import java.io.Serializable;
import java.util.List;

import api.dto.InferenceRequestDTO;

public class ResponseInferenceRequestListDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5999233907589239725L;

	private List<InferenceRequestDTO> inferenceRequestList;
	private int totalSize;
	private ResponseStatusDTO status;

	public ResponseInferenceRequestListDTO() {
		super();
	}

	public ResponseInferenceRequestListDTO(ResponseStatusDTO status) {
		super();
		this.status = status;
	}

	public ResponseInferenceRequestListDTO(List<InferenceRequestDTO> inferenceRequestList, ResponseStatusDTO status) {
		super();
		this.inferenceRequestList = inferenceRequestList;
		this.status = status;
	}

	public List<InferenceRequestDTO> getInferenceRequestList() {
		return inferenceRequestList;
	}

	public void setInferenceRequestList(List<InferenceRequestDTO> inferenceRequestList) {
		this.inferenceRequestList = inferenceRequestList;
	}

	public ResponseStatusDTO getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}
	
	
	public int getTotalSize() {
		totalSize = 0;
		if(inferenceRequestList != null && !inferenceRequestList.isEmpty()) {
			totalSize = inferenceRequestList.size();
		}
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	@Override
	public String toString() {
		return "ResponseInferenceRequestListDTO [inferenceRequestList=" + inferenceRequestList + ", status=" + status
				+ "]";
	}
	
	
	
	
	
	

}
