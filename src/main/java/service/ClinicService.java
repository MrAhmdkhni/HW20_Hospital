package service;

import base.service.BaseService;
import entity.Clinic;

public interface ClinicService extends BaseService<Clinic, Long> {

    Clinic saveByInfo(String name);

    Clinic loadByName(String name);
}
