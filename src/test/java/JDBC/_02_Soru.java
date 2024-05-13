package JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class _02_Soru {

    @Test
    public void Test2() throws SQLException {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement queryScreen = connection.createStatement();

        ResultSet resultSet = queryScreen.executeQuery("select * from city");

        while (resultSet.next()) {
            String name = resultSet.getString("city");
            System.out.println("city = " + name);
        }


        connection.close();
    }
}
