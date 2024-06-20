package exotica.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import exotica.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement LeadsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindAll({@FindBy(linkText = "Sign Out"),@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")})
	private WebElement SignOutLnk;
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}

	//Utilization
	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	//Business Library
	
	/**
	 * This method will perform signout operation
	 * @param driver
	 */
	public void signOutApp(WebDriver driver)
	{
		mouseHoverOn(driver, adminstratorImg);
		SignOutLnk.click();
	}
	
	/**
	 * This method will click on organizations Link
	 */
	public void clickOnOrgLnk()
	{
		OrganizationLnk.click();
	}
	
	/**
	 * This method will click on contacts
	 */
	public void clickOnContactLnk()
	{
		ContactsLnk.click();
	}
	

}
