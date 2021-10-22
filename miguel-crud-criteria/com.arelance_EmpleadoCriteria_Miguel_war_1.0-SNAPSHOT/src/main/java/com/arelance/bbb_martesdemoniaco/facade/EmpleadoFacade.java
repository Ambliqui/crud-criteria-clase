package com.arelance.bbb_martesdemoniaco.facade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.arelance.bbb_martesdemoniaco.entity.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Miguel
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> implements EmpleadoFacadeLocal {

    @PersistenceContext(unitName = "Empleados_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    @Override
    public List<Empleado> sortByName(String orden) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Empleado> rt = cq.from(Empleado.class);
        if (orden.equals("name_asc")) {
            cq.orderBy(getEntityManager().getCriteriaBuilder().asc(rt.get("nombreEmpleado")));
        } else if (orden.equals("name_desc")) {
            cq.orderBy(getEntityManager().getCriteriaBuilder().desc(rt.get("nombreEmpleado")));
        }
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public List<Empleado> filtrarBySalario(int min, int max) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Empleado> rt = cq.from(Empleado.class);
        javax.persistence.criteria.CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        cq.select(rt).where(cb.between(rt.get("salarioEmpleado"), min, max));
        return getEntityManager().createQuery(cq).getResultList();
    }

}
