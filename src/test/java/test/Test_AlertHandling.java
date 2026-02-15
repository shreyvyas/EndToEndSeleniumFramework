package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_AlertHandling {
	
	@Test
	public void hanldeAlert() throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://web-locators-static-site-qa.vercel.app/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement alertLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Alerts")));
		alertLink.click();
		
		WebElement showAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Show Alert')]")));
		showAlert.click();
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		Thread.sleep(2000);
		
		WebElement showAgreement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Show Agreement')]")));
		showAgreement.click();
		
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		
		Thread.sleep(2000);
		
		WebElement addRemarks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Add Remarks')]")));
		addRemarks.click();
		
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Max and Joy");
		alert3.accept();
		
	}

}
