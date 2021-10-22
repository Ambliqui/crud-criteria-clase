package com.arelance.service;

import com.arelance.service.qualifiers.DepartmentFactoryQ;

/**
 *
 * @author Pedro
 */
@DepartmentFactoryQ
public class DepartmentFactory implements Factory {

    @Override
    public Crud createCrud() {

        return new DepartmentCrud();
    }

}
