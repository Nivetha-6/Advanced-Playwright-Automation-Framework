package utils;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StepExecutor {

    private static final Logger log = LogManager.getLogger(StepExecutor.class);

    public static void run(Runnable step, Page page, String stepName) {

        int maxRetry = 2;
        int attempt = 0;

        while (attempt <= maxRetry) {

            try {
                log.info("▶ Executing step: {} | Attempt: {}", stepName, attempt + 1);

                step.run();

                log.info("✅ Step passed: {}", stepName);
                return;

            } catch (Exception e) {

                log.error("❌ Step failed: {} | Error: {}", stepName, e.getMessage());

                // 🧠 AI Analysis
                String reason = AIUtil.analyzeFailure(e, page);
                log.warn("🧠 AI Insight: {}", reason);

                // 📸 Debug capture
                AIUtil.captureDebugData(page, stepName);

                // 🔄 Recovery
                boolean recovered = RecoveryUtil.recover(page, e);

                if (!recovered) {
                    log.error("🚨 Recovery failed for step: {}", stepName);
                    break;
                }

                log.warn("🔁 Retrying step: {}", stepName);
                attempt++;
            }
        }

        throw new RuntimeException("❌ Step permanently failed: " + stepName);
    }
}