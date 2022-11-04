package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Admin;
import exception.NotFoundClassException;
import repository.AdminRepository;
import service.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin, Long, AdminRepository> implements AdminService {

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }

    @Override
    public Admin loadByFullNameAndUser(String firstname, String lastname, String username) {
        Admin admin = repository.loadByFullNameAndUser(firstname, lastname, username);
        if (admin == null) {
            throw new NotFoundClassException("there is no admin with this firstname and lastname and username...!!");
        }
        return admin;
    }
}
