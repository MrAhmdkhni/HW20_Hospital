package service;

import base.service.BaseService;
import entity.Patient;

public interface PatientService extends BaseService<Patient, Long> {

    Patient saveByInfo(String firstname, String lastname,
                       String nationalCode, String username, String password);
}
