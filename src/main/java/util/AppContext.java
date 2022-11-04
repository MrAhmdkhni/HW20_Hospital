package util;

import entity.Admin;
import entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

public class AppContext {

    private final static PatientRepository PATIENT_REPOSITORY;
    private final static PatientService PATIENT_SERVICE;
    private final static DoctorRepository DOCTOR_REPOSITORY;
    private final static DoctorService DOCTOR_SERVICE;
    private final static ClinicRepository CLINIC_REPOSITORY;
    private final static ClinicService CLINIC_SERVICE;
    private final static AdminRepository ADMIN_REPOSITORY;
    private final static AdminService ADMIN_SERVICE;
    private final static PrescriptionRepository PRESCRIPTION_REPOSITORY;
    private final static PrescriptionService PRESCRIPTION_SERVICE;
    private final static QueuingRepository QUEUING_REPOSITORY;
    private final static QueuingService QUEUING_SERVICE;

    private AppContext() {}

    static {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();

        PATIENT_REPOSITORY = new PatientRepositoryImpl(entityManager);
        PATIENT_SERVICE = new PatientServiceImpl(PATIENT_REPOSITORY);

        DOCTOR_REPOSITORY = new DoctorRepositoryImpl(entityManager);
        DOCTOR_SERVICE = new DoctorServiceImpl(DOCTOR_REPOSITORY);

        CLINIC_REPOSITORY = new ClinicRepositoryImpl(entityManager);
        CLINIC_SERVICE = new ClinicServiceImpl(CLINIC_REPOSITORY);

        ADMIN_REPOSITORY = new AdminRepositoryImpl(entityManager);
        ADMIN_SERVICE = new AdminServiceImpl(ADMIN_REPOSITORY);

        PRESCRIPTION_REPOSITORY = new PrescriptionRepositoryImpl(entityManager);
        PRESCRIPTION_SERVICE = new PrescriptionServiceImpl(PRESCRIPTION_REPOSITORY);

        QUEUING_REPOSITORY = new QueuingRepositoryImpl(entityManager);
        QUEUING_SERVICE = new QueuingServiceImpl(QUEUING_REPOSITORY);
    }

    public static PatientService getPatientService() {
        return PATIENT_SERVICE;
    }

    public static DoctorService getDoctorService() {
        return DOCTOR_SERVICE;
    }

    public static ClinicService getClinicService() {
        return CLINIC_SERVICE;
    }

    public static AdminService getAdminService() {
        return ADMIN_SERVICE;
    }

    public static PrescriptionService getPrescriptionService() {
        return PRESCRIPTION_SERVICE;
    }

    public static QueuingService getQueuingService() {
        return QUEUING_SERVICE;
    }
}
