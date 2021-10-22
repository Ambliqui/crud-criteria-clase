/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Empleados;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 * Facade unico para entidad Empleados
 * Los metodos de aqui se priorizan a los de AbstractFacade
 * Los metodos que retornan un dato son rellenados en su correspondiente servlet
 * y mostrados en su jsp
 * @author George_Fullstack
 */
@Stateless
public class EmpleadosFacade extends AbstractFacade<Empleados> implements EmpleadosFacadeLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

//    
    @Override
    public void create(Empleados empleados) {
        getEntityManager().persist(empleados);

    }

    @Override
    public void edit(Empleados empleados) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaUpdate<Empleados> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Empleados.class);
        Root<Empleados> rootEmpleados = criteriaUpdate.from(Empleados.class);

        criteriaUpdate.set("nombre", empleados.getNombre());
        criteriaUpdate.set("apellido", empleados.getApellido());
     
        criteriaUpdate.set("salario", empleados.getSalario());

        criteriaUpdate.where(criteriaBuilder.equal(rootEmpleados.get("idempleados"), empleados.getIdempleados()));
        em.createQuery(criteriaUpdate).executeUpdate();

    }

    @Override
    public List<Empleados> findAll() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Empleados> criteriaQuery = criteriaBuilder.createQuery(Empleados.class);
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
    
    
    @Override
    public List<Empleados> findAllOrderBy() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Empleados> criteriaQuery = criteriaBuilder.createQuery(Empleados.class);
        Root<Empleados> empRoot = criteriaQuery.from(Empleados.class);
        criteriaQuery.orderBy(criteriaBuilder.asc(empRoot.get("salario")));
       // criteriaQuery.groupBy(empRoot.get("salario"));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
        @Override
    public List<Empleados> findAllOrderByDesc() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Empleados> criteriaQuery = criteriaBuilder.createQuery(Empleados.class);
        Root<Empleados> empRoot = criteriaQuery.from(Empleados.class);
        criteriaQuery.orderBy(criteriaBuilder.desc(empRoot.get("salario")));
       // criteriaQuery.groupBy(empRoot.get("salario"));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void remove(Empleados empleados) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaDelete<Empleados> criteriaDelete = criteriaBuilder.createCriteriaDelete(Empleados.class);
        Root<Empleados> rootEmpleados = criteriaDelete.from(Empleados.class);
        criteriaDelete.where(criteriaBuilder.equal(rootEmpleados.get("idempleados"), empleados.getIdempleados()));
        //em.getTransaction().begin();
        em.createQuery(criteriaDelete).executeUpdate();
        // em.getTransaction().commit();
    }
    //quiza sea Empleados empleados
   
    @Override
    public List<Object[]> EmpleadoPorSalario() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Empleados> rootEmp = criteriaQuery.from(Empleados.class);
        criteriaQuery.multiselect(rootEmp.get("salario").alias("sal1"),

            criteriaBuilder.count(rootEmp).alias("sal2")).groupBy(rootEmp.get("salario"));
       // List<Object[]> list = em.createQuery(criteriaQuery).getResultList();
     
        //CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
           return getEntityManager().createQuery(criteriaQuery).getResultList();
        
    }
     @Override
     //podria hacer una que devuelva el salario mas alto de cada grupo de apellidos (familias trabajando)
    public List<Object[]> EmpleadoPorSalarioHaving() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
      CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
      Root<Empleados> empRoot = query.from(Empleados.class);
      query.groupBy(empRoot.get("apellido"));
      query.multiselect(empRoot.get("apellido"),
              criteriaBuilder.avg(empRoot.get("salario")));
      query.having(empRoot.get("apellido").in("gonzalez", "fernandez"));
      //TypedQuery<Object[]> typedQuery = em.createQuery(query);
      //List<Object[]> resultList = typedQuery.getResultList();
      //resultList.forEach(objects ->
        //      System.out.printf("Dept: %s, Max Salary: %s%n", objects[0], objects[1]));
      //em.close();
           return getEntityManager().createQuery(query).getResultList();
        
    }
    

    public EmpleadosFacade() {
        super(Empleados.class);
    }

//    @Override
//    public void removeremoveEmpleado(Empleados empleados) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
