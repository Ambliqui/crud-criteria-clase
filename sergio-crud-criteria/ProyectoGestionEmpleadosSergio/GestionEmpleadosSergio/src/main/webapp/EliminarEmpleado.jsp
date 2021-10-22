<%-- 
    Document   : EliminarEmpleado
    Created on : 22-oct-2021, 1:29:59
    Author     : serlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SLC.SA</title>
        <link rel="stylesheet" href="css/GeneralCSS.css">
        <link rel="stylesheet" href="css/EliminarEmpleado.css">
    </head>
    <body>
        <jsp:include page="include/Titulo.jsp"></jsp:include>
            <section>
                <h2>¿Confirma que desea borrar el usuario siguiente?</h2>
                <h3><c:out value="${empleado}"/></h3>
            <div id="enlaces">
                <a id="si" class="dirigir" href="EliminarEmpleadoPostServlet?id=<c:out value="${id}"/>">SI</a>
                <a id="no" class="dirigir" href="Index.jsp">NO</a>
            </div>
        </section>
    </body>
</html>
