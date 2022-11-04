package service;

import base.service.BaseService;
import entity.Queuing;

import java.util.List;

public interface QueuingService extends BaseService<Queuing, Long> {

    List<Queuing> loadByDoctorId(Long doctorId);
}
