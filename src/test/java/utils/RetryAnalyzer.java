//package utils;
//
//import org.testng.IRetryAnalyzer;
//import org.testng.ITestResult;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class RetryAnalyzer implements IRetryAnalyzer {
//
//    private static final Logger log = LogManager.getLogger(RetryAnalyzer.class);
//
//    private int count = 0;
//    private static final int maxTry = 2; // retry max 2 times
//
//    @Override
//    public boolean retry(ITestResult result) {
//
//        if (count < maxTry) {
//            count++;
//
//            log.warn("🔁 Retrying test: {} | Attempt: {}", result.getName(), count);
//
//            return true;
//        }
//
//        log.error("❌ Test failed after retries: {}", result.getName());
//        return false;
//    }
//}
package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger log = LogManager.getLogger(RetryAnalyzer.class);

    private int count = 0;
    private static final int maxTry = 2;

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxTry) {
            count++;

            String msg = "🔁 Retrying test: " + result.getName() + " | Attempt: " + count;

            log.warn(msg);
            ReportUtil.warn(msg); // 🔥 ADDED TO REPORT

            return true;
        }

        String failMsg = "❌ Test failed after retries: " + result.getName();

        log.error(failMsg);
        ReportUtil.fail(failMsg); // 🔥 ADDED TO REPORT

        return false;
    }
}