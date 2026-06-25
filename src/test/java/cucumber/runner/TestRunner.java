package cucumber.runner;
import org.testng.annotations.Listeners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@Listeners(utils.RetryListener.class)
@CucumberOptions(
	    features = "src/test/resources/features/endToend.feature",
	    glue = {"stepdefinitions", "hooks"},
	    		plugin = {
	    			    "pretty",
	    			    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    			},
	    monochrome = true
	)
public class TestRunner extends AbstractTestNGCucumberTests {
}