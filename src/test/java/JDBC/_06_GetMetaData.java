package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _06_GetMetaData extends JDBCParent{

    @Test
    public void test() throws SQLException {
        DBConnectionOpen();

        ResultSet rs = statement.executeQuery("select city_id, city, country_id from city");

        rs.next();
        System.out.println("id=" + rs.getString(1)); // her tip getString ile alabilirsin
        System.out.println("id=" + rs.getString("city_id"));

        int intID = rs.getInt("city_id"); // Kolonun variable tipine uygun get ile de alabilirsin
        System.out.println("intID = " + intID);


        DBConnectionClose();
    }


    @Test
    public void test2() throws SQLException {
        DBConnectionOpen();

        ResultSet rs = statement.executeQuery("select * from city");

        ResultSetMetaData rsmd = rs.getMetaData(); // DATA dışındaki veriyi ver, kolon sayısı ve kolon isimleri gibi

        int columnNum = rsmd.getColumnCount();
        System.out.println("columnNum = " + columnNum);
        for (int i = 1; i <= columnNum; i++) {
            System.out.println(rsmd.getColumnName(i)+ rsmd.getColumnType(i));
        }

        rs.next();
        System.out.println("1.Column = " + rs.getString(1));
        System.out.println("2.Column = " + rs.getString(2));
        System.out.println("3.Column = " + rs.getString(3));
        System.out.println("------------------------------");

        for (int i = 1; i < columnNum; i++) {
            System.out.println(i + ".Kolon= " + rs.getString(i));
        }


        DBConnectionClose();
    }

}
