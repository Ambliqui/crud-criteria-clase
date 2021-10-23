<%-- 
    Document   : delete
    Created on : 20-oct-2021, 13:25:42
    Author     : usuario
--%>
<%-- TODO: No cumple el caso de uso, tiene que estar todo en un mismo formulario --%>
<%-- TODO: No tienes los mismo elementos estructurales del resto de las paginas, el footer salio por patas? --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminando Empleado</h1>
        <form action="./PostDeleteServlet" method="GET" id="formulario">
            <fieldset>
                <label for="text">Id: </label>
                <input type="text" id="id" value="${update.getIdempleados()}" name="id" hidden>
                <label for="text">Nombre:</label>
                <input type="text" id="nombre" value="${update.getNombreEmpleado()}" name="nombre" maxlength="45" readonly="readonly">
                <label for="text">Apellido:</label>
                <input type="text" id="apellido" value="${update.getApellidoEmpleado()}" name="apellido" maxlength="45" readonly="readonly">
                <label for="text">Salario:</label>
                <input type="number" id="salario" value="${update.getSalario()}"  name="salario" readonly="readonly">

                <input type="submit" name="action" value="Eliminar">
                <input type="reset" name="action" value="Limpiar">
                <a href="./PreIndexServlet" role="button">Volver</a>
            </fieldset>
        </form>
    </body>
</html>
