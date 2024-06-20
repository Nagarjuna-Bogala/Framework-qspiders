package exotica.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import exotica.GenericUtility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility{
	
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrgHeaderText()
	{
		return OrgHeaderText;
	}
	
	//business library
	
	/**
	 * This method will get the header text for organization
	 * @return
	 */
	public String getOrgHeader()
	{
		String orgHeader= OrgHeaderText.getText();
		return orgHeader;
	}

}
