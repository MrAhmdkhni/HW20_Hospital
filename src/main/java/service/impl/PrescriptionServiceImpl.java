package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Prescription;
import exception.NotFoundClassException;
import repository.PrescriptionRepository;
import service.PrescriptionService;

import java.util.List;

public class PrescriptionServiceImpl extends BaseServiceImpl<Prescription, Long, PrescriptionRepository> implements PrescriptionService {

    public PrescriptionServiceImpl(PrescriptionRepository repository) {
        super(repository);
    }

    @Override
    public List<Prescription> loadByPatientId(Long patientId) {
        List<Prescription> prescriptions = repository.loadByPatientId(patientId);
        if (prescriptions == null) {
            throw new NotFoundClassException("there is no prescription with this patient id...!!");
        }
        return prescriptions;
    }
}
