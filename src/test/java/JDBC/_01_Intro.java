package JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    @Test
    public void Test1() throws SQLException {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        // 1- Bağlantı bilgilerini girdik DB server'a bağlandık
        Connection connection = DriverManager.getConnection(url, username, password);

        // 2- Sorgu ekranını açtık
        Statement queryScreen = connection.createStatement();

        // 3- Sorgu ekranına sorguyu yazdım ve çalıştırdım
        ResultSet resultSet = queryScreen.executeQuery("select * from customer");

        // 4- Altta sonuçlar gözüktü
        while (resultSet.next()) {
            String name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");

            System.out.println("full_name = " + name + " " + last_name);
        }


        connection.close();

    }

}
