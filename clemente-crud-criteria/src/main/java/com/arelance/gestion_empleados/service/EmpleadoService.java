/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestion_empleados.service;

import com.arelance.gestion_empleados.entity.Empleados;
import java.util.List;

/**
 *
 * @author damon
 */
public interface EmpleadoService {
   
    public void addEmpleado(Empleados empleados);
     
     public List<Empleados> getAllEmpleados();
     
     public Empleados getEmpleadoById(int idEmpleado);
     
     public void updateEmpleado(Empleados empleados);
     
     public void deleteEmpleado(int idEmpleado);
 
}
