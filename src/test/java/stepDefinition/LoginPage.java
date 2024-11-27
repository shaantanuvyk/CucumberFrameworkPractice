package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resource.Utils;

public class LoginPage extends Utils
{
	public static WebDriver driver;
	
	@Given("User is on the Login page")
	public void user_is_on_the_login_page() throws IOException 
	{
		driver=Utils.driver;
		driver.get(getPropties("OrangeHRMURL"));
		String loginPage = driver.findElement(By.cssSelector("h5.orangehrm-login-title")).getText();
	    assertEquals("Login", loginPage);
	}

	@When("User is trying to login with blank credentials using {string} and {string}")
	public void user_is_trying_to_login_with_blank_credentials_using_and(String string, String string2) 
	{
	    driver.findElement(By.cssSelector("input[name='username']")).sendKeys("");
	    driver.findElement(By.cssSelector("input[name='password']")).sendKeys("");
	    driver.findElement(By.xpath("//button[text()=\" Login \"]")).click();
	}

	@Then("Error message displays as {string} under username and password textboxes")
	public void error_message_displays_as_under_username_and_password_textboxes(String string) 
	{
	    String blankUsernameError= driver.findElement(By.xpath("//div[@class='oxd-form-row'][1]//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][1]")).getText();
	    assertEquals("Required", blankUsernameError);
	    String blankPasswordError= driver.findElement(By.xpath("//div[@class='oxd-form-row'][2]//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][1]")).getText();
	    assertEquals("Required",  blankPasswordError);
	   
	}

	@When("User is trying to login with invalid credentials using {string} and {string}")
	public void user_is_trying_to_login_with_invalid_credentials_using_and(String username, String password) 
	{
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
	    driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
	    driver.findElement(By.xpath("//button[text()=\" Login \"]")).click();
	}

	@Then("Error message displays as {string}")
	public void error_message_displays_as(String string) 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.oxd-text.oxd-text--p.oxd-alert-content-text")));
		String invalidCredentialsError= driver.findElement(By.cssSelector("p.oxd-text.oxd-text--p.oxd-alert-content-text")).getText();
		assertEquals("Invalid credentials", invalidCredentialsError);
	}

	@When("User is trying to login with valid credentials using {string} and {string}")
	public void user_is_trying_to_login_with_valid_credentials_using_and(String string, String string2) throws IOException 
	{
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(getPropties("username"));
	    driver.findElement(By.cssSelector("input[name='password']")).sendKeys(getPropties("password"));
	    driver.findElement(By.xpath("//button[text()=\" Login \"]")).click();
	}

	@Then("User gets login successfully on {string} page")
	public void user_gets_login_successfully_on_page(String string) 
	{
		String dashboardPage= driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		assertEquals("Dashboard", dashboardPage);
	}

}
