package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseTest;

public class SmokeTest extends BaseTest {

	@DataProvider(name = "blogsData")
	public Object[][] blogsData() {

		Object data[][] = new Object[4][1];

		// books
		data[0][0] = app.blogPage.blogPost1;
		data[1][0] = app.blogPage.blogPost2;
		data[2][0] = app.blogPage.blogPost3;
		data[3][0] = app.blogPage.blogPost4;

		return data;

	}

	@Test(dataProvider = "blogsData")
	public void blogTests(WebElement blogPost) {

		// navigare la Blog
		app.navMenu.navigateTo(app.navMenu.blogLink);

		int numberOfChilds = Integer.parseInt(app.blogPage.blogPosts.getAttribute("childElementCount"));
		assertEquals(numberOfChilds, 4);

		// selectare fiecare articol
		app.blogPage.clickBlog(blogPost);

		// adaugare comment
		String comment = "My custom comment " + Math.random();
		String name = "John Doe"; 
		
		app.postCommentsPage.insertComment(comment);
		app.postCommentsPage.nameTextField.sendKeys(name);
		app.postCommentsPage.emailTextField.sendKeys("johndoe@doe.com");
		app.postCommentsPage.websiteTextField.sendKeys("https://www.doe.com");
		app.postCommentsPage.postCommentButton.click();

		// verificare comment
		assertEquals(app.postCommentsPage.commentUsername.getText(), name);
		assertEquals(app.postCommentsPage.commentContent.getText(), comment);

	}

}
