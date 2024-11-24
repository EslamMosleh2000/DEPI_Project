package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends PageBase{
	
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text() = 'All Products']")
    public WebElement allProductsText;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProductButton;

    public void goToProductViewPage(){
        viewProductButton.click();
    }

}
