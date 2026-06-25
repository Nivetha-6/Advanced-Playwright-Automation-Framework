//package utils;
//
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Locator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AIUtil {
//
//    private static final Logger log = LogManager.getLogger(AIUtil.class);
//
//    // 🔍 Generate smart locators
//    public static List<String> generateLocators(String elementName) {
//
//        List<String> locators = new ArrayList<>();
//
//        locators.add("text=" + elementName);
//        locators.add("button:has-text('" + elementName + "')");
//        locators.add("input[placeholder='" + elementName + "']");
//        locators.add("[aria-label='" + elementName + "']");
//        locators.add("//button[contains(text(),'" + elementName + "')]");
//
//        return locators;
//    }
//
//    // 🔁 Self-healing click
//    public static boolean smartClick(Page page, String elementName) {
//
//        List<String> locators = generateLocators(elementName);
//
//        for (String locator : locators) {
//
//            try {
//                Locator element = page.locator(locator);
//
//                if (element.count() > 0) {
//                    element.first().click();
//                    log.info("✅ Clicked '{}' using locator: {}", elementName, locator);
//                    return true;
//                }
//
//            } catch (Exception e) {
//                log.warn("❌ Failed locator: {} | Reason: {}", locator, e.getMessage());
//            }
//        }
//
//        log.error("🚨 All locators failed for element: {}", elementName);
//        return false;
//    }
//
//    // 📊 AI-style failure analysis
//    public static String analyzeFailure(Exception e) {
//
//        String msg = e.getMessage();
//
//        if (msg.contains("timeout")) {
//            return "Element not visible or page load issue";
//        }
//
//        if (msg.contains("not found")) {
//            return "Locator might be incorrect";
//        }
//
//        if (msg.contains("detached")) {
//            return "Element became stale (DOM updated)";
//        }
//
//        return "Unknown issue - needs investigation";
//    }
//}
package utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AIUtil {

    private static final Logger log = LogManager.getLogger(AIUtil.class);

    // Generate smart locators
    public static List<String> generateLocators(String elementName) {

        List<String> locators = new ArrayList<>();

        locators.add("text=" + elementName);
        locators.add("button:has-text('" + elementName + "')");
        locators.add("input[placeholder='" + elementName + "']");
        locators.add("[aria-label='" + elementName + "']");
        locators.add("//button[contains(text(),'" + elementName + "')]");

        return locators;
    }

    // SMART CLICK (Self-healing)
    public static boolean smartClick(Page page, String elementName) {

        List<String> locators = generateLocators(elementName);

        for (String locator : locators) {
            try {
                Locator element = page.locator(locator);

                if (element.count() > 0 && element.first().isVisible()) {
                    element.first().click();
                    log.info("✅ Clicked '{}' using locator: {}", elementName, locator);
                    return true;
                }

            } catch (Exception e) {
                log.warn("❌ Failed locator: {} | Reason: {}", locator, e.getMessage());
            }
        }

        // Fallback strategy
        try {
            Locator fallback = page.locator("text=" + elementName);
            fallback.first().click();
            log.info("⚡ Fallback worked for '{}'", elementName);
            return true;
        } catch (Exception e) {
            log.error("🚨 All locator strategies failed for '{}'", elementName);
        }

        return false;
    }

    // SSMART WAIT
    public static boolean smartWait(Page page, String elementName) {

        List<String> locators = generateLocators(elementName);

        for (String locator : locators) {
            try {
                Locator element = page.locator(locator);

                element.first().waitFor(
                        new Locator.WaitForOptions().setTimeout(5000)
                );

                log.info("⏳ Element '{}' appeared using {}", elementName, locator);
                return true;

            } catch (Exception e) {
                log.warn("Wait failed for locator: {}", locator);
            }
        }

        log.error("🚨 Element '{}' not found after wait", elementName);
        return false;
    }

    // AI FAILURE ANALYSIS
    public static String analyzeFailure(Exception e, Page page) {

        String msg = e.getMessage();

        if (msg.contains("timeout")) {
            return "⏱ Timeout → Element not visible / slow loading";
        }

        if (msg.contains("not found")) {
            return "🔍 Locator issue → Element not present in DOM";
        }

        if (msg.contains("detached")) {
            return "♻️ Stale element → DOM refreshed";
        }

        try {
            String title = page.title();
            return "⚠️ Unknown issue | Page Title: " + title;
        } catch (Exception ex) {
            return "⚠️ Unknown critical failure";
        }
    }

    // DEBUG DATA CAPTURE
    public static void captureDebugData(Page page, String stepName) {

        try {
            String timestamp = String.valueOf(System.currentTimeMillis());

            String basePath = "target/ai-debug/";

            java.io.File dir = new java.io.File(basePath);
            if (!dir.exists()) dir.mkdirs();

            // Screenshot
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get(basePath + stepName + "_" + timestamp + ".png"))
                    .setFullPage(true));

            // DOM
            String dom = page.content();

            Files.write(
                    Paths.get(basePath + stepName + "_" + timestamp + ".html"),
                    dom.getBytes()
            );

            log.info("📸 Debug data captured for step: {}", stepName);

        } catch (Exception e) {
            log.error("Debug capture failed: {}", e.getMessage());
        }
    }

    // UNIVERSAL ACTION ENGINE
    public static void performAction(Page page, String element, String action) {

        switch (action.toLowerCase()) {

            case "click":
                smartClick(page, element);
                break;

            case "wait":
                smartWait(page, element);
                break;

            case "type":
                page.fill("input[placeholder='" + element + "']", element);
                break;

            default:
                log.warn("Unknown action: {}", action);
        }
    }
}