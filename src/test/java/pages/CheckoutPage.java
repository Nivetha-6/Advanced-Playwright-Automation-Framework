package pages;

import com.microsoft.playwright.Page;
import utils.FakerUtil;

public class CheckoutPage {

    private Page page;

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public void completeCheckout() {
    	//Details for checking out (Address..etc)
        page.waitForSelector("text=Billing address");

        page.selectOption("#BillingNewAddress_CountryId", "41");
        page.fill("#BillingNewAddress_City", FakerUtil.getCity());
        page.fill("#BillingNewAddress_Address1", FakerUtil.getAddress());
        page.fill("#BillingNewAddress_ZipPostalCode", FakerUtil.getZipCode());
        page.fill("#BillingNewAddress_PhoneNumber", FakerUtil.getPhoneNumber());

        page.locator("#billing-buttons-container input[value='Continue']").click();
        
        //2. Shipping Address
        page.waitForSelector("text=Shipping address");
        page.locator("#shipping-buttons-container input[value='Continue']").click();

        //Shipping Method
        page.waitForSelector("text=Shipping method");
        page.locator("#shipping-method-buttons-container input[value='Continue']").click();

        //4.Payment methof
        page.waitForSelector("text=Payment method");
        page.locator("#payment-method-buttons-container input[value='Continue']").click();

        //5.Payment info
        page.waitForSelector("text=Payment information");
        page.locator("#payment-info-buttons-container input[value='Continue']").click();

        //6.Confirm order
        page.waitForSelector("text=Confirm order");
        page.locator("#confirm-order-buttons-container input[value='Confirm']").click();
    }

    public boolean isOrderSuccessful() {

        String successText = page.locator(".section.order-completed .title").textContent();

        return successText.contains("successfully processed");
    }
}