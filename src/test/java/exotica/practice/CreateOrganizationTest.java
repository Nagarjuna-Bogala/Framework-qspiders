package exotica.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrganizationTest {
	
	@Test
	public void createOrganizationTest() throws IOException {
		
		Random r = new Random();
		int RANDOM = r.nextInt(1000);
		
		//Step 1: Read the necessary Data
		//-----Property File -> Common Data-----
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);
		//String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//------Excel Sheet -> Test Data------
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Organization");
		Row row = sh.getRow(1);
		Cell cel = row.getCell(2);
		String ORGNAME = cel.getStringCellValue();
		//Step 1: Launch The browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//step 2: Login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step 3: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4: Click on create organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step 5: Enter the mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
		
		//step 6: Save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
	
		System.out.println("Organization created");
		
		
	}

}
