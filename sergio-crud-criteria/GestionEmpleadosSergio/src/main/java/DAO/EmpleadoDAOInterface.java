/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entity.Empleado;
import javax.ejb.Local;

/**
 *
 * @author FullstackSergio
 */
@Local
public interface EmpleadoDAOInterface {
    public void registrarEmpleado(Empleado empleado);
    public Empleado leerEmpleadoPorId(int id);
    public void actualizarEmpleado(Empleado empleado);
    public void eliminarEmpleadoPorId(int id);
    public void eliminarEmpleado(Empleado empleado);
}
