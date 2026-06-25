package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    // Locators
    private String searchBox = "#small-searchterms";
    private String searchButton = "input[value='Search']";
    private String productTitle = ".product-title";

    // Actions
    public void searchProduct(String product) {
        page.fill(searchBox, product);
        page.click(searchButton);
    }

    public boolean isProductDisplayed() {
        return page.locator(".product-item").count() > 0;
    }
    private String logoutLink = "text=Log out";

    public void logout() {
        page.click(logoutLink);
    }
}