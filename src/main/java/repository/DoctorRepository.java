package repository;

import base.repository.BaseRepository;
import entity.Doctor;

import java.util.List;

public interface DoctorRepository extends BaseRepository<Doctor, Long> {

    List<Doctor> loadByClinicId(Long clinicId);

    Doctor loadByFullNameAndUser(String firstname, String lastname, String username);
}
