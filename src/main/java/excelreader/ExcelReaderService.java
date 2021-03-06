package excelreader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReaderService implements IExcelReaderService {

    private static final ExcelReaderService instance = new ExcelReaderService();

    private ExcelReaderService(){}

    public static ExcelReaderService getInstance(){
        return instance;
    }

    @Override
    public List<String> sheetNames(String fileName) {
        File file = new File(fileName);
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        List<String> allNames = new ArrayList<>();

        assert workbook != null;
        for (int i = 0; i<workbook.getNumberOfSheets(); i++){
            allNames.add(workbook.getSheetName(i));
        }
        return allNames;
    }

    @Override
    public int rowNumber(String fileName, int sheetIndex) {
        File file = new File(fileName);
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }

        try {
            assert workbook != null;
            Sheet sheetAt = workbook.getSheetAt(sheetIndex);
            return sheetAt.getLastRowNum()+1;
        }
        catch (NullPointerException e){
            e.getStackTrace();
        }
        return 0;
    }

    @Override
    public int columnNumber(String fileName, int sheetIndex) {
        File file = new File(fileName);
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }

        try {
            assert workbook != null;
            Sheet sheetAt = workbook.getSheetAt(sheetIndex);
            return sheetAt.getRow(0).getLastCellNum();
        }
        catch (NullPointerException e){
            e.getStackTrace();
        }
        return 0;
    }

    @Override
    public List<String> fieldNamesAtHeaderRow(String fileName, int sheetIndex) {
        File file = new File(fileName);
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }

        try {
            assert workbook != null;
            Sheet sheetAt = workbook.getSheetAt(sheetIndex);
            List<String> fieldNames = new ArrayList<>();
            for (Cell c : sheetAt.getRow(0)){
                fieldNames.add(c.getStringCellValue());
            }
            return fieldNames;
        }
        catch (NullPointerException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public String concatCellsAtRow (String fileName, int sheetIndex, int rowNumber) {
        File file = new File(fileName);
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }

        try {
            assert workbook != null;
            Sheet sheetAt = workbook.getSheetAt(sheetIndex);
            StringBuilder allCellNames = new StringBuilder();
            for (Cell c : sheetAt.getRow(rowNumber)){
                allCellNames.append(" ");
                allCellNames.append(c.getStringCellValue());
            }
            return allCellNames.substring(1);
        }
        catch (NullPointerException e){
            e.getStackTrace();
        }
        return null;
    }
}
