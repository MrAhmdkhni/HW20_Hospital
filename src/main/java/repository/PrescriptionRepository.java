package repository;

import base.repository.BaseRepository;
import entity.Prescription;

import java.util.List;

public interface PrescriptionRepository extends BaseRepository<Prescription, Long> {

    List<Prescription> loadByPatientId(Long patientId);
}
