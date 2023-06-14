package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utitlity.WebDriverUtility;


public class CreateNewOrganizationPage extends WebDriverUtility {

	@FindBy(name = "accountname")
	private WebElement ORGNameTextField;

	@FindBy(name = "industry")
	private WebElement IndustryDropDownList;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateNewOrganizationPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getORGNameTextField() {
		return ORGNameTextField;
	}

	public WebElement getIndustryDropDownList() {
		return IndustryDropDownList;
	}

	public void createOrg(String ORGNAME) {
		ORGNameTextField.sendKeys(ORGNAME);
		SaveBtn.click();
	}

	public void createOrgWithIndustry(String ORGNAME, String INDUSTRY) {
		ORGNameTextField.sendKeys(ORGNAME);
		handleDropDown(INDUSTRY, IndustryDropDownList);
		SaveBtn.click();
	}

}
