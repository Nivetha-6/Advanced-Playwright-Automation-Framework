//package hooks;
//
//import java.nio.file.Paths;
//
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserType;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//
//public class Hooks {
//
//    public static Playwright playwright;
//    public static Browser browser;
//    public static Page page;
//
//    @Before
//    public void setUp() {
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
////        browser = playwright.chromium().launch(
////        	    new BrowserType.LaunchOptions()
////        	        .setHeadless(false)
////        	        .setSlowMo(1000) // 🔥 1 second delay per action
////        	);
//        page = browser.newPage();
//    }
//
//    @After
//    public void tearDown(Scenario scenario) {
//
//        
//        if (scenario.isFailed()) {
//
//            byte[] screenshot = page.screenshot(
//                new Page.ScreenshotOptions().setFullPage(true)
//            );
//
//            scenario.attach(screenshot, "image/png", "Failure Screenshot");
//        }
//
//        browser.close();
//        playwright.close();
//    }
//    @AfterStep
//    public void addStepScreenshot(Scenario scenario) {
//
//        try {
//            String scenarioName = scenario.getName().replaceAll(" ", "_");
//            String timestamp = String.valueOf(System.currentTimeMillis());
//
//            String folderPath = "target/screenshots/";
//            String filePath = folderPath + scenarioName + "_" + timestamp + ".png";
//
//            // Ensure folder exists
//            java.io.File dir = new java.io.File(folderPath);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//
//            // Save screenshot
//            page.screenshot(new Page.ScreenshotOptions()
//                    .setPath(Paths.get(filePath))
//                    .setFullPage(true));
//
//            // Attach to report
//            byte[] screenshot = page.screenshot();
//            scenario.attach(screenshot, "image/png", "Step Screenshot");
//
//        } catch (Exception e) {
//            System.out.println("Screenshot failed: " + e.getMessage());
//        }
//    }
//}
////////////////////////////////////////////////////////////////////////////////////////////
package hooks;

import java.nio.file.Paths;

import com.microsoft.playwright.*;

import io.cucumber.java.*;
import utils.ReportUtil;

public class Hooks {

    public static Playwright playwright;
    public static Browser browser;
    public static Page page;

    @Before
    public void setUp(Scenario scenario) {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(1000) 
        );

        page = browser.newPage();


        ReportUtil.info("🚀 Starting Scenario: " + scenario.getName());
        ReportUtil.info("🌐 Browser: Chromium");
        ReportUtil.info("⚙ Environment: QA");
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot = page.screenshot(
                    new Page.ScreenshotOptions().setFullPage(true)
            );

            scenario.attach(screenshot, "image/png", "Failure Screenshot");

            ReportUtil.fail("❌ Scenario Failed: " + scenario.getName());
            ReportUtil.info("📸 Failure screenshot attached");

        } else {
            ReportUtil.pass("✅ Scenario Passed: " + scenario.getName());
        }

        browser.close();
        playwright.close();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {

        try {

            String scenarioName = scenario.getName().replaceAll(" ", "_");
            String timestamp = String.valueOf(System.currentTimeMillis());

            String folderPath = "target/screenshots/";
            String filePath = folderPath + scenarioName + "_" + timestamp + ".png";

            java.io.File dir = new java.io.File(folderPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

 
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get(filePath))
                    .setFullPage(true));

  
            byte[] screenshot = page.screenshot();
            scenario.attach(screenshot, "image/png", "Step Screenshot");

            if (scenario.isFailed()) {
                ReportUtil.fail("❌ Step Failed");
            } else {
                ReportUtil.pass("✅ Step Passed");
            }

        } catch (Exception e) {
            ReportUtil.warn("Screenshot failed: " + e.getMessage());
        }
    }
}