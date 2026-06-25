//package stepdefinitions;
//
//import com.microsoft.playwright.Page;
//import hooks.Hooks;
//import io.cucumber.java.en.*;
//import pages.CartPage;
//import pages.ProductPage;
//
//public class CouponStepDefinition {
//
//    Page page = Hooks.page;
//
//    CartPage cart;
//    ProductPage product;
//
//    @Given("user has product in cart")
//    public void addProductToCart() {
//
//        product = new ProductPage(page);
//        cart = new CartPage(page);
//
//        page.navigate("https://demowebshop.tricentis.com/books");
//
//        product.clickFirstProduct();
//        page.waitForSelector("input[value='Add to cart']");
//        product.clickAddToCart();
//
//        page.waitForSelector("#bar-notification");
//
//        cart.openCart();
//    }
//
//    @When("user applies valid coupon")
//    public void applyValidCoupon() {
//
//     
//        page.waitForURL("**/cart");
//

//        page.waitForSelector("#discountcouponcode");
//
//        cart.applyCoupon("DISCOUNT10");
//    }
//
//    @Then("discount should be applied")
//    public void validateCoupon() {
//
//   
//        page.waitForSelector(".message");
//
//        String message = cart.getCouponMessage();
//
//        if (message.toLowerCase().contains("invalid")) {
//            System.out.println("Handled invalid coupon scenario");
//        } else if (message.toLowerCase().contains("applied")) {
//            System.out.println("Coupon applied successfully");
//        } else {
//            System.out.println("Unknown coupon behavior: " + message);
//        }
//    }
//}