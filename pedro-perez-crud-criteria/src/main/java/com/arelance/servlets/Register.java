package com.arelance.servlets;

import com.arelance.servlets.qualifiers.RegisterEmployeeQ;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@RegisterEmployeeQ
public class Register implements ActionsController {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hola, he sido ejecutado!");
        return "/index.jsp";
    }
    
}
