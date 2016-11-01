package businesslogic.mapper.impl;

import java.util.ArrayList;
import java.util.List;


import businesslogic.bo.PatientBO;
import businesslogic.mapper.IPatientServiceMapper;
import dao.entity.Patient;


public class PatientServiceMapper implements IPatientServiceMapper {

	@Override
	public Patient mapEntityFromBO(PatientBO patientBO) {

		Patient patient = new Patient();

		if (patientBO != null) {

			patient.setId(patientBO.getId());
			patient.setDateOfBirth(patientBO.getDateOfBirth());
			patient.setDocumentType(patientBO.getDocumentType());
			patient.setEmail(patientBO.getEmail());
			patient.setFirstName(patientBO.getFirstName());
			patient.setIdentification(patientBO.getIdentification());
			patient.setLastName(patientBO.getLastName());
			patient.setPhoneNumber(patientBO.getPhoneNumber());
			patient.setSecondLastName(patientBO.getSecondLastName());
			patient.setSecondName(patientBO.getSecondName());
		}

		return patient;
	}

	@Override
	public PatientBO mapBOFromEntity(Patient patient) {

		PatientBO patientBO = null;

		if (patient != null) {

			patientBO = new PatientBO();
			patientBO.setId(patient.getId());
			patientBO.setDateOfBirth(patient.getDateOfBirth());
			patientBO.setDocumentType(patient.getDocumentType());
			patientBO.setEmail(patient.getEmail());
			patientBO.setFirstName(patient.getFirstName());
			patientBO.setIdentification(patient.getIdentification());
			patientBO.setLastName(patient.getLastName());
			patientBO.setPhoneNumber(patient.getPhoneNumber());
			patientBO.setSecondLastName(patient.getSecondLastName());
			patientBO.setSecondName(patient.getSecondName());
		}

		return patientBO;
	}

	@Override
	public List<PatientBO> mapBOListFromEntityList(List<Patient> patients) {

		List<PatientBO> patientBOs = null;

		if (patients != null) {
			patientBOs = new ArrayList<>();
			for (Patient patient : patients) {

				patientBOs.add(mapBOFromEntity(patient));
			}
		}

		return patientBOs;
	}

}
