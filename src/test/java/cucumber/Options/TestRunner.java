package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Feature/OrangeHRMTests.feature",
		glue={"stepDefinition"}
		//,tags={"@SanityTest"}
//		plugin ="html:target/jsonReports/cucumber-report.html",
		)


public class TestRunner 
{
	
}
