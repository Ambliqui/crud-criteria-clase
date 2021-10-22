/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.ejercicioclasecriteria;

import com.antonio.ejercicioclasecriteria.DAO.EmpleadoFacadeLocal;
import com.antonio.ejercicioclasecriteria.servicios.ServiciosEmpleadoLocal;
import java.io.IOException;
import javax.inject.Inject;
import static javax.servlet.RequestDispatcher.ERROR_MESSAGE;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pryet
 */
@WebServlet(name = "PreListado", urlPatterns = {"/preListado"})
public class PreListado extends HttpServlet {

    @Inject
    private EmpleadoFacadeLocal empDAO;
    @Inject
    private ServiciosEmpleadoLocal empServ;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getAttribute("empleadoEditar")==null){
            request.setAttribute("destino", "./guardar");
        }else{
            request.setAttribute("destino", "./editar");
        }
        
        if(request.getAttribute(ERROR_MESSAGE)!=null){
            request.setAttribute("errorMsg","El salario es incorrecto");
        }
        if(request.getAttribute("listaEmpleados")==null){
            request.setAttribute("listaEmpleados", empServ.buscar("", false));
        }
        
        
       request.getRequestDispatcher("./listado.jsp").forward(request, response);
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
