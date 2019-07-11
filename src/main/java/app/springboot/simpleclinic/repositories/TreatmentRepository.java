package app.springboot.simpleclinic.repositories;

import app.springboot.simpleclinic.models.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, String> {

}
