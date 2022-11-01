package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Admin;
import jakarta.persistence.EntityManager;
import repository.AdminRepository;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin, Long> implements AdminRepository {

    public AdminRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
