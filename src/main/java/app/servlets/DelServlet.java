package app.servlets;

import app.entities.StandartGame;
import app.model.SingletonModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DelServlet extends HttpServlet {
    SingletonModel model;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //при получении запроса на удаление - этот метод будет подтверждать удаление на странице add

        // создаем диспетчер запросов; аргументом указываем адрес нужной jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/add.jsp");

        // теперь передадим диспетчеру и запрос, и ответ
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // удаляем нужную запись из БД
        String name = req.getParameter("name");
        String genre = req.getParameter("genre");
        double price = Double.parseDouble(req.getParameter("price"));

        StandartGame game = new StandartGame(name, price, genre);
        model.delGames(game);

        req.setAttribute("success", game);
        doGet(req, resp);
    }
}