package pages;

import com.microsoft.playwright.Page;

public class WishlistPage {

    private Page page;

    public WishlistPage(Page page) {
        this.page = page;
    }

    private String wishlistLink = "text=Wishlist";
    private String wishlistItems = ".wishlist-content .product";

    public void openWishlist() {
        page.click(wishlistLink);
    }

    public boolean isProductPresentInWishlist() {
        return page.locator(wishlistItems).count() > 0;
    }
}