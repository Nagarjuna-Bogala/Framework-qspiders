package exotica.practice;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopUp {

	@Test
	public void SelectAnyDate() throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveByOffset(20, 100).click().perform();
	
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement dst = driver.findElement(By.xpath("//input[@id='toCity']"));
	
		src.sendKeys("mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		
		dst.sendKeys("chennai");
		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();

	
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='Wed Sep 28 2022']")).click();
		Thread.sleep(5000);
		driver.close();
	}
}
