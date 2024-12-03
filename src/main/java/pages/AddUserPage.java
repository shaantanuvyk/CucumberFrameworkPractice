package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddUserPage 
{
	private WebDriver driver;
	
	//Constructor
	public AddUserPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//By Locators
	
	private By MenuOption = By.xpath("//ul[@class='oxd-main-menu']//li");
	private By AddUserButton = By.xpath("//button[text()=' Add ']");
	private By AddFirstName = By.cssSelector("input[name='firstName']");
	private By AddMiddleName = By.cssSelector("input[name='middleName']");
	private By AddLastName = By.cssSelector("input[name='lastName']");
	private By SaveUserButton = By.xpath("//button[text()=' Save ']");
	private By GetUsersFirstName = By.xpath("//input[@name='firstName']");
	private By GetUsersMiddleName = By.cssSelector("input.oxd-input.oxd-input--active.orangehrm-middlename");
	private By GetUsersLastName = By.cssSelector("input.oxd-input.oxd-input--active.orangehrm-lastname");
	private By SaveUserDetails = By.xpath("//form[@class='oxd-form']/div[4]/button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
	private By SearchByEmployeeName = By.xpath("//form[@class='oxd-form']//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//input[@placeholder='Type for hints...']");
	
	
	//PageMethods
	
	public void menuOption(String PageName)
	{
		List<WebElement> menuOption = driver.findElements(MenuOption);		
		int menuOptionCount = menuOption.size();
	    
	    for(int i=1; i<=menuOptionCount; i++)
	    {
	    	String GetMenuOption = driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//li["+i+"]")).getText();
	    	if(GetMenuOption.equalsIgnoreCase(PageName))
	    	{
	    		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//li["+i+"]")).click();
	    		break;
	    	}
	    }
	}
	
	public void addUserButton()
	{
		WebElement addUserButton = driver.findElement(AddUserButton);
		addUserButton.click();
	}
	
	public void addFirstName(String fname)
	{
		WebElement addFirstName = driver.findElement(AddFirstName);
		addFirstName.sendKeys(fname);
	}
	
	public void addMiddleName(String mname)
	{
		WebElement addMiddleName = driver.findElement(AddMiddleName);
		addMiddleName.sendKeys(mname);
	}

	public void addLastName(String mname)
	{
		WebElement addLastName = driver.findElement(AddLastName);
		addLastName.sendKeys(mname);
	}
	
	public void saveUserButton()
	{
		WebElement saveUserButton = driver.findElement(SaveUserButton);
		saveUserButton.click();
	}
	
	public String getUsersFirstName()
	{
		WebElement getUserFirstName = driver.findElement(GetUsersFirstName);
		return getUserFirstName.getDomAttribute("value");
	}
	
	public String getUserMiddlename()
	{
		WebElement getUserMiddlename = driver.findElement(GetUsersMiddleName);
		return getUserMiddlename.getDomAttribute("value");
	}
	
	public String getUserLastname()
	{
		WebElement getUserLastname = driver.findElement(GetUsersLastName);
		return getUserLastname.getDomAttribute("value");
	}
	
	public void saveUserDetails()
	{
		WebElement saveUserDetails = driver.findElement(SaveUserDetails);
		saveUserDetails.click();
	}
	
	public String fullName()
	{
		String fullName = getUsersFirstName()+" "+getUserMiddlename()+" "+getUserLastname();
		return fullName;
	}
	
	public void searchByEmployeename(String value)
	{
		WebElement searchByEmployeename = driver.findElement(SearchByEmployeeName);
		searchByEmployeename.sendKeys(value);
	}
	
	
	
}