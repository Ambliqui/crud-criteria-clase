package com.arelance.servlets;

import com.arelance.servlets.qualifiers.RegisterEmployeeQ;
import com.arelance.servlets.qualifiers.SearchEmployeeQ;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@WebServlet("/actions")
public class ActionsService extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private final Map<String, ActionsController> actions = new HashMap<>();
    
    @Inject
    @SearchEmployeeQ
    private ActionsController searchEmployee;
    
    @Inject
    @RegisterEmployeeQ
    private ActionsController registerEmployee;
    
    @Override
    public void init() throws ServletException {
        super.init();
        actions.put("search", searchEmployee);
        actions.put("register", registerEmployee);
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String actionKey = request.getParameter("action");
        
        ActionsController action = actions.get(actionKey);
        String page = action.execute(request, response);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
        
    }
    
}
