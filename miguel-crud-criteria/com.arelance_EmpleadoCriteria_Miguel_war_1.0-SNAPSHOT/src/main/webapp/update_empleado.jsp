<%-- 
    Document   : update_empleado
    Created on : 20-oct-2021, 9:40:31
    Author     : Miguel
    Formulario de modificacion del empleado
    Tiene un hidden field que sirve para pasar la ID al PostProcesado y facilitar el Criteria
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
        <form method="GET" action="PostUpdateServlet">
            <h3>Introduzca los nuevos datos</h3>
            <div class="row">
                <div class="col">
                    <label for="nombre_empleado">Nombre del empleado</label>
                    <input type="text" class="form-control" id="nombre_empleado" name="nombre_empleado" value="${currentEmpleado.nombreEmpleado}">
                </div>
                <div class="col">
                    <label for="apellido_empleado">Apellido del empleado</label>
                    <input type="text" class="form-control" id="apellido_empleado" name="apellido_empleado" value="${currentEmpleado.apellidoEmpleado}">
                </div>
                <div class="col">
                    <label for="salario_empleado">Salario del empleado</label>
                    <input type="number" class="form-control" id="salario_empleado" name="salario_empleado" value="${currentEmpleado.salarioEmpleado}">
                </div>
                <input type="hidden" name="id_empleado" value="${currentEmpleado.idEmpleado}">
            </div><br>
            <button type="submit" class="btn btn-primary" id="submit_button">Submit</button>
        </form>
        ${errorMessage}
    </body>
</html>
