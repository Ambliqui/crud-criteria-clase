/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestionempleados.dao;

import com.arelance.gestionempleados.modelo.Empleado;
import com.arelance.gestionempleados.modelo.EmpleadoPorDepartamentoDto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 * Empleado hereda de la fachada abstracta, aqui vamos a declarar los metodos especificos
 * @author Mefisto
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> implements EmpleadoFacadeLocal {

    @PersistenceContext(unitName = "empleados")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    /**
     * Modifica un empleado por Criteria
     * @param empleado recibe un empleado
     */
    @Override
    public void modificar(Empleado empleado) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaUpdate<Empleado> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Empleado.class);
        Root<Empleado> root = criteriaUpdate.from(Empleado.class);
        criteriaUpdate.set("nombreEmpleado", empleado.getNombreEmpleado());
        criteriaUpdate.set("apellidosEmpleado", empleado.getApellidosEmpleado());
        criteriaUpdate.set("edadEmpleado", empleado.getEdadEmpleado());
        criteriaUpdate.set("sexoEmpleado", empleado.getSexoEmpleado());
        criteriaUpdate.set("telefonoEmpleado", empleado.getTelefonoEmpleado());
        criteriaUpdate.set("emailEmpleado", empleado.getEmailEmpleado());
        criteriaUpdate.set("salarioEmpleado", empleado.getSalarioEmpleado());
        criteriaUpdate.set("departamentoEmpleado", empleado.getDepartamentoEmpleado());

        criteriaUpdate.where(criteriaBuilder.equal(root.get("idEmpleado"), empleado.getIdEmpleado()));

        em.createQuery(criteriaUpdate).executeUpdate();
    }

    /**
     * Borra un empleado por Criteria
     * @param empleado recibe un empleado
     */
    @Override
    public void borrar(Empleado empleado) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaDelete<Empleado> criteriaDelete = criteriaBuilder.createCriteriaDelete(Empleado.class);
        Root<Empleado> root = criteriaDelete.from(Empleado.class);
        criteriaDelete.where(criteriaBuilder.equal(root.get("idEmpleado"), empleado.getIdEmpleado()));

        em.createQuery(criteriaDelete).executeUpdate();
    }

    /**
     * Busca un empleado por nombre
     * @param nombre cadena a buscar
     * @return una entidad empleado
     */
    @Override
    public List<Empleado> findName(String nombre) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Empleado> cr = cb.createQuery(Empleado.class);
        Root<Empleado> root = cr.from(Empleado.class);
        cr.select(root).where(cb.like(root.get("nombreEmpleado"), "%" + nombre + "%"));

        TypedQuery<Empleado> query = em.createQuery(cr);
        return query.getResultList();
    }

    /**
     * Ordena una lista de empleados por el campo nombre
     * @param campo1 campo a buscar
     * @param ordenacion ascendente o descendente
     * @param nombre texto a buscar
     * @return Lista de empleados
     */
    @Override
    public List<Empleado> ordenar(String campo1, String ordenacion, String nombre) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Empleado> cr = cb.createQuery(Empleado.class);
        Root<Empleado> root = cr.from(Empleado.class);
        cr.select(root).where(cb.like(root.get("nombreEmpleado"), "%" + nombre + "%"));
        if (ordenacion.equals("ordenAscendente")) {
            cr.orderBy(
                    cb.asc(root.get(campo1)));
        } else {
            cr.orderBy(
                    cb.desc(root.get(campo1)));
        }
        TypedQuery<Empleado> query = em.createQuery(cr);
        return query.getResultList();
    }

    /**
     * Hace una agrupacion por departamento del empleado
     * @param salario
     * @return Lista de empleados por departamento (DTO)
     */
    @Override
    public List<EmpleadoPorDepartamentoDto> agrupar(Integer salario) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EmpleadoPorDepartamentoDto> cq = cb.createQuery(EmpleadoPorDepartamentoDto.class);
        Root<Empleado> root = cq.from(Empleado.class);
        cq.multiselect(cb.count(root.get("idEmpleado")), root.get("departamentoEmpleado"), cb.avg(root.get("salarioEmpleado"))).
                groupBy(root.get("departamentoEmpleado")).
                having(cb.gt(cb.avg(root.get("salarioEmpleado")), salario));
        List<EmpleadoPorDepartamentoDto> resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

    /**
     * Hace una agrupacion por departamentos del empleado
     * @param salario
     * @return Lista de empleados por departamento (DTO)
     */
    @Override
    public List<EmpleadoPorDepartamentoDto> agruparJPQL(Integer salario) {

        String JPQL = "SELECT new com.arelance.gestionempleados.modelo.EmpleadoPorDepartamentoDto(COUNT(e.idEmpleado), e.departamentoEmpleado, AVG(e.salarioEmpleado))"
                + " FROM Empleado e"
                + " GROUP BY e.departamentoEmpleado"
                + " HAVING AVG(e.salarioEmpleado) >" + salario + "";

        TypedQuery query = em.createQuery(JPQL, Empleado.class);
        return query.getResultList();
    }
}
