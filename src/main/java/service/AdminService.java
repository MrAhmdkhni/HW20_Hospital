package service;

import base.service.BaseService;
import entity.Admin;

public interface AdminService extends BaseService<Admin, Long> {

    Admin loadByFullNameAndUser(String firstname, String lastname, String username);
}
