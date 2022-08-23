package utils;

import pages.BlogPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.FrozenFoodsPage;
import pages.MainPage;
import pages.NavMenuPage;
import pages.PostCommentsPage;
import pages.ProductPage;

public class BasePage extends BaseTest {

	public NavMenuPage navMenu = new NavMenuPage(driver);
	public FrozenFoodsPage frozenFoodPage = new FrozenFoodsPage(driver);
	public MainPage mainPage = new MainPage(driver);
	public ProductPage productPage = new ProductPage(driver);
	public CartPage cartPage = new CartPage(driver);
	public CheckoutPage checkoutPage = new CheckoutPage(driver);
	public BlogPage blogPage = new BlogPage(driver);
	public PostCommentsPage postCommentsPage = new PostCommentsPage(driver);

}
