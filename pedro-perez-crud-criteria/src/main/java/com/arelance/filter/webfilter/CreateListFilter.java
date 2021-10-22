package com.arelance.filter.webfilter;

import com.arelance.filter.FilterSearch;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Pedro
 */
public class CreateListFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        request.setAttribute("filter", new ArrayList<FilterSearch>());

        chain.doFilter(request, response);

    }

}
