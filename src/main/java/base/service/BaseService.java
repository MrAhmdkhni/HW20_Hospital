package base.service;

import base.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {

    E saveOrUpdate(E e);

    E save(E e);

    E update(E e);

    void remove(E e);

    E loadById(ID id);

    Optional<E> loadById2(ID id);

    List<E> loadAll();
}
