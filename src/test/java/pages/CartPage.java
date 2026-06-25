package pages;

import com.microsoft.playwright.Page;

public class CartPage {
	private String couponField = "#discountcouponcode";
	private String applyCouponBtn = "input[value='Apply coupon']";
	private String couponMessage = ".message";
	

    private Page page;
    
   
    public CartPage(Page page) {
        this.page = page;
    }

    private String cartLink = "text=Shopping cart";  
    private String termsCheckbox = "#termsofservice"; //input tag id value
    private String checkoutButton = "#checkout"; //input tag

    public void openCart() {
        page.click(cartLink);
        page.waitForURL("**/cart");
    }

    public void acceptTerms() {
        page.check(termsCheckbox);
    }

    public void clickCheckout() {
        page.click(checkoutButton);
    }
    public void applyCoupon(String coupon) {
        page.fill(couponField, coupon);
        page.click(applyCouponBtn);
    }

    public String getCouponMessage() {
        return page.locator(couponMessage).textContent();
    }

    public boolean isDiscountApplied() {
        return page.locator(".discount").count() > 0;
    }
}