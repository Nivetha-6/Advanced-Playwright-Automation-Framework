//package tests;
//
//import base.BaseTest;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pages.*;
//
//public class WishlistTest extends BaseTest {
//
//    @Test
//    public void verifyAddToWishlist() {
//
//        HomePage home = new HomePage(page);
//        ProductPage product = new ProductPage(page);
//        WishlistPage wishlist = new WishlistPage(page);
//
//        // search product
//        home.searchProduct("book");
//        page.waitForSelector(".product-title");
//
//        // opening product
//        product.clickFirstProduct();
//        page.waitForSelector("input[value='Add to wishlist']");
//
//        // add to wishlist
//        product.addToWishlist();
//        page.waitForSelector("#bar-notification");
//
//        // Verify whether prod is in wishlist
//        Assert.assertTrue(product.isProductAddedToWishlist(), "Wishlist Failed!");
//
//        // Open wishlist page
//        wishlist.openWishlist();
//        page.waitForSelector(".wishlist-content");
//
//        Assert.assertTrue(wishlist.isProductPresentInWishlist(), "Product not in wishlist!");
//
//        System.out.println("Wishlist feature working ✅");
//    }
//}