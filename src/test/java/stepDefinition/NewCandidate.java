package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resource.Utils;

public class NewCandidate extends Utils
{
	public static WebDriver driver;
	@Given("User navigates on {string} page")
	public void user_navigates_on_page(String value) throws InterruptedException 
	{
		driver=Utils.driver;
	    int count = driver.findElements(By.xpath("//nav[@aria-label='Sidepanel']//ul//li")).size();
	    
		for(int i=1;i<=count;i++)
		{
			String elementName = driver.findElement(By.xpath("//nav[@aria-label='Sidepanel']//ul//li["+i+"]")).getText();
			if(elementName.equals("Recruitment"))
			{
				driver.findElement(By.xpath("//nav[@aria-label='Sidepanel']//ul//li["+i+"]")).click();
				break;
			}
		}
		String PageTitle = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		System.out.println("Page Title is: " +value);
		assertEquals(PageTitle, value);
	}

	@When("User creates a new user in system as {string} {string} {string}")
	public void user_creates_a_new_user_in_system_as(String fname, String mname, String lname) 
	{
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(fname);
		driver.findElement(By.cssSelector("input[name='middleName']")).sendKeys(mname);
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lname);
		driver.findElement(By.xpath("//div[@class='orangehrm-card-container']//form/div[3]//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input")).sendKeys("s@mailinator.com");
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		
		int count = driver.findElements(By.xpath("//ul['data-v-5327b38a']//a[@class='oxd-topbar-body-nav-tab-item']")).size();
		
		for(int i=1;i<=count;i++)
		{
			String 	tabText= driver.findElement(By.xpath("//ul['data-v-5327b38a']//a[@class='oxd-topbar-body-nav-tab-item']")).getText();
			if(tabText.equalsIgnoreCase("Candidates"))
			{
				driver.findElement(By.xpath("//ul['data-v-5327b38a']//a[@class='oxd-topbar-body-nav-tab-item']")).click();
			}
		}
	}

	@Then("New user is created in system")
	public void new_user_is_created_in_system() throws InterruptedException 
	{
		driver.findElement(By.xpath
			("//div[@class='oxd-table-filter']//div[@class='oxd-table-filter-area']/form/div[2]/div/div[1]//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input"))
			.sendKeys("Shantanu ");
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table-filter']//div[@class='oxd-table-filter-area']/form/div[2]/div/div[1]//div/div[2]//div[@role='listbox']")));
		
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).build().perform();
		action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
	}

	@Then("The fetched records display {string} {string} {string}")
	public void the_fetched_records_display(String fname, String mname, String lname)  
	{
		String getCandidiateName= driver.findElement(By.xpath("//div[@class='oxd-table-card']/div['data-v-f2168256'][@class='oxd-table-row oxd-table-row--with-border']/div[3]")).getText();
		String enteredName = fname+" "+mname+" "+lname;
		assertEquals(enteredName, getCandidiateName);
	}
}
