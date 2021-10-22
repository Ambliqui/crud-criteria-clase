/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestionempleados.servlets;

import com.arelance.gestionempleados.modelo.Empleado;
import com.arelance.gestionempleados.services.EmpleadoService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mefisto
 */
@WebServlet(name = "PostDatosEmpleadoServlet", urlPatterns = {"/PostDatosEmpleadoServlet"})
public class PostDatosEmpleadoServlet extends HttpServlet {

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
    private EmpleadoService empleadoService;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        Integer id = Integer.parseInt(request.getParameter("idEmpleado"));
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        Integer edad = Integer.parseInt(request.getParameter("edad"));
        Boolean sexo = Boolean.parseBoolean(request.getParameter("sexo"));
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        Long salario = Long.parseLong(request.getParameter("salario"));
        String departamento = request.getParameter("departamento");

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(id);
        empleado.setNombreEmpleado(nombre);
        empleado.setApellidosEmpleado(apellidos);
        empleado.setEdadEmpleado(edad);
        empleado.setSexoEmpleado(sexo);
        empleado.setSalarioEmpleado(salario);
        empleado.setTelefonoEmpleado(telefono);
        empleado.setEmailEmpleado(email);
        empleado.setDepartamentoEmpleado(departamento);
        
        //XXX: hacer comando error de envoltorio
//        empleadoService.pruebas(request);

//        Map<String, Command> acciones = new HashMap<>();
//        
//        acciones.put("Alta", new Alta());
//        acciones.put("Actualizar", new Actualizar());
//        acciones.put("Eliminar", new Baja());
//        acciones.get(accion).execute(empleado);
        
//        Actualizar actualizar = new Actualizar();
//        actualizar.execute(empleado);
        
        switch (accion) {
            case "Alta":
                empleadoService.create(empleado);
                break;
            case "Actualizar":
                //TODO: metodo alternativo --> empleadoService.edit(empleado);
                empleadoService.modificar(empleado);
                break;
            case "Eliminar":
                //TODO: metodo alternativo --> empleadoService.remove(empleado);
                empleadoService.borrar(empleado);
                break;
            default:
        }

        request.getRequestDispatcher("PreIndexServlet").forward(request, response);
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
