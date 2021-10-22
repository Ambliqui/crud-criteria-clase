/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Empleados;
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
@WebServlet(name = "GlobalServlet", urlPatterns = {"/GlobalServlet"})
public class GlobalServlet extends HttpServlet {

    @Inject
    private EmpleadosFacadeLocal empleadosFacadeLocal;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action) {
            case "addEmp":
                Empleados nuevoEmpleado1 = new Empleados();
                //nuevoEmpleado1.setIdempleados(0);
                nuevoEmpleado1.setNombre(request.getParameter("nombre"));
                nuevoEmpleado1.setApellido(request.getParameter("apellido"));
                nuevoEmpleado1.setSalario(Integer.parseInt(request.getParameter("salario")));
                empleadosFacadeLocal.create(nuevoEmpleado1);

                request.getRequestDispatcher("PreLoadServlet").forward(request, response);
                break;
            case "delete":
                Empleados adiosEmpleado = new Empleados();
                int id = Integer.parseInt(request.getParameter("id"));
                adiosEmpleado.setIdempleados(id);
                empleadosFacadeLocal.remove(adiosEmpleado);

                request.getRequestDispatcher("PreLoadServlet").forward(request, response);
                break;
            case "asc":

                request.setAttribute("listaEmpleadosOrderAsc", empleadosFacadeLocal.findAllOrderBy());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                //request.getRequestDispatcher("PreLoadServlet").forward(request, response);
                break;
            case "muestraTodos":

                request.setAttribute("listaEmpleados", empleadosFacadeLocal.findAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                //request.getRequestDispatcher("PreLoadServlet").forward(request, response);
                break;
            case "edit":
                String message = "Example source code of Servlet to JSP communication.";
                request.setAttribute("message", message);

                //PASAR INFO DE EMPLEADO INDEX A EDIT
                request.setAttribute("id", request.getParameter("id"));
                request.setAttribute("nombre", request.getParameter("nombre"));
                request.setAttribute("apellido", request.getParameter("apellido"));
                request.setAttribute("salario", request.getParameter("salario"));

                request.getRequestDispatcher("edit.jsp").forward(request, response);
                break;
            case "mostrar":

                break;
            case "showedit":

                break;
            case "editar":

                break;
            case "eliminar":

                break;
            default:
                request.getRequestDispatcher("ServletCRUD").forward(request, response);
                break;
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
