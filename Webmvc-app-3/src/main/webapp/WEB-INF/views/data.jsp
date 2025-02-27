<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Students</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>View Students</h2>
    <table>
        <thead>
            <tr> 
                <th>s.no</th>
                <th>name</th>
                <th>email</th>
                <th>gender</th>
                <th>course</th>
                <th>timings</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.gender}</td>
                    <td>${student.course}</td>
                    <td>${student.timings}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
