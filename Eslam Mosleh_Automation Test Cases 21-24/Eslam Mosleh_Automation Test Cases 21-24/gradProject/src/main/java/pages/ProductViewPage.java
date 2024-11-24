package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductViewPage extends PageBase{
    public ProductViewPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[text() = 'Write Your Review']")
    public WebElement  writeYourReviewText;

    @FindBy(id="name")
    WebElement nameTxtBox;

    @FindBy(id="email")
    WebElement emailTxtBox;

    @FindBy(id="review")
    WebElement reviewTxtBox;

    @FindBy(id="button-review")
    WebElement reviewSubmitButton;

    @FindBy(xpath = "//*[text() = 'Thank you for your review.']")
    public WebElement successAddedReviewMessage;

    public void addReview(String name, String email, String reviewText){
        nameTxtBox.sendKeys(name);
        emailTxtBox.sendKeys(email);
        reviewTxtBox.sendKeys(reviewText);
        reviewSubmitButton.click();
    }
}
