import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestExcelReaderService {

    @Test
    public void testA() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = new ExcelReaderService();
        List<String> names = excelReaderService.sheetNames("test.xlsx");
        Assert.assertEquals(Arrays.asList("Sheet1", "Sheet2"), names);
    }

    @Test
    public void testb() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = new ExcelReaderService();
        int rowNum = excelReaderService.rowNumber("test.xlsx", 0);
        Assert.assertEquals(1, rowNum);
    }

    @Test
    public void testc() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = new ExcelReaderService();
        int colNum = excelReaderService.columnNumber("test.xlsx", 0);
        Assert.assertEquals(2, colNum);
    }

    @Test
    public void testd() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = new ExcelReaderService();
        List<String> fieldNames = excelReaderService.fieldNamesAtHeaderRow("test.xlsx", 0);
        Assert.assertEquals(Arrays.asList("HOP", "burdayım"), fieldNames);
    }

    @Test
    public void teste() throws IOException, InvalidFormatException {
        IExcelReaderService excelReaderService = new ExcelReaderService();
        String allCellNames = excelReaderService.concatCellsAtRow("test.xlsx", 0, 0);
        Assert.assertEquals("HOP burdayım", allCellNames);
    }

}
