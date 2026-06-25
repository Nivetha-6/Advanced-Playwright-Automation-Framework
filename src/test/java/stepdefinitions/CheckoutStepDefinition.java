//package stepdefinitions;
//
//import com.microsoft.playwright.Page;
//
//import hooks.Hooks;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class CheckoutStepDefinition {
//
//	Page page = Hooks.page;
//
//	@Given("user has items in cart")
//	public void user_has_items_in_cart() {
//		// Write code here that turns the phrase above into concrete actions
////		throw new io.cucumber.java.PendingException();
//		 page.navigate("https://demowebshop.tricentis.com/login");
//		    page.fill("#Email", "validuser@gmail.com");
//		    page.fill("#Password", "123456");
//		    page.click("input[value='Log in']");
//
//		    page.waitForSelector(".ico-account"); // confirm login
//
//		
//		    page.navigate("https://demowebshop.tricentis.com/books");
//
//		    page.locator("input[value='Add to cart']").first().click();
//
//		    page.click(".cart-label");
//
//		 
//		    page.waitForSelector("#termsofservice");
//	}
//	@When("user completes checkout")
//	public void user_completes_checkout() {
//		// Write code here that turns the phrase above into concrete actions
////		throw new io.cucumber.java.PendingException();
//		page.waitForSelector("#termsofservice");
//	    page.check("#termsofservice");
//
//	    page.click("#checkout");
//	}
//	@Then("order should be placed successfully")
//	public void order_should_be_placed_successfully() {
//		// Write code here that turns the phrase above into concrete actions
////		throw new io.cucumber.java.PendingException();
//		System.out.println("Checkout process done");
//	}
//
//}
