package com.arelance.filter;

import com.arelance.domain.Employee;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Pedro
 */
public class MinSalaryFilterSearch implements FilterSearch {

    private final Integer minSalary;

    public MinSalaryFilterSearch(Integer minSalary) {
        this.minSalary = minSalary;
    }

    @Override
    public Predicate execute(CriteriaBuilder cb, Root<Employee> from) {

        return cb.gt(from.get("salaryEmployee"), minSalary);

    }

}
