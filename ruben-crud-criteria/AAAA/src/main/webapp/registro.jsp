<%-- 
    Document   : registro
    Created on : 5 oct 2021, 10:56:00
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <form  method="GET">
            <%@include  file="formulario_registro.jspf" %> 
            <br>
            <input type="submit" formaction="PostRegistroServlet" value="registrar">
        </form>
    </body>
</html>
