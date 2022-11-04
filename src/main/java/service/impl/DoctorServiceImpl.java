package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Admin;
import entity.Doctor;
import exception.NotFoundClassException;
import repository.DoctorRepository;
import service.DoctorService;

import java.util.List;

public class DoctorServiceImpl extends BaseServiceImpl<Doctor, Long, DoctorRepository> implements DoctorService {

    public DoctorServiceImpl(DoctorRepository repository) {
        super(repository);
    }

    @Override
    public List<Doctor> loadByClinicId(Long clinicId) {
        List<Doctor> doctors = repository.loadByClinicId(clinicId);
        if (doctors == null) {
            throw new NotFoundClassException("there is no doctor with this clinic id...!!");
        }
        return doctors;
    }

    @Override
    public Doctor loadByFullNameAndUser(String firstname, String lastname, String username) {
        Doctor doctor = repository.loadByFullNameAndUser(firstname, lastname, username);
        if (doctor == null) {
            throw new NotFoundClassException("there is no doctor with this firstname and lastname and username...!!");
        }
        return doctor;
    }
}
