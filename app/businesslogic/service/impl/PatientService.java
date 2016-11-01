package businesslogic.service.impl;


import java.util.List;

import javax.inject.Inject;

import businesslogic.bo.PatientBO;
import businesslogic.mapper.IPatientServiceMapper;
import businesslogic.service.IPatientService;
import dao.entity.Patient;
import dao.service.IPatientDAO;
import exceptions.TransactionalServiceException;

public class PatientService implements IPatientService {
	
	@Inject
	private IPatientDAO patientDAO;
	
	@Inject
	private IPatientServiceMapper patientServiceMapper;
	
	@Override
	public List<PatientBO> list() throws TransactionalServiceException {

		try {

			// List entity
			List<Patient> patients = patientDAO.list();

			return (patientServiceMapper.mapBOListFromEntityList(patients));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding all Patients", e);
		}

	}
	
	@Override
	public PatientBO get(Long id) throws TransactionalServiceException {

		try {

			// find Patient
			Patient patient = this.patientDAO.get(id);

			return (patientServiceMapper.mapBOFromEntity(patient));

		} catch (Exception e) {

			throw new TransactionalServiceException("Error finding Patient by id", e);
		}

	}
	
	@Override
	public PatientBO insert(PatientBO patientBO) throws TransactionalServiceException {

		// Validations
		
		if (patientBO == null) {

			throw new TransactionalServiceException("Expected a PatientBO object");
		}

		// End validations

		
		// Persist
		try {
			
			Patient patient = patientServiceMapper.mapEntityFromBO(patientBO);
			return (patientServiceMapper.mapBOFromEntity(patientDAO.insert(patient)));
			
		} catch (Exception e) {
			throw new TransactionalServiceException("Error creating Patient", e);
		}
	}
	
	@Override
	public void delete(Long id) throws TransactionalServiceException {

		//Validations
		
		PatientBO patientBO = null;
		
		try {

			patientBO = get(id);

		} catch (Exception e) {
			
			throw new TransactionalServiceException("Error trying to find the Patient", e);
		}

		if (patientBO == null || patientBO.getId() <= 0) {

			throw new TransactionalServiceException(
					String.format("Patient with id %s not found", id));
		}
		
		// Persist
		try {
			
			patientDAO.delete(id);

		} catch (Exception e) {
			
			throw new TransactionalServiceException("Error deleting Patient", e);
		}
	}

}
