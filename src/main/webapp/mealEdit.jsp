<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<form method="post" action="meals">
    Дата <label><input type="datetime-local" name="date"></label><br>

    Описание <label><input type="text" name="description"></label><br>

    Калории <label><input type="number" name="calories"></label><br><br>

    <input type="submit" value="Ok" name="Ok"> <input type="submit" value="Cancel" name="Cancel" onclick="location.href = 'meals'"><br>
</form>
</body>
</html>
