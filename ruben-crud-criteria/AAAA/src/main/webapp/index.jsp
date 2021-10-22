<%-- 
    Document   : index
    Created on : 20 oct 2021, 14:01:26
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.ruben.modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
       
        <form method="post">
            <table style="width:100%">
                                <tr>
                    <td>id de empleado</td>
                    <td> nombre</td>
                    <td>apellidos</td>
                    <td>salario</td>
                </tr>
            <c:forEach var="empleado" items="${listado}">
                <tr>
                    <td>${empleado.idempleado}</td>
                    <td>${empleado.nombre}</td>
                    <td>${empleado.apellido}</td>
                    <td>${empleado.salario}€</td>
                    <td>
                        <input type="submit" name="modo" formaction="registro.jsp" value="modificar">
                    </td>
                </tr>
            </c:forEach>
            
            </table>
            <input type="submit" name="modo" formaction="registro.jsp" value="registrar">
        </form>
        
    </body>
</html>
