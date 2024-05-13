package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class _06_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);


        int lastRowInd = sheet.getPhysicalNumberOfRows();
        Row newRow = sheet.createRow(lastRowInd); // yeni satır oluştur
        Cell newCell = newRow.createCell(0); // yeni satırda hücre oluştur

        newCell.setCellValue("Hello World"); // yeni hücreye değer ata

        // aynı anda okuma ve yazma yapılamıyor, okuma modu kapatıldı
        inputStream.close();

        // dosyayı KAYDETMEK için
        FileOutputStream outputStream = new FileOutputStream(path); // kaydetme modu
        workbook.write(outputStream); // workbook kaydedildi
        workbook.close(); // hafıza boşaltıldı
        outputStream.close(); // yazma modu kapatıldı

    }
}
