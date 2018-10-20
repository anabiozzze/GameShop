package app.model;

import app.entities.StandartGame;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SingletonModel {
    // этот класс берет данные из БД и обрабатывает их согласно запросам от сервлетов
    // на случай нескольких обращений одновременно, методы синхронизированы

    private static SingletonModel model;
    private static Statement statement = Connector.getStatement();

    private static String thisName, thisGenre;
    private static double thisPrice;
    private static int thisID;


    public SingletonModel() {
    }

    // т.к. данные могут использоваться разными сервлетами (в т.ч. одновременно) - реализуем синглтон
    public static synchronized SingletonModel getModel() {
        if (model==null) {
            model = new SingletonModel();
        }
        return model;
    }


    // метод подключается к БД и формирует список всех её записей
    public static synchronized List<StandartGame> getList() {
        List<StandartGame> games = new ArrayList<StandartGame>();

        try {
            ResultSet resultSet = statement.executeQuery("select * from GameShop");

            while (resultSet.next()) {
                thisPrice = resultSet.getDouble("price");
                thisName = resultSet.getString("name");
                thisGenre = resultSet.getString("genre");
                thisID = resultSet.getInt("id");


                StandartGame game = new StandartGame(thisName, thisPrice, thisGenre);
                game.setID(thisID);
                games.add(game);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return games;
    }

    // метод добавляет новую игру со всеми полями
    public static synchronized void addGames(StandartGame ... gamez) {
        for (StandartGame stg : gamez) {
            thisName = stg.getName();
            thisGenre = stg.getGenre();
            thisPrice = stg.getPrice();

            try {
                statement.executeUpdate("INSERT INTO GameShop(name,genre,price) VALUE " +
                        "('"+thisName+"','"+thisGenre+"','"+thisPrice+"')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // удаление конкретной игры - на всякий случай (не реализовано в jsp)
    public static synchronized void delGames(StandartGame game) {
        try {
            thisName = game.getName();
            thisGenre = game.getGenre();
            thisPrice = game.getPrice();

            statement.executeUpdate("delete from GameShop WHERE name =  '"+thisName+"' AND genre = " +
                    "'"+thisGenre+"' AND price = '"+thisPrice+"'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // удаление записи по ID
    public static synchronized void delByID(int ID) {
        try {

            statement.executeUpdate("delete from GameShop WHERE id =  '"+ID+"'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // удаление записи по имени
    public static synchronized void delByName(String name) {
        try {

            statement.executeUpdate("delete from GameShop WHERE name = '"+name+"'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // изменение имени игры по ID
    public static synchronized void setName(String n, int ID) {
        try {
            statement.executeUpdate("UPDATE GameShop SET name = '"+n+"' WHERE id = "+ID+"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // изменение цены игры по ID
    public static synchronized void setPrice(double p, int ID) {
        try {
            statement.executeUpdate("UPDATE GameShop SET price = '"+p+"' WHERE id = "+ID+"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // изменение жанра записи по ID
    public static synchronized void setGenre(String g, int ID) {
        try {
            statement.executeUpdate("UPDATE GameShop SET genre = '"+g+"' WHERE id = "+ID+"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
