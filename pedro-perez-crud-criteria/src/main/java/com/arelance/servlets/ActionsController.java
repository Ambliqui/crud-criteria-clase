package com.arelance.servlets;

import java.io.IOException;
import javax.ejb.Local;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@Local
@FunctionalInterface
public interface ActionsController {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
}
