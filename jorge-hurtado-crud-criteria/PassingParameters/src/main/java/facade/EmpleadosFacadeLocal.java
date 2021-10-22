/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Empleados;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.Tuple;

/**
 *
 * @author George_Fullstack
 */
@Local
public interface EmpleadosFacadeLocal {

    void create(Empleados empleados);
    //void createEmpleado(Empleados empleados);
    void edit(Empleados empleados);

    void remove(Empleados empleados);

   // void removeremoveEmpleado(Empleados empleados);

    Empleados find(Object id);
   
    List<Empleados> findAll();
List<Empleados> findAllOrderBy();
List<Empleados> findAllOrderByDesc();
List<Object[]> EmpleadoPorSalario();
List<Object[]> EmpleadoPorSalarioHaving();
    List<Empleados> findRange(int[] range);

    int count();


}
