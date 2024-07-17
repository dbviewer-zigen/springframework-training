<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create TODO</title>
</head>
<body>
    <h1>Create TODO</h1>
    <form action="create" method="post">
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required>
        <br/>
        <label for="completed">Completed:</label>
        <input type="checkbox" id="completed" name="completed">
        <br/>
        <input type="submit" value="Create">
    </form>
    <br/>
    <a href="../todos">Back to List</a>
</body>
</html>
