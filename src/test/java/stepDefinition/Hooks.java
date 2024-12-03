package stepDefinition;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import resource.Utils;


public class Hooks extends Utils
{
	public WebDriver driver;
	
	@Before(order=0)
	public void  BrowserLaunching() throws IOException
	{	
		BrowserSelection(getPropties("browser"));
	}
	
	//@After
	public void BrowserClosing()
	{
		driver=Utils.driver;
		driver.quit();
	}
	
	@Before(order=1)
	public void beforeCreatingaNewUser() throws IOException
	{
		OrangeHRMLogin login = new OrangeHRMLogin();
		login.user_is_trying_to_login_with_valid_credentials_using_and(null, null);
	}
	
	@After()
	public void takeScreenshot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(image, new File("C:\\Users\\ACER\\Desktop\\Screenshots\\"+scenario.getName()+".jpg"));
		}
		
	}
}
