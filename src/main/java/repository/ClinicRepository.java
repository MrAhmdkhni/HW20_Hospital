package repository;

import base.repository.BaseRepository;
import entity.Clinic;

public interface ClinicRepository extends BaseRepository<Clinic, Long> {

    Clinic saveByInfo(String name);

    Clinic loadByName(String name);
}
