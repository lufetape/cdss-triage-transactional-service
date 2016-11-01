package businesslogic.service;

import java.util.List;

import businesslogic.bo.PatientBO;
import exceptions.TransactionalServiceException;

public interface IPatientService {
	
	public PatientBO get(Long id) throws TransactionalServiceException;

	public List<PatientBO> list() throws TransactionalServiceException;

	public PatientBO insert(PatientBO patientBO) throws TransactionalServiceException;

	public void delete(Long id) throws TransactionalServiceException;

}
