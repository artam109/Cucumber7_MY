package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
   Main den bir metod çağırmak suretiyle, henüz oluşturulmamış
   path i verilen excel için, program her çalıştıkça içine "test passed"
   yazısını ekleyen metodu yazınız.
   Yani dosya yoksa oluştur ilk satıra yaz, sonra dosya oluşacağı için
   dosya varsa en son satırın altına yaz.
 */
public class _11_Soru {
    public static void main(String[] args) {
        String path = "src/test/java/ApachePOI/resource/Soru11.xlsx";
        String testResult = "Test Passed";
        writeToExcel(path, testResult);
        writeToExcel(path, testResult);

    }

    private static void writeToExcel(String path, String testResult) {

        File file = new File(path);
        if (!file.exists()) { // Create the file
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet 1");

            Row newRow = sheet.createRow(0);
            Cell newCell = newRow.createCell(0);
            newCell.setCellValue("Hello World");

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("File Created");

        } else { // If file exist, write to that file

            FileInputStream inputStream = null;
            Workbook workbook = null;
            Sheet sheet = null;

            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            sheet.createRow(rowCount).createCell(0).setCellValue("test passed");

            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}
