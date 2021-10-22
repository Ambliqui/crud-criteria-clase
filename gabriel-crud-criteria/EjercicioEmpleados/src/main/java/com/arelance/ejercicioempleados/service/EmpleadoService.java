/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.ejercicioempleados.service;

import com.arelance.ejercicioempleados.domain.Empleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gabri
 */
@Local
public interface EmpleadoService {
    
    public List<Empleado> ListarEmpleados();

    public void createEmpleado(Empleado empleado);

    public void updateEmpleado(Empleado empleado);

    public void deleteEmpleado(Empleado empleado);
}
