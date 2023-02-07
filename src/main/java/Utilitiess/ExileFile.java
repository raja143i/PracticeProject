package Utilitiess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExileFile {

	 public String Excel(String sheetName, int rownum, int cellnum) throws Throwable {
		 FileInputStream f=new FileInputStream("./testdata.xlsx");
		 Workbook book = WorkbookFactory.create(f);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);
		return cell.getStringCellValue();
		 
	 }
}
