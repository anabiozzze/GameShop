package app.model;


import app.entities.StandartGame;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonModel {

    private static SingletonModel model;

    private static final String USERNAME = "root";
    private static final String PASSWORD = "ROOT123456";
    private static final String DATABASEURL = "jdbc:mysql://localhost:3306/test?serverTimezone=Europe/Moscow&useSSL=false";

    public static String driverPath = "com.mysql.cj.jdbc.Driver";
    public static Connection connection;
    public static Statement statement;


    public SingletonModel() {
    }

    public static synchronized SingletonModel getModel() {
        if (model==null) {
            model = new SingletonModel();
        }
        return model;
    }

    public static synchronized List<StandartGame> getList() {

        List<StandartGame> games = new ArrayList<StandartGame>();

        try {
            Class.forName(driverPath);
            connection = DriverManager.getConnection(DATABASEURL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from GameShop");

            String thisName, thisGenre;
            double thisPrice;

            while (resultSet.next()) {
                thisPrice = resultSet.getDouble("price");
                thisName = resultSet.getString("name");
                thisGenre = resultSet.getString("genre");

                StandartGame game = new StandartGame(thisName, thisPrice, thisGenre);
                games.add(game);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return games;
    }

    public static synchronized void addGames(StandartGame ... gamez) {
        try {
            //создаем соеднинение для базы данных
            Class.forName(driverPath);
            connection = DriverManager.getConnection(DATABASEURL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            String thisName, thisGenre;
            double thisPrice;

            for (StandartGame stg : gamez) {
                thisName = stg.getName();
                thisGenre = stg.getGenre();
                thisPrice = stg.getPrice();
                statement.executeUpdate("insert into GameShop (name, genre, price) VALUE " +
                        "('"+thisName+"', '"+thisGenre+"', '"+thisPrice+"')");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void delGames(StandartGame game) {
        try {
            //создаем соединение для базы данных
            Class.forName(driverPath);
            connection = DriverManager.getConnection(DATABASEURL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            String thisName = game.getName(), thisGenre = game.getGenre();
            double thisPrice = game.getPrice();

            statement.executeUpdate("delete from GameShop WHERE name =  '"+thisName+"' AND genre = " +
                    "'"+thisGenre+"' AND price = '"+thisPrice+"'");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
