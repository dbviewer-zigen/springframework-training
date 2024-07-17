<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update TODO</title>
</head>
<body>
    <h1>Update TODO</h1>
    <form action="../update/${todo.id}" method="post">
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="${todo.description}" required>
        <br/>
        <label for="completed">Completed:</label>
        <input type="checkbox" id="completed" name="completed" ${todo.completed ? 'checked' : ''}>
        <br/>
        <input type="submit" value="Update">
    </form>
    <br/>
    <a href="../todos">Back to List</a>
</body>
</html>
