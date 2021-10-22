/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arelance.gestionempleados.modelo;

import java.util.Objects;

/**
 *
 * @author Mefisto
 */
public class EmpleadoPorDepartamentoDto {
    
    Long numeroEmpleados;
    String departamento;
    Double salarioMedio;

    public EmpleadoPorDepartamentoDto() {
    }

    public EmpleadoPorDepartamentoDto(Long numeroEmpleados, String departamento, Double salarioMedio) {
        this.numeroEmpleados = numeroEmpleados;
        this.departamento = departamento;
        this.salarioMedio = salarioMedio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.numeroEmpleados);
        hash = 67 * hash + Objects.hashCode(this.departamento);
        hash = 67 * hash + Objects.hashCode(this.salarioMedio);
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
        final EmpleadoPorDepartamentoDto other = (EmpleadoPorDepartamentoDto) obj;
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        if (!Objects.equals(this.numeroEmpleados, other.numeroEmpleados)) {
            return false;
        }
        if (!Objects.equals(this.salarioMedio, other.salarioMedio)) {
            return false;
        }
        return true;
    }

    public Long getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(Long numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Double getSalarioMedio() {
        return salarioMedio;
    }

    public void setSalarioMedio(Double salarioMedio) {
        this.salarioMedio = salarioMedio;
    }

    @Override
    public String toString() {
        return "EmpleadoPorDepartamentoDto{" + "numeroEmpleados=" + numeroEmpleados + ", departamento=" + departamento + ", salarioMedio=" + salarioMedio + '}';
    }
    
}
