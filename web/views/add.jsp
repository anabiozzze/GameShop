<%--
  Created by IntelliJ IDEA.
  User: andreimironov
  Date: 04/10/2018
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>

<%--код страницы "добавить игру"--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/w3.css">
    <title>ДОБАВЛЕНИЕ НОВОЙ ИГРЫ</title>

</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-animate-opacity w3-animate-left">
    <h1>Введите жанр, наименование и цену игры:</h1>
</div>

<form method="post">

    <br />
    <div class="w3-container w3-left-align">
    <label>
        <input type="text" name="name"> НАЗВАНИЕ<br />
    </label>
    </div>

    <div class="w3-container w3-left-align">
    <label>
        <input type="text" name="genre"> ЖАНР<br />
    </label>
    </div>

    <div class="w3-container w3-left-align">
    <label>
        <input type="text" name="price"> ЦЕНА<br />
    </label>
    </div>

    <br />
    <div class="w3-container w3-left-align w3-margin-bottom">
    <button class="w3-button w3-blue-grey w3-round-large" type="submit">Добавить</button>
    </div>
    <%
        if (request.getAttribute("success")!=null) {
            out.println();
            out.println("Игра успешно добавлена в каталог!");
        }%>

</form>

<div class="w3-container w3-left-align">
    <button class="w3-button w3-blue-grey w3-round-large" onclick="location.href='/'">На главную</button>
</div>

</body>
</html>
