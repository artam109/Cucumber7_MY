package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public class _03_ApachePOIStart {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        //Java dosya okuma nesnesine bu yolu vererek bağlantı kuruyorum
        FileInputStream fileRead = new FileInputStream(path);

        //Dosya okuma işlemcisi üzerinden Çalışma Kitabını alıyorum
        // hafızada workbook'u alıp oluşturdu
        Workbook workbook = WorkbookFactory.create(fileRead);

        // istediğim isimdeki çalışma sayfasını aldım
        Sheet workpage = workbook.getSheet("Sheet1");

        Row row = workpage.getRow(0); // 0. satırı aldım

        Cell cell = row.getCell(0); // row içindeki 0. hücre

        System.out.println("cell = " + cell);

    }

}
