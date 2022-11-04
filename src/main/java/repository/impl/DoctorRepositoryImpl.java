package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Admin;
import entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repository.DoctorRepository;

import java.util.List;

public class DoctorRepositoryImpl extends BaseRepositoryImpl<Doctor, Long> implements DoctorRepository {

    public DoctorRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }

    @Override
    public List<Doctor> loadByClinicId(Long clinicId) {
        try {
            String hql = """
                    select d from Doctor d
                    where d.clinic.id = :input
                    """;
            TypedQuery<Doctor> query = em.createQuery(hql, Doctor.class);
            return query
                    .setParameter("input", clinicId)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Doctor loadByFullNameAndUser(String firstname, String lastname, String username) {
        try {
            String hql = """
                    select d from Doctor d
                    where d.firstname = :input1 and d.lastname = :input2 and d.username = :input3
                    """;
            TypedQuery<Doctor> query = em.createQuery(hql, Doctor.class);
            return query.setParameter("input1", firstname)
                    .setParameter("input2", lastname)
                    .setParameter("input3", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
