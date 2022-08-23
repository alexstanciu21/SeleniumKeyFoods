package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import utils.BaseTest;

public class TestEndToEnd extends BaseTest {

	@Test
	public void addFrozenFood() throws InterruptedException {

		// navigare la Frozen Food
		app.navMenu.navigateTo(app.navMenu.frozenFoodsLink);

		// adaugare produse in cos
		app.frozenFoodPage.hoverElement(app.frozenFoodPage.frozenBeef);
		app.frozenFoodPage.frozenBeefCart.click();
		app.frozenFoodPage.hoverElement(app.frozenFoodPage.batteredFish);
		app.frozenFoodPage.batteredFishCart.click();
		assertTrue(app.navMenu.checkCurrentUrl("https://keyfood.ro/product-category/frozen-foods/"));

		// navigare la beverages
		app.mainPage.allCategories.click();
		app.navMenu.navigateTo(app.navMenu.beveragesLink);
		assertTrue(app.navMenu.checkCurrentUrl("https://keyfood.ro/product-category/beverages/"));

		// cautare si adaugare coca cola in cos
		app.mainPage.mainSearchForm.sendKeys("coca cola");
		app.mainPage.mainSearchForm.sendKeys(Keys.RETURN);
		app.productPage.addToCart.click();

		// navigare la cart si aflare pret total
		app.mainPage.mainCart.click();
		double cartTotalInitial = Double.parseDouble(app.cartPage.cartTotal.getText().substring(1));

		// aplicare cupon discount
		app.cartPage.applyCouponCode();
		Thread.sleep(3000);

		double cartTotalFinal = Double.parseDouble(app.cartPage.cartTotal.getText().substring(1));
		assertTrue(cartTotalFinal < cartTotalInitial);

		// navigare la checkout
		app.cartPage.proceedToCheckout.click();

		// completare date shipping
		app.checkoutPage.firstNameForm.sendKeys("John");
		app.checkoutPage.lastNameForm.sendKeys("Doe");
		app.checkoutPage.companyForm.sendKeys("Doe Company");
		app.checkoutPage.adressForm1.sendKeys("Default1");
		app.checkoutPage.addressForm2.sendKeys("Default2");
		app.checkoutPage.cityForm.sendKeys("Los Angeles");
		app.checkoutPage.postcodeForm.sendKeys("12345");
		app.checkoutPage.phoneForm.sendKeys("12-12-12-12");
		app.checkoutPage.emailForm.sendKeys("johndoe@doe.com");

		// plasare comanda
		app.checkoutPage.termsCheckbox.click();
		app.checkoutPage.placeOrderButton.click();

		assertEquals(app.checkoutPage.orderSuccess.getText(), "Thank you. Your order has been received.");
		assertTrue((driver.getCurrentUrl().contains(app.checkoutPage.orderNumber.getText())));

	}

}
