/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.bbb_martesdemoniaco.listener;

import com.arelance.bbb_martesdemoniaco.entity.Empleado;
import com.arelance.bbb_martesdemoniaco.facade.EmpleadoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Miguel
 * Al inicio de la aplicacion, recoge la lista de empleados de la base de datos y la guarda en la sesion
 */
public class PreInicioListener implements HttpSessionListener {

    @EJB
    EmpleadoFacadeLocal empleadoFacade;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("lista", empleadoFacade.findAll());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
