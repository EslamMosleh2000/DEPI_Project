package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    public Actions action;
    public WebDriverWait wait;
    WebDriver driver;
 
    
    public PageBase (WebDriver driver){
    	this.driver = driver;
        PageFactory.initElements(driver,this);
    }




}
