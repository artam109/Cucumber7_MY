package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _08_GetAllRowColumn extends JDBCParent{
    // bir metoda sorguyu("select * from language") gönderiniz,
    // metod size sorgunun datasını bir ArrayList olarak döndürsün

    @Test
    public void Test() throws SQLException {
        DBConnectionOpen();

        System.out.println(getTable("select * from language"));

        DBConnectionClose();
    }

}
