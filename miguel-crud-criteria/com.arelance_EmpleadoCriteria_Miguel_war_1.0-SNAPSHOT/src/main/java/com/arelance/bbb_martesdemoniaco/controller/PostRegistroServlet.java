/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.bbb_martesdemoniaco.controller;

import com.arelance.bbb_martesdemoniaco.entity.Empleado;
import com.arelance.bbb_martesdemoniaco.exception.CampoVacioException;
import com.arelance.bbb_martesdemoniaco.facade.EmpleadoFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "PostRegistroServlet", urlPatterns = {"/PostRegistroServlet"})
public class PostRegistroServlet extends HttpServlet {

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
     * @throws CampoVacioException si uno de los campos estan vacios, CampoVacioHandler maneja esta excepcion
     * 
     * Al final del metodo, se actualiza en el atributo de la sesion la lista desordenada de todos los empleados
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nombre_empleado = request.getParameter("nombre_empleado");
        String apellido_empleado = request.getParameter("apellido_empleado");
        Integer salario_empleado = Integer.parseInt(request.getParameter("salario_empleado"));
        
        if (nombre_empleado.isEmpty() || apellido_empleado.isEmpty()) {
            throw new CampoVacioException("Campo vacio, por favor, rellene todos los campos");
        }
        
        Empleado empleado = new Empleado();
        empleado.setNombreEmpleado(nombre_empleado);
        empleado.setApellidoEmpleado(apellido_empleado);
        empleado.setSalarioEmpleado(salario_empleado);

        empleadoFacade.create(empleado);
        request.getSession().setAttribute("lista", empleadoFacade.findAll());
        response.sendRedirect("index.jsp");
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
