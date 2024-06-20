package infomax_Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import exotica.GenericUtility.BaseClass;

public class CreateOrganizationTest extends BaseClass{
	@Test
	public void createOrgTest() throws IOException {
		//Generate random number to avoid duplicate data
		Random r = new Random();
		int RANDOM = r.nextInt(1000);
				
		//------Excel Sheet -> Test Data------
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\Test data.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Organization");
		Row row = sh.getRow(1);
		Cell cel = row.getCell(2);
		String ORGNAME = cel.getStringCellValue();
				
		//Step 4: navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();
				
		//Step 5: navigate create Organizations
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
		//Step 6: create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
				
		//Step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		}

}
