package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Admin;
import repository.AdminRepository;
import service.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin, Long, AdminRepository> implements AdminService {

    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }
}
