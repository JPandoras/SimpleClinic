package app.springboot.simpleclinic.services;

import app.springboot.simpleclinic.models.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientService {

    void save(Patient patient);

}
