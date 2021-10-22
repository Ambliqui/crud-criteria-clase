<%-- 
    Document   : modificar
    Created on : 20-oct-2021, 22:03:44
    Author     : lenovo
--%>

<%@page import="com.arelance.empresa.gestionempleados.domain.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MODIFICAR</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
</head>
<body>
    <div class="container">
        <h2>Modificar Empleados:</h2>

        <form action="PostUpdateServlet">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="nombre" class="form-control" id="nombre" placeholder="${empleado.getNombre()}" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="apellido">Apellido:</label>
                <input type="text" class="form-control" id="apellido" placeholder="${empleado.getApellido()}" name="apellido" required>
            </div>
            <div class="form-group">
                <label for="salario">Salario:</label>
                <input type="number" class="form-control" id="salario" placeholder="${empleado.getSalario()}" name="salario"required>
            </div>
            <div class="form-group">
                <label for="sexo">Elije un sexo:</label>
                <select name="sexo" id="sexo">          
                    <option value="${empleado.getSexo()}">${empleado.getSexo()}</option>
                    <option value="${sexo}">${sexo}</option>
                  
                </select>
            </div>
            <input type="submit" class="btn btn-danger" value="Modificar">
            <a href="PreIndexServlet" class="btn btn-danger" role="button"">Volver</a>
            <input type="hidden" id="idEmpleado" name="idEmpleado" value="${empleado.getIdempleado()}">
        </form>
    </div>
</body>
</html>
