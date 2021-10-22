<%@page import="DAO.EmpleadoDAOImplementado"%>
<%@page import="Entity.Empleado"%>
<%@page import="DAO.EmpleadoDAOInterface"%>

<%
    Empleado e = (Empleado) request.getAttribute("empleado");
%>
<pre><a href="ModificarEmpleadoPreServlet?id=<%=e.getIdempleado()%>" class="editarBorrar"><img src="imagenes/lapiz.png"/></a><a href="EliminarEmpleadoPreServlet?id=<%=e.getIdempleado()%>" class="editarBorrar"><img src="imagenes/borrar.png"/></a><%=e.toString()%></pre>