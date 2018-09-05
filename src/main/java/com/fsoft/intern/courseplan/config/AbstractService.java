package com.fsoft.intern.courseplan.config;

import java.io.Serializable;
import java.util.List;

public interface AbstractService <T extends Serializable>{
    T findOne(final int id);

    List<T> findAll();

    void create(final T entity);

    void update(final T entity);

    void delete(final T entity);

    void deleteById(final int entityId);
}
