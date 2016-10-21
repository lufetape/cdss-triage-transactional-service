package api.dto.response;

import java.io.Serializable;
import java.util.List;

import api.dto.TriageRequestDTO;

public class ResponseTriageRequestListDTO implements Serializable {

	private static final long serialVersionUID = -6732508045622154050L;

	private List<TriageRequestDTO> triageRequestList;
	private int totalSize;	
	private ResponseStatusDTO status;

	public ResponseTriageRequestListDTO() {
		super();
	}

	public ResponseTriageRequestListDTO(ResponseStatusDTO status) {
		super();
		this.status = status;
	}

	public ResponseTriageRequestListDTO(List<TriageRequestDTO> triageRequestList, ResponseStatusDTO status) {
		super();
		this.triageRequestList = triageRequestList;
		this.status = status;
	}

	public List<TriageRequestDTO> getTriageRequestList() {
		return triageRequestList;
	}

	public void setTriageRequestList(List<TriageRequestDTO> triageRequestList) {
		this.triageRequestList = triageRequestList;
	}

	public ResponseStatusDTO getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}
	
	public int getTotalSize() {
		totalSize = 0;
		if(triageRequestList != null && !triageRequestList.isEmpty()) {
			totalSize = triageRequestList.size();
		}
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	@Override
	public String toString() {
		return "ResponseTriageRequestListDTO [triageRequestList=" + triageRequestList + ", status=" + status + "]";
	}

}
