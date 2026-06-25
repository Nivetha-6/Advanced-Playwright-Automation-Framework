//////package stepdefinitions;
//////
//////import com.microsoft.playwright.Page;
//////
//////import hooks.Hooks;
//////import io.cucumber.java.en.Given;
//////import io.cucumber.java.en.Then;
//////import io.cucumber.java.en.When;
//////import utils.CSVUtil;
//////
//////public class EndToEnd {
//////	boolean executionCompleted = false;
//////
//////    int currentUserIndex = 1;
//////    String[][] data;
//////
//////    String firstName;
//////    String lastName;
//////    String password;
//////    String searchProduct;
//////    String city;
//////    String address;
//////    String zip;
//////    String phone;
//////
//////    Page page = Hooks.page;
//////    String email;
//////
//////   
////////    @Given("user registers from CSV")
////////    public void user_registers_from_csv() {
////////
////////        data = CSVUtil.getData("src/test/data/user1.csv");
////////
////////        for (int i = 1; i < data.length; i++) {
////////
////////            loadUserData(i);
////////
////////            System.out.println("Running for user: " + firstName);
////////
////////            registerUser();
////////            user_is_logged_into_the_application();
////////            search_product();
////////            user_adds_product_to_wishlist();
////////            add_to_cart();
////////            checkout();
////////            logout();
////////
////////            System.out.println("Completed for user: " + firstName);
////////        }
////////
////////        System.out.println("All users executed successfully ✅");
////////
////////        executionCompleted = true;   // 🔥 IMPORTANT
////////    }
////////    // ✅ LOAD CSV DATA
////////    public void loadUserData(int i) {
////////        firstName = data[i][0];
////////        lastName  = data[i][1];
////////        password  = data[i][2];
////////        searchProduct = data[i][3];
////////        city = data[i][4];
////////        address = data[i][5];
////////        zip = data[i][6];
////////        phone = data[i][7];
////////    }
////////
////////    // ✅ FIXED REGISTER METHOD
////////    public void registerUser() {
////////
////////        email = "user" + System.currentTimeMillis() + "@gmail.com";
////////
////////        page.navigate("https://demowebshop.tricentis.com/register");
////////
////////        page.click("#gender-male");
////////        page.fill("#FirstName", firstName);
////////        page.fill("#LastName", lastName);
////////        page.fill("#Email", email);
////////        page.fill("#Password", password);
////////        page.fill("#ConfirmPassword", password);
////////        page.click("#register-button");
////////
////////        page.waitForSelector(".result");
////////        page.click("input[value='Continue']");
////////        page.waitForSelector("text=Log out");
////////    }
////////
////////    @Given("user registers a new account")
////////    public void user_registers() {
////////
////////        email = "user" + System.currentTimeMillis() + "@gmail.com";
////////
////////        page.navigate("https://demowebshop.tricentis.com/register");
////////
////////        page.click("#gender-male");
////////        page.fill("#FirstName", "Test");
////////        page.fill("#LastName", "User");
////////        page.fill("#Email", email);
////////        page.fill("#Password", "123456");
////////        page.fill("#ConfirmPassword", "123456");
////////        page.click("#register-button");
////////
////////        page.waitForSelector(".result");
////////        page.click("input[value='Continue']");
////////        page.waitForLoadState();
////////        page.waitForSelector("text=Log out");
////////    }
////////
////////    @Given("user is logged into the application")
////////    public void user_is_logged_into_the_application() {
////////
////////        page.waitForSelector("text=Log out");
////////        System.out.println("User is successfully logged in");
////////    }
////////
////////    @When("user searches for a product")
////////    public void search_product() {
////////
////////        page.fill("#small-searchterms", searchProduct); // from CSV
////////        page.click("input[value='Search']");
////////
////////        page.waitForSelector(".product-item");
////////        int count = page.locator(".product-item").count();
////////
////////        if (count == 0) {
////////            System.out.println("No results for: " + searchProduct);
////////        }
////////
////////        System.out.println("Searching for: " + searchProduct);
////////    }
////////
//////////    @When("user adds product to wishlist")
//////////    public void user_adds_product_to_wishlist() {
//////////
//////////        page.waitForSelector(".product-item");
//////////
//////////        page.locator(".product-item h2 a").first().click();
//////////
//////////        page.waitForSelector("input[value='Add to wishlist']");
//////////
//////////        page.click("input[value='Add to wishlist']");
//////////
//////////        page.waitForTimeout(2000);
//////////
//////////        page.goBack();
//////////
//////////        page.waitForSelector(".product-item");
//////////    }
////////
////////    @When("user adds product to wishlist")
////////    public void user_adds_product_to_wishlist() {
////////
////////        page.waitForSelector(".product-item");
////////
////////        // open product page
////////        page.locator(".product-item h2 a").first().click();
////////
////////        // ✅ check if wishlist button exists
////////        int wishlistCount = page.locator("input[value='Add to wishlist']").count();
////////
////////        if (wishlistCount > 0) {
////////
////////            page.click("input[value='Add to wishlist']");
////////            page.waitForSelector("#bar-notification");
////////
////////            System.out.println("Wishlist added successfully");
////////
////////        } else {
////////
////////            System.out.println("Wishlist NOT available for this product → skipping");
////////
////////        }
////////
////////        page.goBack();
////////        page.waitForSelector(".product-item");
////////    }
//////////    @When("user adds product to cart")
//////////    public void add_to_cart() {
//////////
//////////        page.locator("input[value='Add to cart']").first().click();
//////////
//////////        page.waitForTimeout(2000);
//////////
//////////        page.click(".cart-label");
//////////
//////////        page.waitForSelector("#termsofservice");
//////////    }
////////    @When("user adds product to cart")
////////    public void add_to_cart() {
////////
////////        // ✅ Always open product page first
////////        page.locator(".product-item h2 a").first().click();
////////
////////        // ✅ Wait for product page
////////        page.waitForSelector("input[value='Add to cart']");
//////////        if (page.locator("input[value='Add to cart']").count() == 0) {
//////////            System.out.println("Add to cart not available for this product");
//////////        }
////////        // ✅ Click Add to cart
////////        page.click("input[value='Add to cart']");
////////
////////        page.waitForSelector("#bar-notification");
////////
////////        // ✅ Go to cart
////////        page.click(".cart-label");
////////
////////        page.waitForSelector("#termsofservice");
////////    }
////////
////////    @When("user completes checkout")
////////    public void checkout() {
////////
////////        page.check("#termsofservice");
////////        page.click("#checkout");
////////
////////        page.waitForSelector(".page-title");
////////        page.waitForSelector("text=Billing address");
////////
////////        page.selectOption("#BillingNewAddress_CountryId", "41");
////////
////////        // ✅ USING CSV DATA (NO FAKER)
////////        page.fill("#BillingNewAddress_City", city);
////////        page.fill("#BillingNewAddress_Address1", address);
////////        page.fill("#BillingNewAddress_ZipPostalCode", zip);
////////        page.fill("#BillingNewAddress_PhoneNumber", phone);
////////
////////        page.locator("#billing-buttons-container input[value='Continue']").click();
////////
////////        page.waitForSelector("text=Shipping address");
////////        page.locator("#shipping-buttons-container input[value='Continue']").click();
////////
////////        page.waitForSelector("text=Shipping method");
////////        page.locator("#shipping-method-buttons-container input[value='Continue']").click();
////////
////////        page.waitForSelector("text=Payment method");
////////        page.locator("#payment-method-buttons-container input[value='Continue']").click();
////////
////////        page.waitForSelector("text=Payment information");
////////        page.locator("#payment-info-buttons-container input[value='Continue']").click();
////////
////////        page.waitForSelector("text=Confirm order");
////////        page.locator("#confirm-order-buttons-container input[value='Confirm']").click();
////////
////////        page.waitForSelector("text=Thank you");
////////        page.locator("xpath=//input[@value='Continue']").click();
////////    }
////////
////////    @Then("user logs out successfully")
////////    public void logout() {
////////
////////        page.click(".ico-logout");
////////
////////        page.waitForSelector(".ico-login");
////////    }
//////    
//////}
////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////package stepdefinitions;
//////
//////import com.microsoft.playwright.Page;
//////import hooks.Hooks;
//////import io.cucumber.java.en.*;
//////import org.apache.logging.log4j.LogManager;
//////import org.apache.logging.log4j.Logger;
//////import utils.CSVUtil;
//////
//////public class EndToEnd {
//////	private static final Logger log = LogManager.getLogger(EndToEnd.class);
//////
//////    boolean executionCompleted = false;
//////
//////    String[][] data;
//////
//////    String firstName;
//////    String lastName;
//////    String password;
//////    String searchProduct;
//////    String city;
//////    String address;
//////    String zip;
//////    String phone;
//////
//////    Page page = Hooks.page;
//////    String email;
//////
//////    @Given("user registers from CSV")
//////    public void user_registers_from_csv() {
//////
//////        data = CSVUtil.getData("src/test/data/user1.csv");
//////
//////        for (int i = 1; i < data.length; i++) {
//////
//////            loadUserData(i);
//////
////////            System.out.println("Running for user: " + firstName);
//////            log.info("Starting execution for user: {}", firstName);
//////
//////            registerUser();
//////            user_is_logged_into_the_application();
//////            search_product();
//////            user_adds_product_to_wishlist();
//////            add_to_cart();
//////            checkout();
//////            logout();
//////
//////            System.out.println("Completed for user: " + firstName);
//////        }
//////
////////        System.out.println("All users executed successfully");
//////        log.info("User registered successfully");
//////
//////        executionCompleted = true; 
//////    }
//////
//////    public void loadUserData(int i) {
//////        firstName = data[i][0];
//////        lastName  = data[i][1];
//////        password  = data[i][2];
//////        searchProduct = data[i][3];
//////        city = data[i][4];
//////        address = data[i][5];
//////        zip = data[i][6];
//////        phone = data[i][7];
//////    }
//////
//////    public void registerUser() {
//////
//////        email = "user" + System.currentTimeMillis() + "@gmail.com";
//////
//////        page.navigate("https://demowebshop.tricentis.com/register");
//////
//////        page.click("#gender-male");
//////        page.fill("#FirstName", firstName);
//////        page.fill("#LastName", lastName);
//////        page.fill("#Email", email);
//////        page.fill("#Password", password);
//////        page.fill("#ConfirmPassword", password);
//////        page.click("#register-button");
//////
//////        page.waitForSelector(".result");
//////        page.click("input[value='Continue']");
//////        page.waitForSelector("text=Log out");
//////    }
//////
//////    @Given("user is logged into the application")
//////    public void user_is_logged_into_the_application() {
//////
//////        if (executionCompleted) return;
//////
//////        page.waitForSelector("text=Log out");
//////        System.out.println("User is successfully logged in");
//////    }
//////    @When("user searches for a product")
//////    public void search_product() {
//////
//////        if (executionCompleted) return;
//////
//////        page.fill("#small-searchterms", searchProduct);
//////        page.click("input[value='Search']");
//////        page.waitForSelector(".product-item");
//////
//////        System.out.println("Searching for: " + searchProduct);
//////    }
//////
//////    @When("user adds product to wishlist")
//////    public void user_adds_product_to_wishlist() {
//////
//////        if (executionCompleted) return;
//////
//////        page.waitForSelector(".product-item");
//////
//////        page.locator(".product-item h2 a").first().click();
//////
//////        int wishlistCount = page.locator("input[value='Add to wishlist']").count();
//////
//////        if (wishlistCount > 0) {
//////            page.click("input[value='Add to wishlist']");
//////            page.waitForSelector("#bar-notification");
//////            System.out.println("Wishlist added successfully");
//////        } else {
//////            System.out.println("Wishlist NOT available → skipping");
//////        }
//////
//////        page.goBack();
//////        page.waitForSelector(".product-item");
//////    }
//////
//////    @When("user adds product to cart")
//////    public void add_to_cart() {
//////
//////        if (executionCompleted) return;
//////
//////        page.locator(".product-item h2 a").first().click();
//////
//////        page.waitForSelector("input[value='Add to cart']");
//////        page.click("input[value='Add to cart']");
//////
//////        page.waitForSelector("#bar-notification");
//////
//////        page.click(".cart-label");
//////        page.waitForSelector("#termsofservice");
//////    }
//////    @When("user completes checkout")
//////    public void checkout() {
//////
//////        if (executionCompleted) return;
//////
//////        page.check("#termsofservice");
//////        page.click("#checkout");
//////
//////        page.waitForSelector(".page-title");
//////        page.waitForSelector("text=Billing address");
//////
//////        page.selectOption("#BillingNewAddress_CountryId", "41");
//////
//////        page.fill("#BillingNewAddress_City", city);
//////        page.fill("#BillingNewAddress_Address1", address);
//////        page.fill("#BillingNewAddress_ZipPostalCode", zip);
//////        page.fill("#BillingNewAddress_PhoneNumber", phone);
//////
//////        page.locator("#billing-buttons-container input[value='Continue']").click();
//////
//////        page.locator("#shipping-buttons-container input[value='Continue']").click();
//////        page.locator("#shipping-method-buttons-container input[value='Continue']").click();
//////        page.locator("#payment-method-buttons-container input[value='Continue']").click();
//////        page.locator("#payment-info-buttons-container input[value='Continue']").click();
//////
//////        page.locator("#confirm-order-buttons-container input[value='Confirm']").click();
//////
//////        page.waitForSelector("text=Thank you");
//////        page.locator("xpath=//input[@value='Continue']").click();
//////
//////        System.out.println("Checkout completed");
//////    }
//////
//////    @Then("user logs out successfully")
//////    public void logout() {
//////
//////        if (executionCompleted) return;
//////
//////        page.click(".ico-logout");
//////        page.waitForSelector(".ico-login");
//////    }
//////}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////
////package stepdefinitions;
////
////import java.nio.file.Paths;
////
////import org.apache.logging.log4j.LogManager;
////import org.apache.logging.log4j.Logger;
////
////import com.microsoft.playwright.Page;
////
////import hooks.Hooks;
////import io.cucumber.java.en.Given;
////import io.cucumber.java.en.Then;
////import io.cucumber.java.en.When;
////import utils.AIUtil;
////import utils.CSVUtil;
////
////public class EndToEnd {
////
////    private static final Logger log = LogManager.getLogger(EndToEnd.class);
////
////    boolean executionCompleted = false;
////
////    String[][] data;
////
////    String firstName;
////    String lastName;
////    String password;
////    String searchProduct;
////    String city;
////    String address;
////    String zip;
////    String phone;
////
////    Page page = Hooks.page;
////    String email;
////
////    @Given("user registers from CSV")
////    public void user_registers_from_csv() {
////
////        data = CSVUtil.getData("src/test/data/user1.csv");
////
////        for (int i = 1; i < data.length; i++) {
////        	 
////            loadUserData(i);
////         
////            log.info("===== Starting execution for user: {} =====", firstName);
////         
////            try {
////                registerUser();
////                takeScreenshot("register", i);
////         
////                user_is_logged_into_the_application();
////                takeScreenshot("login", i);
////         
////                search_product();
////                takeScreenshot("search", i);
////         
////                user_adds_product_to_wishlist();
////                takeScreenshot("wishlist", i);
////         
////                add_to_cart();
////                takeScreenshot("cart", i);
////         
////                checkout();
////                takeScreenshot("checkout", i);
////         
////                logout();
////                takeScreenshot("logout", i);
////         
////            } catch (Exception e) {
////                log.error("Execution failed for user {} : {}", firstName, e.getMessage());
////            }
////        }
////
////        log.info("All users executed successfully");
////
////        executionCompleted = true;
////    }
////
////    public void loadUserData(int i) {
////        firstName = data[i][0];
////        lastName  = data[i][1];
////        password  = data[i][2];
////        searchProduct = data[i][3];
////        city = data[i][4];
////        address = data[i][5];
////        zip = data[i][6];
////        phone = data[i][7];
////    }
////
////    public void registerUser() {
////
////        email = "user" + System.currentTimeMillis() + "@gmail.com";
////
////        log.info("Registering user with email: {}", email);
////
////        page.navigate("https://demowebshop.tricentis.com/register");
////
////        page.click("#gender-male");
////        page.fill("#FirstName", firstName);
////        page.fill("#LastName", lastName);
////        page.fill("#Email", email);
////        page.fill("#Password", password);
////        page.fill("#ConfirmPassword", password);
////        page.click("#register-button");
////
////        page.waitForSelector(".result");
////        page.click("input[value='Continue']");
////        page.waitForSelector("text=Log out");
////    }
////
////    @Given("user is logged into the application")
////    public void user_is_logged_into_the_application() {
////
////        if (executionCompleted) return;
////
////        page.waitForSelector("text=Log out");
////        log.info("User is logged in successfully");
////    }
////
////    @When("user searches for a product")
////    public void search_product() {
////
////        if (executionCompleted) return;
////
////        page.fill("#small-searchterms", searchProduct);
////        page.click("input[value='Search']");
////        page.waitForSelector(".product-item");
////
////        log.info("Searching for product: {}", searchProduct);
////    }
////
////    @When("user adds product to wishlist")
////    public void user_adds_product_to_wishlist() {
////
////        if (executionCompleted) return;
////
////        page.waitForSelector(".product-item");
////
////        page.locator(".product-item h2 a").first().click();
////
////        int wishlistCount = page.locator("input[value='Add to wishlist']").count();
////
////        if (wishlistCount > 0) {
////            page.click("input[value='Add to wishlist']");
////            page.waitForSelector("#bar-notification");
////            log.info("Product added to wishlist");
////        } else {
////            log.warn("Wishlist option not available for this product");
////        }
////
////        page.goBack();
////        page.waitForSelector(".product-item");
////    }
////
//////    @When("user adds product to cart")
//////    public void add_to_cart() {
//////
//////        if (executionCompleted) return;
//////
//////        page.locator(".product-item h2 a").first().click();
//////
////////        page.waitForSelector("input[value='Add to cart']");
//////        AIUtil.smartClick(page, "Add to cart");
//////        
//////        page.click("input[value='Add to cart']");
//////
//////        page.waitForSelector("#bar-notification");
//////
//////        page.click(".cart-label");
//////        page.waitForSelector("#termsofservice");
//////
//////        log.info("Product added to cart");
//////    }
////
////    @When("user adds product to cart")
////    public void add_to_cart() {
////
////        if (executionCompleted) return;
////
////        page.locator(".product-item h2 a").first().click();
////
////        // OLD CODE (normal click)
////        // page.waitForSelector("input[value='Add to cart']");
////        // page.click("input[value='Add to cart']");
////
////        // NEW AI SELF-HEALING CLICK
////        AIUtil.smartClick(page, "Add to cart");
////
////        page.waitForSelector("#bar-notification");
////
////        page.click(".cart-label");
////        page.waitForSelector("#termsofservice");
////
////        log.info("Product added to cart");
////    }
//////    @When("user completes checkout")
//////    public void checkout() {
//////
//////        if (executionCompleted) return;
//////
//////        try {
//////            page.check("#termsofservice");
////////            page.click("#checkout");
//////
//////            AIUtil.smartClick(page, "Checkout");
//////            
//////            page.waitForSelector("text=Billing address");
//////
//////            page.selectOption("#BillingNewAddress_CountryId", "41");
//////
//////            page.fill("#BillingNewAddress_City", city);
//////            page.fill("#BillingNewAddress_Address1", address);
//////            page.fill("#BillingNewAddress_ZipPostalCode", zip);
//////            page.fill("#BillingNewAddress_PhoneNumber", phone);
//////
//////            page.locator("#billing-buttons-container input[value='Continue']").click();
//////            page.locator("#shipping-buttons-container input[value='Continue']").click();
//////            page.locator("#shipping-method-buttons-container input[value='Continue']").click();
//////            page.locator("#payment-method-buttons-container input[value='Continue']").click();
//////            page.locator("#payment-info-buttons-container input[value='Continue']").click();
//////
//////            page.locator("#confirm-order-buttons-container input[value='Confirm']").click();
//////
//////            page.waitForSelector("text=Thank you");
//////            page.locator("xpath=//input[@value='Continue']").click();
//////
//////        } catch (Exception e) {
////////            log.error("Checkout failed: {}", e.getMessage());
//////        	String reason = AIUtil.analyzeFailure(e);
//////        	log.error("Checkout failed: {} | AI Insight: {}", e.getMessage(), reason);
//////        }
//////    }
////    @When("user completes checkout")
////    public void checkout() {
////
////        if (executionCompleted) return;
////
////        try {
////
////            page.check("#termsofservice");
////
////            AIUtil.smartWait(page, "Checkout");
////            AIUtil.smartClick(page, "Checkout");
////
////            page.waitForSelector("text=Billing address");
////
////            page.selectOption("#BillingNewAddress_CountryId", "41");
////
////            page.fill("#BillingNewAddress_City", city);
////            page.fill("#BillingNewAddress_Address1", address);
////            page.fill("#BillingNewAddress_ZipPostalCode", zip);
////            page.fill("#BillingNewAddress_PhoneNumber", phone);
////
////            page.locator("#billing-buttons-container input[value='Continue']").click();
////            page.locator("#shipping-buttons-container input[value='Continue']").click();
////            page.locator("#shipping-method-buttons-container input[value='Continue']").click();
////            page.locator("#payment-method-buttons-container input[value='Continue']").click();
////            page.locator("#payment-info-buttons-container input[value='Continue']").click();
////
////            page.locator("#confirm-order-buttons-container input[value='Confirm']").click();
////
////            page.waitForSelector("text=Thank you");
////            page.locator("xpath=//input[@value='Continue']").click();
////
////        } catch (Exception e) {
////
////            AIUtil.captureDebugData(page, "checkout");
////
////            String reason = AIUtil.analyzeFailure(e, page);
////
////            log.error("❌ Checkout failed | {} | {}", e.getMessage(), reason);
////        }
////    }
////
////    @Then("user logs out successfully")
////    public void logout() {
////
////        if (executionCompleted) return;
////
//////        page.click(".ico-logout");
////        AIUtil.smartClick(page, "Log out");
////        
////        page.waitForSelector(".ico-login");
////
////        log.info("User logged out");
////    }
////    public void takeScreenshot(String stepName, int userIndex) {
////    	 
////        try {
////            String folderPath = "target/screenshots/";
////            String filePath = folderPath + "User_" + userIndex + "_" + stepName + "_" + System.currentTimeMillis() + ".png";
////     
////            java.io.File dir = new java.io.File(folderPath);
////            if (!dir.exists()) {
////                dir.mkdirs();
////            }
////     
////            page.screenshot(new Page.ScreenshotOptions()
////                    .setPath(Paths.get(filePath))
////                    .setFullPage(true));
////     
////        } catch (Exception e) {
////            System.out.println("Screenshot failed: " + e.getMessage());
////        }
////    }
////}
/////////////////////////////////////////4/29/2026/////////////////
//package stepdefinitions;
//
//import java.nio.file.Paths;
//
//import com.microsoft.playwright.Page;
//
//import hooks.Hooks;
//import io.cucumber.java.en.*;
//
//import utils.AIUtil;
//import utils.CSVUtil;
//import utils.ReportUtil;
//
//public class EndToEnd {
//
//    boolean executionCompleted = false;
//
//    String[][] data;
//
//    String firstName;
//    String lastName;
//    String password;
//    String searchProduct;
//    String city;
//    String address;
//    String zip;
//    String phone;
//
//    Page page = Hooks.page;
//    String email;
//
//    // ========================= MAIN FLOW =========================
//
//    @Given("user registers from CSV")
//    public void user_registers_from_csv() {
//
//        data = CSVUtil.getData("src/test/data/user1.csv");
//
//        for (int i = 1; i < data.length; i++) {
//
//            loadUserData(i);
//
//            ReportUtil.info("👤 Starting execution for user: " + firstName);
//
//            try {
//
//                registerUser();
//                takeScreenshot("register", i);
//
//                user_is_logged_into_the_application();
//                takeScreenshot("login", i);
//
//                search_product();
//                takeScreenshot("search", i);
//
//                user_adds_product_to_wishlist();
//                takeScreenshot("wishlist", i);
//
//                add_to_cart();
//                takeScreenshot("cart", i);
//
//                checkout();
//                takeScreenshot("checkout", i);
//
//                logout();
//                takeScreenshot("logout", i);
//
//                ReportUtil.pass("✅ Completed execution for user: " + firstName);
//
//            } catch (Exception e) {
//
//                ReportUtil.fail("❌ Execution failed for user: " + firstName + " | " + e.getMessage());
//            }
//        }
//
//        ReportUtil.pass("🎯 All users executed successfully");
//        executionCompleted = true;
//    }
//
//    // ========================= DATA =========================
//
//    public void loadUserData(int i) {
//        firstName = data[i][0];
//        lastName  = data[i][1];
//        password  = data[i][2];
//        searchProduct = data[i][3];
//        city = data[i][4];
//        address = data[i][5];
//        zip = data[i][6];
//        phone = data[i][7];
//    }
//
//    // ========================= REGISTER =========================
//
//    public void registerUser() {
//
//        email = "user" + System.currentTimeMillis() + "@gmail.com";
//
//        ReportUtil.info("Registering user: " + email);
//
//        page.navigate("https://demowebshop.tricentis.com/register");
//
//        page.click("#gender-male");
//        page.fill("#FirstName", firstName);
//        page.fill("#LastName", lastName);
//        page.fill("#Email", email);
//        page.fill("#Password", password);
//        page.fill("#ConfirmPassword", password);
//        page.click("#register-button");
//
//        page.waitForSelector(".result");
//        page.click("input[value='Continue']");
//        page.waitForSelector("text=Log out");
//
//        ReportUtil.pass("User registered successfully");
//    }
//
//    // ========================= LOGIN =========================
//
//    @Given("user is logged into the application")
//    public void user_is_logged_into_the_application() {
//
//        if (executionCompleted) return;
//
//        page.waitForSelector("text=Log out");
//        ReportUtil.pass("User logged in successfully");
//    }
//
//    // ========================= SEARCH =========================
//
//    @When("user searches for a product")
//    public void search_product() {
//
//        if (executionCompleted) return;
//
//        page.fill("#small-searchterms", searchProduct);
//        page.click("input[value='Search']");
//        page.waitForSelector(".product-item");
//
//        ReportUtil.info("Searching for product: " + searchProduct);
//    }
//
//    // ========================= WISHLIST =========================
//
//    @When("user adds product to wishlist")
//    public void user_adds_product_to_wishlist() {
//
//        if (executionCompleted) return;
//
//        page.waitForSelector(".product-item");
//
//        page.locator(".product-item h2 a").first().click();
//
//        int wishlistCount = page.locator("input[value='Add to wishlist']").count();
//
//        if (wishlistCount > 0) {
//            page.click("input[value='Add to wishlist']");
//            page.waitForSelector("#bar-notification");
//            ReportUtil.pass("Product added to wishlist");
//        } else {
//            ReportUtil.warn("Wishlist not available for this product");
//        }
//
//        page.goBack();
//        page.waitForSelector(".product-item");
//    }
//
//    // ========================= ADD TO CART =========================
//
//    @When("user adds product to cart")
//    public void add_to_cart() {
//
//        if (executionCompleted) return;
//
//        page.locator(".product-item h2 a").first().click();
//
//        AIUtil.smartClick(page, "Add to cart");
//
//        page.waitForSelector("#bar-notification");
//
//        page.click(".cart-label");
//        page.waitForSelector("#termsofservice");
//
//        ReportUtil.pass("Product added to cart");
//    }
//
//    // ========================= CHECKOUT =========================
//
//    @When("user completes checkout")
//    public void checkout() {
//
//        if (executionCompleted) return;
//
//        try {
//
//            page.check("#termsofservice");
//
//            AIUtil.smartWait(page, "Checkout");
//            AIUtil.smartClick(page, "Checkout");
//
//            page.waitForSelector("text=Billing address");
//
//            page.selectOption("#BillingNewAddress_CountryId", "41");
//
//            page.fill("#BillingNewAddress_City", city);
//            page.fill("#BillingNewAddress_Address1", address);
//            page.fill("#BillingNewAddress_ZipPostalCode", zip);
//            page.fill("#BillingNewAddress_PhoneNumber", phone);
//
//            page.locator("#billing-buttons-container input[value='Continue']").click();
//            page.locator("#shipping-buttons-container input[value='Continue']").click();
//            page.locator("#shipping-method-buttons-container input[value='Continue']").click();
//            page.locator("#payment-method-buttons-container input[value='Continue']").click();
//            page.locator("#payment-info-buttons-container input[value='Continue']").click();
//
//            page.locator("#confirm-order-buttons-container input[value='Confirm']").click();
//
//            page.waitForSelector("text=Thank you");
//            page.locator("xpath=//input[@value='Continue']").click();
//
//            ReportUtil.pass("Checkout completed successfully");
//
//        } catch (Exception e) {
//
//            AIUtil.captureDebugData(page, "checkout");
//
//            String reason = AIUtil.analyzeFailure(e, page);
//
//            ReportUtil.fail("Checkout failed: " + e.getMessage());
//            ReportUtil.info("🤖 AI Insight: " + reason);
//        }
//    }
//
//    // ========================= LOGOUT =========================
//
//    @Then("user logs out successfully")
//    public void logout() {
//
//        if (executionCompleted) return;
//
//        AIUtil.smartClick(page, "Log out");
//
//        page.waitForSelector(".ico-login");
//
//        ReportUtil.pass("User logged out successfully");
//    }
//
//    // ========================= SCREENSHOT =========================
//
//    public void takeScreenshot(String stepName, int userIndex) {
//
//        try {
//
//            String folderPath = "target/screenshots/";
//            String filePath = folderPath + "User_" + userIndex + "_" + stepName + "_" + System.currentTimeMillis() + ".png";
//
//            java.io.File dir = new java.io.File(folderPath);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//
//            page.screenshot(new Page.ScreenshotOptions()
//                    .setPath(Paths.get(filePath))
//                    .setFullPage(true));
//
//            ReportUtil.info("📸 Screenshot captured: " + stepName);
//
//        } catch (Exception e) {
//            ReportUtil.warn("Screenshot failed: " + e.getMessage());
//        }
//    }
//}
package stepdefinitions;

