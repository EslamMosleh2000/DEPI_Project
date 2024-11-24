package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);
	}
	
	@FindBy (id = "address_delivery")
	WebElement deliveryAddressElement;
	
	@FindBy (id = "address_invoice")
	WebElement billingAddressElement;
	
	@FindBy(name = "message")
	WebElement commentTxtBox;
	
	@FindBy(xpath ="//*[text()='Place Order']")
	WebElement placeOrderButton;
	
	
	public void enterComment(String comment) {
		action.scrollToElement(placeOrderButton).perform();
		commentTxtBox.sendKeys(comment);
		placeOrderButton.click();
		
	}
	
	public Boolean getAllDeliveryAdressText(String address) {		
		List<WebElement> addressItems = deliveryAddressElement.findElements(By.tagName("li"));
	    for (WebElement item : addressItems) {
	         String data = item.getText();
	         if (data.equals(address)) {
	        	 return true;   	 
	         }
	         else {
	        	 
	         }
	    } 
		return false;
	}

	
	public Boolean getAllBillingAdressText(String address) {		
		List<WebElement> addressItems = billingAddressElement.findElements(By.tagName("li"));
	    for (WebElement item : addressItems) {
	         String data = item.getText();
	         if (data.equals(address)) {
	        	 return true;   	 
	         }
	    } 
		return false;
	}


}
