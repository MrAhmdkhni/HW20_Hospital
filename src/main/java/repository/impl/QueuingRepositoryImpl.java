package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Queuing;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import repository.QueuingRepository;

import java.util.List;

public class QueuingRepositoryImpl extends BaseRepositoryImpl<Queuing, Long> implements QueuingRepository {

    public QueuingRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Queuing> getEntityClass() {
        return Queuing.class;
    }

    @Override
    public List<Queuing> loadByDoctorId(Long doctorId) {
        try {
            String hql = """
                    select q from Queuing q
                    where q.doctor.id = :input and q.patient.id is null
                    """;
            TypedQuery<Queuing> query = em.createQuery(hql, Queuing.class);
            return query
                    .setParameter("input", doctorId)
                    .getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
