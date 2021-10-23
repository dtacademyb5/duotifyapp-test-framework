package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestApachePOI


{

    public static void main(String[] args) throws IOException {



        FileInputStream fis = new FileInputStream("testDat.xlsx");

        XSSFWorkbook book = new XSSFWorkbook(fis);
        XSSFSheet sheet = book.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(0); // Apache POI method indexes are 0-based
        XSSFCell cell = row.getCell(0);

        System.out.println(cell.toString());

        int noRows = sheet.getPhysicalNumberOfRows();
        System.out.println(sheet.getLastRowNum());

        int noCols = sheet.getRow(0).getPhysicalNumberOfCells();


        System.out.println(noCols);

        for (int i = 0; i < noRows; i++) {

            for (int j = 0; j < noCols; j++) {

                System.out.print(sheet.getRow(i).getCell(j) + "\t");
            }
            System.out.println();

        }



        ExcelUtils excelUtils = new ExcelUtils("testDat.xlsx", "Sheet1");


        System.out.println(excelUtils.getCellData(0, 0));
        System.out.println(excelUtils.getColumnNames());


        excelUtils.getDataAs2DArray();


        List<Map<String, String>> list = excelUtils.getDataAsMap();

        System.out.println(list.get(1).get("Price"));


        excelUtils.setCellData("TEST PASSED", "Status", 1);




    }


}
