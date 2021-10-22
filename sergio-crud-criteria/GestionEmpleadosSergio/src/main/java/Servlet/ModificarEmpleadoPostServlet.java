/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.EmpleadoDAOInterface;
import Entity.Empleado;
import Service.EmpleadoServiceImplementado;
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
@WebServlet(name = "ModificarEmpleadoPostServlet", urlPatterns = {"/ModificarEmpleadoPostServlet"})
public class ModificarEmpleadoPostServlet extends HttpServlet {

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
        String sueldoaux = request.getParameter("sueldo");
        String departamento = request.getParameter("departamento");
        int sueldo;

        int id = Integer.parseInt(request.getParameter("id"));

        Empleado empleado = eDAOi.leerEmpleadoPorId(id);

        if (nombre.equals("") && apellidos.equals("") && sueldoaux.equals("") && departamento.equals("")) {
            String error = "Introduzca al menos un dato.";
            request.setAttribute("error", error);
            request.setAttribute("empleado", empleado);
            request.getServletContext().getRequestDispatcher("/ModificarEmpleado.jsp?id=" + id).forward(request, response);
        } else {
            if (nombre.equals("")) {
                nombre = empleado.getNombreempleado();
            }
            if (apellidos.equals("")) {
                apellidos = empleado.getApellidoempleado();
            }
            if (sueldoaux.equals("")) {
                sueldo = empleado.getSueldoempleado();
            } else {
                sueldo = Integer.parseInt(sueldoaux);
            }
            if (departamento.equals("")) {
                departamento = empleado.getDepartamentoempleado();
            }
            Empleado empleadoAComprobar = new Empleado(id,nombre, apellidos, sueldo, departamento);
            if (esi.existeEmpleado(empleadoAComprobar)) {
                String error = "Modifique al menos un dato.";
                request.setAttribute("error", error);
                request.setAttribute("empleado", empleado);
                request.getServletContext().getRequestDispatcher("/ModificarEmpleado.jsp?id=" + id).forward(request, response);
            } else {
                eDAOi.actualizarEmpleado(empleadoAComprobar);
                response.sendRedirect("EmpleadoModificado.jsp");
            }
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
