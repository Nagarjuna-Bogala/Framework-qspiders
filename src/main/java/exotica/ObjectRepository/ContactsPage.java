package exotica.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import exotica.GenericUtility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {
	
	//declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewContactLookUpImg;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateNewContactLookUpImg() {
		return createNewContactLookUpImg;
	}
	
	//business library
	public void clickOnCreateNewContactImg()
	{
		createNewContactLookUpImg.click();
	}
	
	
	
}
