<%-- 
    Document   : ModificarEmpleado
    Created on : 22-oct-2021, 1:27:54
    Author     : serlo
--%>

<%@page import="Entity.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SLC.SA</title>
        <link rel="stylesheet" href="css/GeneralCSS.css">
        <link rel="stylesheet" href="css/AnnadirEmpleadoCSS.css">
    </head>
    <body>
        <jsp:include page="include/Titulo.jsp"></jsp:include>
        <form action="ModificarEmpleadoPostServlet?id=<%=request.getParameter("id")%>" method="GET">
            <div id="error">
                <c:out value="${error}"/>
            </div>
            <div>
                <label for="nombre">Nombre:</label>
                <input class="dato" type="text" id="nombre" name="nombre" placeholder="<c:out value='${empleado.getNombreempleado()}'/>">
            </div>
            <div>
                <label for="apellidos">Apellidos:</label>
                <input class="dato" type="text" id="apellidos" name="apellidos" placeholder="<c:out value='${empleado.getApellidoempleado()}'/>">
            </div>
            <div>
                <label for="sueldo">Sueldo:</label>
                <input class="dato" type="number" id="sueldo" name="sueldo" placeholder="<c:out value='${empleado.getSueldoempleado()}'/>" step="1000">
            </div>
            <div>
                <label for="departamento">Departamento:</label>
                <input class="dato" type="text" id="departamento" name="departamento" placeholder="<c:out value='${empleado.getDepartamentoempleado()}'/>">
            </div>
                <input type="text" name="id" id="id" value="<%=request.getParameter("id")%>" hidden>
            <div id="botones">
                <input type="reset" value="LIMPIAR">
                <input type="submit" value="MODIFICAR">
            </div>
        </form>
    </body>
</html>
