package base.repository;

import base.entity.BaseEntity;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> {

    E saveOrUpdate(E e);

    E save(E e);

    E update(E e);

    void remove(E e);

    E loadById(ID id);

    Optional<E> loadById2(ID id);

    List<E> loadAll();

    EntityManager getEntityManager();
}
