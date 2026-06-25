//package stepdefinitions;
//
//import com.microsoft.playwright.Page;
//
//import hooks.Hooks;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class SearchStepDefinition {
//	Page page = Hooks.page;
//	
//	@Given("user logged in")
//	public void user_logged_in() {
//	    // Write code here that turns the phrase above into concrete actions
////	    throw new io.cucumber.java.PendingException();
//		 page.navigate("https://demowebshop.tricentis.com/login");
//	        page.fill("#Email", "test@gmail.com");
//	        page.fill("#Password", "1234");
//	        page.click("input[value='Log in']");
//	}
//	@When("user search for {string}")
//	public void user_search_for(String product) {
//	    // Write code here that turns the phrase above into concrete actions
////	    throw new io.cucumber.java.PendingException();
//		 page.fill("#small-searchterms", product);
//	        page.click("input[value='Search']");
//	}
//	@Then("results will be displayed on the screen")
//	public void results_will_be_displayed_on_the_screen() {
//	    // Write code here that turns the phrase above into concrete actions
//		System.out.println("Search results displayed");
//	}
//
//
//}
