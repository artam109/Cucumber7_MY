package ApachePOI;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        FileInputStream fileRead = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileRead);
        Sheet sheet = workbook.getSheet("Sheet1");


        // 1.Yöntem
        int rowCount = sheet.getPhysicalNumberOfRows(); // Kaç tane satır var, ilk null satıra kadar

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);

            if (row == null) continue;

            int cellCount = row.getPhysicalNumberOfCells(); // bu satırdaki hücre sayısı

            for (int j = 0; j < cellCount; j++) {
                if (row.getCell(j) != null){
                    System.out.print(row.getCell(j) + "\t");
                }
            }
            System.out.println();
        }


        // 2.Yöntem

        for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j <sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                System.out.print(sheet.getRow(i).getCell(j) + "\t");
            }
            System.out.println();
        }


    }

}
