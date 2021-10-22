/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herramientas;

import Entity.Empleado;

/**
 *
 * @author serlo
 */
public class MetodosServlets {
    public static String conseguirString(Object st){
        String ret;
        if(st==null){
            ret = "";
        }
        else{
            ret=(String) st;
        }
        return ret;
    }
    
    public static Empleado conseguirEmpleado(Object empleado){
        Empleado ret;
        if(empleado==null){
            ret = new Empleado("", "", 0, "");
        }
        else{
            ret = (Empleado) empleado;
        }
        return ret;
    }
}
