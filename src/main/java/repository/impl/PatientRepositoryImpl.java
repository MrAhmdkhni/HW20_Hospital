package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repository.PatientRepository;

public class PatientRepositoryImpl extends BaseRepositoryImpl<Patient, Long> implements PatientRepository {

    public PatientRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    public Patient saveByInfo(String firstname, String lastname, String nationalCode, String username, String password) {
        Patient patient = new Patient(firstname, lastname, nationalCode, username, password);
        em.persist(patient);
        return patient;
    }

    @Override
    public Patient loadPatient(String nationalCode) {
        try {
            String hql = """
                    select p from Patient p
                    where p.nationalCode = :input
                    """;
            TypedQuery<Patient> query = em.createQuery(hql, Patient.class);
            return query
                    .setParameter("input", nationalCode)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Patient loadPatient(String nationalCode, String username) {
        try {
            String hql = """
                    select p from Patient p
                    where p.nationalCode = :input1 and p.username = :input2
                    """;
            TypedQuery<Patient> query = em.createQuery(hql, Patient.class);
            return query.setParameter("input1", nationalCode)
                    .setParameter("input2", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
