package com.arelance.service;

import com.arelance.service.qualifiers.EmployeeFactoryQ;

/**
 *
 * @author Pedro
 */
@EmployeeFactoryQ
public class EmployeeFactory implements Factory {

    @Override
    public Crud createCrud() {

        return new EmployeeCrud();
    }

}
