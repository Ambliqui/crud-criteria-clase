<%-- 
    Document   : AnnadirEmpleado
    Created on : 21-oct-2021, 19:04:52
    Author     : serlo
--%>

<%@page import="Entity.Empleado"%>
<%@page import="Herramientas.MetodosServlets"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <title>SLC.SA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/GeneralCSS.css">
        <link rel="stylesheet" href="css/AnnadirEmpleadoCSS.css">
    </head>
    <body>
        <jsp:include page="include/Titulo.jsp"></jsp:include>
        <form action="AnnadirEmpleadoPostServlet" method="GET">
            <div id="error">
                <c:out value="${error}"/>
            </div>
            <div>
                <label for="nombre">Nombre:</label>
                <input class="dato" type="text" id="nombre" name="nombre" placeholder="<c:out value='${empleado.getNombreempleado()}'/>" required>
            </div>
            <div>
                <label for="apellidos">Apellidos:</label>
                <input class="dato" type="text" id="apellidos" name="apellidos" placeholder="<c:out value='${empleado.getApellidoempleado()}'/>" required>
            </div>
            <div>
                <label for="sueldo">Sueldo:</label>
                <%
                Empleado empleado = (Empleado) request.getAttribute("empleado");
                String sueldo = "";
                if(!empleado.getNombreempleado().equals("")){
                    sueldo=empleado.getSueldoempleado().toString();
                }
                %>
                <input class="dato" type="number" id="sueldo" name="sueldo" placeholder="<%=sueldo%>" step=1000 required>
            </div>
            <div>
                <label for="departamento">Departamento:</label>
                <input class="dato" type="text" id="departamento" name="departamento" placeholder="<c:out value='${empleado.getDepartamentoempleado()}'/>" required>
            </div>
            <div id="botones">
                <input type="reset" value="LIMPIAR">
                <input type="submit" value="REGISTRAR">
            </div>
        </form>
    </body>
</html>
