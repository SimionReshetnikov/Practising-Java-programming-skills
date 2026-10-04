<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Добавление данных</title>
</head>
<body>
    <meta charset="UTF-8">
    <h1>Добавить задачу</h1>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/tasks/add" method="post">
        <p>
            <label>Описание задачи:</label><br>
            <input type="text" name="title" required>
        </p>
        <p>
            <button type="submit">Создать</button>
        </p>
    </form>

    <p>
        <a href="${pageContext.request.contextPath}/tasks">К списку задач</a>
    </p>
</body>
</html>