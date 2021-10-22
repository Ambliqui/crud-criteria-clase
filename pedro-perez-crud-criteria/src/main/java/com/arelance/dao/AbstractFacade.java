package com.arelance.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Pedro
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;
    
    protected AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    public void delete(T entity) {
        getEntityManager().merge(entity);
        getEntityManager().remove(entity);
    }

    public T read(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> readAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
