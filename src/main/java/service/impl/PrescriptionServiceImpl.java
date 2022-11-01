package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Prescription;
import repository.PrescriptionRepository;
import service.PrescriptionService;

public class PrescriptionServiceImpl extends BaseServiceImpl<Prescription, Long, PrescriptionRepository> implements PrescriptionService {

    public PrescriptionServiceImpl(PrescriptionRepository repository) {
        super(repository);
    }
}
