package com.arelance.domain;

import com.arelance.enums.Genre;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByIdEmployee", query = "SELECT e FROM Employee e WHERE e.idEmployee = :idEmployee"),
    @NamedQuery(name = "Employee.findByNameEmployee", query = "SELECT e FROM Employee e WHERE e.nameEmployee = :nameEmployee"),
    @NamedQuery(name = "Employee.findByLastNameEmployee", query = "SELECT e FROM Employee e WHERE e.lastNameEmployee = :lastNameEmployee"),
    @NamedQuery(name = "Employee.findByGenreEmployee", query = "SELECT e FROM Employee e WHERE e.genreEmployee = :genreEmployee"),
    @NamedQuery(name = "Employee.findBySalaryEmployee", query = "SELECT e FROM Employee e WHERE e.salaryEmployee = :salaryEmployee")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Size(max = 100)
    @Column(name = "name_employee")
    private String nameEmployee;
    @Size(max = 100)
    @Column(name = "last_name_employee")
    private String lastNameEmployee;
    @Enumerated(EnumType.STRING)
    @Column(name = "genre_employee")
    private Genre genreEmployee;
    @Column(name = "salary_employee")
    private BigDecimal salaryEmployee;
    @JoinColumn(name = "department_employee", referencedColumnName = "id_department")
    @ManyToOne
    private Department departmentEmployee;

    public Employee() {
    }

    public Employee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getLastNameEmployee() {
        return lastNameEmployee;
    }

    public void setLastNameEmployee(String lastNameEmployee) {
        this.lastNameEmployee = lastNameEmployee;
    }

    public String getGenreEmployee() {
        return this.genreEmployee.name();
    }

    public void setGenreEmployee(String genreEmployee) {
        this.genreEmployee = Genre.valueOf(genreEmployee);
    }

    public BigDecimal getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(BigDecimal salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public Department getDepartmentEmployee() {
        return departmentEmployee;
    }

    public void setDepartmentEmployee(Department departmentEmployee) {
        this.departmentEmployee = departmentEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployee != null ? idEmployee.hashCode() : 0);
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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.nameEmployee, other.nameEmployee)) {
            return false;
        }
        if (!Objects.equals(this.lastNameEmployee, other.lastNameEmployee)) {
            return false;
        }
        if (!Objects.equals(this.idEmployee, other.idEmployee)) {
            return false;
        }
        if (this.genreEmployee != other.genreEmployee) {
            return false;
        }
        if (!Objects.equals(this.salaryEmployee, other.salaryEmployee)) {
            return false;
        }
        if (!Objects.equals(this.departmentEmployee, other.departmentEmployee)) {
            return false;
        }
        return true;
    }    

    @Override
    public String toString() {
        return "Employee{" + "idEmployee=" + idEmployee + ", nameEmployee=" + nameEmployee + ", lastNameEmployee=" + lastNameEmployee + ", genreEmployee=" + genreEmployee + ", salaryEmployee=" + salaryEmployee + ", departmentEmployee=" + departmentEmployee + '}';
    }    
    
}
