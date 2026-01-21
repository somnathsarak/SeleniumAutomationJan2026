package com.automation.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelFileManager {
    private String excelFilePath;
    private Workbook workbook;
    private Sheet sheet;

    public ExcelFileManager(String filePath, String sheetName) {
        this.excelFilePath = filePath;
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
        }
    }

    public List<Map<String, String>> getTestData(String sheetName) {
        List<Map<String, String>> data = new ArrayList<>();
        sheet = workbook.getSheet(sheetName);
        
        int rowCount = sheet.getPhysicalNumberOfRows();
        Row headerRow = sheet.getRow(0);
        
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;
            
            Map<String, String> rowData = new LinkedHashMap<>();
            for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
                String key = headerRow.getCell(j).getStringCellValue();
                String value = row.getCell(j).getStringCellValue();
                rowData.put(key, value);
            }
            data.add(rowData);
        }
        return data;
    }

    public void closeWorkbook() {
        try {
            if (workbook != null) workbook.close();
        } catch (IOException e) {
            System.out.println("Error closing workbook: " + e.getMessage());
        }
    }
}
