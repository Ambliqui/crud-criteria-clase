/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestionempleados.services;

import com.arelance.gestionempleados.modelo.Empleado;
import com.arelance.gestionempleados.modelo.EmpleadoPorDepartamentoDto;
import java.util.List;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Mefisto
 */
@Local
public interface EmpleadoService {

    void create(Empleado empleado);

    void edit(Empleado empleado);

    void borrar(Empleado empleado);

    void remove(Empleado empleado);

    void modificar(Empleado empleado);

    List<Empleado> ordenar(String campo1, String campo2, String nombre);

    List<EmpleadoPorDepartamentoDto> agrupar(Integer salario);

    List<EmpleadoPorDepartamentoDto> agruparJPQL(Integer salario);

    Empleado find(Object id);

    List<Empleado> findAll();

    List<Empleado> findRange(int[] range);

    List<Empleado> findName(String nombre);

    int count();
    
    void pruebas(HttpServletRequest request);
}
