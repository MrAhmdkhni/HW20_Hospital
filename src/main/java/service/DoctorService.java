package service;

import base.service.BaseService;
import entity.Admin;
import entity.Doctor;

import java.util.List;

public interface DoctorService extends BaseService<Doctor, Long> {

    List<Doctor> loadByClinicId(Long clinicId);

    Doctor loadByFullNameAndUser(String firstname, String lastname, String username);
}