import com.microsoft.playwright.Page;
import hooks.Hooks;
import io.cucumber.java.en.*;

import utils.AIUtil;
import utils.CSVUtil;
import utils.ReportUtil;

public class EndToEnd {

    Page page = Hooks.page;

    static String[][] data;
    static int currentUser = 1;

    String firstName, lastName, password, searchProduct, city, address, zip, phone, email;



    @Given("user data is loaded")
    public void loadCSV() {
        data = CSVUtil.getData("src/test/data/user1.csv");
        ReportUtil.info("CSV loaded");
    }



    public void loadUser() {
        firstName = data[currentUser][0];
        lastName  = data[currentUser][1];
        password  = data[currentUser][2];
        searchProduct = data[currentUser][3];
        city = data[currentUser][4];
        address = data[currentUser][5];
        zip = data[currentUser][6];
        phone = data[currentUser][7];

        ReportUtil.info("👤 Running for user: " + firstName);
    }

    @Given("user registers")
    public void register() {

        loadUser();

        email = "user" + System.currentTimeMillis() + "@gmail.com";

        page.navigate("https://demowebshop.tricentis.com/register");

        page.click("#gender-male");
        page.fill("#FirstName", firstName);
        page.fill("#LastName", lastName);
        page.fill("#Email", email);
        page.fill("#Password", password);
        page.fill("#ConfirmPassword", password);
        page.click("#register-button");

        page.waitForSelector(".result");
        page.click("input[value='Continue']");

        ReportUtil.pass("User registered");
    }

 
    @Given("user is logged into the application")
    public void login() {

        page.waitForSelector("text=Log out");
        ReportUtil.pass("User logged in");
    }

    

