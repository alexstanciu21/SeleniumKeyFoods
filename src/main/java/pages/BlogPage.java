package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class BlogPage extends SeleniumWrappers{
	
	public BlogPage(WebDriver driver) {
		super(driver); 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='site-posts']") public WebElement blogPosts;		 
	
	@FindBy(css="div[class='site-posts'] article:nth-child(1)") public WebElement blogPost1;		
	@FindBy(css="div[class='site-posts'] article:nth-child(2)") public WebElement blogPost2;		
	@FindBy(css="div[class='site-posts'] article:nth-child(3)") public WebElement blogPost3;		
	@FindBy(css="div[class='site-posts'] article:nth-child(4)") public WebElement blogPost4;		
	
	public void clickBlog(WebElement blogPost) {
		 blogPost.click();
	}

			
			
}
