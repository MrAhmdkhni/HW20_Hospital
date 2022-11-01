package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Clinic;
import jakarta.persistence.EntityManager;
import repository.ClinicRepository;

public class ClinicRepositoryImpl extends BaseRepositoryImpl<Clinic, Long> implements ClinicRepository {

    public ClinicRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Clinic> getEntityClass() {
        return Clinic.class;
    }
}
