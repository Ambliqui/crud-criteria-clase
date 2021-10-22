/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.ejercicioempleados.facade;

import com.arelance.ejercicioempleados.domain.Empleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
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

    List<Empleado> ascOrder();

    List<Empleado> descOrder();

    List<Empleado> findSalary(Integer salario);

}
