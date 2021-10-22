<%-- 
    Document   : index
    Created on : 20-oct-2021, 3:07:46
    Author     : model
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/chart.js@3.5.1/dist/chart.min.js"></script>
    </head>
    <body>


        <form  action="actions?action=search" method="POST">
            <legend>Elige sexo</legend>
            <ul>
                <li><label><input type="radio" name="genre" value="all"<c:if test="${genre == 'all' || genre == null}">checked</c:if>>Todos</label></li>
                <li><label><input type="radio" name="genre" value="MALE" <c:if test="${genre == 'MALE'}">checked</c:if>>Masculino</label></li>
                <li><label><input type="radio" name="genre" value="FEMALE" <c:if test="${genre == 'FEMALE'}">checked</c:if>>Femenino</label></li>
                <li><label><input type="radio" name="genre" value="NONBINARY" <c:if test="${genre == 'NONBINARY'}">checked</c:if>>No-binario</label></li>
                <li><label><input type="radio" name="genre" value="FLUID" <c:if test="${genre == 'FLUID'}">checked</c:if>>Fluido</label></li>
                </ul>
                <legend>Departamento</legend>
                <ul>
                    <li><label><input type="radio" name="department" value="all"<c:if test="${department == 'all' || department == null}">checked</c:if>>Todos</label></li>
                <li><label><input type="radio" name="department" value="Plant" <c:if test="${department == 'Plant'}">checked</c:if>>Planta producción</label></li>
                <li><label><input type="radio" name="department" value="Office" <c:if test="${department == 'Office'}">checked</c:if>>Oficina</label></li>
                <li><label><input type="radio" name="department" value="Workshop" <c:if test="${department == 'Workshop'}">checked</c:if>>Taller</label></li>

                </ul>

                <ul>
                    <li><label>Salario mínimo <input type="range" name="minSalary" min="1150"  max="3000" value="${minSalary}" id="minValue" step="50"></label></li><p id="minValueDisplay"></p>
                <li><label>Salario máximo <input type="range" name="maxSalary" min="1150"  max="3000" value="${maxSalary}" id="maxValue" step="50"></label></li><p id="maxValueDisplay"></p>                
            </ul>


            <ul>
                <li>
                    <label for="column">Ordenar por:</label>
                    <select name="column">
                        <option value="idEmployee" <c:if test="${column == 'idEmployee' || column == null}">selected</c:if>>idEmployee</option>
                        <option value="nameEmployee" <c:if test="${column == 'nameEmployee'}">selected</c:if>>nameEmployee</option>
                        <option value="lastNameEmployee" <c:if test="${column == 'lastNameEmployee'}">selected</c:if>>lastNameEmployee</option>
                        <option value="genreEmployee" <c:if test="${column == 'genreEmployee'}">selected</c:if>>genreEmployee</option>
                        <option value="salaryEmployee" <c:if test="${column == 'salaryEmployee'}">selected</c:if>>salaryEmployee</option>
                        <option value="departmentEmployee" <c:if test="${column == 'departmentEmployee'}">selected</c:if>>departmentEmployee</option>
                        </select>
                    </li>
                </ul>
                <ul>
                    <li>
                        <label for="ascDesc">Orden:</label>
                        <select name="ascDesc">
                            <option value="asc" <c:if test="${ascDesc == 'asc' || ascDesc == null}">selected</c:if>>Ascendente</option>
                        <option value="desc"<c:if test="${ascDesc == 'desc'}">selected</c:if>>Descendente</option>
                        </select>
                    </li>
                </ul>



                <input type="submit" value="Enviar">
            </form>


            <h1>Lista empleados</h1>
            <table id="tablaPaginada">
                <tr>
                    <th>ID empleado</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Sexo</th>
                    <th>Salario</th>
                    <th>Departamento</th>
                </tr>
            <c:forEach var="employee" items="${allEmployees}">  
                <tr>
                    <td><c:out value="${employee.idEmployee}"/></td>
                    <td><c:out value="${employee.nameEmployee}"/></td>
                    <td><c:out value="${employee.lastNameEmployee}"/></td>
                    <td><c:out value="${employee.genreEmployee}"/></td>
                    <td><c:out value="${employee.salaryEmployee}"/></td>
                    <td><c:out value="${employee.departmentEmployee.nameDepartment}"/></td>

                </tr>
            </c:forEach>
        </table>

        <h2>Estadísticas</h2>
        <p>Hay ${departmentStats[0]} empleados en Office</p>
        <p>Hay ${departmentStats[1]}  empleados en Workshop</p>
        <p>Hay ${departmentStats[2]}  empleados en Plant</p>

        <p>Hay ${genreStats[3]} empleados FEMALE</p>
        <p>Hay ${genreStats[1]} empleados MALE</p>
        <p>Hay ${genreStats[2]} empleados FLUID</p>
        <p>Hay ${genreStats[0]} empleados NONBINARY</p>

        <p>El salario medio es de ${avgSalaryEmployee}</p>

        <div id="contenedor">
            <canvas id="genreDistribution"></canvas>
            <canvas id="departmentDistribution"></canvas>
        </div>

        <script>
            
 
            
            
            var sliderMin = document.getElementById("minValue");
            var outputMin = document.getElementById("minValueDisplay");
            outputMin.innerHTML = sliderMin.value;
            sliderMin.oninput = function () {
                outputMin.innerHTML = this.value;
            };
            var sliderMax = document.getElementById("maxValue");
            var outputMax = document.getElementById("maxValueDisplay");
            outputMax.innerHTML = sliderMax.value;

            sliderMax.oninput = function () {
                outputMax.innerHTML = this.value;
            };
            var ctx = document.getElementById('genreDistribution').getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ['No-binario', 'Masculino', 'Fluido', 'Femenino'],
                    datasets: [{
                            label: 'Distribucción por género',
                            data: [${genreStats[0]}, ${genreStats[1]}, ${genreStats[2]}, ${genreStats[3]}],
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
            var ctx = document.getElementById('departmentDistribution').getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ['Oficina', 'Taller', 'Planta'],
                    datasets: [{
                            label: 'Distribucción por departamentos',
                            data: [${departmentStats[0]}, ${departmentStats[1]}, ${departmentStats[2]}],
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        </script>



    </body>
</html>
