package app.springboot.simpleclinic.services;

import app.springboot.simpleclinic.models.Patient;
import app.springboot.simpleclinic.models.Treatment;

public interface PatientService {

    void save(Patient patient);
    Iterable<Patient> getAll();
    Treatment patientTreatment(String patientId, String doctorId);

}
