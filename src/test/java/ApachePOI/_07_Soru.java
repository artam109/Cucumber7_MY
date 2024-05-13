package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_Soru {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/MultTable.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);


        Row newRow;
        Cell newCell;

        int num = 1;
        int multiplier = 0;
        for (int i = 1; i <= 109; i++) {
            multiplier++;
            newRow = sheet.createRow(i - 1);
            newCell = newRow.createCell(0);
            newCell.setCellValue(num);
            for (int j = 1; j < 2; j++) {
                newRow.createCell(j).setCellValue("x");
                newRow.createCell(j + 1).setCellValue(multiplier);
                newRow.createCell(j + 2).setCellValue("=");
            }
            newCell = newRow.createCell(4);
            newCell.setCellValue(num * multiplier);
            if (i % 11 == 0) {
                num++;
                multiplier = 0;
                sheet.createRow(i - 1);
            }
        }

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }


}


