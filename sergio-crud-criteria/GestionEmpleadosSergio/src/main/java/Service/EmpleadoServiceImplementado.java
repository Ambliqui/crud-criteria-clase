/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Entity.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author FullstackSergio
 */
@Stateless
public class EmpleadoServiceImplementado implements EmpleadoServiceInterface {

    @PersistenceContext(unitName = "FiltrosEmpleadoPU")
    EntityManager em;

    @Override
    public List<Empleado> obtenerEmpleados() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Empleado> criteriaQuery = criteriaBuilder.createQuery(Empleado.class);

        Root<Empleado> from = criteriaQuery.from(Empleado.class);

        //select all records
        CriteriaQuery<Empleado> select = criteriaQuery.select(from);
        TypedQuery<Empleado> typedQuery = em.createQuery(select);
        List<Empleado> resultList = typedQuery.getResultList();
        return resultList;
    }

    @Override
    public List<Empleado> obtenerEmpleadosFiltrados(String nombre, String apellido, int sueldoMinimo, int sueldoMaximo, String departamento) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Empleado> criteriaQuery = criteriaBuilder.createQuery(Empleado.class);

        Root<Empleado> root = criteriaQuery.from(Empleado.class);

        Predicate[] predicates = new Predicate[5];
        predicates[0] = criteriaBuilder.like(root.get("nombreempleado"), "%"+nombre+"%");
        predicates[1] = criteriaBuilder.like(root.get("apellidoempleado"), "%"+apellido+"%");
        predicates[2] = criteriaBuilder.gt(root.get("sueldoempleado"), sueldoMinimo);
        predicates[3] = criteriaBuilder.lt(root.get("sueldoempleado"), sueldoMaximo);
        predicates[4] = criteriaBuilder.like(root.get("departamentoempleado"), "%"+departamento+"%");

        criteriaQuery.select(root).where(predicates);

        TypedQuery<Empleado> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getResultList();

    }
    
    @Override
    public boolean existeEmpleadoHorquilla(Empleado empleado){
        boolean existe = false;
        
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Empleado> criteriaQuery = criteriaBuilder.createQuery(Empleado.class);

        Root<Empleado> root = criteriaQuery.from(Empleado.class);

        Predicate[] predicates = new Predicate[3];
        predicates[0] = criteriaBuilder.like(root.get("nombreempleado"), empleado.getNombreempleado());
        predicates[1] = criteriaBuilder.like(root.get("apellidoempleado"), empleado.getApellidoempleado());
        predicates[2] = criteriaBuilder.like(root.get("departamentoempleado"), empleado.getDepartamentoempleado());

        criteriaQuery.select(root).where(predicates);

        TypedQuery<Empleado> typedQuery = em.createQuery(criteriaQuery);
        List<Empleado> empleados = typedQuery.getResultList();
        
        if(!empleados.isEmpty()){
            existe=true;
        }        
        
        return existe;
    }
    
    @Override
    public boolean existeEmpleado(Empleado empleado){
        boolean existe = false;
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Empleado> criteriaQuery = criteriaBuilder.createQuery(Empleado.class);

        Root<Empleado> root = criteriaQuery.from(Empleado.class);

        Predicate[] predicates = new Predicate[5];
        predicates[0] = criteriaBuilder.equal(root.get("idempleado"), empleado.getIdempleado());
        predicates[1] = criteriaBuilder.equal(root.get("nombreempleado"), empleado.getNombreempleado());
        predicates[2] = criteriaBuilder.equal(root.get("apellidoempleado"), empleado.getApellidoempleado());
        predicates[3] = criteriaBuilder.equal(root.get("sueldoempleado"),empleado.getSueldoempleado());
        predicates[4] = criteriaBuilder.equal(root.get("departamentoempleado"), empleado.getDepartamentoempleado());

        criteriaQuery.select(root).where(predicates);

        TypedQuery<Empleado> typedQuery = em.createQuery(criteriaQuery);
        List<Empleado> empleados = typedQuery.getResultList();
        
        if(!empleados.isEmpty()){
            existe=true;
        }        
        return existe;
    }
}
