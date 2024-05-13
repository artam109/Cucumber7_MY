package ApachePOI;

import Utilities.ExcelUtility;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _07_SoruVertical {
    public static void main(String[] args) throws IOException {

        writeVertical();

    }

    public static void writeVertical() throws IOException {
        String path = "src/test/java/ApachePOI/resource/MultTableHorizontal.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);


        Row row = null;
        int colInd = 0;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i == 1) {
                    row = sheet.createRow(j - 1);
                }
                sheet.getRow(j - 1).createCell(colInd).setCellValue(i);
                sheet.getRow(j - 1).createCell(colInd + 1).setCellValue("x");
                sheet.getRow(j - 1).createCell(colInd + 2).setCellValue(j);
                sheet.getRow(j - 1).createCell(colInd + 3).setCellValue("=");
                sheet.getRow(j - 1).createCell(colInd + 4).setCellValue(i * j);
            }
            colInd = row.getPhysicalNumberOfCells() + i;
        }

        ExcelUtility.alignData(sheet, workbook, "right");


        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }

}


