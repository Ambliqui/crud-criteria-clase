<%-- 
    Document   : listado
    Created on : 19 oct. 2021, 9:52:18
    Author     : pryet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <main class="container">
            <h1 class="text-center">Listado de empleados</h1>
            <div class="row">
                <div class="col-md-4 pt-2">
                    <form action="${destino}" method="GET">
                        <td><input class="form-control" type="text" name="nombre" placeholder="Nombre" value="${empleadoEditar.nombre}"></td>
                        <td><input class="form-control" type="text" name="salario" placeholder="Salario" value="${empleadoEditar.salario}"></td>
                        <input type="hidden" name="id" value="${empleadoEditar.id}"/>
                        <td>
                            <input type="submit" class="btn btn-primary" value="Guardar"/>
                        </td>
                    </form>
                    <c:if test="${errorMsg!=null}">
                        <p class="alert alert-danger" role="alert">${errorMsg}</p>
                    </c:if>
                </div>
                <div class="col-md-8">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Salario</th>
                                <th scope="col">
                                    <form action="./buscar">                                    
                                        <div class="form-group">
                                            <input style="display: inline;" class="form-control" name="param" type="text" placeholder="Search" aria-label="Search">
                                            <label>Desc</label>
                                            <input type="radio" name="orden" id="desc" value="true"/>
                                            <label>Asc</label>
                                            <input type="radio" name="orden" id="asc" checked value="false"/>
                                            <input type="submit" class="btn btn-primary" value="Buscar"/>
                                        </div>                                    
                                    </form>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="e" items="${listaEmpleados}">
                                <tr>
                            <form action="./preEditar" method="GET">
                                <td>${e.nombre}</td>
                                <td>${e.salario}</td>
                                <td> <a class="btn btn-warning" href="./preEditar?id=${e.id}">Editar</a>
                                    <a href="eliminar?id=${e.id}" class="btn btn-danger">Borrar</a>         
                                </td>
                            </form>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </body>
</html>
