package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class MainPage extends SeleniumWrappers {

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(css="div[class='all-categories locked']") public WebElement allCategories; 	
	@FindBy(css="input[id='dgwt-wcas-search-input-1']") public WebElement mainSearchForm;		
	@FindBy(css="div[class='dgwt-wcas-content-wrapp']") public WebElement mainSearchResult;		
	@FindBy(css="i[class='klbth-icon-shopping-bag']") public WebElement mainCart;	

}
