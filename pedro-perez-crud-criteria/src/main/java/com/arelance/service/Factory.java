package com.arelance.service;

import javax.ejb.Local;

/**
 *
 * @author Pedro
 */
@Local
@FunctionalInterface
public interface Factory {
    
    Crud createCrud();
    
}
