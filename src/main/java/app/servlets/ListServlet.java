package app.servlets;

import app.entities.StandartGame;
import app.model.SingletonModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SingletonModel model = SingletonModel.getModel();
        List<StandartGame> servletGames = model.getList();

        req.setAttribute("allGames", servletGames);

        // создаем диспетчер запросов; аргументом указываем адрес нужной jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/list.jsp");
        // теперь передадим диспетчеру и запрос, и ответ
        dispatcher.forward(req, resp);
    }
}
