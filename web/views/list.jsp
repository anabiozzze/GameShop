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
    <style>
        .layer {
            width: 85px; /* Ширина блока */
            height: 50px; /* Высота блока */
            padding: 5px; /* Поля вокруг текста */
            border: solid 1px black; /* Параметры рамки */
            white-space: pre-wrap; /* Запрещаем перенос строк */
        }
    </style>
</head>
<body class="w3-light-gray">
<div class="w3-container w3-animate-left w3-animate-opacity w3-blue-gray">
    <h1>На данный момент доступны игры:</h1>
</div>

<div class="lay">
<div class="w3-container w3-left-align">
    <br />

    <li>
        <span style="margin-left: 75px"><b>Жанр</b></span>
        <span style="margin-left: 75px"><b>Название</b></span>
        <span style="margin-left: 75px"><b>Цена($)</b></span>
        </li>
<%
    List<StandartGame> games =  (List<StandartGame>) request.getAttribute("allGames");
    if (!games.isEmpty() || games!=null) {
        for (StandartGame gm : games) {
%>
    <li>
        <%--Выводим описание игры через определенный отступ, чтобы попасть в столбцы категорий--%>
        <span style = "margin-left: 75px">
        <%
            out.print(gm.getGenre() + ";");
        %>
        </span>
        <span style = "margin-left: 75px">
        <%
            out.print(gm.getName() + ";");
        %>
        </span>
        <span style = "margin-left: 90px">
        <%
            out.print(gm.getPrice());
        %>

    <%--Добавляем кнопку "удалить"--%>
    <span class="button1" style = "margin-left: 75px">
        <button class="w3-button w3-blue-grey w3-round-large" type="submit">удалить</button>
    </span>
                <%
        if (request.getAttribute("success")!=null) {
            out.println();
            out.println("Игра успешно удалена!");
        }%>
    </li>

    <br />

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
