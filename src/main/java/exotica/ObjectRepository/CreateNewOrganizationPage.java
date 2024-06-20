package exotica.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import exotica.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	//declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business library
	
	/**
	 * This method will create organization with org name
	 * @param Orgname
	 */
	public void createNewOrg(String Orgname)
	{
		OrgNameEdt.sendKeys(Orgname);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with industry drop down
	 * @param Orgname
	 * @param IndustryType
	 */
	public void createNewOrg(String Orgname,String IndustryType)
	{
		OrgNameEdt.sendKeys(Orgname);
		handleDropDown(IndustryType, industryDropDown);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with type and industry drop down
	 * @param Orgname
	 * @param industryType
	 * @param type
	 */
	public void createNewOrg(String Orgname,String industryType,String type)
	{
		OrgNameEdt.sendKeys(Orgname);
		handleDropDown(industryType, industryDropDown);
		handleDropDown(type, typeDropDown);
		saveBtn.click();
	}

}
