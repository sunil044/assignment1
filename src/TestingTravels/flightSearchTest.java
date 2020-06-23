package TestingTravels;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class flightSearchTest extends base {
	public WebDriver driver;
	public WebDriverWait wait;



	@BeforeClass
	public void setUp() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void searchForFlight() throws InterruptedException {
			
		loginTest lt = new loginTest();
	    driver = lt.logIn();
	    driver.findElement(By.xpath("//li[@class='from']")).click(); 

	}
	
	


	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
