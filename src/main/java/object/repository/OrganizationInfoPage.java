package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(xpath = "//span[contains(text(),'Organization Information')]")
	private WebElement OrgHeader;

	public OrganizationInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getOrgHeader() {
		return OrgHeader;
	}

	public String getHeader() {
		return OrgHeader.getText();
	}
}
