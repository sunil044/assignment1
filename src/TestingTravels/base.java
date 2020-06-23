package TestingTravels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public static WebDriver driver;
	public static Properties pop;
	public WebDriver initializeDriver() throws IOException
	{
		pop = new Properties();
		FileInputStream fil = new FileInputStream(System.getProperty("user.dir")+"\\src\\TestingTravels\\data.properties");
		pop.load(fil);
		String browerName = pop.getProperty("browser");
		
		
		if(browerName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\TestingTravels\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		
		if(browerName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.grcko.driver", System.getProperty("user.dir")+"\\src\\TestingTravels\\\\geckodriver.exe");
			driver = new ChromeDriver();	
		}
		int wait = Integer.parseInt(pop.getProperty("wait"));
	    driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		return driver;
	}
}
