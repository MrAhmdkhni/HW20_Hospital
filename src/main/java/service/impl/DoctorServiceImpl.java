package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Doctor;
import repository.DoctorRepository;
import service.DoctorService;

public class DoctorServiceImpl extends BaseServiceImpl<Doctor, Long, DoctorRepository> implements DoctorService {

    public DoctorServiceImpl(DoctorRepository repository) {
        super(repository);
    }
}
