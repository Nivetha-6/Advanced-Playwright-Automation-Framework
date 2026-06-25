//package utils;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
//
//public class ReportUtil {
//
//    private static final Logger log = LogManager.getLogger(ReportUtil.class);
//
//    public static void info(String message) {
//        log.info(message);
//        ExtentCucumberAdapter.addTestStepLog("INFO: " + message);
//    }
//
//    public static void pass(String message) {
//        log.info(message);
//        ExtentCucumberAdapter.addTestStepLog("✅ PASS: " + message);
//    }
//
//    public static void fail(String message) {
//        log.error(message);
//        ExtentCucumberAdapter.addTestStepLog("❌ FAIL: " + message);
//    }
//
//    public static void warn(String message) {
//        log.warn(message);
//        ExtentCucumberAdapter.addTestStepLog("⚠ WARN: " + message);
//    }
//}
package utils;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReportUtil {

    private static final Logger log = LogManager.getLogger(ReportUtil.class);

    public static void info(String message) {
        log.info(message);
        ExtentCucumberAdapter.addTestStepLog("ℹ️ " + message);
    }

    public static void pass(String message) {
        log.info(message);
        ExtentCucumberAdapter.addTestStepLog("✅ " + message);
    }

    public static void fail(String message) {
        log.error(message);
        ExtentCucumberAdapter.addTestStepLog("❌ " + message);
    }

    public static void warn(String message) {
        log.warn(message);
        ExtentCucumberAdapter.addTestStepLog("⚠️ " + message);
    }
}