package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Admin;
import entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repository.AdminRepository;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin, Long> implements AdminRepository {

    public AdminRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }

    @Override
    public Admin loadByFullNameAndUser(String firstname, String lastname, String username) {
        try {
            String hql = """
                    select a from Admin a
                    where a.firstname = :input1 and a.lastname = :input2 and a.username = :input3
                    """;
            TypedQuery<Admin> query = em.createQuery(hql, Admin.class);
            return query.setParameter("input1", firstname)
                    .setParameter("input2", lastname)
                    .setParameter("input3", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
