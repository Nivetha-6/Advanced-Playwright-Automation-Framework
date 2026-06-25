//package tests;
//
//import base.BaseTest;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pages.*;
//import utils.FakerUtil;
//
//public class CheckoutTest extends BaseTest {
//
//    @Test
//    public void verifyCheckoutFlow() {
//
//        RegisterPage register = new RegisterPage(page);
//        LoginPage login = new LoginPage(page);
//        HomePage home = new HomePage(page);
//        ProductPage product = new ProductPage(page);
//        CartPage cart = new CartPage(page);
//        CheckoutPage checkout = new CheckoutPage(page);
//
//        String email = FakerUtil.getFirstName()+"user" + System.currentTimeMillis() + "@gmail.com";
//        String password = FakerUtil.getPassword();
//
//        //Register- Function
//        register.openRegisterPage();
//        register.fillRegistrationForm("Test", "User", email, password);
//        register.clickRegister();
//
//        page.waitForSelector("text=Log out");
//
//        //Search Function
//        home.searchProduct("book");
//        page.waitForSelector(".product-title");
//
//        //Add to cart function
//        product.clickFirstProduct();
//        page.waitForSelector("input[value='Add to cart']");
//        product.clickAddToCart();
//        page.waitForSelector("#bar-notification");
//
//        //cart
//        cart.openCart();
//        page.waitForSelector("#termsofservice");
//
//     
//        cart.acceptTerms();
//
//        //checkout
//        cart.clickCheckout();
//
//
//        // waiting for checkout page
//        page.waitForSelector("input[value='Continue']");
//
//        // complete checkout
//        checkout.completeCheckout();
//
//        //Verify order is successful or not
//        Assert.assertTrue(checkout.isOrderSuccessful(), "Checkout Failed");
//
//        System.out.println("Checkout Successful");
//        home.logout();
//
//     // verifying logout
//     page.waitForSelector("text=Log in");
//
//     System.out.println("Logout successful");
//    }
//}