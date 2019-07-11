package app.springboot.simpleclinic.repositories;

import app.springboot.simpleclinic.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

}
