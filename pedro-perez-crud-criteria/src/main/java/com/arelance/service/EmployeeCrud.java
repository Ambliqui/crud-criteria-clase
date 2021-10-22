package com.arelance.service;

import com.arelance.dao.EmployeeFacadeLocal;
import com.arelance.dao.exceptions.NonexistentEntityException;
import com.arelance.domain.Employee;
import com.arelance.service.qualifiers.EmployeeQ;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Pedro
 */
@EmployeeQ
public class EmployeeCrud implements Crud<Employee> {
    
    @Inject
    private EmployeeFacadeLocal employeeFacade; 

    @Override
    public void create(Employee t) {
        employeeFacade.create(t);
    }

    @Override
    public void update(Employee t) {
        try {
           employeeFacade.update((Employee) t);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Employee t) {
        try {
            employeeFacade.delete(t);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmployeeCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Employee read(Integer t) {        
        return employeeFacade.read(t);
    }
    
    @Override
    public List<Employee> readAll() {
        return employeeFacade.readAll();
    }

}
