/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.bbb_martesdemoniaco.filtros;

import com.arelance.bbb_martesdemoniaco.facade.EmpleadoFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "FiltroSalarioServlet", urlPatterns = {"/FiltroSalarioServlet"})
public class FiltroSalarioServlet extends HttpServlet {

    @EJB
    EmpleadoFacadeLocal empleadoFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws NumberFormatException si el salario minimo es mayor que el maximo
     * Guarda en la sesion la lista filtrada por los salarios indicados, y se
     * devuelve al jsp donde se solicito el filtro
     *
     * Si el valor de maximo esta en blanco o es cero se le asigna el valor
     * maximo de int para que busque a todos los empleados con un minimo de
     * salario
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int minimo = Integer.parseInt(request.getParameter("salario_min"));
        int maximo = 0;
        try {
            maximo = Integer.parseInt(request.getParameter("salario_max"));
            if (maximo == 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            maximo = Integer.MAX_VALUE;
        }
        if (minimo > maximo) {
            throw new NumberFormatException("Por favor, escriba valores correctos");
        }
        request.getSession().setAttribute("lista", empleadoFacade.filtrarBySalario(minimo, maximo));
        response.sendRedirect(request.getHeader("referer"));
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
