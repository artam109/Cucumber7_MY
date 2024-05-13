package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Excel Çarpım tablosunu
 * YENİ bir excel dosyasına
 * 1 den 10 kadar çarpımlar için yapınız.
 */

public class _09_Soru {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet 1");


        int rowInd = 0;

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                Row newRow = sheet.createRow(rowInd++);
                newRow.createCell(0).setCellValue(i);
                newRow.createCell(1).setCellValue("x");
                newRow.createCell(2).setCellValue(j);
                newRow.createCell(3).setCellValue("=");
                newRow.createCell(4).setCellValue(i * j);
            }
            sheet.createRow(rowInd++);
        }

        String path = "src/test/java/ApachePOI/resource/MultTable.xlsx";

        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
