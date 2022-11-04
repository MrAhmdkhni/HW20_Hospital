package repository;

import base.repository.BaseRepository;
import entity.Admin;

public interface AdminRepository extends BaseRepository<Admin, Long> {

    Admin loadByFullNameAndUser(String firstname, String lastname, String username);
}
