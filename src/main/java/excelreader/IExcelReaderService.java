package excelreader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.List;

public interface IExcelReaderService {
    List<String> sheetNames(String fileName) throws IOException, InvalidFormatException;

    int rowNumber(String fileName, int sheetIndex) throws IOException, InvalidFormatException;

    int columnNumber(String fileName, int sheetIndex) throws IOException, InvalidFormatException;

    List<String> fieldNamesAtHeaderRow(String fileName, int sheetIndex) throws IOException, InvalidFormatException;

    String concatCellsAtRow(String fileName, int sheetIndex, int rowNumber) throws IOException, InvalidFormatException;
}
