package api.mapper;

import java.util.List;

import api.dto.PatientDTO;
import businesslogic.bo.PatientBO;

public interface IPatientResourceMapper {

	public PatientBO mapBOFromDTO(PatientDTO triageRequestDTO);

	public PatientDTO mapDTOFromBO(PatientBO patientBO);

	public List<PatientDTO> mapDTOListFromBOList(List<PatientBO> patientBOs);

}
