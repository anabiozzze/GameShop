package app.servlets;

import app.entities.StandartGame;
import app.model.SingletonModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // создаем диспетчер запросов; аргументом указываем адрес нужной jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/add.jsp");

        // теперь передадим диспетчеру и запрос, и ответ
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // на основании параметров создаддим новый объект игры и добавим его в список игр через модель
        String name = req.getParameter("name");
        String genre = req.getParameter("genre");
        int price = Integer.parseInt(req.getParameter("price"));

        StandartGame game = new StandartGame(name, price, genre);

        SingletonModel model = SingletonModel.getModel();
        model.addGames(game);

        req.setAttribute("success", game);
        doGet(req, resp);
    }
}
