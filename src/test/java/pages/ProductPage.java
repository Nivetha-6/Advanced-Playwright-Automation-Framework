package pages;

import com.microsoft.playwright.Page;

public class ProductPage {

    private Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    private String firstProductTitle = ".product-title >> nth=0";
    private String addToCartButton = "#add-to-cart-button-31"; 
    private String successBar = "#bar-notification";


    public void clickFirstProduct() {
        page.click(firstProductTitle);
    }

    public void clickAddToCart() {
        page.click("input[value='Add to cart']");
    }

    public boolean isProductAdded() {
        return page.locator(successBar)
                .textContent()
                .contains("The product has been added");
    }

    private String addToWishlistBtn = "input[value='Add to wishlist']";


    public void addToWishlist() {
        page.click(addToWishlistBtn);
    }


    public boolean isProductAddedToWishlist() {
        return page.locator("#bar-notification")
                .textContent()
                .contains("The product has been added to your wishlist");
    }
}