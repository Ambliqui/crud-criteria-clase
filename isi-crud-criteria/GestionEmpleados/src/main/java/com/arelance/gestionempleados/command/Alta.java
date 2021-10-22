/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestionempleados.command;

import com.arelance.gestionempleados.dao.EmpleadoFacadeLocal;
import com.arelance.gestionempleados.modelo.Empleado;
import com.arelance.gestionempleados.services.EmpleadoService;
import javax.ejb.Stateless;
import javax.inject.Inject;

public class Alta implements Command {

    @Inject
    private EmpleadoService empleadoService;
    
    @Override
    public void execute(Empleado empleado) {
        empleadoService.create(empleado);
    }

}
