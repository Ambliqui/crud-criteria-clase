/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestion_empleados.dao.implement;

import com.arelance.gestion_empleados.dao.EmpleadoDao;
import com.arelance.gestion_empleados.entity.Empleados;
import java.util.List;
import javax.persistence.Query;



/**
 *
 * @author damon
 */
public class EmpleadoDaoImpl implements EmpleadoDao {
 

    private SessionFactory sessionFactory;
 

    @Override
    public void addEmpleado(Empleados empleados) {
        sessionFactory.getCurrentSession().save(empleados);
    }
 

    @Override
    public List<Empleados> getAllEmpleados() {
        return sessionFactory.getCurrentSession().createQuery("from Empleados").getResultList();
    }

    @Override
    public Empleados getEmpleadoById(int idEmpleado) {
 
        Session session = sessionFactory.getCurrentSession();
        Empleados empleados = null;
        String hqlQuery = "from User where id = :id";
        @SuppressWarnings("rawtypes")
        Query query = session.createQuery(hqlQuery);
        query.setParameter("id", idEmpleado);
        empleados = (Empleados) query.getSingleResult();
        return empleados;
    }
 

    @Override
    public void updateEmpleado(Empleados empleados){
        sessionFactory.getCurrentSession().update(empleados);
    }
 

    @Override
    public void deleteEmpleado(int idEmpleado) {
 
        Empleados empleados = (Empleados) sessionFactory.getCurrentSession().load(Empleados.class, idEmpleado);
        if (null != empleados) {
            sessionFactory.getCurrentSession().delete(empleados);
        }
 
    }
 
}
