package base.service.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import base.service.BaseService;
import exception.NotFoundClassException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {
    
    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E saveOrUpdate(E e) {
        try {
            repository.getEntityManager().getTransaction().begin();
            repository.saveOrUpdate(e);
            repository.getEntityManager().getTransaction().commit();
            return e;
        } catch (Exception ex) {
            repository.getEntityManager().getTransaction().rollback();
            return null;
        }
    }

    @Override
    public E save(E e) {
        try {
            repository.getEntityManager().getTransaction().begin();
            repository.save(e);
            repository.getEntityManager().getTransaction().commit();
            return e;
        } catch (Exception ex) {
            repository.getEntityManager().getTransaction().rollback();
            return null;
        }
    }

    @Override
    public E update(E e) {
        try {
            repository.getEntityManager().getTransaction().begin();
            repository.update(e);
            repository.getEntityManager().getTransaction().commit();
            return e;
        } catch (Exception ex) {
            repository.getEntityManager().getTransaction().rollback();
            return null;
        }
    }

    @Override
    public void remove(E e) {
        try {
            repository.getEntityManager().getTransaction().begin();
            repository.remove(e);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            repository.getEntityManager().getTransaction().rollback();
        }
    }

    @Override
    public E loadById(ID id) {
        E e = repository.loadById(id);
        if (e == null) {
            throw new NotFoundClassException("there is no result with this id...!!");
        }
        return e;
    }

    @Override
    public Optional<E> loadById2(ID id) {
        return repository.loadById2(id);
        //return Optional.empty();
    }

    @Override
    public List<E> loadAll() {
        List<E> eList = repository.loadAll();
        if (eList == null) {
            throw new NotFoundClassException("there is no results...!!");
        }
        return repository.loadAll();
    }
}
