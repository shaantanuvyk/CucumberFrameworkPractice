package stepDefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AddUserPage;
import resource.Utils;


public class AddUser extends Utils
{
	public WebDriver driver = Utils.driver;
	public AddUserPage adduser = new AddUserPage(driver);
	
	@Given("User is on the {string} page")
	public void user_is_on_the_page(String menuOptionName) 
	{
		adduser.menuOption(menuOptionName); 
	}

	@When("Enter user {string}, {string}, {string}")
	public void enter_user(String fname, String mname, String lname) 
	{
		adduser.addUserButton();
		adduser.addFirstName(fname);
		adduser.addMiddleName(mname);
		adduser.addLastName(lname);
		
	}

	@When("Saving the Details")
	public void saving_the_details() 
	{
		adduser.saveUserButton(); 
	}

	@Then("User gets added to the system with {string}, {string}, {string}")
	public void user_gets_added_to_the_system_with(String fname, String mname, String lname) 
	{
		//System.out.println("fname in user_gets_added_to_the_system_with is: " +adduser.getUsersFirstName());
		//assertEquals(adduser.getUsersFirstName(),fname);
		//assertEquals(adduser.getUserMiddlename(),mname);
		//assertEquals(adduser.getUserLastname(),lname);
		adduser.saveUserDetails();
	}

	@Then("On searching user gets fetched")
	public void on_searching_user_gets_fetched() throws InterruptedException 
	{
		
		adduser.menuOption("PIM");
	    Actions action= new Actions(driver);
	    adduser.searchByEmployeename("Shantanu ");
	    Thread.sleep(5000);
	    action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_UP).keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
	    driver.findElement(By.xpath("//button[text()=' Search ']")).click();
	    
	}

}
