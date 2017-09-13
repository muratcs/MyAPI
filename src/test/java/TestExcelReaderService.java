import excelreader.ExcelReaderService;
import excelreader.IExcelReaderService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestExcelReaderService {

    @Test
    public void testSheetNames() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = ExcelReaderService.getInstance();
        List<String> names = excelReaderService.sheetNames("src/test/resources/test.xlsx");
        Assert.assertEquals(Arrays.asList("Sheet1", "Sheet2", "testSheet"), names);
    }

    @Test
    public void testRowNumbers() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = ExcelReaderService.getInstance();
        int rowNum = excelReaderService.rowNumber("src/test/resources/test.xlsx", 0);
        Assert.assertEquals(1, rowNum);
    }

    @Test
    public void testColumnNumbers() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = ExcelReaderService.getInstance();
        int colNum = excelReaderService.columnNumber("src/test/resources/test.xlsx", 0);
        Assert.assertEquals(2, colNum);
    }

    @Test
    public void testFieldNames() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = ExcelReaderService.getInstance();
        List<String> fieldNames = excelReaderService.fieldNamesAtHeaderRow("src/test/resources/test.xlsx", 1);
        Assert.assertEquals(Arrays.asList("first", "second"), fieldNames);
    }

    @Test
    public void testConcatCells() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = ExcelReaderService.getInstance();
        String allCellNames = excelReaderService.concatCellsAtRow("src/test/resources/test.xlsx", 0, 0);
        Assert.assertEquals("HOP burdayım", allCellNames);
    }

}
