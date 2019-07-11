package app.springboot.simpleclinic.repositories;

import app.springboot.simpleclinic.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, String> {
}
