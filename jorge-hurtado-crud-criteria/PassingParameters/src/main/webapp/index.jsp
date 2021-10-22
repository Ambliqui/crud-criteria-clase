<%-- 
    Display de datos basados en queries select con criteria
    Document   : index
    Created on : 21-oct-2021, 9:24:19
    Author     : jorge
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Muestra de empleados</h1>
      
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">ID Empleado</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Salario</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="empleado" items="${listaEmpleados}">
                <form>
                    <tr>
                        <th scope="row">${empleado.idempleados}</th>
                        <td name="nombre"> ${empleado.nombre}</td>
                        <td>${empleado.apellido}</td>
                        <td> ${empleado.salario}$</td>
                        <td><a href="GlobalServlet?action=edit&id=${empleado.idempleados}&nombre=${empleado.nombre}&apellido=${empleado.apellido}&salario=${empleado.salario}">EditarBueno </a>

                        <td><a href="GlobalServlet?action=delete&id=${empleado.idempleados}">EliminarBueno </a>

                </form>
            </c:forEach>
        </tr>

    </tbody>
</table>
<a class="btn btn-outline-primary" href="add.jsp">Añadir</a>

<p>--------------MUESTRA DE EMPLEADOS POR ORDER BY SALARIO------------------</p>
<p>Salario por orden ascendente</p>

<table class="table">
    <thead>
        <tr>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Salario</th>
        </tr>
    </thead>
    <tbody>

        <c:forEach var="empleado" items="${listaEmpleadosOrder}">

            <tr>
                <th scope="row">${empleado.nombre}</th>
                <td name="nombre"> ${empleado.apellido}</td>
                <td name="nombre"> ${empleado.salario}</td>
            </c:forEach>
        </tr>

    </tbody>
</table>
<p>--------------MUESTRA DE EMPLEADOS POR GROUP BY SALARIO------------------</p>
<p>Devuelve la cantidad de personas con X salario</p>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Salario</th>
            <th scope="col">Cantidad(personas)</th>
        </tr>
    </thead>
    <tbody>

        <c:forEach var="empleado" items="${listaEmpleadosRealGroup}">
            <tr>
                <th scope="row">${empleado[0]}</th>
                <td name="nombre"> ${empleado[1]}</td>
            </c:forEach>
        </tr>

    </tbody>
</table>
<p>--------------MUESTRA DE EMPLEADOS POR GROUP BY, MULTISELECT Y HAVING SALARIO POR APELLIDO------</p>
<p>Devuelve la media de ganancias por familia</p>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Familia</th>
            <th scope="col">La media</th>
        </tr>
    </thead>
    <tbody>

        <c:forEach var="empleado" items="${listaEmpleadosSalarioHaving}">
            <tr>
                <th scope="row">${empleado[0]}</th>
                <td name="nombre"> ${empleado[1]}</td>
            </c:forEach>
        </tr>

    </tbody>
</table>


</body>
</html>
