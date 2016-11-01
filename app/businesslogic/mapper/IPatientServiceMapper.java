package businesslogic.mapper;

import java.util.List;

import businesslogic.bo.PatientBO;
import dao.entity.Patient;

public interface IPatientServiceMapper {
	
	public Patient mapEntityFromBO(PatientBO patientBO);

	public PatientBO mapBOFromEntity(Patient Patient);
	
	public List<PatientBO> mapBOListFromEntityList(List<Patient> patients);

}
