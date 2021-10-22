<%-- 
    Document   : registro
    Created on : 21-oct-2021, 22:57:55
    Author     : Gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista empleados</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="jumbotron">
            <h1 class="text-center">Lista de Empleados</h1>      
            <p class = "text-center">Registro de los empleados de la empresa FullStark</p>
        </div>
        <div class="container mt-3">
            <form action="PostRegistroServlet" method="POST">
                <div class="form-floating mb-3 mt-3">
                    <label for="fname">Nombre:</label><br>
                    <input type="text" id="fname" class ="form-control" name="fname" required><br>
                </div>
                <div class="form-floating mt-3 mb-3">
                    <label for="lname">Apellido:</label><br>
                    <input type="text" id="lname" class ="form-control" name="lname" required><br>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <label for="salary">Salario:</label><br>
                    <input type ="number" id ="salary" class ="form-control" name ="salary" required><br><br>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <label for="dept">Departamento:</label><br>
                    <input type="text" id="dept" class ="form-control" name="dept" required><br>
                </div>
                <input type="submit" value="Registro">
                <input type="reset" name="action" value="Limpiar">
                 <a href="./PreIndexServlet" role="button">Volver</a>
            </form>
        </div>
        <footer class="bg-light text-center text-white">
            <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                © 2021
                <a class="text-white">FullStark</a>
            </div>
        </footer>
    </body>
</html>
