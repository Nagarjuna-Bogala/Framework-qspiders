package exotica.practice;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Read_Data_From_Excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step 1: Load the file into file input stream
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		
		//step 2: Create workbook with workbook factory
		Workbook wb= WorkbookFactory.create(fis);
		
		//step 3: navigate to sheet
		Sheet sh= wb.getSheet("Organization");
		
		//step 4: Navigate to row
		Row r=sh.getRow(1);
		
		//step 5: navigate to cell
		Cell c= r.getCell(2);
		
		//step 6: read the respective cell value
		String value=c.getStringCellValue();
		System.out.println(value);

	}

}
