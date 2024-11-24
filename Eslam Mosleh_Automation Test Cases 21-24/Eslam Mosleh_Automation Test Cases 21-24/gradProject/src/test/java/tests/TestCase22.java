package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ShoppingCartPage;

public class TestCase22 extends TestBase {
	HomePage homePageObject;
	ShoppingCartPage shoppingCartObject;
	
	
	@Test
	public void addToCartFromRecommendedItems() {
		
		homePageObject = new HomePage(driver);
		shoppingCartObject = new ShoppingCartPage(driver);
		
		
		homePageObject.scrollToRecommendedMenu();
		Assert.assertEquals(homePageObject.recommendedItemsHeaderTxt.getText(), "recommended items".toUpperCase());
		homePageObject.addRecommendedItemToCart();
		Assert.assertEquals(shoppingCartObject.proceedToCheckoutButton.isDisplayed(),true);

		
	}

}
