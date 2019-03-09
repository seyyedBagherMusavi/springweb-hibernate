<%--
  Created by IntelliJ IDEA.
  User: sayyed
  Date: 06/02/2019
  Time: 01:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>students</title>
</head>
<body>
<table style="">
    <thead style="background-color: #3f87a6;border-collapse: collapse;">
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>stdNumber</th>
    </tr>
    </thead>
    <tbody style="background-color: #e4f0f5">
    <c:forEach items="${persons}" var="person" >

        <tr>
            <td><c:out value="${person.name}" /></td>
            <td><c:out value="${person.family}" /></td>
            <td><c:out value="${person.age}" /></td>
            <td><a href="<c:url value='/delete/${person.id}' />" class="btn btn-success

custom-width">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
