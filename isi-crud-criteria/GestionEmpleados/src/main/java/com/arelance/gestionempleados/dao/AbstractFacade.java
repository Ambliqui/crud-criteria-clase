/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestionempleados.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * Fachada abstracta para el CRUD de cualquier entidad
 * @author Mefisto
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    /**
     * Da de alta una entidad
     * @param entity 
     */
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     * Modifica una entidad
     * @param entity 
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * Borra una entidad
     * @param entity 
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Busca una entidad por su clave primaria unica
     * @param id
     * @return devuelve una entidad
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Busca todos los registros de una entidad
     * @return devuelve una lista de entidades
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Devuelve una lista delimitada por un rango
     * @param range array de enteros
     * @return lista de entidades
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * Devuelve la cantidad de elementos de una entidad
     * @return devuelve la cantidad de elementos de una entidad
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
