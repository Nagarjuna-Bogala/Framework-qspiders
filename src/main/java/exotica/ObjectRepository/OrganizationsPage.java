package exotica.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import exotica.GenericUtility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility{
	
	//declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgLookUpImg;
	
	//initialization 
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateOrgLookUpImg()
	{
		return createNewOrgLookUpImg;
	}
	
	//business library
	
	/**
	 * This method will click on create new organization lookup image
	 */
	public void clickOnCreateNewOrgImg()
	{
		createNewOrgLookUpImg.click();
	}

}
