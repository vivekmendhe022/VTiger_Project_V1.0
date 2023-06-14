package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(xpath = "//span[contains(text(),'Contact Information')]")
	private WebElement ContactHeaderText;

	public ContactInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getContactHeader() {
		return ContactHeaderText;
	}

	public String getContactHeaderInfo() {
		return ContactHeaderText.getText();
	}

}
