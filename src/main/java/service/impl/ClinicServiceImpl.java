package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Clinic;
import repository.ClinicRepository;
import service.ClinicService;

public class ClinicServiceImpl extends BaseServiceImpl<Clinic, Long, ClinicRepository> implements ClinicService {

    public ClinicServiceImpl(ClinicRepository repository) {
        super(repository);
    }
}
