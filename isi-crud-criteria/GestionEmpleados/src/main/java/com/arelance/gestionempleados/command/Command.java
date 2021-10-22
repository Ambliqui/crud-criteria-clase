/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestionempleados.command;

import com.arelance.gestionempleados.modelo.Empleado;
import javax.ejb.Local;

/**
 *
 * @author Mefisto
 */

public interface Command {
    
    void execute(Empleado empleado);
}
