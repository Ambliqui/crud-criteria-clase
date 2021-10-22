package com.arelance.dao;

import com.arelance.dao.exceptions.NonexistentEntityException;
import com.arelance.domain.Employee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
public interface EmployeeFacadeLocal {
    
    public void create(Employee employee);
    
    public void update(Employee employee) throws NonexistentEntityException, Exception;
    
    public void delete(Employee employee) throws NonexistentEntityException;
    
    public Employee read(Object id);
    
    public List<Employee> readAll();
    
}
