package service;

import base.service.BaseService;
import entity.Prescription;

import java.util.List;

public interface PrescriptionService extends BaseService<Prescription, Long> {

    List<Prescription> loadByPatientId(Long patientId);
}
