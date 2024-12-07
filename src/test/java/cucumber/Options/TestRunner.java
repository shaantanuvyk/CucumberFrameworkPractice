package cucumber.Options;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//import io.cucumber.testng.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Feature",
		glue={"stepDefinition"},
		tags="@SmokeTest or @SanityTest",
		plugin ={"pretty","html:target/cucumber-reports.html"}, //pretty report gets generated in the local folder (Target location)
		monochrome = true,
		publish = true //Publish report on the cucumber.io server, the link gets generated in the console
		)

public class TestRunner extends AbstractTestNGCucumberTests
{
	/*@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}*/
}
