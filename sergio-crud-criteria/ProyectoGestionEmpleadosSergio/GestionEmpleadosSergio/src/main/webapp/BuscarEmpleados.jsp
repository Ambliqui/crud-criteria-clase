<%-- 
    Document   : index
    Created on : 20-oct-2021, 22:55:53
    Author     : serlo
--%>

<%@page import="Entity.Empleado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SLC.SA</title>
        <link rel="stylesheet" href="css/BuscarEmpleadosCSS.css">
        <link rel="stylesheet" href="css/GeneralCSS.css">
    </head>
    <body>
        <jsp:include page="include/Titulo.jsp"></jsp:include>
            <form action="BuscarEmpleadosPostServlet" method="GET">
                <section id="botones">
                    <button id="isntfiltros" class="noshow">FILTROS</button>
                    <button id="isfiltros" class="show" hidden>FILTROS</button>
                    <input type="submit" name="submit" id="mostrar" value="MOSTRAR TODOS">
                    <input type="submit" name="submit" id="filtrar" value="FILTRAR" hidden>
                </section>
                <section id="datos" class="show" hidden>
                    <div>
                        <label for="nombre">Nombre:</label>
                        <input type="text" name="nombre" id="nombre">
                    </div>
                    <div>
                        <label for="apellido">Apellidos:</label>
                        <input type="text" name="apellido" id="apellido">
                    </div>
                    <div>
                        <label for="minimo">Salario mínimo:</label>
                        <input type="number" name="minimo" id="minimo" step="1000">
                    </div>
                    <div>
                        <label for="maximo">Salario máximo:</label>
                        <input type="number" name="maximo" id="maximo" step="1000">
                    </div>
                    <div>
                        <label for="departamento">Departamento</label>
                        <input type="text" name="departamento" id="departamento">
                    </div>
                </section>
            </form>
            <section id="lista">
            <%
                List<Empleado> empleadosFiltrados = (List<Empleado>) request.getAttribute("empleadosFiltrados");
                if (empleadosFiltrados != null) {
                    for (Empleado e : empleadosFiltrados) {
                        request.setAttribute("empleado", e);
            %>
            <jsp:include page="include/Empleado.jsp"/>
            <%
                    }
                }
            %>
        </section>

        <script src="js/BuscarEmpleadosJS.js"></script>
    </body>
</html>
