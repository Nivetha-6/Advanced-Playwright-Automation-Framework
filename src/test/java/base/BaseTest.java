package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.ConfigReader;

public class BaseTest {
	  protected Playwright playwright;
	    protected Browser browser;
	    protected Page page;

	    @BeforeMethod
	    public void setUp() {

	        playwright = Playwright.create();

	        String browserName = ConfigReader.get("browser");

	        if (browserName.equals("chrome")) {
	            browser = playwright.chromium().launch(
	                    new BrowserType.LaunchOptions().setHeadless(false)
	            );
	        }

	        page = browser.newPage();
	        page.navigate(ConfigReader.get("baseUrl"));
	    }

	    @AfterMethod
	    public void tearDown() {
	        browser.close();
	        playwright.close();
	    }
}
