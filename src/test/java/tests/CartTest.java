package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    
    @Test
    public void verifyAddToCart() {

        HomePage home = new HomePage(page);
        ProductPage product = new ProductPage(page);

        home.searchProduct("laptop");

      
        page.waitForSelector(".product-title");

       
        product.clickFirstProduct();

     //wait for add to cart to appear
        page.waitForSelector("input[value='Add to cart']");

        // add to cart
        product.clickAddToCart();

        //wait for the notification to appear
        page.waitForSelector("#bar-notification");

        // Assertion
        Assert.assertTrue(product.isProductAdded(), "Add to Cart Failed");

        System.out.println("Product added to cart");
    }
}