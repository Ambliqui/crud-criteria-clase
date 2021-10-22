package com.arelance.filter;

import com.arelance.domain.Employee;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Pedro
 */
public class GenreFilterSearch implements FilterSearch {

    private final String genre;

    public GenreFilterSearch(String genre) {
        this.genre = genre;
    }

    @Override
    public Predicate execute(CriteriaBuilder cb, Root<Employee> from) {

        return cb.like(from.get("genreEmployee"), genre);

    }

}
