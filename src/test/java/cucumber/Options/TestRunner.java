package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//import io.cucumber.testng.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/Feature",
		glue={"stepDefinition"},
		tags="@RegressionTest or @SmokeTest"
//		plugin ="html:target/jsonReports/cucumber-report.html",
		)




public class TestRunner 
{
	
}
