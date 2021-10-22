package com.arelance.service;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Pedro
 * @param <T>
 */
@Local
public interface Crud<T> {

    void create(T t);

    void update(T t);

    void delete(T t);

    T read(Integer n);
    
    List<T> readAll();

}
