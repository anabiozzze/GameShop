<%@ page import="java.util.List" %>
<%@ page import="app.entities.StandartGame" %><%--
  Created by IntelliJ IDEA.
  User: andreimironov
  Date: 04/10/2018
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/w3.css">
    <title>ПОЛНЫЙ КАТАЛОГ</title>
</head>
<body class="w3-light-gray">
<div class="w3-container w3-animate-left w3-animate-opacity w3-blue-gray">
    <h1>На данный момент доступны игры:</h1>
</div>

<div class="list">
<div class="w3-container w3-left-align">
    <br />
<%
    List<StandartGame> games =  (List<StandartGame>) request.getAttribute("allGames");
    if (!games.isEmpty() || games!=null) {
        for (StandartGame gm : games) {
            out.print("<li>" + gm.getGenre() + "; " + gm.getName() + "; " + gm.getPrice() + "</li>");
            %>
    <%--Добавляем кнопку "удалить"--%>
    <span class="button1">
        <button class="w3-button w3-round-large w3-blue-gray" onclick="location.href='/'">удалить</button>
    </span>
    <%--Возвращаемся в foreach--%>
    <%
        }
    } else out.print("КАТАЛОГ ПУСТ");
    %>
</div>
</div>

<br />
<div class="w3-container w3-left-align">
    <br />
    <button class="w3-button w3-round-large w3-blue-gray" onclick="location.href='/'">НА ГЛАВНУЮ</button>
</div>
</body>
</html>
