/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.ejercicioempleados.service.impl;

import com.arelance.ejercicioempleados.dao.EmpleadoDAO;
import com.arelance.ejercicioempleados.domain.Empleado;
import com.arelance.ejercicioempleados.service.EmpleadoService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Gabri
 */

//TODO: No utilizas la implementacion para nada
public class EmpleadoServiceImpl implements EmpleadoService {

    @Inject
    private EmpleadoDAO empleadoDAO;

    @Override
    public List<Empleado> ListarEmpleados() {
        return empleadoDAO.ListarEmpleados();
    }

    @Override
    public void createEmpleado(Empleado empleado) {
        empleadoDAO.createEmpleado(empleado);
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        empleadoDAO.updateEmpleado(empleado);
    }

    @Override
    public void deleteEmpleado(Empleado empleado) {
        empleadoDAO.deleteEmpleado(empleado);
    }

}
