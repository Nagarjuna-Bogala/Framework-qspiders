package infomax_Contact;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import exotica.GenericUtility.BaseClass;

public class CreateContactTest extends BaseClass {
	
	@Test
	public void createContactTest() throws IOException {
		//------Excel Sheet -> Test Data------
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Contact");
		Row row = sh.getRow(1);
		Cell cel = row.getCell(2);
		String LastName = cel.getStringCellValue();
		
		//Step 4: navigate to Contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 5: navigate create Contacts
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Step 6: create Contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		//Step 7: save
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		}

}
