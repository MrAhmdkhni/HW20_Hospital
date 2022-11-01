package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Patient;
import repository.PatientRepository;
import service.PatientService;

public class PatientServiceImpl extends BaseServiceImpl<Patient, Long, PatientRepository> implements PatientService {

    public PatientServiceImpl(PatientRepository repository) {
        super(repository);
    }

    @Override
    public Patient saveByInfo(String firstname, String lastname, String nationalCode, String username, String password) {
        try {
            repository.getEntityManager().getTransaction().begin();
            Patient patient = repository.saveByInfo(firstname, lastname, nationalCode, username, password);
            repository.getEntityManager().getTransaction().commit();
            return patient;
        } catch (Exception ex) {
            repository.getEntityManager().getTransaction().rollback();
            return null;
        }
    }
}
