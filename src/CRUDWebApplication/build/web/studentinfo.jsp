<%-- 
    Document   : studentinfo
    Created on : 2/03/2025, 08:13:09 PM
    Author     : 57300
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student and Course Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value="${student.studentId}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstname" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastname" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.yearLevel}" /></td>
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
            <th>Student ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudent}" var="stud">
                <tr>
                    <td>${stud.studentId}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearLevel}</td>
                </tr>
            </c:forEach> 
        </table>
        
        <br>
        <h1>Course Information</h1>
        <form action="./CourseServlet" method="POST">
            <table>
                <tr>
                    <td>Course Id</td>
                    <td><input type="text" name="courseId" value="${course.courseId}" /></td>
                </tr>
                <tr>
                    <td>Course Name</td>
                    <td><input type="text" name="name" value="${course.name}" /></td>
                </tr>
                <tr>
                    <td>Number of Credits</td>
                    <td><input type="text" name="creditsNumber" value="${course.creditsNumber}" /></td>
                </tr>
                <tr>
                    <td>Semester</td>
                    <td><input type="text" name="semester" value="${course.semester}" /></td>
                </tr>
                <tr>
                    <td>Admited Students</td>
                    <td><input type="text" name="admitedStudents" value="${course.admitedStudents}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="AddCourse" />
                        <input type="submit" name="action" value="EditCourse" />
                        <input type="submit" name="action" value="DeleteCourse" />
                        <input type="submit" name="action" value="SearchCourse" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Course ID</th>
            <th>Course Name</th>
            <th>Number of Credits</th>
            <th>Semester</th>
            <th>Admited Students</th>
                <c:forEach items="${allCourse}" var="crs">
                <tr>
                    <td>${crs.courseId}</td>
                    <td>${crs.name}</td>
                    <td>${crs.creditsNumber}</td>
                    <td>${crs.semester}</td>
                    <td>${crs.admitedStudents}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>

