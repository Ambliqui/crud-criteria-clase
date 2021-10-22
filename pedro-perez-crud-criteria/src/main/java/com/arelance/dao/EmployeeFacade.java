package com.arelance.dao;

import com.arelance.domain.Employee;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pedro
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements Serializable, EmployeeFacadeLocal {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "employeeData")
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

}
