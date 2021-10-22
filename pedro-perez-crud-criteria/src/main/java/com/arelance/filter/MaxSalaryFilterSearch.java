package com.arelance.filter;

import com.arelance.domain.Employee;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Pedro
 */
public class MaxSalaryFilterSearch implements FilterSearch {

    private final Integer maxSalary;

    public MaxSalaryFilterSearch(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public Predicate execute(CriteriaBuilder cb, Root<Employee> from) {

        return cb.lt(from.get("salaryEmployee"), maxSalary);

    }

}
