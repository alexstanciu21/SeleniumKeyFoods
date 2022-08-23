package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class CartPage extends SeleniumWrappers {
	
	public CartPage(WebDriver driver) {
		super(driver); 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="td[data-title='Total']") public WebElement cartTotal;	
	@FindBy(css="input[id='coupon_code']") public WebElement couponCode;	
	@FindBy(css="button[name='apply_coupon']") public WebElement applyCoupon;	
	@FindBy(css="div[class='wc-proceed-to-checkout']") public WebElement proceedToCheckout;	
	
	public void applyCouponCode() {
		
		couponCode.sendKeys("keyfood31122021");
		applyCoupon.click();
		
	}
	

	

}
