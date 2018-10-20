package app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    // класс отвечает за установление и разрыв соединения с БД
    // другие классы получают уже готовое подключение - statement

    private static final String USERNAME = "root";
    private static final String PASSWORD = "ROOT123456";
    private static final String DATABASEURL = "jdbc:mysql://localhost:3306/test?serverTimezone=Europe/Moscow&useSSL=false";

    private static String driverPath = "com.mysql.cj.jdbc.Driver";
    private static Connection connection;
    private static Statement statement;

    public static Statement getStatement() {
        try {
            //создаем соеднинение для базы данных
            Class.forName(driverPath);
            connection = DriverManager.getConnection(DATABASEURL, USERNAME, PASSWORD);
            statement = connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }

    public static void closeStatement() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
