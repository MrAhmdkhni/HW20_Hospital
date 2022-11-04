package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Clinic;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repository.ClinicRepository;

public class ClinicRepositoryImpl extends BaseRepositoryImpl<Clinic, Long> implements ClinicRepository {

    public ClinicRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Clinic> getEntityClass() {
        return Clinic.class;
    }

    @Override
    public Clinic saveByInfo(String name) {
        Clinic clinic = new Clinic(name);
        em.persist(clinic);
        return clinic;
    }

    @Override
    public Clinic loadByName(String name) {
        try {
            String hql = """
                    select c from Clinic c
                    where c.name = :input
                    """;
            TypedQuery<Clinic> query = em.createQuery(hql, Clinic.class);
            return query.setParameter("input", name)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
