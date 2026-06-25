//package stepdefinitions;
//
//import com.microsoft.playwright.Page;
//
//import hooks.Hooks;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class RegisterStepDefinition {
//	Page page = Hooks.page;
//
//	@Given("user is on registration page")
//	public void user_is_on_registration_page() {
//		// Write code here that turns the phrase above into concrete actions
//		page.navigate("https://demowebshop.tricentis.com/register");
//	}
//	@When("user enters registration details")
//	public void user_enters_registration_details() {
//		// Write code here that turns the phrase above into concrete actions
//		page.fill("#FirstName", "Test");
//        page.fill("#LastName", "User");
//        page.fill("#Email", "testuser" + System.currentTimeMillis() + "@gmail.com");
//        page.fill("#Password", "123456");
//        page.fill("#ConfirmPassword", "123456");
//        page.click("#register-button");
//	}
//	@Then("user account should be created successfully")
//	public void user_account_should_be_created_successfully() {
//		// Write code here that turns the phrase above into concrete actions
//		System.out.println("Registration completed");
//	}
//
//
//}
