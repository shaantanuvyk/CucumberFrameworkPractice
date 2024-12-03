package resource;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils 
{
	public static WebDriver driver; 
	public WebDriver BrowserSelection(String browserName) throws IOException
	{
		if(browserName.equalsIgnoreCase("Chrome")||browserName.equalsIgnoreCase("Google Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Desktop\\Shantanu Karambalkar\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.get(getPropties("OrangeHRMURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
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
	
	public String getPropties(String value) throws IOException
	{
		FileReader fir = new FileReader("C:\\Users\\ACER\\CucumberFrameworkPractice\\CucumberFrameworkPractice\\src\\test\\java\\resource\\Global.properties");
		
		Properties prop = new Properties();
		prop.load(fir);
		
		return prop.getProperty(value);
		
	}
}
