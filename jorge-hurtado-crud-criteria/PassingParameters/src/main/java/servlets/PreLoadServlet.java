/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import facade.EmpleadosFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
@WebServlet(name = "PreLoadServlet", urlPatterns = {"/PreLoadServlet"})
public class PreLoadServlet extends HttpServlet {
    @Inject
    private EmpleadosFacadeLocal empleadosFacadeLocal;
/**
 * El retorno de cada metodo es guardado en una variable de nombre X, que será
 * mostrada en index.jsp
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException 
 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
       request.setAttribute("listaEmpleados", empleadosFacadeLocal.findAll());
        request.setAttribute("listaEmpleadosOrder", empleadosFacadeLocal.findAllOrderBy()); 
         //request.setAttribute("listaEmpleadosOrderDesc", empleadosFacadeLocal.findAllOrderByDesc()); 
         request.setAttribute("listaEmpleadosRealGroup", empleadosFacadeLocal.EmpleadoPorSalario());
                 request.setAttribute("listaEmpleadosSalarioHaving", empleadosFacadeLocal.EmpleadoPorSalarioHaving()); 
       request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
