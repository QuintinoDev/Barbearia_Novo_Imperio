package br.com.barbershop.repository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.apache.commons.beanutils.PropertyUtils;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.barbershop.model.AbstractEntity;
import br.com.barbershop.util.assignment.Views;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class BaseRepositoryImpl<T extends AbstractEntity> implements BaseRepository<T> {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public T findOneAndUpdateAttributes(T entity) {
    	@SuppressWarnings("unchecked")
		T existingEntity = (T) em.find(entity.getClass(), entity.getId());

        if (existingEntity == null) {
            throw new IllegalArgumentException("Entity not found: " + entity.getId());
        }

        try {
            copyNonEditableFields(existingEntity, entity);
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Failed to update entity attributes", e);
        }

        return entity;
    }

    public void copyNonEditableFields(T source, T target) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<?> current = source.getClass();

        while (current != Object.class) {
            for (Field field : current.getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonView.class)) {
                    JsonView viewer = field.getAnnotation(JsonView.class);

                    if (!Arrays.asList(viewer.value()).contains(Views.Editable.class)) {
                    	if (PropertyUtils.isReadable(source, field.getName()) &&
                            PropertyUtils.isWriteable(target, field.getName())) {
                            
                            Object value = PropertyUtils.getProperty(source, field.getName());
                            PropertyUtils.setProperty(target, field.getName(), value);
                        }
                    }
                }
            }
            current = current.getSuperclass();
        }
    }
}
