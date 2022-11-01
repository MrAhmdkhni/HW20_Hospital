package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Doctor;
import jakarta.persistence.EntityManager;
import repository.DoctorRepository;

public class DoctorRepositoryImpl extends BaseRepositoryImpl<Doctor, Long> implements DoctorRepository {

    public DoctorRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }
}
