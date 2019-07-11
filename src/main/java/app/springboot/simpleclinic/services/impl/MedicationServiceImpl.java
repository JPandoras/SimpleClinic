package app.springboot.simpleclinic.services.impl;

import app.springboot.simpleclinic.models.Medication;
import app.springboot.simpleclinic.repositories.MedicationRepository;
import app.springboot.simpleclinic.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationServiceImpl implements MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    @Override
    public void save(Medication medication) {
        medicationRepository.save(medication);
    }

}
