<%-- 
    Document   : index
    Created on : 19-oct-2021, 18:13:53
    Author     : Mefisto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="structure/head_index.jsp"%>
    </head>
    <body>
        <header>
            <%@include file="structure/nav.jsp"%>
        </header>
        <main>

            <div class="container">
                <h1 class="row col text-center">Gestion de Empleados</h1>
                <hr>
                <div class="row">
                    <div class="col">
                        <h2>Filtros</h2>
                        <hr>
                        <form action="PostIndexServlet">
                            <input type="submit" class="btn btn-outline-primary my-2 my-sm-0" id="filtrar" name="filtrar" value="Aplicar filtros">
                            <hr>
                            <label class="btn btn-outline-primary my-2 my-sm-0">Buscar Nombre</label>
                            <input type="text" class="d-inline btn btn-outline-secondary my-2 my-sm-0" id="buscarNombre" name="buscarNombre">
                            <hr>
                            <label class="btn btn-outline-primary my-2 my-sm-0">Ordenar</label>
                            <select class="d-inline btn btn-outline-primary my-2 my-sm-0" id="exampleFormControlSelect1" name="campoFiltrado">
                                <option value="nombreEmpleado">Nombre</option>
                                <option value="departamentoEmpleado">Departamento</option>
                                <option value="salarioEmpleado">Salario</option>
                                <option value="sexoEmpleado">Sexo</option>
                            </select>
                            <label class="btn btn-outline-primary my-2 my-sm-0">Tipo de orden</label>
                            <select class="d-inline btn btn-outline-primary my-2 my-sm-0" id="exampleFormControlSelect1" name="tipoOrdenacion">
                                <option value="ordenAscendente">Ascendente</option>
                                <option value="ordenDescendente">Descendente</option>
                            </select>
                            <hr>
                            <label class="btn btn-outline-primary my-2 my-sm-0">Salario medio > </label>
                            <input type="text" class="d-inline btn btn-outline-secondary my-2 my-sm-0" id="salario medio" name="salarioAgrupado">
                            <hr>
                        </form>
                    </div>
                    <div class="col">
                        <h2>Estadisticas por Departamento</h2>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Departamento</th>
                                    <th>Nº Empleados</th>
                                    <th>Salario Medio</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items = "${empleadosDepartamento}" var ="empleadoDpt">
                                    <tr>    
                                        <td><c:out value = "${empleadoDpt.departamento}"/></td>
                                        <td><c:out value = "${empleadoDpt.numeroEmpleados}"/></td>
                                        <td><c:out value = "${empleadoDpt.salarioMedio}€"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="row col">
                    <h2>Lista de empleados</h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>Salario</th>
                                <th>Departamento</th>
                                <th>Sexo</th>
                                <th>Gestionar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items = "${listaEmpleados}" var ="empleado">
                                <tr>    
                                    <td><c:out value = "${empleado.nombreEmpleado}"/></td>
                                    <td><c:out value = "${empleado.apellidosEmpleado}"/></td>
                                    <td><c:out value = "${empleado.salarioEmpleado}€"/></td>
                                    <td><c:out value = "${empleado.departamentoEmpleado}"/></td>
                                    <td><c:choose> 
                                            <c:when test="${empleado.sexoEmpleado}">
                                                Masculino
                                            </c:when>
                                            <c:otherwise>
                                                Femenino
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td><a href=PreDatosEmpleadoServlet?idEmpleado=${empleado.idEmpleado}>Gestionar</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
        </main>
            <!-- <%@include file="structure/footer.jsp"%> -->
    </body>
</html>
