package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
   Main den bir metod çağırmak suretiyle, path i ve sheetName i verilen excelden
   istenilen sütun kadar veriyi okuyup bir List e atınız.
   Bu soruda kaynak Excel için : ApacheExcel2.xlsx  in 2.sheet ini kullanabilirsiniz.
 */
public class _10_Soru {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        List<List<String>> list = getList(path, "testCitizen", 3, 3);
        System.out.println(list);

    }

    public static List<List<String>> getList(String path, String sheet, int row, int colm) {
        Sheet workpage = null;
        try {
            FileInputStream fileRead = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fileRead);
            workpage = workbook.getSheet(sheet);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            assert false;
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<String> rowList = new ArrayList<>();
            for (int j = 0; j < colm; j++) {
                rowList.add(workpage.getRow(i).getCell(j).toString());
            }
            result.add(rowList);
        }

        return result;
    }
}
