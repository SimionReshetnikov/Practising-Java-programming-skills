<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>List</title>
</head>
<body>
<section>
    <h3>Список всех задач</h3>
    <c:choose>
        <c:when test="${empty tasks}">
            <p>Список задач пуст</p>
        </c:when>
        <c:otherwise>
            <ul>
                <c:forEach var="task" items="${tasks}">
                    <li>ID: ${task.id} | Title: ${task.title} | Done: ${task.done} | Time: ${task.createdAt}</li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</section>
</body>
</html>