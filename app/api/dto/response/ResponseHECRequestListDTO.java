package api.dto.response;

import java.io.Serializable;
import java.util.List;

import api.dto.HECRequestDTO;

public class ResponseHECRequestListDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 527022832222458150L;

	private List<HECRequestDTO> hecRequestList;
	private int totalSize;
	private ResponseStatusDTO status;

	public ResponseHECRequestListDTO() {
		super();
	}

	public ResponseHECRequestListDTO(ResponseStatusDTO status) {
		super();
		this.status = status;
	}

	public ResponseHECRequestListDTO(List<HECRequestDTO> hecRequestList, ResponseStatusDTO status) {
		super();
		this.hecRequestList = hecRequestList;
		this.status = status;
	}

	public List<HECRequestDTO> getHecRequestList() {
		return hecRequestList;
	}

	public void setHecRequestList(List<HECRequestDTO> hecRequestList) {
		this.hecRequestList = hecRequestList;
	}

	public ResponseStatusDTO getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}

	public int getTotalSize() {
		totalSize = 0;
		if (hecRequestList != null && !hecRequestList.isEmpty()) {
			totalSize = hecRequestList.size();
		}
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	@Override
	public String toString() {
		return "ResponseHECRequestListDTO [hecRequestList=" + hecRequestList + ", status=" + status + "]";
	}

}
