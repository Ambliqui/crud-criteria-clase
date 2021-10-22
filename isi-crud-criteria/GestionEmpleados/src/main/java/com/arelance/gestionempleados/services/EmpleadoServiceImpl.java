/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestionempleados.services;

import com.arelance.gestionempleados.dao.EmpleadoFacadeLocal;
import com.arelance.gestionempleados.modelo.Empleado;
import com.arelance.gestionempleados.modelo.EmpleadoPorDepartamentoDto;
import com.arelance.gestionempleados.services.EmpleadoService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Stateless
public class EmpleadoServiceImpl implements EmpleadoService {

    @Inject
    EmpleadoFacadeLocal empleadoFL;

    @Override
    public void create(Empleado empleado) {
        empleadoFL.create(empleado);
    }

    @Override
    public void edit(Empleado empleado) {
        empleadoFL.edit(empleado);
    }

    @Override
    public void borrar(Empleado empleado) {
        empleadoFL.borrar(empleado);
    }

    @Override
    public void remove(Empleado empleado) {
        empleadoFL.remove(empleado);
    }

    @Override
    public void modificar(Empleado empleado) {
        empleadoFL.modificar(empleado);
    }

    @Override
    public List<Empleado> ordenar(String campo1, String campo2, String nombre) {
        return empleadoFL.ordenar(campo1, campo2, nombre);
    }

    @Override
    public List<EmpleadoPorDepartamentoDto> agrupar(Integer salario) {
        return empleadoFL.agrupar(salario);
    }

    @Override
    public List<EmpleadoPorDepartamentoDto> agruparJPQL(Integer salario) {
        return empleadoFL.agruparJPQL(salario);
    }

    @Override
    public Empleado find(Object id) {
        return empleadoFL.find(id);
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoFL.findAll();
    }

    @Override
    public List<Empleado> findRange(int[] range) {
        return empleadoFL.findRange(range);
    }

    @Override
    public List<Empleado> findName(String nombre) {
        return empleadoFL.findName(nombre);
    }

    @Override
    public int count() {
        return empleadoFL.count();
    }

    @Override
    public void pruebas(HttpServletRequest request) {
        
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
        
        empleadoFL.modificar(empleado);
    }

}
