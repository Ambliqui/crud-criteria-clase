package com.arelance.filter;

import com.arelance.domain.Employee;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Pedro
 */
@FunctionalInterface
public interface FilterSearch {    
    
    public Predicate execute(CriteriaBuilder cb, Root<Employee> from);

}
