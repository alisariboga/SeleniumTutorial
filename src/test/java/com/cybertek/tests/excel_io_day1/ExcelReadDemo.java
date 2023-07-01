package com.cybertek.tests.excel_io_day1;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReadDemo {
    //to create on object that will store Excel file
    Workbook workbook;
    //to create an object that will store specific sheet
    Sheet sheet;
    //to provide path to the file
    String path = "/Users/alisariboga/IdeaProjects/TestAutomation2023April/src/test/resources/Countries.xlsx";
    //to establish connection with Excel file
    FileInputStream inputStream;
    //to write data into file, we need output stream
    //*A file output stream is an output stream for writing data to a File
    FileOutputStream fileOutputStream;

    @BeforeMethod
    public void setUp() throws IOException {
        inputStream = new FileInputStream(path);
        workbook = WorkbookFactory.create(inputStream);
        fileOutputStream = new FileOutputStream(path);
        sheet = workbook.getSheet("Countries");

    }

    @Test
    public void readExcelFileRowAndColTest() {
        int rowCount = sheet.getLastRowNum();
        System.out.println("Row count: " + rowCount);
        //how to get number of columns?

        int colCount = sheet.getRow(0).getLastCellNum();
        System.out.println("Number of columns: " + colCount);
    }

    @Test
    public void readSingleCellValueTest() {
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        String value = cell.getStringCellValue();
        System.out.println("Value: " + value);

        String expected = "Nur-Sultan";
        String actual = sheet.getRow(3).getCell(1).toString();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void readWholeSheetTest() {
        int rowCount = sheet.getLastRowNum();
        for (int i = 0; i < +rowCount; i++) {
            String country = sheet.getRow(i).getCell(0).getStringCellValue();
            String capital = sheet.getRow(i).getCell(1).getStringCellValue();
            System.out.println(country + " - " + capital);
        }
    }

    @Test
    public void putDataInToMapTest() {
        //key - country
        //value - capital
        Map<String, String> countries = new HashMap<>();
        int rowCount = sheet.getLastRowNum();
        for (int i = 0; i < +rowCount; i++) {
            String country = sheet.getRow(i).getCell(0).getStringCellValue();
            String capital = sheet.getRow(i).getCell(1).getStringCellValue();
            countries.put(country, capital);
        }
        System.out.println(countries);
        String expected = "Moscow";
        String actual = countries.get("Russia");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void putDataIntoListOfMapsTest() {
        List<Map<String, String>> countries = new ArrayList<>();
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        for (int j = 1; j <= rowCount; j++) {
            Map<String, String> map = new HashMap<>();
            String country = sheet.getRow(j).getCell(0).toString();
            String capital = sheet.getRow(j).getCell(1).toString();
            map.put("country", country);
            map.put("capital", capital);
            countries.add(map);
        }
        System.out.println(countries);
    }

    @Test
    public void putDataIntoListOfMapsTest2() {
        List<Map<String, String>> table = new ArrayList<>();
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        //outer loop will change rows
        for (int row = 1; row <= rowCount; row++) {
            /*
            map that will contain key-value pair
            key - it's column name
            value - it's a cell value of specific row
             */
            Map<String, String> map = new HashMap<>();
            /*
            go through the row, and read all cells
            create a key-value pair based on:
            column name = cell value
             */
            for (int column = 0; column < colCount; column++) {
                String columnName = sheet.getRow(0).getCell(column).getStringCellValue();
                String columnValue = sheet.getRow(row).getCell(column).getStringCellValue();
                map.put(columnName, columnValue);
            }
            //add column name +
            table.add(map);
        }
        for (Map<String, String> value : table) {
            System.out.println(value);
        }
    }

    @Test
    public void writeDataTest() {
        Cell columnName = sheet.getRow(0).getCell(2);
        if (columnName == null) {
            //to create a cell
            columnName = sheet.getRow(0).createCell(2);
        }
        //3rd column is completely empty
        //we will write down test result next to every data set
        columnName.setCellValue("Result"); // to write something into cell
        int rowCount = sheet.getLastRowNum();
        for (int row=1; row<=rowCount; row++){
            Row rowValue = sheet.getRow(row);
            Cell cell = rowValue.getCell(2);
            if (cell==null){
                cell = rowValue.createCell(2);
            }
            cell.setCellValue("PASS");

        }
    }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        inputStream.close();
    }
}
