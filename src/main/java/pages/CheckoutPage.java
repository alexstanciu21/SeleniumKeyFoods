package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class CheckoutPage extends SeleniumWrappers{
	
	public CheckoutPage(WebDriver driver) {
		super(driver); 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[id='billing_first_name']") public WebElement firstNameForm;	
	@FindBy(css="input[id='billing_last_name']") public WebElement lastNameForm;	
	@FindBy(css="input[id='billing_company']") public WebElement companyForm;	
	@FindBy(css="input[id='billing_address_1']") public WebElement adressForm1;	
	@FindBy(css="input[id='billing_address_2']") public WebElement addressForm2;	
	@FindBy(css="input[id='billing_city']") public WebElement cityForm;	
	@FindBy(css="input[id='billing_postcode']") public WebElement postcodeForm;	
	@FindBy(css="input[id='billing_phone']") public WebElement phoneForm;	
	@FindBy(css="input[id='billing_email']") public WebElement emailForm;	
	@FindBy(css="input[id='terms']") public WebElement termsCheckbox;
	@FindBy(css="button[id='place_order']") public WebElement placeOrderButton;
	@FindBy(css="p[class*='woocommerce-thankyou-order-received']") public WebElement orderSuccess;
	@FindBy(css="li[class*='woocommerce-order-overview__order'] > strong") public WebElement orderNumber;

		
}
