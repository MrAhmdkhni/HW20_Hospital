package util;

import entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import repository.PatientRepository;
import repository.impl.PatientRepositoryImpl;
import service.PatientService;
import service.impl.PatientServiceImpl;

public class AppContext {

    private final static PatientRepository PATIENT_REPOSITORY;
    private final static PatientService PATIENT_SERVICE;
//    private final static
//    private final static
//    private final static
//    private final static
//    private final static
//    private final static
//    private final static
//    private final static

    private AppContext() {}

    static {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();

        PATIENT_REPOSITORY = new PatientRepositoryImpl(entityManager);
        PATIENT_SERVICE = new PatientServiceImpl(PATIENT_REPOSITORY);
    }

    public static PatientService getPatientService() {
        return PATIENT_SERVICE;
    }
}
