//package stepdefinitions;
//
//import com.microsoft.playwright.Page;
//
//import hooks.Hooks;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class LoginStepDefinition {
//	Page page = Hooks.page;
//	
//
//    String username;
//    String password;
//
//    @Given("user is on login page")
//    public void user_is_on_login_page() {
//        // Write code here that turns the phrase above into concrete actions
////        throw new io.cucumber.java.PendingException();
//    	String email = "user" + System.currentTimeMillis() + "@gmail.com";
//
//    	page.navigate("https://demowebshop.tricentis.com/register");
//
//    	page.fill("#FirstName", "Test");
//    	page.fill("#LastName", "User");
//    	page.fill("#Email", email);
//    	page.fill("#Password", "123456");
//    	page.fill("#ConfirmPassword", "123456");
//    	page.click("#register-button");
//
//    	// login
//    	page.navigate("https://demowebshop.tricentis.com/login");
//    	page.fill("#Email", email);
//    	page.fill("#Password", "123456");
//    	page.click("input[value='Log in']");
//
//    	page.waitForSelector(".ico-account");
//    }
//    @When("user enters valid credentials")
//    public void user_enters_valid_credentials() {
//        // Write code here that turns the phrase above into concrete actions
////        throw new io.cucumber.java.PendingException();
//    	page.fill("#Email", "xxxyyy123666@gmail.com");
//        page.fill("#Password", "xxxyyy123");
//        page.click("input[value='Log in']");
//    }
//    @Then("user should login successfully")
//    public void user_should_login_successfully() {
//        page.waitForSelector(".ico-account");
//        System.out.println("Login successful");
//    }
//
//
//
//}
