package test;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {
	
	@Test(description="Window Handling Test")
	public void test_WindowHandling() {		
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://web-locators-static-site-qa.vercel.app/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement windowLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Windows")));
		
		windowLink.click();
		
		String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);
		
		WebElement launchNewWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Launch New Window')]")));
		
		launchNewWindow.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String handle : windowHandles) {
			
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				System.out.println(handle);
				//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#APjFqb")));
				//element.sendKeys("Max and Joy");
				String childTitle = driver.getTitle();
				System.out.println(childTitle);
				break;
			}
			
		}
		driver.close();
		
		driver.switchTo().window(parentHandle);
		String parentTitle = driver.getTitle();
		System.out.println(parentTitle);
		driver.quit();
		
		
	}

}
