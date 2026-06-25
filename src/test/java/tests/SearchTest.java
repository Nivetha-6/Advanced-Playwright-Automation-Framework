//package tests;
//
//import base.BaseTest;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pages.HomePage;
//
//public class SearchTest extends BaseTest {
//
//    @Test
//    public void verifyProductSearch() {
//
//        HomePage home = new HomePage(page);
//
//        home.searchProduct("laptop");
//
//
//        Assert.assertTrue(home.isProductDisplayed(), "Product not found");
//
//        System.out.println("Search Successful");
//    }
//}