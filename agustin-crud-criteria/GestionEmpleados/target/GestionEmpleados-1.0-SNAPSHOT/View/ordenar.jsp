<%-- 
    Document   : ordenar
    Created on : 21-oct-2021, 19:54:20
    Author     : lenovo
--%>

<%@page import="java.util.List"%>
<%@page import="com.arelance.empresa.gestionempleados.domain.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title>CRUD</title>
    </head>
    <body class="bg-dark">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <!-- Brand/logo -->
            <a class="navbar-brand" href="">Gestión empleados</a>

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="PreAltaServlet">Añadir empleados</a>
                </li>
                     <li class="nav-item">
                    <a class="nav-link" href="PostOrberByServlet">Ordenar por salario</a>
                </li>  
            </ul>
        </nav>     
        <table class="table table-dark">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Salario</th>
                    <th>Sexo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Empleado> lista = (List<Empleado>) request.getAttribute("empleados");
                %>
                <%
                    for (Empleado empleado : lista) {
                        out.print("<tr>" + "<td>" + empleado.getNombre() + "</td>" + "<td>"
                                + empleado.getApellido() + "</td>" + "<td>" + empleado.getSalario()
                                + "</td>" + "<td>" + empleado.getSexo() + "</td>"
                                + "<td>" + "<a href='PostDeleteServlet?IdEmpleado="
                                + empleado.getIdempleado() + "'" + "class='btn btn-danger'role=button"
                                + ">" + "Eliminar" + "</a>" + " " + "<a href='PreUpdateServlet?IdEmpleado="
                                + empleado.getIdempleado() + "'" + "class='btn btn-warning'role=button"
                                + ">" + "Modificar" + "</a>");
                    }
                %>
            </tbody>
        </table>
    </body>
