//package stepdefinitions;
//
//import com.microsoft.playwright.Page;
//import hooks.Hooks;
//import io.cucumber.java.en.*;
//import pages.ComparePage;
//import pages.HomePage;
//
//public class CompareStepDefinition {
//
//    Page page = Hooks.page;
//    ComparePage compare;
//    HomePage home;
//
//    @Given("user is on product listing page")
//    public void goToProductPage() {
//
//        compare = new ComparePage(page);
//        home = new HomePage(page);
//
//        page.navigate("https://demowebshop.tricentis.com/books");
//        page.waitForSelector(".product-item");
//    }
//
//    @When("user adds products to compare")
//    public void addToCompare() {
//        compare.addProductsToCompare();
//    }
//
//    @When("user opens compare page")
//    public void openCompare() {
//        compare.openComparePage();
//    }
//
//    @Then("products should be compared successfully")
//    public void validateCompare() {
//
//        if (page.locator(".compare-products-table").isVisible()) {
//            System.out.println("✅ Compare page displayed successfully");
//        } else {
//            throw new RuntimeException("❌ Compare failed");
//        }
//    }
//}