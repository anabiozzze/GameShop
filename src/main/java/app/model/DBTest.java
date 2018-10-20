package app.model;

import java.sql.*;

public class DBTest {

    //тестовый класс для проверки исполнения запросов к БД

    public static void main(String[] args) {
        addGames();
    }

    public static void addGames(){
        Statement st = Connector.getStatement();

        String thisName = "AAAAA", thisGenre = "FFFFF";
        double thisPrice = 65;
        String n = "AWE"; int ID = 55;

//        try {
//            st.executeUpdate("INSERT INTO GameShop(name,genre,price) VALUE " +
//                    "('"+thisName+"','"+thisGenre+"','"+thisPrice+"')");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try {
            st.executeUpdate("UPDATE GameShop SET name = '"+n+"' WHERE id = "+ID+"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
