package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    public static Connection connection;
    public static Statement statement;

    public static void DBConnectionOpen() {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    public static void DBConnectionClose() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    public List<List<String>> getTable(String query) {
        DBConnectionOpen();
        List<List<String>> arr = new ArrayList<>();
        try{
            ResultSet rs = statement.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()){
                List<String> tmp = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++){
                    tmp.add(rs.getString(i));
                }
                arr.add(tmp);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            DBConnectionClose();
        }

        return arr;
    }
}
