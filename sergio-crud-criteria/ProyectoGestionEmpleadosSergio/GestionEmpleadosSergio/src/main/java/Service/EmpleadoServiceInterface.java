/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Entity.Empleado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author FullstackSergio
 */
@Local
public interface EmpleadoServiceInterface {
    public List<Empleado> obtenerEmpleados();
    public List<Empleado> obtenerEmpleadosFiltrados(String nombre, String apellido, int sueldoMinimo, int sueldoMaximo, String departamento);
    public boolean existeEmpleadoHorquilla(Empleado empleado);
    public boolean existeEmpleado(Empleado empleado);
}
