/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestionempleados.modelo;

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
 * @author Mefisto
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByNombreEmpleado", query = "SELECT e FROM Empleado e WHERE e.nombreEmpleado = :nombreEmpleado"),
    @NamedQuery(name = "Empleado.findByApellidosEmpleado", query = "SELECT e FROM Empleado e WHERE e.apellidosEmpleado = :apellidosEmpleado"),
    @NamedQuery(name = "Empleado.findByEdadEmpleado", query = "SELECT e FROM Empleado e WHERE e.edadEmpleado = :edadEmpleado"),
    @NamedQuery(name = "Empleado.findBySexoEmpleado", query = "SELECT e FROM Empleado e WHERE e.sexoEmpleado = :sexoEmpleado"),
    @NamedQuery(name = "Empleado.findByEmailEmpleado", query = "SELECT e FROM Empleado e WHERE e.emailEmpleado = :emailEmpleado"),
    @NamedQuery(name = "Empleado.findByTelefonoEmpleado", query = "SELECT e FROM Empleado e WHERE e.telefonoEmpleado = :telefonoEmpleado"),
    @NamedQuery(name = "Empleado.findBySalarioEmpleado", query = "SELECT e FROM Empleado e WHERE e.salarioEmpleado = :salarioEmpleado"),
    @NamedQuery(name = "Empleado.findByDepartamentoEmpleado", query = "SELECT e FROM Empleado e WHERE e.departamentoEmpleado = :departamentoEmpleado")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Size(max = 45)
    @Column(name = "nombre_empleado")
    private String nombreEmpleado;
    @Size(max = 255)
    @Column(name = "apellidos_empleado")
    private String apellidosEmpleado;
    @Column(name = "edad_empleado")
    private Integer edadEmpleado;
    @Column(name = "sexo_empleado")
    private Boolean sexoEmpleado;
    @Size(max = 255)
    @Column(name = "email_empleado")
    private String emailEmpleado;
    @Size(max = 14)
    @Column(name = "telefono_empleado")
    private String telefonoEmpleado;
    @Column(name = "salario_empleado")
    private Long salarioEmpleado;
    @Size(max = 45)
    @Column(name = "departamento_empleado")
    private String departamentoEmpleado;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidosEmpleado() {
        return apellidosEmpleado;
    }

    public void setApellidosEmpleado(String apellidosEmpleado) {
        this.apellidosEmpleado = apellidosEmpleado;
    }

    public Integer getEdadEmpleado() {
        return edadEmpleado;
    }

    public void setEdadEmpleado(Integer edadEmpleado) {
        this.edadEmpleado = edadEmpleado;
    }

    public Boolean getSexoEmpleado() {
        return sexoEmpleado;
    }

    public void setSexoEmpleado(Boolean sexoEmpleado) {
        this.sexoEmpleado = sexoEmpleado;
    }

    public String getEmailEmpleado() {
        return emailEmpleado;
    }

    public void setEmailEmpleado(String emailEmpleado) {
        this.emailEmpleado = emailEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public Long getSalarioEmpleado() {
        return salarioEmpleado;
    }

    public void setSalarioEmpleado(Long salarioEmpleado) {
        this.salarioEmpleado = salarioEmpleado;
    }

    public String getDepartamentoEmpleado() {
        return departamentoEmpleado;
    }

    public void setDepartamentoEmpleado(String departamentoEmpleado) {
        this.departamentoEmpleado = departamentoEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arelance.gestionempleados.modelo.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
