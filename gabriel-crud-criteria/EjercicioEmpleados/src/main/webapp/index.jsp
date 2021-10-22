<%-- 
    Document   : index
    Created on : 19-oct-2021, 12:29:42
    Author     : usuario
--%>

<%@page import="java.util.List"%>
<%@page import="com.arelance.ejercicioempleados.domain.Empleado"%>
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
        <div class ="container">
            <table class="table">

                <thead class = "table-dark">
                    <tr class = "table-info">
                        <th>Nombre</th>
                        <th>Primer Apellido</th>
                        <th>Salario</th>
                        <th>Departamento</th>
                        <th></th>
                        <th></th>

                    </tr>
                </thead>


                <%
                    List<Empleado> lista = (List<Empleado>) request.getAttribute("lista");

                    for (Empleado empleado : lista) {
                %>
                <tr>
                    <td class = "table-success"><%=empleado.getNombreEmpleado()%></td>
                    <td class = "table-success"><%=empleado.getApellidoEmpleado()%></td>
                    <td class = "table-success"><%=empleado.getSalario()%></td>
                    <td class ="table-success"><%=empleado.getDepartamentoEmpleado()%></td>
                    <td class ="table-warning"><a href="PreUpdateServlet?idEmpleado=<%=empleado.getIdempleados()%>">Modificar</a></td>
                    <td class ="table-danger"><a href="PreDeleteServlet?idEmpleado=<%=empleado.getIdempleados()%>">Eliminar</a></td>
                    <%
                        }
                    %>
            </table>
        </div>
        <a href="registro.jsp" class="btn btn-primary">Dar de Alta</a>

        <h3>Ordenación por nombre</h3>
        <form action="PostIndexServlet" method="GET">
            <label for ="asc">Ascendente</label>
            <input type="radio" id="order"  name="order" value="asc" class="form-check-label">
            <label for ="desc">Descendente</label>
            <input type="radio" id="order" name="order" value="desc" class="form-check-label">
            <input type="submit" name="action" value="Filtrar" class="btn btn-secondary">
        </form>
        <h3>Filtro por salario</h3>
        <form action ="FiltroSalarioServlet" method ="GET">
            <label for= "salario">Salario: </label>
            <input type="number" id="salario"  name="salario">
            <input type ="submit" name="action" value ="Filtrar" class="btn-secondary">
        </form>
        <footer class="bg-light text-center text-white">
            <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                © 2021
                <a class="text-white">FullStark</a>
            </div>
        </footer>
    </body>
</html>
