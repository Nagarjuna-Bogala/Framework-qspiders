package exotica.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToOpenClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://online.qspiders.com/user?meeting_id=64a46def-4d5c-4f06-a8a7-b1c10779942e");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='/classes/476c64e5-fc34-4b9f-beb0-3ac204d9fb21']"));
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("nagarjunanag9573@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("7981927951");
	}

}
