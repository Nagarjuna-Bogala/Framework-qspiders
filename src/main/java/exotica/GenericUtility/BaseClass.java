package exotica.GenericUtility;
import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import exotica.ObjectRepository.HomePage;
import exotica.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains basic configuration annotation for common
 * @author nagar
 *
 */
public class BaseClass {
	
	public DatabaseUtility dUtil=new DatabaseUtility();
	public ExelFileUtility eUtil=new ExelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	
	public WebDriver driver=null;
	static WebDriver sdriver;
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		//dUtil.connectToDB();
		Reporter.log("---Data Base connection successful--",true);
	}
	@Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("--Browser"+BROWSER+"launched successfully", true);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Reporter.log("--Browser"+BROWSER+"launched successfully", true);
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		sdriver=driver;
		wUtil.maximiseWindow(driver);
		wUtil.waitForElementsToLoadInDOM(driver);
		driver.get(URL);

	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String USERNAME= pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("--Login Successfull--", true);
	}
	
	@AfterMethod
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
		hp.signOutApp(driver);
		Reporter.log("--Signout successfull--", true);
	}
	
	@AfterClass
	public void acConfig()
	{
		driver.close();
		Reporter.log("--browser closed sucessfully--", true);
	}
	
	@AfterSuite
	public void asConfig() throws SQLException
	{
		dUtil.closeDB();
		Reporter.log("--Database connection closed successfully--", true);
	}
	
	
	
	
	

}
