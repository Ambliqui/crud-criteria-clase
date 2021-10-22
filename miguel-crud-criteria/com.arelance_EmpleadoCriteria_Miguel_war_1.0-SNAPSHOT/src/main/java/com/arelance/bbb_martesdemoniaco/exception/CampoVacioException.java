/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.bbb_martesdemoniaco.exception;

import javax.servlet.ServletException;

/**
 *
 * @author Miguel
 * CampoVacioHandler se encarga de manejar esta excepcion
 */
public class CampoVacioException extends ServletException {

    /**
     * Creates a new instance of <code>CampoVacioException</code> without detail
     * message.
     */
    public CampoVacioException() {

    }

    /**
     * Constructs an instance of <code>CampoVacioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CampoVacioException(String msg) {
        super(msg);
    }
}
