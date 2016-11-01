package api.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import api.dto.PatientDTO;
import api.mapper.IPatientResourceMapper;
import businesslogic.bo.PatientBO;

public class PatientResourceMapper implements IPatientResourceMapper {

	@Override
	public PatientBO mapBOFromDTO(PatientDTO patientDTO) {

		PatientBO patientBO = new PatientBO();

		if (patientDTO != null) {

			patientBO.setId(patientDTO.getId());
			patientBO.setDateOfBirth(patientDTO.getDateOfBirth());
			patientBO.setDocumentType(patientDTO.getDocumentType());
			patientBO.setEmail(patientDTO.getEmail());
			patientBO.setFirstName(patientDTO.getFirstName());
			patientBO.setIdentification(patientDTO.getIdentification());
			patientBO.setLastName(patientDTO.getLastName());
			patientBO.setPhoneNumber(patientDTO.getPhoneNumber());
			patientBO.setSecondLastName(patientDTO.getSecondLastName());
			patientBO.setSecondName(patientDTO.getSecondName());

		}

		return patientBO;
	}

	@Override
	public PatientDTO mapDTOFromBO(PatientBO patientBO) {

		PatientDTO patientDTO = null;

		if (patientBO != null) {

			patientDTO = new PatientDTO();
			patientDTO.setId(patientBO.getId());
			patientDTO.setDateOfBirth(patientBO.getDateOfBirth());
			patientDTO.setDocumentType(patientBO.getDocumentType());
			patientDTO.setEmail(patientBO.getEmail());
			patientDTO.setFirstName(patientBO.getFirstName());
			patientDTO.setIdentification(patientBO.getIdentification());
			patientDTO.setLastName(patientBO.getLastName());
			patientDTO.setPhoneNumber(patientBO.getPhoneNumber());
			patientDTO.setSecondLastName(patientBO.getSecondLastName());
			patientDTO.setSecondName(patientBO.getSecondName());

		}

		return patientDTO;
	}

	@Override
	public List<PatientDTO> mapDTOListFromBOList(List<PatientBO> patientBOs) {

		List<PatientDTO> patientDTOs = null;

		if (patientBOs != null) {
			patientDTOs = new ArrayList<>();
			for (PatientBO patientBO : patientBOs) {

				patientDTOs.add(mapDTOFromBO(patientBO));
			}
		}

		return patientDTOs;
	}

}
