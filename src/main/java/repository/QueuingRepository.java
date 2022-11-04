package repository;

import base.repository.BaseRepository;
import entity.Queuing;

import java.util.List;

public interface QueuingRepository extends BaseRepository<Queuing, Long> {

    List<Queuing> loadByDoctorId(Long doctorId);
}
