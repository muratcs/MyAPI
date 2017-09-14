package excelreader;

import java.util.List;

public interface IExcelReaderService {
    List<String> sheetNames(String fileName);

    int rowNumber(String fileName, int sheetIndex);

    int columnNumber(String fileName, int sheetIndex);

    List<String> fieldNamesAtHeaderRow(String fileName, int sheetIndex);

    String concatCellsAtRow(String fileName, int sheetIndex, int rowNumber);
}
