package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageBase {

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//*[@data-qa='name-on-card']")
	WebElement nameOnCardTxtBox;
	
	@FindBy(xpath = "//*[@data-qa='card-number']")
	WebElement cardNumberTxtBox;

	@FindBy(xpath = "//*[@data-qa='cvc']")
	WebElement cvcTxtBox;
	
	@FindBy(xpath = "//*[@data-qa='expiry-month']")
	WebElement expiryMonthTxtBox;
	
	@FindBy(xpath = "//*[@data-qa='expiry-year']")
	WebElement expiryYearTxtBox;
	
	@FindBy(xpath = "//*[@data-qa='pay-button']")
	WebElement payButton;
	
	@FindBy(xpath = "//*[text()='Download Invoice']")
	public WebElement downloadInvoicButton;
	
	
	
	public void fillPaymentData(String nameOnCard, String cardNumber,
			String cvc, String expiryMonth,String expiryYear) {
		
		nameOnCardTxtBox.sendKeys(nameOnCard);
		cardNumberTxtBox.sendKeys(cardNumber);
		cvcTxtBox.sendKeys(cvc);
		expiryMonthTxtBox.sendKeys(expiryMonth);
		expiryYearTxtBox.sendKeys(expiryYear);
		payButton.click();
	}
	
	public void downloadInvoic() {
		downloadInvoicButton.click();
	}
	
	
	

}
