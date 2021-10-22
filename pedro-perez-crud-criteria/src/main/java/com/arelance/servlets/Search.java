package com.arelance.servlets;

import com.arelance.domain.Employee;
import com.arelance.filter.FilterSearch;
import com.arelance.filter.Sorting;
import com.arelance.servlets.qualifiers.SearchEmployeeQ;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Search class is an engine for filtering elements of the Employee table. 
 * It uses the Chain of Responsability pattern. When the user filters a set of
 * data, the filter chain is executed, which are:
 * <ul>
 *   <li>{@code DepartmentWebFilter}</li>
 *   <li>{@code GenreWebFilter}</li>
 *   <li>{@code MaxSalaryWebFilter}</li>
 *   <li>{@code MinSalaryWebFilter}</li>
 * </ul>
 * In addition to that, it has a default sort method, which is with idEmployee.
 * When the filter chain is executed, a series of String are generated and saved
 * in a collection, from this collection each String is collected to be added in
 * the Predicate by means of the {@code execute} method.
 * 
 * @author Pedro
 */
@SearchEmployeeQ
public class Search implements ActionsController {

    @PersistenceContext(unitName = "employeeData")
    EntityManager em;

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Sorting getOrder = new Sorting();

        HttpSession session = request.getSession();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> from = cq.from(Employee.class);

        List<Employee> filteredList;
        List<Predicate> predicates = new ArrayList<>();

        List<FilterSearch> filtersSearch = (List<FilterSearch>) request.getAttribute("filter");
        filtersSearch.forEach(filterSearch -> predicates.add(filterSearch.execute(cb, from)));

        Order order = getOrder.getOrder(request, cb, from, session);

        CriteriaQuery<Employee> select = cq.select(from).where(predicates.toArray(new Predicate[0])).orderBy(order);

        TypedQuery<Employee> tq = em.createQuery(select);
        filteredList = tq.getResultList();
        session.setAttribute("allEmployees", filteredList);

        return "/index.jsp";
    }

}
