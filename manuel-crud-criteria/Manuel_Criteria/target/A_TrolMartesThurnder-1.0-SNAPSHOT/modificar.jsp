<%-- 
    Document   : modificar
    Created on : 19 oct. 2021, 19:42:52
    Author     : manul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <h2>Modificacion del empleado</h2>
        <form action="PostModificar" method="GET" id="formulario">
            <input type="text" id="id" value="${modificar.getIdempleado()}" name="id" hidden="hidden">
            <p for="text">Nombre:
                <input type="text" id="nombre" value="${modificar.getEmpName()}" name="nombre" maxlength="45" class="form-control" required></p>
            <p for="text">Apellido:
                <input type="text" id="apellido" value="${modificar.getEmpLastName()}" name="apellido" maxlength="45" class="form-control" required></p>
            <p for="text">Salario:
                <input type="number" id="salario" value="${modificar.getEmpSalary()}"  name="salario" class="form-control" required></p>
            <p for="departamento">Departamento:
                <input type="departamento" id="departamento" value="${modificar.getEmpDep()}" name="departamento" class="form-control" required></p>
            <input type="submit" name="action" value="Modificar" class="btn btn-primary">
            <input type="reset" name="action" value="Limpiar"  class="btn btn-primary">
            <a href="PreIndex" type="button" class="btn btn-secondary">Volver</a>
    </body>
</html>
