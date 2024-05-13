package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_NextPrevAbsRel extends JDBCParent{

    @Test
    public void Test() throws SQLException {
        DBConnectionOpen();

        ResultSet rs = statement.executeQuery("select * from language");
        rs.next();
        System.out.println("1.Row = " + rs.getString(2)); //  2 index değil sıra : Italian

        rs.next();
        System.out.println("2.Row = " + rs.getString(2)); // English

        rs.previous(); // bir öncekine döner
        System.out.println("2.Row = " + rs.getString(2)); // Italian


        DBConnectionClose();
    }

    @Test
    public void Test2() throws SQLException {
        // rs.next() : sonraki satır
        // rs.previous : önceki satır
        // rs.absolute(10) : baştan itibaren 10.satıra ileri gider.
        // rs.relative(10) : bulunduğu yerden 10.satıra ileri gider.
        // rs.absolute(-10) : - (eksi) sondan demektir, sondan 10.satır
        // rs.relative(-5) :  - (eksi) bulunduğu yerden 5 satır geri
        DBConnectionOpen();

        ResultSet rs =  statement.executeQuery("select * from film");

        rs.absolute(10); // direkt 10.satıra gider
        System.out.println("10.Row : " + rs.getString("title"));

        rs.absolute(5); // her zaman baştan sayarak gider
        System.out.println("5.Row" + rs.getString("title"));

        rs.relative(5); // en son yerden 5 satır ileri gider yani 10.satır
        System.out.println("10.Row :" + rs.getString("title"));

        rs.next(); // 11.satıra gider

    }

}
