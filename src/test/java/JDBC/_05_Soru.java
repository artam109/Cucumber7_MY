package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_Soru extends JDBCParent{
    //city tablosundaki tüm satırlardaki şehir isimlerini absolute ile yazdırınız

    @Test
    public void test() throws SQLException {
        DBConnectionOpen();

        ResultSet rs = statement.executeQuery("select city from city");

        rs.last();
        int rowInd = rs.getRow();

        for (int i = 1; i <= rowInd; i++) {
            rs.absolute(i);

            System.out.println(rs.getString("city"));
        }

        DBConnectionClose();
    }

    @Test
    public void test2() throws SQLException {
        DBConnectionOpen();
        // city tablosundaki tüm satırlardaki şehir isimlerini relative ile yazdırınız

        ResultSet rs = statement.executeQuery("select city from city");

        rs.last();
        int rowInd = rs.getRow();

        rs.first();
        for (int i = 1; i < rowInd; i++) {
            rs.relative(1);
            System.out.println(rs.getString("city"));
        }

        DBConnectionClose();
    }

}
