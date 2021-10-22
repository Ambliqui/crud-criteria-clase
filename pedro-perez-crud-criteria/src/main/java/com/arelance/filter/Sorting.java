package com.arelance.filter;

import com.arelance.domain.Employee;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
public class Sorting {

    public Order getOrder(HttpServletRequest request, CriteriaBuilder cb, Root<Employee> from, HttpSession session) {

        String column = request.getParameter("column");
        String ascDesc = request.getParameter("ascDesc");
        session.setAttribute("column", column);
        session.setAttribute("ascDesc", ascDesc);

        Order order;

        if (column.equals("departmentEmployee") && ascDesc.equals("asc")) {

            return order = cb.asc(from.join("departmentEmployee").get("nameDepartment"));

        } else if (column.equals("departmentEmployee") && ascDesc.equals("desc")) {

            return cb.desc(from.join("departmentEmployee").get("nameDepartment"));

        } else if (ascDesc.equals("desc") && !column.equals("departmentEmployee")) {

            return order = cb.desc(from.get(column));

        }

        return order = cb.asc(from.get(column));

    }

}
