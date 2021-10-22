package com.arelance.filter;

import com.arelance.domain.Department;
import com.arelance.domain.Employee;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Pedro
 */
public class DepartmentFilterSearch implements FilterSearch {

    private final String department;

    public DepartmentFilterSearch(String department) {
        this.department = department;
    }

    @Override
    public Predicate execute(CriteriaBuilder cb, Root<Employee> from) {
        
        Join<Department, Employee> joinEmployeeAndDepartment = from.join("departmentEmployee", JoinType.INNER);
        return cb.like(joinEmployeeAndDepartment.get("nameDepartment"), department);    

    }

}
