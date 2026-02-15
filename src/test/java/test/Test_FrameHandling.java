package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test_FrameHandling {
	
	@Test
	public void frameHandling() {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://web-locators-static-site-qa.vercel.app/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement frameLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Frames")));
		frameLink.click();
		
		WebElement iFrame1 = 
		
		
	}

}
