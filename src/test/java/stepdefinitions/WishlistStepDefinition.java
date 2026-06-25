//package stepdefinitions;
//
//import com.microsoft.playwright.Page;
//
//import hooks.Hooks;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class WishlistStepDefinition {
//	Page page = Hooks.page;
//
//	@Given("user is in WISHLIST section")
//	public void user_is_in_wishlist_section() {
//		// Write code here that turns the phrase above into concrete actions
//		 page.navigate("https://demowebshop.tricentis.com/");
//	        System.out.println("Navigated to homepage");
//	}
//	@When("user select a product to put inside wishlist")
//	public void user_select_a_product_to_put_inside_wishlist() {
//		// Write code here that turns the phrase above into concrete actions
//		page.navigate("https://demowebshop.tricentis.com/books");
//
//		// wait for products to load
//		page.waitForSelector(".product-item");
//
//		// click wishlist
//		page.locator("input[value='Add to wishlist']").first().click();
//	}
//	@When("user selected and clicked the wishlist option")
//	public void user_selected_and_clicked_the_wishlist_option() {
//		// Write code here that turns the phrase above into concrete actions
//		 page.click(".wishlist-label");
//	        System.out.println("Clicked wishlist section");
//	}
//	@Then("wishlist should be added in that section")
//	public void wishlist_should_be_added_in_that_section() {
//		// Write code here that turns the phrase above into concrete actions
//		 String title = page.title();
//	        System.out.println("Wishlist page title: " + title);
//	}
//
//
//}
