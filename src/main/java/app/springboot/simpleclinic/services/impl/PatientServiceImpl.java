package app.springboot.simpleclinic.services.impl;

import app.springboot.simpleclinic.constants.MainConstants;
import app.springboot.simpleclinic.helper.UUIDHelper;
import app.springboot.simpleclinic.models.Doctor;
import app.springboot.simpleclinic.models.Patient;
import app.springboot.simpleclinic.models.Treatment;
import app.springboot.simpleclinic.repositories.DoctorRepository;
import app.springboot.simpleclinic.repositories.PatientRepository;
import app.springboot.simpleclinic.repositories.TreatmentRepository;
import app.springboot.simpleclinic.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Override
    public void save(Patient patient) {
        patientRepository.saveAndFlush(patient);
    }

    @Override
    public Iterable<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Treatment patientTreatment(String patientId, String doctorId) {
        // get data patient
        Patient p = patientRepository.getOne(patientId);
        p.setStatus(MainConstants.PATIENT_STATUS_TREATMENT);

        // update patient status
        patientRepository.save(p);

        // get data doctor
        Doctor d = doctorRepository.getOne(doctorId);

        // save to treatment
        Treatment t = new Treatment();
        t.setId(UUIDHelper.getGeneratedID());
        t.setDoctorId(d);
        t.setPatientId(p);

        treatmentRepository.saveAndFlush(t);

        t.getPatientId();
        t.getDoctorId();

        return t;
    }

}
