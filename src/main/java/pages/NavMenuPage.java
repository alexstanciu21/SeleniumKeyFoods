package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class NavMenuPage extends SeleniumWrappers{
	
	public NavMenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Frozen Foods") public WebElement frozenFoodsLink;
	@FindBy(linkText = "Beverages") public WebElement beveragesLink;
	@FindBy(linkText = "BLOG") public WebElement blogLink;
		
	public void navigateTo(WebElement element) {
		click(element);
	}

}
