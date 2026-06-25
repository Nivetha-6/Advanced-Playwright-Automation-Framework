//package stepdefinitions;
//
//import com.microsoft.playwright.Page;
//
//import hooks.Hooks;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class CartStepDefinition {
//	Page page = Hooks.page;
//	
//	@Given("user is logged in")
//	public void user_is_logged_in() {
//	    // Write code here that turns the phrase above into concrete actions
//		page.navigate("https://demowebshop.tricentis.com/login");
//        page.fill("#Email", "test@gmail.com");
//        page.fill("#Password", "1234");
//        page.click("input[value='Log in']");
//	}
//	@When("user adds product to cart")
//	public void user_adds_product_to_cart() {
//	    // Write code here that turns the phrase above into concrete actions
//		 page.click("a[href='/books']");
//	        page.click("(//input[@value='Add to cart'])[1]");
//	}
//	@Then("product should be added successfully")
//	public void product_should_be_added_successfully() {
//	    // Write code here that turns the phrase above into concrete actions
////	    throw new io.cucumber.java.PendingException();
//	    System.out.println("Product added to cart");
//	}
//
//}
