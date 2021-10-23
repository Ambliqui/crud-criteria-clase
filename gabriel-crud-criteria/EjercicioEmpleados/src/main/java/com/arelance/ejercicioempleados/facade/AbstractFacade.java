/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.ejercicioempleados.facade;

import com.arelance.ejercicioempleados.domain.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author usuario
 */

//TODO: no usas nunca la fachada
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    /*
    Ordena la tabla de Empleados de manera ascendente usando el parametro
    "nombreEmpleado"
    */
    public List<T> ascOrder() {

        CriteriaQuery<Empleado> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(Empleado.class);
        Root<Empleado> from = criteriaQuery.from(Empleado.class);
        CriteriaQuery<Empleado> select = criteriaQuery.select(from);
        criteriaQuery.orderBy(getEntityManager().getCriteriaBuilder().asc(from.get("nombreEmpleado")));
        TypedQuery<Empleado> typedQuery = getEntityManager().createQuery(select);
        return (List<T>) typedQuery.getResultList();
    }
    /*
    Ordena la tabla de Empleados de manera descendente usando el parametro
    "nombreEmpleado"
    */
    public List<T> descOrder() {
        CriteriaQuery<Empleado> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(Empleado.class);
        Root<Empleado> from = criteriaQuery.from(Empleado.class);
        CriteriaQuery<Empleado> select = criteriaQuery.select(from);
        criteriaQuery.orderBy(getEntityManager().getCriteriaBuilder().desc(from.get("nombreEmpleado")));
        TypedQuery<Empleado> typedQuery = getEntityManager().createQuery(select);
        return (List<T>) typedQuery.getResultList();
    }
    /*
    Filtra los empleados que tengan el mismo salario, que se pasará como parámetro.
    "nombreEmpleado"
    */
    public List<T> findSalary(Integer salario) {
        CriteriaQuery<Empleado> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(Empleado.class);
        Root<Empleado> from = criteriaQuery.from(Empleado.class);
        CriteriaQuery<Empleado> select = criteriaQuery.select(from);
        select.where(getEntityManager().getCriteriaBuilder().equal(from.get("salario"), salario));
        TypedQuery<Empleado> typedQuery = getEntityManager().createQuery(select);
        return (List<T>) typedQuery.getResultList();
    }
}
