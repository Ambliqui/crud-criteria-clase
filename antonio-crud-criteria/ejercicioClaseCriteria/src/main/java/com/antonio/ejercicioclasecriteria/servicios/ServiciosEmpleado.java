/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.ejercicioclasecriteria.servicios;

import com.antonio.ejercicioclasecriteria.DAO.EmpleadoFacadeLocal;
import com.antonio.ejercicioclasecriteria.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author pryet
 */
@Stateless
public class ServiciosEmpleado implements ServiciosEmpleadoLocal {

    @Inject
    private EmpleadoFacadeLocal empDAO;
    
    @Override
    public void guardar(Empleado empleado) {
        empDAO.create(empleado);
    }

    @Override
    public void eliminar(int id) {
        empDAO.remove(empDAO.find(id));
    }

    @Override
    public void actualizar(Empleado empleado) {
        empDAO.edit(empleado);
    }

    @Override
    public List<Empleado> buscarTodos() {
        return empDAO.findAll();
    }

    @Override
    public Empleado buscarPorId(int id) {
        return empDAO.find(id);
    }

    @Override
    public void actualizarCriteria(Empleado empleado) {
        empDAO.actualizarCriteria(empleado);
    }

    @Override
    public void eliminarCriteria(int id) {
        empDAO.removeCriteria(id);
    }

    @Override
    public List<Empleado> buscar(String parameter) {
        return empDAO.buscar(parameter);
    }

    @Override
    public List<Empleado> buscar(String parameter, boolean salarioDescendente) {
        return empDAO.buscar(parameter, salarioDescendente);
    }

    @Override
    public List<Empleado> buscarSalario(Integer salario, boolean orden) {
        return empDAO.buscarSalario(salario,orden);
    }

    
}
