import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestExcelReaderService {

    @Test
    public void testSheetNames() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = new ExcelReaderService();
        List<String> names = excelReaderService.sheetNames("test.xlsx");
        Assert.assertEquals(Arrays.asList("Sheet1", "Sheet2", "testSheet"), names);
    }

    @Test
    public void testRowNumbers() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = new ExcelReaderService();
        int rowNum = excelReaderService.rowNumber("test.xlsx", 0);
        Assert.assertEquals(1, rowNum);
    }

    @Test
    public void testColumnNumbers() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = new ExcelReaderService();
        int colNum = excelReaderService.columnNumber("test.xlsx", 0);
        Assert.assertEquals(2, colNum);
    }

    @Test
    public void testFieldNames() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = new ExcelReaderService();
        List<String> fieldNames = excelReaderService.fieldNamesAtHeaderRow("test.xlsx", 1);
        Assert.assertEquals(Arrays.asList("first", "second"), fieldNames);
    }

    @Test
    public void testConcatCells() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = new ExcelReaderService();
        String allCellNames = excelReaderService.concatCellsAtRow("test.xlsx", 0, 0);
        Assert.assertEquals("HOP burdayım", allCellNames);
    }

}
