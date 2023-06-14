package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateContactLookUpImg;

	public ContactPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}

	public void clickOnCreateContactLookUpImg() {
		CreateContactLookUpImg.click();
	}

}
