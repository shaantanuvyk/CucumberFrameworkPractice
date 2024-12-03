package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{
	private WebDriver driver;

	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}	
	
	//By Locators
	private By UserName = By.cssSelector("input[name='username']");
	private By UserPassword = By.cssSelector("input[name='password']");
	private By LoginButton = By.xpath("//button[text()=' Login ']");
	private By LoginTextOnLoginPage = By.cssSelector("h5.oxd-text.oxd-text--h5.orangehrm-login-title");
	private By UserNameErrorMessage = By.xpath("//div[@class='oxd-form-row'][1]//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][1]");
	private By UserPasswordErrorMessage = By.xpath("//div[@class='oxd-form-row'][2]//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][1]");
	private By UserInvalidCredentialsError = By.cssSelector("p.oxd-text.oxd-text--p.oxd-alert-content-text");
	
	
	//Page Methods/Actions
	public void userName(String username)
	{
		WebElement userName = driver.findElement(UserName);
		userName.sendKeys(username);
	}
	
	public void userPassword(String userpassword)
	{
		WebElement userPassword = driver.findElement(UserPassword);
				userPassword.sendKeys(userpassword);
	}
	
	public void loginButtonClick()
	{
		WebElement loginButton = driver.findElement(LoginButton);
		loginButton.click();
	}
	
	public String loginPageText()
	{
		WebElement loginTextOnLoginPage = driver.findElement(LoginTextOnLoginPage);
		return loginTextOnLoginPage.getText();
	}
	
	public boolean userNameErrorMessageDisplay()
	{
		WebElement userNameErrorMessage = driver.findElement(UserNameErrorMessage);
		return userNameErrorMessage.isDisplayed();
	}
	
	public boolean userPasswordErrorMessageDisplay()
	{
		WebElement userPasswordErrorMessageDisplay = driver.findElement(UserPasswordErrorMessage);
		return userPasswordErrorMessageDisplay.isDisplayed();
	}

	public boolean userInvalidCredentialsErrorDisplays()
	{
		WebElement userInvalidCredentialsErrorDisplays = driver.findElement(UserInvalidCredentialsError);
		return userInvalidCredentialsErrorDisplays.isDisplayed();
	}
	
	public String userInvalidCredentialsErrorMessage()
	{
		WebElement userInvalidCredentialsErrorMessage = driver.findElement(UserInvalidCredentialsError);
		return userInvalidCredentialsErrorMessage.getText();
	}

}
