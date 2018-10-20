<%@ page import="java.util.List" %>
<%@ page import="app.entities.StandartGame" %>

<%--
  Created by IntelliJ IDEA.
  User: andreimironov
  Date: 04/10/2018
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>

<%--код страницы "весь каталог"--%>

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


    <%--создаем таблицу и столбцы, в которые будет выводиться информация--%>
<table align="left" cellpadding="10px">
    <thead>
<tr>
    <td><b>ID</b></td>
    <td><b>Жанр</b></td>
    <td><b>Название</b></td>
    <td><b>Цена</b></td>
</tr>
</thead>

    <%--
    получаем список всех игр в БД из метода doGet класса ListServlet;
    затем выводим список через foreach, располагая св-ва элементов списка в столбцах
    --%>
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

    <%
            }
            }else out.print("КАТАЛОГ ПУСТ");
%>

</table>

    <%--
    блок для изменения данных игры по ее ID;
    задает содержание и имена полей для ввода, имена затем используются в методе doPost класса ListServlet.
    кнопка подтверждает отправку запроса на изменение игры.
    --%>
    <form method="post">
        <div class="w3-container w3-left-align">
            <br />
            __________________________________________________________________________________________________
            <br />
            <br />
            <br />

            <button class="w3-button w3-blue-grey w3-round-large" style="width: 300px" type="submit">
                ИЗМЕНИТЬ ПО ID:</button>

            <label>
                ID <input type="text" placeholder="введите нужный ID" name="changeID">
            </label>

                Назв. <input type="text" placeholder="введите новое название" name="changeName">
            </label>

            <label>
                Жанр <input type="text" placeholder="введите другой жанр" name="changeGenre">
            </label>

            <label>
                Цена <input type="text" placeholder="введите новую цену" name="changePrice">
            </label>

            <%
                if (request.getAttribute("successChange")!=null) {
                    out.println();
                    out.println("Готово!");
                }%>

        </div>
    </form>


    <%--
    блок для удаления игры по ее ID;
    задает содержание и имя полю для ввода, имя затем используется в методе doPost класса ListServlet.
    кнопка подтверждает отправку запроса на удаление игры.
    --%>
    <form method="post">
    <div class="w3-container w3-left-align">

        <button class="w3-button w3-blue-grey w3-round-large" style="width: 300px" type="submit">
            УДАЛИТЬ ПО ID:</button>

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

    <%--
    блок для удаления игры по ее названию;
    задает содержание и имя полю для ввода, имя затем используется в методе doPost класса ListServlet.
    кнопка подтверждает отправку запроса на удаление игры.
    --%>

    <form method="post">
        <div class="w3-container w3-left-align">

            <button class="w3-button w3-blue-grey w3-round-large" style="width: 300px" type="submit">
                УДАЛИТЬ ПО НАИМЕНОВАНИЮ:</button>

            <label>
                <input type="text" name="name">
            </label>

            <%
                if (request.getAttribute("successName")!=null) {
                    out.println();
                    out.println("Игра успешно удалена!");
                }%>

            <br />

            <text><small> удаление всех подходящих по имени товаров</small></text>

        </div>
    </form>

    <div class="w3-container w3-left-align">
        <button class="w3-button w3-round-large w3-blue-gray" onclick="location.href='/'">НА ГЛАВНУЮ</button>
    </div>
</div>
</div>
</body>
</html>
