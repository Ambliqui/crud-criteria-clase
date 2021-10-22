<%-- 
    Document   : add
    Created on : 21-oct-2021, 9:42:53
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadir empleado</title>
    </head>
    <body>
        <h1>Agregar persona</h1>
         <form action="addEmpServlet">
             <label>Nombre empleado</label>
             <input type="text" class="form-control" name="nombre" placeholder="nombre empleado" id="nombre"><br>
            <label>Apellido empleado</label>
             <input type="text" class="form-control" name="apellido" placeholder="apellido empleado" id="apellido"><br>
            <label>Salario empleado</label>
             <input type="text" class="form-control" name="salario" placeholder="salario empleado" id="salario"><br>
            
            
            <button class="btn btn-primary profile-button" type="submit">Agregar persona</button>
        </form>
    </body>
</html>
