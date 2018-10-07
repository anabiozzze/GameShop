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
    <title>ПОЛНЫЙ КАТАЛОГ</title>
</head>
<body>
МЫ НАХОДИМСЯ В JSP LIST

<%
    List<StandartGame> games =  (List<StandartGame>) request.getAttribute("allGames");
    if (!games.isEmpty() || games!=null) {
        for (StandartGame gm : games) {
            out.println("<li>" + gm.getGenre() + "; " + gm.getName() + "; " + gm.getPrice() + "</li>");
        }
    } else out.print("Каталог пока что пуст!");
%>
</body>
</html>
