<%-- 
    Document   : edit
    Created on : 21-oct-2021, 9:52:28
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edición de personal</h1>
        <p>${message}</p>
        <form action="editEmpServlet">
            <input type="hidden" class="form-control" name="id_editar" value="${id}">
            <input type="text" class="form-control" name="nombre_editado" placeholder="nombre empleado" id="nombre" value="${nombre}">
 <input type="text" class="form-control" name="apellido_editado" placeholder="apellido empleado" id="apellido" value="${apellido}">
       

            <input type="text" class="form-control" name="salario_editado" placeholder="salario empleado" id="salario" value="${salario}">
        
        
         <button class="btn btn-primary profile-button" type="submit">Editar persona</button>
        </form>
    </body>
</html>
