package api.dto.response;

import java.io.Serializable;
import java.util.List;

import api.dto.PatientDTO;

public class ResponsePatientListDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4923358059014412885L;
	
	private List<PatientDTO> patientList;
	private int totalSize;	
	private ResponseStatusDTO status;
	
	public ResponsePatientListDTO() {
		super();
	}

	public ResponsePatientListDTO(ResponseStatusDTO status) {
		super();
		this.status = status;
	}

	public ResponsePatientListDTO(List<PatientDTO> patientList, ResponseStatusDTO status) {
		super();
		this.patientList = patientList;
		this.status = status;
	}

	public List<PatientDTO> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<PatientDTO> patientList) {
		this.patientList = patientList;
	}

	public ResponseStatusDTO getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}
	
	public int getTotalSize() {
		totalSize = 0;
		if(patientList != null && !patientList.isEmpty()) {
			totalSize = patientList.size();
		}
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	@Override
	public String toString() {
		return "ResponsePatientListDTO [patientList=" + patientList + ", status=" + status + "]";
	}
	
	
	
	

}
