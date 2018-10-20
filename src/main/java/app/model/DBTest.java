package app.model;

import java.sql.*;

public class DBTest {


    public static void main(String[] args) {
        addGames();
    }

    public static void addGames(){
        Statement st = Connector.getStatement();

        String thisName = "AAAAA", thisGenre = "FFFFF";
        double thisPrice = 65;

        try {
            st.executeUpdate("INSERT INTO GameShop(name,genre,price) VALUE " +
                    "('"+thisName+"','"+thisGenre+"','"+thisPrice+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
