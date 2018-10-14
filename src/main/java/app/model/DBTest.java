package app.model;

import app.entities.StandartGame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBTest {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "ROOT123456";
    private static final String DATABASEURL = "jdbc:mysql://localhost:3306/test?serverTimezone=Europe/Moscow&useSSL=false";

    public static void main(String[] args) {
//        Properties properties = new Properties();
//        properties.setProperty("user", USERNAME);
//        properties.setProperty("password", PASSWORD);
//        properties.setProperty("useSSL", "false");

        try {
            //создаем соеднинение для базы данных
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DATABASEURL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            String thisName, thisGenre;
            double thisPrice;
//            statement.executeUpdate("INSERT INTO GameShop(name,genre,price) VALUE " +
//                    "('"+thisName+"','"+thisGenre+"','"+thisPrice+"')");

            ResultSet resultSet = statement.executeQuery("select * from GameShop");
            List<StandartGame> games = new ArrayList<StandartGame>();

            while (resultSet.next()) {
                thisPrice = resultSet.getDouble("price");
                thisName = resultSet.getString("name");
                thisGenre = resultSet.getString("genre");

                StandartGame game = new StandartGame(thisName, thisPrice, thisGenre);
                games.add(game);
            }

            for (StandartGame game: games) {
                System.out.println(game.getName());
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
