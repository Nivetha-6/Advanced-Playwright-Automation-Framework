package pages;

import com.microsoft.playwright.Page;

public class RegisterPage {

    private Page page;

    public RegisterPage(Page page) {
        this.page = page;
    }

    // Locators
    private String registerLink = "text=Register";
    private String genderMale = "#gender-male";
    private String firstName = "#FirstName";
    private String lastName = "#LastName";
    private String email = "#Email";
    private String password = "#Password";
    private String confirmPassword = "#ConfirmPassword";
    private String registerButton = "#register-button";
    private String successMessage = ".result";
    
    public void openRegisterPage() {
        page.click(registerLink);
    }

    public void fillRegistrationForm(String fName, String lName, String mail, String pass) {
        page.check(genderMale);
        page.fill(firstName, fName);
        page.fill(lastName, lName);
        page.fill(email, mail);
        page.fill(password, pass);
        page.fill(confirmPassword, pass);
    }

    public void clickRegister() {
        page.click(registerButton);
    }

    public String getSuccessMessage() {
        return page.textContent(successMessage);
    }
}