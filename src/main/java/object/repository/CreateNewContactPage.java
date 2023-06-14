package object.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utitlity.WebDriverUtility;


public class CreateNewContactPage extends WebDriverUtility {
	@FindBy(name = "lastname")
	private WebElement LastName;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement CreateOrganisationLookUpImg;

	@FindBy(name = "search_text")
	private WebElement OrgSearchTextField;

	@FindBy(name = "search")
	private WebElement OrgSearchBtn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateNewContactPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getCreateOrganisationLookUpImg() {
		return CreateOrganisationLookUpImg;
	}

	public WebElement getSearchTextField() {
		return OrgSearchTextField;
	}

	public WebElement getSearchBtn() {
		return OrgSearchBtn;
	}

	public void createNewContact(WebDriver d, String LASTNAME, String ORGNAME) {
		LastName.sendKeys(LASTNAME);
		CreateOrganisationLookUpImg.click();
		switchToWindow(d, "Accounts");
		OrgSearchTextField.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		d.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(d, "Contacts");
		SaveBtn.click();
	}

}
