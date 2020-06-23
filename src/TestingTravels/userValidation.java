package TestingTravels;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class userValidation extends base {
	public WebDriver driver;
	public WebDriverWait wait;

	

	@BeforeClass
	public void setUp() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void validationOfUserID() throws InterruptedException
	{
		loginTest lt = new loginTest();
		lt.logIn();
		
		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/div[2]/flight-home/home-header/header/div/div/div[2]/utilitymenu/ul/li[3]"))
				.click();

		String userID = driver.findElement(By.cssSelector("button.username.mat-menu-item.ng-star-inserted")).getText();

		if (userID.equalsIgnoreCase("raddisunil1@gmail.com")) {
			System.out.println("Expected text on button matches");
		} else {
			System.out.println("mismatches Actual button text");
		}

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
