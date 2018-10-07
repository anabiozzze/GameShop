<%--
  Created by IntelliJ IDEA.
  User: andreimironov
  Date: 04/10/2018
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ДОБАВЛЕНИЕ НОВОЙ ИГРЫ</title>
</head>
<body>

<div>
    <h1>Введите жанр, наименование и цену игры:</h1>
</div>


<div>
<form method="post">

    <label>Name:
        <input type="text" name="name"><br />
    </label>

    <label>Genre:
        <input type="text" name="genre"><br />
    </label>

    <label>Price:
        <input type="text" name="price"><br />
    </label>

    <button type="submit">Submit</button>

    <%
        if (request.getAttribute("success")!=null) {
            out.println();
            out.println("Игра успешно добавлена в каталог!");
        }%>

</div>
</form>

<div>
    <button onclick="location.href='/'">НА ГЛАВНУЮ</button>
</div>

</body>
</html>
