package ApachePOI;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
 * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
 * yani metoda "Password" kelimesi gönderilecek, dönen değer Password un değeri olacak.
 * bulup ve sonucun döndürülmesi için metod kullanınız.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */

public class _05_GetASpesificData {

    public static void main(String[] args) throws IOException {

        String result = getFromExcel("Address");
        System.out.println(result);

    }

    public static String getFromExcel(String value) throws IOException {
        String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";
        FileInputStream fileRead = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileRead);
        Sheet sheet = workbook.getSheetAt(0);


        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(value)) {
                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    result.append(sheet.getRow(i).getCell(j)).append(" | ");
                }
            }

        }
        return result.toString();
    }


}
