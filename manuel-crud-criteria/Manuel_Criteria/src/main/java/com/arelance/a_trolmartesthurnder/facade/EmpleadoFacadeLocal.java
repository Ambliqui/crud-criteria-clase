/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.a_trolmartesthurnder.facade;

import com.arelance.a_trolmartesthurnder.entity.Empleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Manuel
 */
@Local
public interface EmpleadoFacadeLocal {

    void create(Empleado empleado);

    void edit(Empleado empleado);

    void remove(Empleado empleado);

    Empleado find(Object id);

    List<Empleado> findAll();

    List<Empleado> findRange(int[] range);

    int count();
    
    List<Empleado> findDep(String nombre);
    
    Empleado findNom(String nombre);
    
    Empleado findApe(String nombre);
    
    List<Empleado> findSal(String nombre);
    
    List<Long> DepartamentosMayores1();
    
    List<Empleado> OrdenAscendente();
    
    List<Empleado> OrdenDescendente();
    
    
}
