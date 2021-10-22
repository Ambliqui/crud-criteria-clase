 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Empleado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FullstackSergio
 */
@Stateless
public class EmpleadoDAOImplementado implements EmpleadoDAOInterface {

    @PersistenceContext(unitName = "FiltrosEmpleadoPU")
    EntityManager em;

    @Override
    public void registrarEmpleado(Empleado empleado) {
        em.persist(empleado);
    }

    @Override
    public Empleado leerEmpleadoPorId(int id) {
        Empleado ret = em.find(Empleado.class, id);
        return ret;
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        em.merge(empleado);
    }

    @Override
    public void eliminarEmpleadoPorId(int id) {
        em.remove(leerEmpleadoPorId(id));
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        em.remove(em.merge(empleado));
    }
    
    
}
