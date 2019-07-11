package app.springboot.simpleclinic.services.impl;

import app.springboot.simpleclinic.models.Treatment;
import app.springboot.simpleclinic.repositories.TreatmentRepository;
import app.springboot.simpleclinic.services.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreatmentServiceImpl implements TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Override
    public Treatment getTreatment(String id) {
        return treatmentRepository.getOne(id);
    }

}
