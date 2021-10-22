package com.arelance.filter.webfilter;

import com.arelance.filter.FilterSearch;
import com.arelance.filter.GenreFilterSearch;
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
public class GenreWebFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();

        String genre = request.getParameter("genre");
        session.setAttribute("genre", genre);

        if (!(genre != null && genre.trim().length() > 0) || genre.equals("all")) {
            chain.doFilter(request, response);
        }
        List<FilterSearch> filtersSearch = (List<FilterSearch>) request.getAttribute("filter");
        FilterSearch fs = new GenreFilterSearch(genre);
        filtersSearch.add(fs);
        chain.doFilter(request, response);

    }

}
