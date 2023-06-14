package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utitlity.WebDriverUtility;


public class HomePage extends WebDriverUtility {

	@FindBy(linkText = "Organizations")
	private WebElement Organizations;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorLookUpImg;

	@FindBy(linkText = "Sign Out")
	private WebElement LogoutLink;

	@FindBy(linkText = "Contacts")
	private WebElement ContactLink;

	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getOrganizations() {
		return Organizations;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getAdministratorLookUpImg() {
		return AdministratorLookUpImg;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}

	public void clickOnOrganizationLink() {
		Organizations.click();
	}

	public void clickOnContactLink() {
		ContactLink.click();
	}

	public void logoutToApplication(WebDriver d) {
		mouseHoverAction(d, AdministratorLookUpImg);
	}

}
