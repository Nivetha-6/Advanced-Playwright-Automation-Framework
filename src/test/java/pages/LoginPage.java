package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	  private Page page;

	    public LoginPage(Page page) {
	        this.page = page;
	    }

	  
	    private String loginLink = "text=Log in";
	    private String emailField = "#Email";
	    private String passwordField = "#Password";
	    private String loginButton = "input[value='Log in']";
	    private String logoutLink = "text=Log out";

	    public void openLoginPage() {
	        page.click(loginLink);
	    }

	    public void login(String email, String password) {
	        page.fill(emailField, email);
//	        page.pause();
	        page.fill(passwordField, password);
	        page.click(loginButton);
	    }

	    public boolean isLoginSuccessful() {
	        return page.isVisible(logoutLink);
	    }
	

}
