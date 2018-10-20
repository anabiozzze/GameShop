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
    private SingletonModel model = SingletonModel.getModel();
    private int id;
    private String name;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            id = Integer.parseInt(req.getParameter("id"));
            if (id!=0) {
                model.delByID(id);
                req.setAttribute("successID", id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            name = req.getParameter("name");
            if (!name.equals(null)) {
                model.delByName(name);
                req.setAttribute("successName", name);
            }

        } catch (Exception e) {
           e.printStackTrace();
        }

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StandartGame> servletGames = model.getList();

        req.setAttribute("allGames", servletGames);

        // создаем диспетчер запросов; аргументом указываем адрес нужной jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/list.jsp");
        // теперь передадим диспетчеру и запрос, и ответ
        dispatcher.forward(req, resp);
    }
}
