package api.dto.response;

import java.io.Serializable;
import java.util.List;

import api.dto.EHRRequestDTO;

public class ResponseEHRRequestListDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2716460856655168653L;
	
	private List<EHRRequestDTO> ehrRequestList;
	private int totalSize;	
	private ResponseStatusDTO status;
	
	public ResponseEHRRequestListDTO() {
		super();
	}

	public ResponseEHRRequestListDTO(ResponseStatusDTO status) {
		super();
		this.status = status;
	}

	public ResponseEHRRequestListDTO(List<EHRRequestDTO> ehrRequestList, ResponseStatusDTO status) {
		super();
		this.ehrRequestList = ehrRequestList;
		this.status = status;
	}

	public List<EHRRequestDTO> getEhrRequestList() {
		return ehrRequestList;
	}

	public void setEhrRequestList(List<EHRRequestDTO> ehrRequestList) {
		this.ehrRequestList = ehrRequestList;
	}
	
	

	public ResponseStatusDTO getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}

	public int getTotalSize() {
		totalSize = 0;
		if(ehrRequestList != null && !ehrRequestList.isEmpty()) {
			totalSize = ehrRequestList.size();
		}
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	@Override
	public String toString() {
		return "ResponseEHRRequestListDTO [ehrRequestList=" + ehrRequestList + ", status=" + status + "]";
	}
	
	
	
	
	
	

}
