package JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _07_Soru extends JDBCParent{
    // language tablosundaki tüm satırları ve tüm sütunları yazdırınız,
    // aynı mysql sonuç ekranında olduğu gibi

    @Test
    public void test() throws SQLException {
        DBConnectionOpen();

        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData(); // DATA dışındaki veriyi ver, kolon sayısı ve kolon isimleri gibi


        int columnNum = rsmd.getColumnCount();

        for (int i = 1; i <= columnNum; i++) {
            System.out.print(rsmd.getColumnName(i)+" | ");
        }
//
//        rs.last();
//        int rowInd = rs.getRow();
//
//        rs.next();
//        System.out.println();
//        for (int i = 1; i < rowInd; i++) {
//            rs.absolute(i);
//            System.out.println(rs.getString(1) +" | "+ rs.getString(2) +" | "+ rs.getString(3) + " |");
//        }
        System.out.println();
        // 2.Yöntem
        while (rs.next()){

            //bulunduğun satırı yazdır
            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                System.out.print(rs.getString(i)+"\t");

            System.out.println();
        }

        DBConnectionClose();
        // TODO : daha düzenli şekilde printf le isteyen yapsın
    }

}
