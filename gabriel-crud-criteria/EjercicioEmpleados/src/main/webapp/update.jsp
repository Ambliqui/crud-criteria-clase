<%-- 
    Document   : editar
    Created on : 20-oct-2021, 12:17:23
    Author     : usuario
--%>
<%-- TODO: Mirar comentarios de delete.jsp --%>
<%-- No cumple el caso de uso, tiene que estar todo en un mismo formulario --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de registro</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <%-- Los estilos van en un archivo CSS aparte --%>
        <style>
            fieldset {
                display: block;
                margin-left: 2px;
                margin-right: 2px;
                padding-top: 0.35em;
                padding-bottom: 0.625em;
                padding-left: 0.75em;
                padding-right: 0.75em;
                border: 2px groove (internal value);
            }
        </style> 
    </head>
    <body>
        <div class="jumbotron">
            <h1 class="text-center">Lista de Empleados</h1>      
            <p class = "text-center">Registro de los empleados de la empresa FullStark</p>
        </div>
        <form action="./PostUpdateServlet" method="GET" id="formulario">
            <fieldset>
                <legend>Registro:</legend>
                <label for="text" hidden>Id: </label>
                <input type="text" id="id" value="${update.getIdempleados()}" name="id" hidden>
                <label for="text">Nombre:</label>
                <input type="text" id="nombre" value="${update.getNombreEmpleado()}" name="nombre" maxlength="45" required>
                <label for="text">Apellido:</label>
                <input type="text" id="apellido" value="${update.getApellidoEmpleado()}" name="apellido" maxlength="45" required>
                <label for="text">Salario:</label>
                <input type="number" id="salario" value="${update.getSalario()}"  name="salario" required>
                <label for="text">Departamento:</label>
                <input type="text" id="dept" value="${update.getDepartamentoEmpleado()}" name="dept" maxlength="45" required>
                
                <input type="submit" name="action" value="Modificar">
                <input type="reset" name="action" value="Limpiar">
                <a href="./PreIndexServlet" role="button">Volver</a>
            </fieldset>
        </form>
        <footer class="bg-light text-center text-white">
            <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                © 2021
                <a class="text-white">FullStark</a>
            </div>
        </footer>
    </body>
</html>
