<%-- 
    Document   : index
    Created on : 19 oct. 2021, 13:06:51
    Author     : Manuel
--%>

<%@page import="com.arelance.a_trolmartesthurnder.entity.Empleado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Lista de empleados</h2>
        <h4>Filtro de departamento</h4>
        <form action="PostIndex" method="GET" id="formulario">
            <p for="text">Nombre del departamento:
                <input type="text" id="nombre" placeholder="dep1" name="nombre" maxlength="45" class="form-control"></p>
            <p>Ordenacion por salario:</p>
            <p>Ascendente:<input type="radio" id="orden"  name="orden" value="asc" class="form-check-label"></p>
            <p>Descendente:<input type="radio" id="orden" name="orden" value="desc" class="form-check-label"></p>
            <input type="submit" name="action" value="Filtrar" class="btn btn-secondary">
        </form>
        <p class="text-center">El numero de departamentos con dos o mas empleados es: <%=request.getAttribute("dep")%></p>
        <%
            if (request.getAttribute("lista") != null) {
        %>
        <table class="table table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Salario en millones/anuales</th>
                    <th>Departamento</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <%
                List<Empleado> lista = (List<Empleado>) request.getAttribute("lista");

                for (Empleado empleado : lista) {
            %>
            <tr>
                <td><%=empleado.getEmpName()%></td><td><%=empleado.getEmpLastName()%></td>
                <td><%=empleado.getEmpSalary()%></td><td><%=empleado.getEmpDep()%></td>
                <td><a href="PreModificar?idEmpleado=<%=empleado.getIdempleado()%>">Modificar</a></td>
                <td><a href="PreEliminar?idEmpleado=<%=empleado.getIdempleado()%>">Eliminar</a></td></tr>
                <%
                        }
                    }
                %>
        </table>
        <a href="insertar.jsp" class="btn btn-success" role="button">Alta</a>
    </body>
</html>
