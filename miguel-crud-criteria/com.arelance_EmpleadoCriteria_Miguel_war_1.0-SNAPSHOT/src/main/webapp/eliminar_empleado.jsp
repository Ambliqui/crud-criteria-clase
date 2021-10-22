<%-- 
    Document   : eliminar_empleado
    Created on : 20-oct-2021, 13:18:07
    Author     : Miguel
    Lista de empleados, con los filtros implementados, en el cual eliges cual quieres eliminar
    Cada elemento es un link en el que cada empleado pasa como parametro su ID, para facilitar su eliminacion en Criteria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="WEB-INF/bootstrap/bootstrap.jspf" %>
        <%@include file="WEB-INF/bootstrap/styles/bootstrap_navbar.jspf" %>
    </head>
    <body>
        <div class="container">
            <br><h3>Que empleado desea eliminar?</h3>
            <%@include file="WEB-INF/jspf/filtros.jspf" %>
            <c:forEach var="empleado" items="${lista}">  
                <div class="list-group list-group-flush">
                    <a href="EliminarEmpleadoServlet?id=${empleado.idEmpleado}" class="list-group-item list-group-item-action">
                        ${empleado.nombreEmpleado} ${empleado.apellidoEmpleado} con un salario de ${empleado.salarioEmpleado}€</a>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
