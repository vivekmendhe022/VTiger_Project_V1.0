package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "user_name")
	private WebElement Username;

	@FindBy(name = "user_password")
	private WebElement Password;

	@FindBy(id = "submitButton")
	private WebElement LoginBtn;

	public LoginPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	public void loginToApplication() {
		Username.sendKeys("admin");
		Password.sendKeys("admin");
		LoginBtn.click();
	}

}
