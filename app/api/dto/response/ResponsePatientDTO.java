package api.dto.response;

import java.io.Serializable;

import api.dto.PatientDTO;

public class ResponsePatientDTO implements Serializable {

	private static final long serialVersionUID = 3598269043718090947L;

	private PatientDTO patient;
	private ResponseStatusDTO status;

	public ResponsePatientDTO() {
		super();
	}

	public ResponsePatientDTO(ResponseStatusDTO status) {
		super();
		this.status = status;
	}

	public ResponsePatientDTO(PatientDTO patient, ResponseStatusDTO status) {
		super();
		this.patient = patient;
		this.status = status;
	}

	public PatientDTO getPatient() {
		return patient;
	}

	public void setPatient(PatientDTO patient) {
		this.patient = patient;
	}

	public ResponseStatusDTO getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusDTO status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponsePatientDTO [patient=" + patient + ", status=" + status + "]";
	}

}
