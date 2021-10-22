/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.ejercicioclasecriteria.DAO;

import com.antonio.ejercicioclasecriteria.Empleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pryet
 */
@Local
public interface EmpleadoFacadeLocal {

    void create(Empleado empleado);

    void edit(Empleado empleado);
    
    void actualizarCriteria(Empleado entidad);

    void remove(Empleado empleado);
    
    void removeCriteria(int id);

    Empleado find(Object id);

    List<Empleado> findAll();

    List<Empleado> findRange(int[] range);

    int count();

    List<Empleado> buscar(String parameter);
    
    List<Empleado> buscar(String parameter, boolean salarioDescendiente);

    public List<Empleado> buscarSalario(Integer salario, boolean orden);
    
    
    
}
