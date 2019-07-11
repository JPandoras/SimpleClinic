package app.springboot.simpleclinic.services.impl;

import app.springboot.simpleclinic.models.Patient;
import app.springboot.simpleclinic.repositories.PatientRepository;
import app.springboot.simpleclinic.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void save(Patient patient) {
        patientRepository.saveAndFlush(patient);
    }

}
