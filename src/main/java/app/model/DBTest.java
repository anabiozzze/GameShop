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

        try {
            //создаем соеднинение для базы данных
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DATABASEURL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();

            String thisName = "ferrefef", thisGenre = "feferf";
            double thisPrice = 65;
//            statement.executeUpdate("INSERT INTO GameShop(name,genre,price) VALUE " +
//                    "('"+thisName+"','"+thisGenre+"','"+thisPrice+"')");


            statement.executeUpdate("delete from GameShop WHERE name =  '"+thisName+"' AND genre = " +
                    "'"+thisGenre+"' AND price = '"+thisPrice+"'");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
