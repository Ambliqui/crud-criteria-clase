/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Objects;
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
 * @author FullstackSergio
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdempleado", query = "SELECT e FROM Empleado e WHERE e.idempleado = :idempleado"),
    @NamedQuery(name = "Empleado.findByNombreempleado", query = "SELECT e FROM Empleado e WHERE e.nombreempleado = :nombreempleado"),
    @NamedQuery(name = "Empleado.findByApellidoempleado", query = "SELECT e FROM Empleado e WHERE e.apellidoempleado = :apellidoempleado"),
    @NamedQuery(name = "Empleado.findBySueldoempleado", query = "SELECT e FROM Empleado e WHERE e.sueldoempleado = :sueldoempleado"),
    @NamedQuery(name = "Empleado.findByDepartamentoempleado", query = "SELECT e FROM Empleado e WHERE e.departamentoempleado = :departamentoempleado")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempleado")
    private Integer idempleado;
    @Size(max = 45)
    @Column(name = "nombreempleado")
    private String nombreempleado;
    @Size(max = 45)
    @Column(name = "apellidoempleado")
    private String apellidoempleado;
    @Column(name = "sueldoempleado")
    private Integer sueldoempleado;
    @Size(max = 45)
    @Column(name = "departamentoempleado")
    private String departamentoempleado;

    public Empleado() {
    }

    public Empleado(String nombreempleado, String apellidoempleado, Integer sueldoempleado, String departamentoempleado) {
        this.nombreempleado = nombreempleado;
        this.apellidoempleado = apellidoempleado;
        this.sueldoempleado = sueldoempleado;
        this.departamentoempleado = departamentoempleado;
    }

    public Empleado(Integer idempleado, String nombreempleado, String apellidoempleado, Integer sueldoempleado, String departamentoempleado) {
        this.idempleado = idempleado;
        this.nombreempleado = nombreempleado;
        this.apellidoempleado = apellidoempleado;
        this.sueldoempleado = sueldoempleado;
        this.departamentoempleado = departamentoempleado;
    }
    
    public Empleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombreempleado() {
        return nombreempleado;
    }

    public void setNombreempleado(String nombreempleado) {
        this.nombreempleado = nombreempleado;
    }

    public String getApellidoempleado() {
        return apellidoempleado;
    }

    public void setApellidoempleado(String apellidoempleado) {
        this.apellidoempleado = apellidoempleado;
    }

    public Integer getSueldoempleado() {
        return sueldoempleado;
    }

    public void setSueldoempleado(Integer sueldoempleado) {
        this.sueldoempleado = sueldoempleado;
    }

    public String getDepartamentoempleado() {
        return departamentoempleado;
    }

    public void setDepartamentoempleado(String departamentoempleado) {
        this.departamentoempleado = departamentoempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.nombreempleado, other.nombreempleado)) {
            return false;
        }
        if (!Objects.equals(this.apellidoempleado, other.apellidoempleado)) {
            return false;
        }
        if (!Objects.equals(this.departamentoempleado, other.departamentoempleado)) {
            return false;
        }
        if (!Objects.equals(this.idempleado, other.idempleado)) {
            return false;
        }
        return Objects.equals(this.sueldoempleado, other.sueldoempleado);
    }

    @Override
    public String toString() {
        String format = "%-25s%-25s%-25s%14s%-10s";
        String toString = String.format(format, "Empleado [" + idempleado + "] ",
                 nombreempleado + " " + apellidoempleado,
                 "Sueldo: " + sueldoempleado + "€",
                 "Departamento: ",
                 departamentoempleado);
        return toString;
    }

}
