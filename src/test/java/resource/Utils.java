package resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils 
{
	public static WebDriver driver; 
	public WebDriver BrowserSelection(String browserName)
	{
		if(browserName.equalsIgnoreCase("Chrome")||browserName.equalsIgnoreCase("Google Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Desktop\\Shantanu Karambalkar\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver= new ChromeDriver();
			//return driver;
		}
		if(browserName.equalsIgnoreCase("Edge"))
		{ 
			System.setProperty("webdriver.edge.driver", "");
			driver= new EdgeDriver();
			//return driver;
		}
		if(browserName.equalsIgnoreCase("FF")||browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "");
			driver = new FirefoxDriver();
			//return driver;
		}
		return driver;
		
	}
}
