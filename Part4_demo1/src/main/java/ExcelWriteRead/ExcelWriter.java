package ExcelWriteRead;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import static org.apache.poi.ss.usermodel.IndexedColors.RED;

public class ExcelWriter {
    private File excelFile;
    private Workbook workbook;
    private Sheet sheet;

    public ExcelWriter(File excelFile) {
        this.excelFile = excelFile;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Danh sách sản phẩm");
        sheet.setDefaultColumnWidth(20);

    }

    public void CreateContentRow (int index, int id, String name, int price, Date date, int totalStock, int currentStock, int itemSold){
        Row contentRow = sheet.createRow(index);

        Cell contenCell = contentRow.createCell(0);
        contenCell.setCellValue(id);

        contenCell = contentRow.createCell(1);
        contenCell.setCellValue(name);

        contenCell = contentRow.createCell(2);
        contenCell.setCellValue(price);

        contenCell = contentRow.createCell(3);
        contenCell.setCellValue(date);

        contenCell = contentRow.createCell(4);
        contenCell.setCellValue(totalStock);

        contenCell = contentRow.createCell(5);
        contenCell.setCellValue(currentStock);

        if(itemSold != (totalStock - currentStock)){
            contenCell = contentRow.createCell(6);
            contenCell.setCellValue(itemSold);

            CellStyle style = workbook.createCellStyle();
            style.setFillBackgroundColor(RED.getIndex());
            contenCell.setCellStyle(style);

        }


    }

    public void CreateContentRow (int index, int id, String name, int price, Date date, int totalStock, int currentStock){
        Row contentRow = sheet.createRow(index);

        Cell contenCell = contentRow.createCell(0);
        contenCell.setCellValue(id);

        contenCell = contentRow.createCell(1);
        contenCell.setCellValue(name);

        contenCell = contentRow.createCell(2);
        contenCell.setCellValue(price);

        contenCell = contentRow.createCell(3);
        contenCell.setCellValue(date);

        contenCell = contentRow.createCell(4);
        contenCell.setCellValue(totalStock);

        contenCell = contentRow.createCell(5);
        contenCell.setCellValue(currentStock);

        contenCell = contentRow.createCell(6);
        contenCell.setCellValue(totalStock - currentStock);

    }

    public  void createHeaderCell(Row headerRow, int index, String value, CellStyle style){
        Cell headerCell = headerRow.createCell(index);
        headerCell.setCellValue(value);
        headerCell.setCellStyle(style);
    }

    public void createHeaderRow (int index, String column0, String column1, String column2, String column3, String column4, String column5, String column6) {
        Row headerRow = sheet.createRow(index);

        CellStyle headStyle = workbook.createCellStyle();
        headStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());

        createHeaderCell(headerRow, 0, column0, headStyle);
        createHeaderCell(headerRow, 1, column1, headStyle);
        createHeaderCell(headerRow, 2, column2, headStyle);
        createHeaderCell(headerRow, 3, column3, headStyle);
        createHeaderCell(headerRow, 4, column4, headStyle);
        createHeaderCell(headerRow, 5, column5, headStyle);
        createHeaderCell(headerRow, 6, column6, headStyle);

    }

    public void WriteWorkBookToExcelFile() throws IOException{
        FileOutputStream outputStream = new FileOutputStream(excelFile);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }




}
