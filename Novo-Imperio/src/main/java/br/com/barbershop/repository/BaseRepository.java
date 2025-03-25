package br.com.barbershop.repository;

import br.com.barbershop.model.AbstractEntity;

public interface BaseRepository<T extends AbstractEntity> {
    T findOneAndUpdateAttributes(T entity, Object id);
}