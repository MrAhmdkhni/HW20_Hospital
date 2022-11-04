package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Clinic;
import exception.NotFoundClassException;
import repository.ClinicRepository;
import service.ClinicService;

public class ClinicServiceImpl extends BaseServiceImpl<Clinic, Long, ClinicRepository> implements ClinicService {

    public ClinicServiceImpl(ClinicRepository repository) {
        super(repository);
    }

    @Override
    public Clinic saveByInfo(String name) {
        try {
            repository.getEntityManager().getTransaction().begin();
            Clinic clinic = repository.saveByInfo(name);
            repository.getEntityManager().getTransaction().commit();
            return clinic;
        } catch (Exception e) {
            repository.getEntityManager().getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Clinic loadByName(String name) {
        Clinic clinic = repository.loadByName(name);
        if (clinic == null) {
            throw new NotFoundClassException("there is no clinic with this name...!!");
        }
        return clinic;
    }
}
