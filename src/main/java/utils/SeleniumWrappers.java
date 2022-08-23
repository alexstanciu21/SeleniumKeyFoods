package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrappers {

	public WebDriver driver;

	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}

	public void hoverElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		Log.info("called explicit wait");
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Log.info("moved to element");
	}

	public boolean checkCurrentUrl(String expectedUrl) {
		if (driver.getCurrentUrl().equals(expectedUrl)) {
			return true;
		} else {
			return false;
		}
	}

	public void click(WebElement element) {

		try {
			Log.info("called method click on <element>" + element.getAttribute("outterHTML"));
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();

		} catch (Exception e) {
			Log.error("Click method failed");
			Log.error(e.fillInStackTrace());
		}
	}

}
