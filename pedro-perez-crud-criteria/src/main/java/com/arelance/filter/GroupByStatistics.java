package com.arelance.filter;

import com.arelance.domain.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Pedro
 */
public class GroupByStatistics {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeData");
    private final EntityManager em = emf.createEntityManager();

    public List<Long> getGenreStats() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Employee> from = cq.from(Employee.class);
        cq.select(cb.count(from.get("genreEmployee"))).groupBy(from.get("genreEmployee"));
        TypedQuery<Long> tq = em.createQuery(cq);
        return tq.getResultList();
    }

    public List<Long> getDepartmentStats() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Employee> from = cq.from(Employee.class);
        cq.select(cb.count(from.get("departmentEmployee"))).groupBy(from.get("departmentEmployee"));
        TypedQuery<Long> tq = em.createQuery(cq);
        return tq.getResultList();
    }

    public Double getAverageSalary() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Double> cq = cb.createQuery(Double.class);
        Root<Employee> from = cq.from(Employee.class);
        cq.select(cb.avg(from.get("salaryEmployee")));
        TypedQuery<Double> tq = em.createQuery(cq);
        return tq.getSingleResult();
    }

}
