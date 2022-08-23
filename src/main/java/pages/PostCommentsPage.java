package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class PostCommentsPage extends SeleniumWrappers{
	
	public PostCommentsPage(WebDriver driver) {
		super(driver); 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="textarea[id='comment']") public WebElement commentTextField;	
	@FindBy(css="input[id='author']") public WebElement nameTextField;	
	@FindBy(css="input[id='email']") public WebElement emailTextField;	
	@FindBy(css="input[id='url']") public WebElement websiteTextField;	
	@FindBy(css="input[id='submit']") public WebElement postCommentButton;		 
	@FindBy(css="li[class*='depth-1']:nth-last-child(1) a[class='url']") public WebElement commentUsername;
	@FindBy(css="li[class*='depth-1']:nth-last-child(1) div[class='klb-post'] > p") public WebElement commentContent;

	public void insertComment(String comment) {
		commentTextField.sendKeys(comment);
	}

}
