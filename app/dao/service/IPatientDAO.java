package dao.service;

import java.util.List;

import dao.entity.Patient;

public interface IPatientDAO {

	public Long getNextId();

	public List<Patient> list();

	public Patient get(Long id);

	public Patient insert(Patient patient);

	public void delete(Long id);
}
