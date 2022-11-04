package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Prescription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repository.PrescriptionRepository;

import java.util.List;

public class PrescriptionRepositoryImpl extends BaseRepositoryImpl<Prescription, Long> implements PrescriptionRepository {

    public PrescriptionRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Prescription> getEntityClass() {
        return Prescription.class;
    }

    @Override
    public List<Prescription> loadByPatientId(Long patientId) {
        try {
            String hql = """
                    select p from Prescription p
                    where p.patient.id = :input
                    """;
            TypedQuery<Prescription> query = em.createQuery(hql, Prescription.class);
            return query
                    .setParameter("input", patientId)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
