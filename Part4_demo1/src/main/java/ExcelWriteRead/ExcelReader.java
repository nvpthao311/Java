package ExcelWriteRead;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class ExcelReader {
    private Workbook workbook;
    private Sheet sheet;

    public ExcelReader(File excelFile) throws IOException, InvalidFormatException {
        workbook = new XSSFWorkbook(excelFile);
        sheet = workbook.getSheetAt(0);
    }

    public void readFromExcelFile() throws  IOException{
        for (Row row : sheet){
            System.out.println();
            for (Cell cell : row){
                printCellValue(cell);
                System.out.print("\t");
            }
        }
        workbook.close();
    }

    public void printCellValue(Cell cell){
        switch (cell.getCellType()){
            case STRING :
                System.out.print(cell.getStringCellValue());
                break;
            case NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)){
                    System.out.print(new SimpleDateFormat("dd-MM-yyyy").format(cell.getDateCellValue()));
                }else{
                    System.out.print((int) cell.getNumericCellValue());
                }
                break;
            default:
                break;
        }
    }


}
