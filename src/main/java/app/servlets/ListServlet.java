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
    // класс отвечает за обработку запросов от страницы со списком всех игр

    private SingletonModel model = SingletonModel.getModel();
    private int id;
    private String name;
    private String genre;
    private double price;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // обработка запроса на удаление игры по ИД + атрибут для вывода сообщения об успешном удалении
        // атрибут будет считан и иапользован в list.jsp

        try {

            id = Integer.parseInt(req.getParameter("id"));
            if (id!=0) {
                model.delByID(id);
                req.setAttribute("successID", id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // обработка запроса на удаление игры по имени + атрибут для вывода сообщения об успешном удалении
        // атрибут будет считан и иапользован в list.jsp
        try {
            name = req.getParameter("name");
            if (!name.equals(null)) {
                model.delByName(name);
                req.setAttribute("successName", name);
            }

        } catch (Exception e) {
           e.printStackTrace();
        }


        // обработка запроса на изменение игры по ИД;
        // если запрос включает в себя параметр changeID - значит, пользователь воспользовался соответствующим
        // полем ("введите нужный ID"); дальше идут проверки след. полей ("введите новое название" и т.д.).

        try {
            int changeID = Integer.parseInt(req.getParameter("changeID"));
            if (changeID!=0) {

                try {
                    name = req.getParameter("changeName");
                    if (!name.equals(null)) {
                        model.setName(name, changeID);
                        // атрибут будет считан и иапользован в list.jsp для вывода соотв. сообщения
                        req.setAttribute("successChange", name);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    genre = req.getParameter("changeGenre");
                    if (!genre.equals(null)) {
                        model.setGenre(genre, changeID);
                        // атрибут будет считан и использован в list.jsp для вывода соотв. сообщения
                        req.setAttribute("successChange", genre);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    price = Double.parseDouble(req.getParameter("changePrice"));
                    if (price!=0) {
                        model.setPrice(price, changeID);
                        // атрибут будет считан и использован в list.jsp для вывода соотв. сообщения
                        req.setAttribute("successChange", price);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        doGet(req, resp);
    }

    @Override
    // метод передает в list.jsp данные, необходимые для загрузки страницы;
    // также указывается адрес тела самой страницы
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StandartGame> servletGames = model.getList();

        req.setAttribute("allGames", servletGames);

        // создаем диспетчер запросов; аргументом указываем адрес нужной jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/list.jsp");
        // передадим диспетчеру и запрос, и ответ
        dispatcher.forward(req, resp);
    }
}
