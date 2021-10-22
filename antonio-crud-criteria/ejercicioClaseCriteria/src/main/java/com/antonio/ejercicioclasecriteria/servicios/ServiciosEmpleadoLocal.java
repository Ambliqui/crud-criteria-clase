/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.ejercicioclasecriteria.servicios;

import com.antonio.ejercicioclasecriteria.Empleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author pryet
 */
@Local
public interface ServiciosEmpleadoLocal {

    void guardar(Empleado Empleado);

    void eliminar(int id);

    void actualizar(Empleado empleado);
    
    void actualizarCriteria(Empleado empleado);
    
    void eliminarCriteria(int id);

    List<Empleado> buscarTodos();

    Empleado buscarPorId(int id);
    
    public List<Empleado> buscar(String parameter);

    public List<Empleado> buscar(String parameter, boolean salarioDescendente);

    public List<Empleado> buscarSalario(Integer salario, boolean orden);
    
}
