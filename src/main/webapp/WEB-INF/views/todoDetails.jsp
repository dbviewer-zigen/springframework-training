<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>TODO Details</title>
</head>
<body>
    <h1>TODO Details</h1>
    <p>ID: ${todo.id}</p>
    <p>Description: ${todo.description}</p>
    <p>Completed: ${todo.completed}</p>
    <br/>
    <a href="../todos">Back to List</a>
</body>
</html>
