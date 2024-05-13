package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_Soru_2 extends JDBCParent {
    @Test
    public void Test() throws SQLException {

        DBConnectionOpen();

        ResultSet resultSet = statement.executeQuery("select * from city");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("city"));
        }

        DBConnectionClose();

    }
}
