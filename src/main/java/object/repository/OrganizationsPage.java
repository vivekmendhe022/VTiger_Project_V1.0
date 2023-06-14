package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateOrgLookUpImg;

	public OrganizationsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}

	public void clickOnCreateOrgLookUpImg() {
		CreateOrgLookUpImg.click();
	}
}
