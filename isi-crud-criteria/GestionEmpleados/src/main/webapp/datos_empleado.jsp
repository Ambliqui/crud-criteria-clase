
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="structure/head_datos_personales.jsp"%>
    </head>
    <body>
        <header>
            <%@include file="structure/nav.jsp"%>
        </header>
        <main>
            <div class="container" id="advanced-search-form">
                <h2>Datos personales</h2>
                <form action="PostDatosEmpleadoServlet">
                    <input type="number" id="idEmpleado" name="idEmpleado" value='<c:if test = "${empleado.idEmpleado > 0}">${empleado.idEmpleado}</c:if>' hidden>
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" value='<c:if test = "${empleado.idEmpleado > 0}">${empleado.nombreEmpleado}</c:if>' placeholder="Introduce tu nombre" required>
                        </div>
                        <div class="form-group">
                            <label for="apellidos">Apellidos</label>
                            <input type="text" class="form-control" id="apellidos" name="apellidos" value='<c:if test = "${empleado.idEmpleado > 0}">${empleado.apellidosEmpleado}</c:if>' placeholder="Introduce tus apellidos" required>
                        </div>
                        <div class="form-group">
                            <label for="edad">Edad</label>
                            <input type="number" class="form-control" id="edad" name="edad" value='<c:if test = "${empleado.idEmpleado > 0}">${empleado.edadEmpleado}</c:if>' placeholder="Introduce tu edad" required>
                        </div>
                        <div class="form-group">
                            <label>Sexo</label>
                            <div class="radio">
                                <label class="radio-inline">
                                    <input type="radio" name="sexo" value="1" <c:if test = "${empleado.sexoEmpleado == true}">checked</c:if>>Hombre</label>
                                <label class="radio-inline">
                                    <input type="radio" name="sexo" value="0" <c:if test = "${empleado.sexoEmpleado == false}">checked</c:if>>Mujer</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="telefono">Telefono</label>
                            <input type="text" class="form-control" id="telefono" name="telefono" value='<c:if test = "${empleado.idEmpleado > 0}">${empleado.telefonoEmpleado}</c:if>' placeholder="Introduce tu telefono" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" value='<c:if test = "${empleado.idEmpleado > 0}">${empleado.emailEmpleado}</c:if>' placeholder="Introduce tu email" required>
                        </div>
                        <h2>Datos laborales</h2>
                        <div class="form-group">
                            <label for="salario">Salario</label>
                            <input type="number" class="form-control" id="salario" name="salario" value='<c:if test = "${empleado.idEmpleado > 0}">${empleado.salarioEmpleado}</c:if>' placeholder="Introduce tu salario" required>
                        </div>
                        <div class="form-group">
                            <label for="departamento">Departamento</label>
                            <input type="text" class="form-control" id="departamento" name="departamento" value='<c:if test = "${empleado.idEmpleado > 0}">${empleado.departamentoEmpleado}</c:if>' placeholder="Introduce tu departamento" required>
                        </div>
                        <div class="clearfix"></div>
                        <input type="submit" class="form-group btn btn-success btn-lg" name="accion" value="Alta">    
                        <input type="submit" class="form-group btn btn-primary btn-lg" name="accion" value="Actualizar">
                        <input type="submit" class="form-group btn btn-danger btn-lg" name="accion" value="Eliminar" formnovalidate>
                        <input type="submit" class="form-group btn btn-secondary btn-lg" name="accion" value="Volver" formnovalidate>
                    </form>
                </div>
            </main>
        <%@include file="structure/footer.jsp"%>
    </body>
</html>
