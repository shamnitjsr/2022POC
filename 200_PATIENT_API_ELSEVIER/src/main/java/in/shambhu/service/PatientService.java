package in.shambhu.service;

import java.util.List;
import java.util.UUID;

import in.shambhu.model.Patient;

public interface PatientService {

	public List<Patient> getAllPatient();

	public List<Patient> getAllPatientWithMandatoryField();

	public Patient getPatientById(UUID id);

	public boolean savePatient(Patient patient);

	public boolean savePatientWithNecessaryField(UUID id);

	public boolean deletePatient(UUID id);

}
