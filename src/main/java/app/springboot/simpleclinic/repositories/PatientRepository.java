package app.springboot.simpleclinic.repositories;

import app.springboot.simpleclinic.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {

}
