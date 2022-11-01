package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Patient;
import jakarta.persistence.EntityManager;
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
}
