/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.ejercicioclasecriteria.DAO;

import com.antonio.ejercicioclasecriteria.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author pryet
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> implements EmpleadoFacadeLocal {

    @PersistenceContext(unitName = "prod")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }
/***
 * 
 * @param entidad Entidad Empleado
 * Actualiza la entidad
 */
    @Override
    public void actualizarCriteria(Empleado entidad) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaUpdate<Empleado> update = cb.createCriteriaUpdate(Empleado.class);
        Root from = update.from(Empleado.class);
        update.set("nombre", entidad.getNombre());
        update.set("salario", entidad.getSalario());
        update.where(cb.equal(from.get("id"), entidad.getId()));
        em.createQuery(update).executeUpdate();

    }
/**
 * 
 * @param id id de la entidad
 */
    @Override
    public void removeCriteria(int id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaDelete<Empleado> delete = cb.createCriteriaDelete(Empleado.class);
        Root from = delete.from(Empleado.class);
        delete.where(cb.equal(from.get("id"), id));
        em.createQuery(delete).executeUpdate();
    }
/**
 * 
 * @param parameter nombre de la entidad
 * @return lista de empleados que coinciden con el patron
 */
    @Override
    public List<Empleado> buscar(String parameter) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Empleado> query = cb.createQuery(Empleado.class);
        Root fromEmpleado = query.from(Empleado.class);
        Predicate pNombre = cb.like(fromEmpleado.get("nombre"), "%" + parameter + "%");
        query.select(fromEmpleado).where(pNombre);
        TypedQuery tQuery = em.createQuery(query);
        return tQuery.getResultList();
    }
/**
 * 
 * @param parameter nombre
 * @param orden true descendiente, false ascendete
 * @return lista de empleados que coinciden con el patron ordenados
 */
    @Override
    public List<Empleado> buscar(String parameter, boolean orden) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Empleado> query = cb.createQuery(Empleado.class);
        Root fromEmpleado = query.from(Empleado.class);
        Predicate pNombre = cb.like(fromEmpleado.get("nombre"), "%" + parameter + "%");
        if (orden) {
            query.select(fromEmpleado).where(pNombre).orderBy(cb.desc(fromEmpleado.get("nombre")));
        } else {
            query.select(fromEmpleado).where(pNombre).orderBy(cb.asc(fromEmpleado.get("nombre")));
        }
        TypedQuery tQuery = em.createQuery(query);
        return tQuery.getResultList();
    }
/**
 * 
 * @param salario salario
 * @param orden true descendiente, false ascendete
 * @return lista de empleados con salario mayor o iguales al salario introducido ordenados
 */
    @Override
    public List<Empleado> buscarSalario(Integer salario, boolean orden) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Empleado> query = cb.createQuery(Empleado.class);
        Root fromEmpleado = query.from(Empleado.class);
        Predicate pSalario = cb.greaterThanOrEqualTo(fromEmpleado.get("salario"),  salario );
        if (orden) {
            query.select(fromEmpleado).where(pSalario).orderBy(cb.desc(fromEmpleado.get("salario")));
        } else {
            query.select(fromEmpleado).where(pSalario).orderBy(cb.asc(fromEmpleado.get("salario")));
        }
        TypedQuery tQuery = em.createQuery(query);
        return tQuery.getResultList();
    }

}
