package base.repository.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<E, ID> {

    protected final EntityManager em;

    public BaseRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public abstract Class<E> getEntityClass();


    @Override
    public E saveOrUpdate(E e) {
        if (e.isNew()) {
            return save(e);
        } else {
            return update(e);
        }
    }

    @Override
    public E save(E e) {
        em.persist(e);
        return e;
    }

    @Override
    public E update(E e) {
        return em.merge(e);
    }

    @Override
    public void remove(E e) {
        em.remove(e);
    }

    @Override
    public E loadById(ID id) {
        try {
            return em.find(getEntityClass(), id);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Optional<E> loadById2(ID id) {
        return Optional.ofNullable(em.find(getEntityClass(), id));
    }

    @Override
    public List<E> loadAll() {
        try {
            return em.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
