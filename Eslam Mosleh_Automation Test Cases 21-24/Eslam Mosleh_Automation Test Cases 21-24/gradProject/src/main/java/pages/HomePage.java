package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    	wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @FindBy(css = "a[href='/products']")
    WebElement productsButton;
    
    
    @FindBy(xpath = "//*[text()='recommended items']")
    public WebElement recommendedItemsHeaderTxt;
    
    @FindBy(xpath = "//*[text()='Subscription']")
    WebElement subscriptionHeaderTxt;
    
    @FindBy(xpath = "//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/a")
    WebElement addFirstRecommendedButton;
    
    
    @FindBy(xpath = "//*[text()='View Cart']")
    WebElement viewCartButton;

    
    public void goToProductsPage(){
        productsButton.click();
    }
    
    public void scrollToRecommendedMenu() {
    	action.scrollToElement(subscriptionHeaderTxt).perform();	
    }
    
    public void addRecommendedItemToCart() {
    	wait.until(ExpectedConditions.visibilityOf(addFirstRecommendedButton));
    	addFirstRecommendedButton.click();
    	wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
    	viewCartButton.click();
    	
    }
    
	@FindBy(linkText = "Signup / Login")
	WebElement SignUpLoginBtn;
	
	@FindBy(xpath = "//a[contains(.,' Home')]")
	public WebElement HomeBtn;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[10]/a[1]")
	public
	WebElement LoggedInAs_Message;
	
	@FindBy(xpath ="//*[@id=\"header\"]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
	WebElement logOutBtn;
	
	public void OpenRegistrationPage() {
		SignUpLoginBtn.click();
	}
	public void OpenLoginPage() {
		SignUpLoginBtn.click();
	}
	public void logOut() {
		logOutBtn.click();
	}



}
