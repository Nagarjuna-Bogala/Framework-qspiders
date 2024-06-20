package infomax_Contact;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import exotica.GenericUtility.BaseClass;

public class CreateContactWithOrgTest extends BaseClass {
	
	@Test
	public void createContactWithOrgTest() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Nag");
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		String parentid = driver.getWindowHandle();
		Set<String> childIds = driver.getWindowHandles();
		for(String childId:childIds)
		{
			driver.switchTo().window(childId);	
		}
		
		Actions a=new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[text()='Qspidaers']"));
		a.moveToElement(element).click().perform();
		driver.switchTo().window(parentid);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(5000);
		
		
	}

}
