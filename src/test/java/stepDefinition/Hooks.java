package stepDefinition;


import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import resource.Utils;


public class Hooks extends Utils
{
	public static WebDriver driver;
	
	@Before
	public void BrowserLaunching() throws IOException
	{
		BrowserSelection(getPropties("browser"));
		driver.get(getPropties("OrangeHRMURL"));
	}
	
	@After
	public void BrowserClosing()
	{
		driver.quit();
	}
}
