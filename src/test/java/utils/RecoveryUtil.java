package utils;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RecoveryUtil {

    private static final Logger log = LogManager.getLogger(RecoveryUtil.class);

    public static boolean recover(Page page, Exception e) {

        String reason = AIUtil.analyzeFailure(e, page);

        log.warn("🔄 Attempting recovery | Reason: {}", reason);

        try {

            if (reason.contains("Timeout")) {
                page.waitForTimeout(2000);
                return true;
            }

            if (reason.contains("Locator")) {
                return true; // smartClick will retry
            }

            if (reason.contains("page load")) {
                page.reload();
                page.waitForLoadState();
                return true;
            }

            if (reason.contains("Stale")) {
                page.reload();
                return true;
            }

        } catch (Exception ex) {
            log.error("Recovery failed: {}", ex.getMessage());
        }

        log.error("❌ No recovery strategy worked");
        return false;
    }
}