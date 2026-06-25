//package stepdefinitions;
//
//import com.microsoft.playwright.Page;
//
//import hooks.Hooks;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class LogoutStepDefinition {
//	Page page = Hooks.page;
//
//	@Given("user in the login page")
//	public void user_in_the_login_page() {
//		// Write code here that turns the phrase above into concrete actions
////		throw new io.cucumber.java.PendingException();
//		page.navigate("https://demowebshop.tricentis.com/login");
//        page.fill("#Email", "test@gmail.com");
//        page.fill("#Password", "1234");
//        page.click("input[value='Log in']");
//	}
//	@When("user clicked logout")
//	public void user_clicked_logout() {
//		// Write code here that turns the phrase above into concrete actions
////		throw new io.cucumber.java.PendingException();
//		page.waitForSelector(".ico-logout");
//	    page.click(".ico-logout");
//	}
//	@Then("user should have been logged out")
//	public void user_should_have_been_logged_out() {
//		// Write code here that turns the phrase above into concrete actions
////		throw new io.cucumber.java.PendingException();
//		System.out.println("Logout successful");
//	}
//
//}
