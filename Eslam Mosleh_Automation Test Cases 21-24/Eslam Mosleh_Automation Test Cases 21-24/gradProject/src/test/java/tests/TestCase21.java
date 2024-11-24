package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductViewPage;
import pages.ProductsPage;

public class TestCase21 extends TestBase{

    HomePage homePageObject;
    ProductsPage productsPageObject;
    ProductViewPage productViewPageObject;

    @Test
    public void addReviewOnProduct(){
        homePageObject = new HomePage(driver);
        productsPageObject = new ProductsPage(driver);
        productViewPageObject = new ProductViewPage(driver);
        
        homePageObject.goToProductsPage();
        Assert.assertEquals(productsPageObject.allProductsText.getText(),"ALL PRODUCTS");
        productsPageObject.goToProductViewPage();
        Assert.assertEquals(productViewPageObject.writeYourReviewText.getText(),"WRITE YOUR REVIEW");
        productViewPageObject.addReview("EslamMosleh","asd@gmail.com","bla bla ... 10/10");
        Assert.assertEquals(productViewPageObject.successAddedReviewMessage.getText(),"Thank you for your review.");

    }
}
