<%-- 
    Document   : projectinfo
    Created on : 2/03/2025, 11:57:30 PM
    Author     : 57300
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project Information</title>
    </head>
    <body>
        <h1>Project Information</h1>
        <form action="./ProjectServlet" method="POST">
            <table>
                <tr>
                    <td>Project Id</td>
                    <td><input type="text" name="idProject" value="${project.idProject}" /></td>
                </tr>
                <tr>
                    <td>Project Name</td>
                    <td><input type="text" name="name" value="${project.name}" /></td>
                </tr>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="${project.descripcion}" /></td>
                </tr>
                <tr>
                    <td>Localidad</td>
                    <td><input type="text" name="localidad" value="${project.localidad}" /></td>
                </tr>
                <tr>
                    <td>Presupuesto</td>
                    <td><input type="text" name="presupuesto" value="${project.presupuesto}" /></td>
                </tr>
                <tr>
                    <td>Habitantes</td>
                    <td><input type="text" name="habitantes" value="${project.habitantes}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Project ID</th>
            <th>Project Name</th>
            <th>Descripcion</th>
            <th>Localidad</th>
            <th>Presupuesto</th>
            <th>Habitantes</th>
                <c:forEach items="${allProject}" var="proj">
                <tr>
                    <td>${proj.idProject}</td>
                    <td>${proj.name}</td>
                    <td>${proj.descripcion}</td>
                    <td>${proj.localidad}</td>
                    <td>${proj.presupuesto}</td>
                    <td>${proj.habitantes}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>


