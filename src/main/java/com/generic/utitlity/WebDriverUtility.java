package com.generic.utitlity;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains 28 methods of Web Drivers including JavaScript Interface
 * or Take ScreenShot Interface.
 * 
 * @author vivek
 *
 */
public class WebDriverUtility {

	/**
	 * This method will maximise the window.
	 * 
	 * @param d
	 */
	public void maximiseWindow(WebDriver d) {
		d.manage().window().maximize();
	}

	/**
	 * This method will minimise the window.
	 * 
	 * @param d
	 */
	public void minimiseWindow(WebDriver d) {
		d.manage().window().minimize();
	}

	/**
	 * 
	 * This method wait for page to load for 20 seconds
	 * 
	 * @param d
	 */
	public void waitForPageLoad(WebDriver d) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * This method will wait for 20 seconds for a element to be visible.
	 * 
	 * @param d
	 * @param element
	 */
	public void waitForElementClickable(WebDriver d, WebElement element) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method handle dropdown using index value.
	 * 
	 * @param Element
	 * @param index
	 */
	public void handleDropDown(WebElement Element, int index) {
		Select select = new Select(Element);
		select.selectByIndex(index);
	}

	/**
	 * This method handle dropdown using value.
	 * 
	 * @param value
	 * @param Element
	 */
	public void handleDropDown(String value, WebElement Element) {
		Select select = new Select(Element);
		select.selectByValue(value);
	}

	/**
	 * This method handle dropdown using VisibleText.
	 * 
	 * @param Element
	 * @param VisibleText
	 */
	public void handleDropDown(WebElement Element, String VisibleText) {
		Select select = new Select(Element);
		select.selectByVisibleText(VisibleText);
	}

	/**
	 * This method will perfor mouse hover action on particular element.
	 * 
	 * @param d
	 * @param Element
	 */
	public void mouseHoverAction(WebDriver d, WebElement Element) {
		Actions actions = new Actions(d);
		actions.moveToElement(Element).perform();
		
	}

	/**
	 * This method will perfor right click on web page.
	 * 
	 * @param d
	 */
	public void rightClickAction(WebDriver d) {
		Actions actions = new Actions(d);
		actions.contextClick().perform();
	}

	/**
	 * This method will perform right click on particular element.
	 * 
	 * @param Element
	 * @param d
	 */
	public void rightClickAction(WebElement Element, WebDriver d) {
		Actions actions = new Actions(d);
		actions.contextClick(Element).perform();
	}

	/**
	 * This method will perform double click action on web page.
	 * 
	 * @param d
	 */
	public void doubbleCilckAction(WebDriver d) {
		Actions actions = new Actions(d);
		actions.doubleClick().perform();
	}

	/**
	 * This method will perform double click action on particular element.
	 * 
	 * @param d
	 * @param Element
	 */
	public void doubbleCilckAction(WebDriver d, WebElement Element) {
		Actions actions = new Actions(d);
		actions.doubleClick(Element).perform();
	}

	/**
	 * This method will perform drag & drop actio on source to target.
	 * 
	 * @param d
	 * @param source
	 * @param target
	 */
	public void dragAndDropAction(WebDriver d, WebElement source, WebElement target) {
		Actions actions = new Actions(d);
		actions.dragAndDrop(source, target).perform();
		;
	}

	/**
	 * This method will perform drag & drop actio on source to XOFFset, YOFFset.
	 * 
	 * @param d
	 * @param source
	 * @param x
	 * @param y
	 */
	public void dragAndDropAction(WebDriver d, WebElement source, int x, int y) {
		Actions actions = new Actions(d);
		actions.dragAndDropBy(source, x, y);
	}

	/**
	 * This method will switch to frame using index.
	 * 
	 * @param d
	 * @param index
	 */
	public void switchToFrame(WebDriver d, int index) {
		d.switchTo().frame(index);
	}

	/**
	 * This method will switch to frame using nameOrId.
	 * 
	 * @param d
	 * @param nameOrId
	 */
	public void switchToFrame(WebElement nameOrId, WebDriver d) {
		d.switchTo().frame(nameOrId);
	}

	/**
	 * This method will switch to frame using frameElement.
	 * 
	 * @param d
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver d, WebElement frameElement) {
		d.switchTo().frame(frameElement);
	}

	/**
	 * This method will switch to parent frame using parentFrame.
	 * 
	 * @param d
	 */
	public void switchToParentFrame(WebDriver d) {
		d.switchTo().parentFrame();
	}

	/**
	 * This method will accept the alert pop up.
	 * 
	 * @param d
	 */
	public void acceptAlert(WebDriver d) {
		d.switchTo().alert().accept();
	}

	/**
	 * This method will dismiss the alert pop up.
	 * 
	 * @param d
	 */
	public void dismissAlert(WebDriver d) {
		d.switchTo().alert().dismiss();
	}

	/**
	 * This method will return text from pop up.
	 * 
	 * @param d
	 * @return
	 */
	public String getAlertText(WebDriver d) {
		return d.switchTo().alert().getText();
	}

	/**
	 * This method will execute javascript scrollBy method to web page.
	 * 
	 * @param d
	 * @param x
	 * @param y
	 */
	public void scrollBy(WebDriver d, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("scrollBy(x,y)");
	}

	/**
	 * This method will execute javascript scrollTo method to web page.
	 * 
	 * @param d
	 * @param x
	 * @param y
	 */
	public void scrollTo(WebDriver d, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("ScrollTo(x,y)");
	}

	/**
	 * This method will take screen shot of current web page.
	 * 
	 * @param d
	 * @param scrname
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver d, String scrname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) d;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\screenshot\\" + scrname + ".png");
		Files.copy(scr, dst);
		return dst.getAbsolutePath();
	}

	/**
	 * This mehtod will take screen shot of particular web element.
	 * 
	 * @param d
	 * @param scrname
	 * @param Element
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver d, String scrname, WebElement Element) throws IOException {
		File src = new File(".\\screenshot\\" + scrname + ".png");
		File dst = Element.getScreenshotAs(OutputType.FILE);
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}

	/**
	 * This method will select element by using index.
	 * 
	 * @param d
	 * @param Element
	 * @param index
	 */
	public void selectByIndex(WebDriver d, WebElement Element, int index) {
		Select select = new Select(Element);
		select.selectByIndex(index);
	}

	/**
	 * This method will select element by using select by value.
	 * 
	 * @param d
	 * @param Element
	 * @param value
	 */
	public void selectByIndex(WebDriver d, WebElement Element, String value) {
		Select select = new Select(Element);
		select.selectByValue(value);
	}

	/**
	 * This method will select element by using visible text.
	 * 
	 * @param d
	 * @param VisibleText
	 * @param Element
	 */
	public void selectByIndex(WebDriver d, String VisibleText, WebElement Element) {
		Select select = new Select(Element);
		select.selectByVisibleText(VisibleText);
	}

	/**
	 * This method will switch the windows based on window title
	 * 
	 * @param d
	 * @param partialwindowTitle
	 */
	public void switchToWindow(WebDriver d, String partialwindowTitle) {
		// Capture all window ID
		Set<String> WindowIds = d.getWindowHandles();

		// Navigate to each window
		for (String windowId : WindowIds) {
			// Capture the tile of each window
			String actualTitle = d.switchTo().window(windowId).getTitle();
			// compaire the title
			if (actualTitle.contains(partialwindowTitle)) {
				break;
			}
		}
	}
}
