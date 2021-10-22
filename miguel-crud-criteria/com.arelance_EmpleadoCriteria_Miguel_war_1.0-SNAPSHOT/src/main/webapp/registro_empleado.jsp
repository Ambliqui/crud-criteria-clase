<%-- 
    Document   : registro_empleado
    Created on : 19-oct-2021, 13:07:48
    Author     : Miguel
    Formulario de inscripcion del empleado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/bootstrap/bootstrap.jspf" %>
<%@include file="WEB-INF/bootstrap/styles/bootstrap_navbar.jspf" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <form method="GET" action="PostRegistroServlet">
            <div class="row">
                <div class="col">
                    <label for="nombre_empleado">Nombre del empleado</label>
                    <input type="text" class="form-control" id="nombre_empleado" name="nombre_empleado">
                </div>
                <div class="col">
                    <label for="apellido_empleado">Apellido del empleado</label>
                    <input type="text" class="form-control" id="apellido_empleado" name="apellido_empleado">
                </div>
                <div class="col">
                    <label for="salario_empleado">Salario del empleado</label>
                    <input type="number" class="form-control" id="salario_empleado" name="salario_empleado">
                </div>
            </div><br>
            <button type="submit" class="btn btn-primary" id="submit_button">Submit</button>
        </form>
        ${errorMessage}
    </body>
</html>
