package TestingTravels;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class loginTest extends base {
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeSuite
	public void checkingInternetConnectiity() throws IOException {
		driver = initializeDriver();
		driver.get("https://ismyinternetworking.com/");
		String internetStatus = driver.findElement(By.xpath("//div[@id='yessub']")).getText();
		if (!internetStatus.equalsIgnoreCase("Your Internet is Working!")) {
			loginTest lt = new loginTest();
			lt.tearDown();
		}
	}

	@BeforeClass
	public void setUp() throws IOException {

		driver.manage().window().maximize();
	}

	@Test
	public WebDriver logIn() throws InterruptedException {
		driver.navigate().to("https://www.akbartravels.com");
		driver.findElement(By.xpath(
				"//utilitymenu[@class='ng-tns-c7-2']//span[@class='mat-button-wrapper']//span[@class='ak-user']"))
				.click();
		driver.findElement(By.xpath("//button[@role='menuitem' and contains(text(),'Login')]")).click();

		driver.findElement(By.cssSelector("input#mat-input-3")).sendKeys("raddisunil1@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("05&July&1994");

		driver.findElement(By.xpath("//*[@class='btn mat-flat-button mat-primary']/span")).click();
		Thread.sleep(10000);
		
		return driver;
		
	

	}
	
	
	

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
