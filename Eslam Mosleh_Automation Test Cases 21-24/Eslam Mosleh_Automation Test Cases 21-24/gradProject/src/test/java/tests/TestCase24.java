package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.RegisterPage;
import pages.ShoppingCartPage;

public class TestCase24 extends TestBase {
	HomePage homeObject;
	RegisterPage registerObject;
	ShoppingCartPage shoppingCartObject;
	CheckOutPage checkOutPageObject;
	PaymentPage paymentPageObject;
	
	
	@Test
	public void VerifyAddressDetailsInCheckoutPage() {
		homeObject = new HomePage(driver);
		registerObject = new RegisterPage(driver);
		shoppingCartObject = new ShoppingCartPage(driver);
		checkOutPageObject = new CheckOutPage(driver);
		paymentPageObject = new PaymentPage(driver);
		 
		homeObject.OpenRegistrationPage();
		registerObject.newUserSignUp("Eslam Mosleh", "Eslammosleh2@hgmail.com");
		registerObject.RegisterwithAllData("12345678","10", "3","2000","Eslam", "Mosleh", 
				  "company", "address1","address2", "United States", 
				  "state", "city","12345","01012346578");
		registerObject.accountContinue();
		Assert.assertTrue(homeObject.LoggedInAs_Message.getText().contains("Logged in as "));
		homeObject.scrollToRecommendedMenu();
		Assert.assertEquals(homeObject.recommendedItemsHeaderTxt.getText(), "recommended items".toUpperCase());
		homeObject.addRecommendedItemToCart();
		Assert.assertEquals(shoppingCartObject.proceedToCheckoutButton.isDisplayed(),true);
		shoppingCartObject.goToCheckoutPage();
		Assert.assertTrue(checkOutPageObject.getAllDeliveryAdressText("address1"));
		Assert.assertTrue(checkOutPageObject.getAllBillingAdressText("address1"));
		checkOutPageObject.enterComment("Call Me First!");
		
		paymentPageObject.fillPaymentData("EslamMosleh", "12321", "123", "2", "2024");
		Assert.assertTrue(paymentPageObject.downloadInvoicButton.isDisplayed());
		paymentPageObject.downloadInvoic();
		registerObject.DeleteAccount();
		Assert.assertEquals(registerObject.Delete_Account_Message.getText(), "ACCOUNT DELETED!");
		registerObject.continueDeleteAccount();

		





		
	}
	
}
