<%@ page import="java.util.List" %>
<%@ page import="app.entities.StandartGame" %>
<%@ page import="app.model.Connector" %>
<%@ page import="app.model.SingletonModel" %>
<%@ page import="app.servlets.DelServlet" %><%--
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

<div class="lay">
<div class="w3-container w3-left-align">
    <br />

<table align="left" cellpadding="10px">
    <thead>
<tr>
    <td><b>ID</b></td>
    <td><b>Жанр</b></td>
    <td><b>Название</b></td>
    <td><b>Цена</b></td>
</tr>
</thead>

    <%
        List<StandartGame> games =  (List<StandartGame>) request.getAttribute("allGames");
        if (!games.isEmpty() || games!=null) {
            for (StandartGame gm : games) {
    %>

<tr>
    <td><%out.print(gm.getID());%></td>
    <td><%out.print(gm.getGenre());%></td>
    <td><%out.print(gm.getName());%></td>
    <td><%out.print(gm.getPrice());%></td>
    <td align="left">
<%--<%--%>
    <%--StandartGame game = new StandartGame(gm.getName(), gm.getPrice(), gm.getGenre());--%>
    <%--SingletonModel.delGames(game);--%>
<%--%>--%>

    <%
            }
            }else out.print("КАТАЛОГ ПУСТ");
%>

<br />

</table>
    <br />
    <form method="post">
    <div class="w3-container w3-left-align">

        <button class="w3-button w3-blue-grey w3-round-large" style="width: 300px" type="submit">
            УДАЛИТЬ ПО ID</button>

        <label>
            <input type="text" name="id">
        </label>

        <%
            if (request.getAttribute("successID")!=null) {
                out.println();
                out.println("Игра успешно удалена!");
            }%>

    </div>
    </form>

    <form method="post">
        <div class="w3-container w3-left-align">

            <button class="w3-button w3-blue-grey w3-round-large" style="width: 300px" type="submit">
                УДАЛИТЬ ПО НАИМЕНОВАНИЮ</button>

            <label>
                <input type="text" name="name">
            </label>

            <%
                if (request.getAttribute("successName")!=null) {
                    out.println();
                    out.println("Игра успешно удалена!");
                }%>

            <br />

            <text><small> будут удалены все подходящие по имени товары</small></text>

        </div>
    </form>

    <div class="w3-container w3-left-align">
        <button class="w3-button w3-round-large w3-blue-gray" onclick="location.href='/'">НА ГЛАВНУЮ</button>
    </div>
</div>
</div>
</body>
</html>
