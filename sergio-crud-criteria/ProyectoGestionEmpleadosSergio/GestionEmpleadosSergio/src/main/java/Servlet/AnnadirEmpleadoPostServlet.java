/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.EmpleadoDAOInterface;
import Entity.Empleado;
import Service.EmpleadoServiceInterface;
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
 * @author serlo
 */
@WebServlet(name = "AnnadirEmpleadoPostServlet", urlPatterns = {"/AnnadirEmpleadoPostServlet"})
public class AnnadirEmpleadoPostServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Inject
    EmpleadoServiceInterface esi;
    @Inject
    EmpleadoDAOInterface eDAOi;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        int sueldo = Integer.parseInt(request.getParameter("sueldo"));
        String departamento = request.getParameter("departamento");
        
        Empleado empleado = new Empleado(nombre, apellidos, sueldo, departamento);
        if(esi.existeEmpleadoHorquilla(empleado)){
            String error = "El empleado que intenta agregar ya existe.";
            request.setAttribute("error", error);
            request.setAttribute("empleado", empleado);
            request.getServletContext().getRequestDispatcher("/AnnadirEmpleadoPreServlet").forward(request, response);
        }
        else{
            eDAOi.registrarEmpleado(empleado);
            response.sendRedirect("EmpleadoAnnadido.jsp");
        }
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
