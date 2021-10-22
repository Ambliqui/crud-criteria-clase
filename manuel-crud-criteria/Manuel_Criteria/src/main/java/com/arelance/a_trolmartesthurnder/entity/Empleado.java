/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.a_trolmartesthurnder.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdempleado", query = "SELECT e FROM Empleado e WHERE e.idempleado = :idempleado"),
    @NamedQuery(name = "Empleado.findByEmpName", query = "SELECT e FROM Empleado e WHERE e.empName = :empName"),
    @NamedQuery(name = "Empleado.findByEmpLastName", query = "SELECT e FROM Empleado e WHERE e.empLastName = :empLastName"),
    @NamedQuery(name = "Empleado.findByEmpSalary", query = "SELECT e FROM Empleado e WHERE e.empSalary = :empSalary"),
    @NamedQuery(name = "Empleado.findByEmpDep", query = "SELECT e FROM Empleado e WHERE e.empDep = :empDep")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempleado")
    private Integer idempleado;
    @Size(max = 45)
    @Column(name = "empName")
    private String empName;
    @Size(max = 45)
    @Column(name = "empLastName")
    private String empLastName;
    @Column(name = "empSalary")
    private Integer empSalary;
    @Size(max = 45)
    @Column(name = "empDep")
    private String empDep;

    public Empleado() {
    }

    public Empleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Empleado(String empName) {
        this.empName = empName;
    }

    public Empleado(String empName, String empLastName, Integer empSalary, String empDep) {
        this.empName = empName;
        this.empLastName = empLastName;
        this.empSalary = empSalary;
        this.empDep = empDep;
    }
    
    public Empleado(Integer idempleado, String empName, String empLastName, Integer empSalary, String empDep) {
        this.idempleado = idempleado;
        this.empName = empName;
        this.empLastName = empLastName;
        this.empSalary = empSalary;
        this.empDep = empDep;
    }

    
    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public Integer getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Integer empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpDep() {
        return empDep;
    }

    public void setEmpDep(String empDep) {
        this.empDep = empDep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.a_trolmartesthurnder.entity.Empleado[ idempleado=" + idempleado + " ]";
    }
    
}
