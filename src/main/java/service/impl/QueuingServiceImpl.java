package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Queuing;
import exception.NotFoundClassException;
import repository.QueuingRepository;
import service.QueuingService;

import java.util.List;

public class QueuingServiceImpl extends BaseServiceImpl<Queuing, Long, QueuingRepository> implements QueuingService {

    public QueuingServiceImpl(QueuingRepository repository) {
        super(repository);
    }

    @Override
    public List<Queuing> loadByDoctorId(Long doctorId) {
        List<Queuing> queuing = repository.loadByDoctorId(doctorId);
        if (queuing == null) {
            throw new NotFoundClassException("there is no queuing with this doctor id...!!");
        }
        return queuing;
    }
}
