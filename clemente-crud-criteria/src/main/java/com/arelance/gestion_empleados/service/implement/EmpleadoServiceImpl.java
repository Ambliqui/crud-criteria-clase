/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestion_empleados.service.implement;

import com.arelance.gestion_empleados.dao.EmpleadoDao;
import com.arelance.gestion_empleados.entity.Empleados;
import com.arelance.gestion_empleados.service.EmpleadoService;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author damon
 */

public class EmpleadoServiceImpl implements EmpleadoService {
 
    private EmpleadoDao empleadoDao;


    /**
     *
     * @param empleados
     */
    @Transactional
    public void addEmpleado(Empleados empleados) {
        empleadoDao.addEmpleado(empleados);
    }
 


    /**
     *
     * @return
     */
    @Transactional
    @Override
    public List<Empleados> getAllEmpleados() {
        return empleadoDao.getAllEmpleados();
    }
 

    /**
     *
     * @param idEmpleado
     * @return
     */
    @Transactional
    @Override
    public Empleados getEmpleadoById(int idEmpleado) {
        return empleadoDao.getEmpleadoById(idEmpleado);
    }
 


    /**
     *
     * @param empleados
     */
    @Transactional
    @Override
    public void updateEmpleado(Empleados empleados) {
        empleadoDao.updateEmpleado(empleados);
    }
 

    /**
     *
     * @param idEmpleado
     */
    @Transactional
    @Override
    public void deleteEmpleado(int idEmpleado) {
        empleadoDao.deleteEmpleado(idEmpleado);
    }
 
    /**
     *
     * @return
     */
    public EmpleadoDao getEmpleadoDao() {
        return empleadoDao;
    }
 
    /**
     *
     * @param empleadoDao
     */
    public void setEmpleadoDao(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }
 
}