    @When("user searches for a product")
    public void search() {

        page.fill("#small-searchterms", searchProduct);
        page.click("input[value='Search']");
        page.waitForSelector(".product-item");

        ReportUtil.info("Searching: " + searchProduct);
    }


    @When("user adds product to wishlist")
    public void wishlist() {

        page.locator(".product-item h2 a").first().click();

        if (page.locator("input[value='Add to wishlist']").count() > 0) {
            page.click("input[value='Add to wishlist']");
            ReportUtil.pass("Added to wishlist");
        } else {
            ReportUtil.warn("Wishlist not available");
        }

        page.goBack();
    }

    @When("user adds product to cart")
    public void cart() {

        page.locator(".product-item h2 a").first().click();

        AIUtil.smartClick(page, "Add to cart");

        page.click(".cart-label");

        ReportUtil.pass("Added to cart");
    }


    @When("user completes checkout")
    public void checkout() {

        try {
            page.check("#termsofservice");
            AIUtil.smartClick(page, "Checkout");

            page.waitForSelector("text=Billing address");
            page.waitForSelector("#BillingNewAddress_CountryId");
            page.selectOption("#BillingNewAddress_CountryId", "India");


            page.fill("#BillingNewAddress_City", city);
            page.fill("#BillingNewAddress_Address1", address);
            page.fill("#BillingNewAddress_ZipPostalCode", zip);
            page.fill("#BillingNewAddress_PhoneNumber", phone);

            page.locator("input[value='Continue']").first().click();

            ReportUtil.pass("Checkout done");

        } catch (Exception e) {
            ReportUtil.fail("Checkout failed");
        }
    }

    // ================= LOGOUT + LOOP =================

    @Then("user logs out successfully")
    public void logout() {

        AIUtil.smartClick(page, "Log out");

        ReportUtil.pass("User logged out");

      
        currentUser++;

        if (currentUser < data.length) {

            ReportUtil.info(" Switching to next user...");

          
            register();
            login();
            search();
            wishlist();
            cart();
            checkout();
            logout();

        } else {
            ReportUtil.pass(" All users executed");
        }
    }
}