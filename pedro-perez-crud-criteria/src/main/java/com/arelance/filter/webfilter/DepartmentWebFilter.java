package com.arelance.filter.webfilter;

import com.arelance.filter.DepartmentFilterSearch;
import com.arelance.filter.FilterSearch;
import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
public class DepartmentWebFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpSession session=((HttpServletRequest) request).getSession();

        String department = request.getParameter("department");
        session.setAttribute("department", department);

        if (!(department != null && department.trim().length() > 0) || department.equals("all")) {
            chain.doFilter(request, response);
        }
        List<FilterSearch> filtersSearch = (List<FilterSearch>) request.getAttribute("filter");
        FilterSearch fs = new DepartmentFilterSearch(department);
        filtersSearch.add(fs);
        chain.doFilter(request, response);

    }

}
