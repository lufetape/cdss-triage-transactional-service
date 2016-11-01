package dao.service.impl;

import java.util.List;

import com.avaje.ebean.Ebean;

import dao.entity.Patient;
import dao.service.IPatientDAO;

public class PatientDAO implements IPatientDAO {

	@Override
	public Long getNextId() {

		StringBuilder sql = new StringBuilder();
		sql.append("select nextval('patient_seq') secuencia");

		return Ebean.createSqlQuery(sql.toString()).findUnique().getLong("secuencia");
	}

	@Override
	public Patient get(Long id) {

		Patient patient = Patient.find.byId(id);

		return patient;

	}

	@Override
	public List<Patient> list() {

		List<Patient> patients = Patient.find.all();

		return patients;
	}

	@Override
	public Patient insert(Patient patient) {
		patient.setId(getNextId());
		patient.save();
		return patient;
	}

	@Override
	public void delete(Long id) {
		Patient patient = get(id);
		patient.delete();
	}

}
