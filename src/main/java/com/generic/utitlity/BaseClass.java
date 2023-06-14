package com.generic.utitlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.repository.HomePage;
import object.repository.LoginPage;

public class BaseClass {

	public PropertyFileUtility putil = new PropertyFileUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public JavaUtility jutil = new JavaUtility();

	public WebDriver d = null;
	public static WebDriver SDriver;

	@BeforeSuite(groups = { "SmokeSuit", "RegressionSuit" })
	public void BS() {
		System.out.println("===== DB Connection Successful =====");
	}

//	@Parameters("browser")
//	@AfterTest
	@BeforeClass(alwaysRun = true)
	public void BCLaunchBrowser(/* String BROWSER */) {
		String BROWSER = "chrome";
		String URL = "http://localhost:8888";

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser name.");
		}

		SDriver = d;
		// Maximise the window.
		wutil.maximiseWindow(d);

		// Wait until all html tree elements loaded.
		wutil.waitForPageLoad(d);

		// get URL
		d.get(URL);

	}

	@BeforeMethod(groups = { "SmokeSuit", "RegressionSuit" })
	public void BMLoginTOApplication() {
		LoginPage login = new LoginPage(d);
		login.loginToApplication();
	}

	@AfterMethod(groups = { "SmokeSuit", "RegressionSuit" })
	public void AMLogoutTOApplication() {
		HomePage hp = new HomePage(d);
		hp.logoutToApplication(d);
	}

//	@AfterTest
	@AfterClass(groups = { "SmokeSuit", "RegressionSuit" })
	public void ACCloseBrowser() {
		d.quit();
	}

	@AfterSuite(groups = { "SmokeSuit", "RegressionSuit" })
	public void AS() {
		System.out.println("===== DB Connection Closed =====");
	}
}
