package infomax_Organization;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import exotica.GenericUtility.DatabaseUtility;
import exotica.GenericUtility.ExelFileUtility;
import exotica.GenericUtility.JavaUtility;
import exotica.GenericUtility.PropertyFileUtility;
import exotica.GenericUtility.WebDriverUtility;
import exotica.ObjectRepository.CreateNewOrganizationPage;
import exotica.ObjectRepository.HomePage;
import exotica.ObjectRepository.LoginPage;
import exotica.ObjectRepository.OrganizationInfoPage;
import exotica.ObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(exotica.GenericUtility.ListenersImplementation.class)
public class CreateMultipleOrganizatinsWithIndustryTest {
	
	ExelFileUtility eUtil=new ExelFileUtility();
	DatabaseUtility dUtil=new DatabaseUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	JavaUtility jUtil=new JavaUtility();
	
	WebDriver driver=null;
	@Test(dataProvider = "OrgData")
	public void createMultipleOrgTest(String OrgName, String IndustryType) throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		
		String Org=OrgName+jUtil.getRandomNumber();
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("----- chrome browser launched successfully-----");
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			System.out.println("-----firefox browser launched successfully----");
		}
		else
		{
			System.out.println("browser invalid");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("----- chrome browser launched successfully-----");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createNewOrg(Org, IndustryType);
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader=oip.getOrgHeader();
		System.out.println(OrgHeader);
		Assert.assertTrue(OrgHeader.contains(Org));
	}
	
	@DataProvider(name = "OrgData")
	public Object[][] getData() throws IOException
	{
		return eUtil.readMultipleDataFromExcel("MultipleOrg");
		
	}
}
