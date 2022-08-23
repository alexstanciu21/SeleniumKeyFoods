package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class FrozenFoodsPage extends SeleniumWrappers {

	public FrozenFoodsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}	
	
	@FindBy(css="a[title='Frozen Beef & Cheese Mini Tacos']") public WebElement frozenBeef; 
	@FindBy(css="a[data-product_id='368']") public WebElement frozenBeefCart; 	
	@FindBy(css="a[title='Gorton’s Beer Battered Fish Fillets']") public WebElement batteredFish; 
	@FindBy(css="a[data-product_id='362']") public WebElement batteredFishCart; 

}
