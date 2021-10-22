package com.arelance.filter.webfilter;

import com.arelance.filter.FilterSearch;
import com.arelance.filter.GenreFilterSearch;
import com.arelance.filter.MaxSalaryFilterSearch;
import com.arelance.filter.MinSalaryFilterSearch;
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
public class MaxSalaryWebFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();

        String maxSalary = request.getParameter("maxSalary");
        session.setAttribute("maxSalary", maxSalary);

        if (!(maxSalary != null && maxSalary.trim().length() > 0)) {
            chain.doFilter(request, response);
        }
        List<FilterSearch> filtersSearch = (List<FilterSearch>) request.getAttribute("filter");
        FilterSearch fs = new MaxSalaryFilterSearch(Integer.parseInt(maxSalary));
        filtersSearch.add(fs);
        chain.doFilter(request, response);

    }

}
