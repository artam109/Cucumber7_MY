package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_FirstLastGetRowGetType extends JDBCParent{


    @Test
    public void Test() throws SQLException {
        DBConnectionOpen();

        ResultSet rs = statement.executeQuery("select city from city");

        rs.last(); // son satıra gider
        System.out.println("Last row = " + rs.getString(1));

        rs.first(); // ilk satıra gider
        System.out.println("First row = " + rs.getString(1));

        rs.last();
        int rowInd = rs.getRow(); // şuanki satır indexini döner
        System.out.println("rowInd = " + rowInd);



        DBConnectionClose();
    }


}
