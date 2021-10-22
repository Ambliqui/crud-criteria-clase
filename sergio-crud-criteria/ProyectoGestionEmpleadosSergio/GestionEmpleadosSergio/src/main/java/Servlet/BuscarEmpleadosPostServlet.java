/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;



import Service.EmpleadoServiceInterface;
import Entity.Empleado;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FullstackSergio
 */
@WebServlet(name = "BuscarEmpleadosPostServlet", urlPatterns = {"/BuscarEmpleadosPostServlet"})
public class BuscarEmpleadosPostServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String sueldominimoaux = request.getParameter("minimo");
        String sueldomaximoaux = request.getParameter("maximo");
        String departamento = request.getParameter("departamento");
        if(sueldomaximoaux.equals("")){
            sueldomaximoaux="1000000";
        }
        if(sueldominimoaux.equals("")){
            sueldominimoaux="0";
        }
        int sueldominimo = Integer.parseInt(sueldominimoaux);
        int sueldomaximo = Integer.parseInt(sueldomaximoaux);
        
        List<Empleado> resultList = esi.obtenerEmpleadosFiltrados(nombre, apellido, sueldominimo, sueldomaximo, departamento);
        request.setAttribute("empleadosFiltrados", resultList);
        request.getServletContext().getRequestDispatcher("/BuscarEmpleados.jsp").forward(request, response);
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
