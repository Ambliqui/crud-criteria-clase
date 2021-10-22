<%-- 
    Document   : index
    Created on : 19-oct-2021, 12:40:57
    Author     : Miguel
    Pagina de inicio. Cada empresario es un link que lleva a la modificacion de ese empleado
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
            <br><h3>Lista de empleados</h3>
            <%@include file="WEB-INF/jspf/filtros.jspf" %>
            <c:forEach var="empleado" items="${lista}">  
                <div class="list-group list-group-flush">
                    <a href="PreUpdateServlet?id=${empleado.idEmpleado}" class="list-group-item list-group-item-action">
                        ${empleado.nombreEmpleado} ${empleado.apellidoEmpleado} con un salario de ${empleado.salarioEmpleado}€</a>
                </div>
            </c:forEach>
            <br>
            <h4>Haga click en un empleado para modificar sus datos</h4>
        </div>
    </body>
</html>
