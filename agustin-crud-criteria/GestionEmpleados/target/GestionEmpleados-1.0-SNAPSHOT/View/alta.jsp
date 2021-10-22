<%-- 
    Document   : alta
    Created on : 19-oct-2021, 23:19:25
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALTA</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            .texto{
                color:white;
            }
        </style>
    </head>
</head>
<body class="bg-dark">
    <div class="container">
        <h2 class="texto">Alta Empleados:</h2>
        <form action="../PostAltaServlet">
            <div class="form-group">
                <label for="nombre" class="texto">Nombre:</label>
                <input type="nombre" class="form-control" id="nombre" placeholder="Nombre..." name="nombre" required>
            </div>
            <div class="form-group">
                <label for="apellido" class="texto">Apellido:</label>
                <input type="text" class="form-control" id="apellido" placeholder="Apellido..." name="apellido" required>
            </div>
            <div class="form-group">
                <label for="salario" class="texto">Salario:</label>
                <input type="number" class="form-control" id="salario" placeholder="Salario..." name="salario"required>
            </div>
            <div class="form-group">
                <label for="sexo" class="texto">Elije un sexo:</label>
                <select name="sexo" id="sexo">
                    <option value="M">M</option>
                    <option value="F">F</option>
                </select>
            </div>
            <input type="submit" class="btn btn-warning" value="Alta">
            <a href="../PreIndexServlet" class="btn btn-warning" role="button"">Volver</a>
            <span class="texto">${SalarioMsg}</span>
        </form>
    </div>
</body>
</html>
