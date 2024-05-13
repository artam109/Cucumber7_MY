package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExcelUtility {

    public static void writeToExcel(String path, String testResult) {
        File file = new File(path);
        if (!file.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet 1");

            Row newRow = sheet.createRow(0);
            Cell newCell = newRow.createCell(0);
            newCell.setCellValue(testResult);

            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("File Created");

        } else {
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
            sheet.createRow(rowCount).createCell(0).setCellValue(testResult);

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

    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int colmNum) {
        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  //tüm satırlar

            ArrayList<String> satir = new ArrayList<>();
            for (int j = 0; j < colmNum; j++) {
                satir.add(sheet.getRow(i).getCell(j).toString());  // o andaki satırın tüm hücreleri okundu
            }

            table.add(satir);  // satır  tabloya (2D)  eklendi
        }

        return table;
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

    public static void alignData(Sheet sheet, Workbook workbook, String alignment) {
        CellStyle style = workbook.createCellStyle();
        try {
            style.setAlignment(HorizontalAlignment.valueOf(alignment.toUpperCase(Locale.ROOT)));
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid alignment specified: " + alignment.toUpperCase(Locale.ROOT));
            System.err.println("Changed alignment to: CENTER");
            // Defaulting to CENTER if an invalid alignment is provided
            style.setAlignment(HorizontalAlignment.CENTER);
        }
        Row row;
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
            if (row != null) {
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    Cell currentCell = row.getCell(j);
                    if (currentCell != null) {
                        currentCell.setCellStyle(style);
                    }
                }
            }
        }
    }


}
