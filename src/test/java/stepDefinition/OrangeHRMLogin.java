package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import javax.security.auth.login.LoginContext;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import resource.Utils;

public class OrangeHRMLogin extends Utils
{
	public WebDriver driver = Utils.driver;
	LoginPage login = new LoginPage(driver);
	
	@Given("User is on the Login page")
	public void user_is_on_the_login_page() throws IOException 
	{
		Assert.assertEquals(login.loginPageText(),"Login");
	}

	@When("User is trying to login with blank credentials using {string} and {string}")
	public void user_is_trying_to_login_with_blank_credentials_using_and(String string, String string2) 
	{
		login.userName("");
		login.userPassword("");
		login.loginButtonClick();
	}

	@Then("Error message displays as {string} under username and password textboxes")
	public void error_message_displays_as_under_username_and_password_textboxes(String string) 
	{
	    Assert.assertTrue(login.userNameErrorMessageDisplay());
	    Assert.assertTrue(login.userPasswordErrorMessageDisplay());	   
	}

	@When("User is trying to login with invalid credentials using {string} and {string}")
	public void user_is_trying_to_login_with_invalid_credentials_using_and(String username, String password) 
	{
		login.userName(username);
		login.userPassword(password);
		login.loginButtonClick();
	}

	@Then("Error message displays as {string}")
	public void error_message_displays_as(String errorMessage) 
	{
		Assert.assertTrue(login.userInvalidCredentialsErrorDisplays());
		Assert.assertEquals(login.userInvalidCredentialsErrorMessage(), errorMessage);
	}

	@When("User is trying to login with valid credentials using {string} and {string}")
	public void user_is_trying_to_login_with_valid_credentials_using_and(String string, String string2) throws IOException 
	{
		login.userName(getPropties("username"));
	    login.userPassword(getPropties("password"));
	    login.loginButtonClick();
	}

	@Then("User gets login successfully on {string} page")
	public void user_gets_login_successfully_on_page(String value)
	{
		String dashboardPage= driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		assertEquals(value, dashboardPage);
	}
}
