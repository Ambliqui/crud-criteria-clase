/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.ejercicioempleados.dao.impl;

import com.arelance.ejercicioempleados.dao.EmpleadoDAO;
import com.arelance.ejercicioempleados.domain.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gabri
 */

//TODO: No se utiliza en ningun momento esta clase... sin sentido
@Stateless
public class EmpleadoDAOImpl implements EmpleadoDAO {

    @PersistenceContext(unitName = "empleadodb")
    EntityManager em;

    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

    @Override
    public List<Empleado> ListarEmpleados() {
        CriteriaQuery<Empleado> criteriaQuery = criteriaBuilder.createQuery(Empleado.class);
        Root<Empleado> from = criteriaQuery.from(Empleado.class);
        CriteriaQuery<Empleado> select = criteriaQuery.select(from);
        TypedQuery<Empleado> typedQuery = em.createQuery(select);
        return typedQuery.getResultList();
    }

    @Override
    public void createEmpleado(Empleado empleado) {
        em.persist(empleado);
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        CriteriaUpdate<Empleado> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Empleado.class);
        Root<Empleado> root = criteriaUpdate.from(Empleado.class);
        criteriaUpdate.set("nombre_empleado", empleado.getNombreEmpleado());
        criteriaUpdate.set("apellido_empleado", empleado.getApellidoEmpleado());
        criteriaUpdate.set("salario", empleado.getSalario());
        criteriaUpdate.where(criteriaBuilder.equal(root.get("idempleado"), empleado.getIdempleados()));

        //TODO: en la vida te va a funcionar esto, ya es transacional
        em.getTransaction().begin();
        em.createQuery(criteriaUpdate).executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        CriteriaDelete<Empleado> criteriaDelete = criteriaBuilder.createCriteriaDelete(Empleado.class);
        Root<Empleado> root = criteriaDelete.from(Empleado.class);
        criteriaDelete.where(criteriaBuilder.greaterThan(root.get("nombre_empleado"), empleado.getNombreEmpleado()));

        //TODO: en la vida te va a funcionar esto, ya es transacional
        em.getTransaction().begin();
        em.createQuery(criteriaDelete).executeUpdate();
        em.getTransaction().commit();
    }

}
