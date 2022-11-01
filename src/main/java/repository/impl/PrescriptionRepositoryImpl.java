package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Prescription;
import jakarta.persistence.EntityManager;

public class PrescriptionRepositoryImpl extends BaseRepositoryImpl<Prescription, Long> implements repository.PrescriptionRepository {

    public PrescriptionRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Prescription> getEntityClass() {
        return Prescription.class;
    }
}
