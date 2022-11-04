package repository;

import base.repository.BaseRepository;
import entity.Patient;

public interface PatientRepository extends BaseRepository<Patient, Long> {

    Patient saveByInfo(String firstname, String lastname,
                       String nationalCode, String username, String password);

    public Patient loadPatient(String nationalCode);

    public Patient loadPatient(String nationalCode, String username);
}
