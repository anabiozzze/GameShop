package app.servlets;

import app.entities.StandartGame;
import app.model.SingletonModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    // класс отвечает за обработку запросов от страницы добавления новой игры

    @Override
    // метод передает в add.jsp данные, необходимые для загрузки страницы;
    // также указывается адрес тела самой страницы
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // создаем диспетчер запросов; аргументом указываем адрес нужной jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/add.jsp");

        // теперь передадим диспетчеру и запрос, и ответ
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // на основании параметров полученного запроса создадим новый объект игры
        // и добавим его в модель. Она, в свою очередь, добавляет игру в БД и сообщает странице об успехе

        String name = req.getParameter("name");
        String genre = req.getParameter("genre");
        double price = Double.parseDouble(req.getParameter("price"));

        StandartGame game = new StandartGame(name, price, genre);

        SingletonModel model = SingletonModel.getModel();
        model.addGames(game);

        // атрибут будет считан и использован в add.jsp для вывода соотв. сообщения
        req.setAttribute("success", game);
        doGet(req, resp);
    }
}
