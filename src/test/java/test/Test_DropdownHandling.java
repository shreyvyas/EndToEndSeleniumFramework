package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test_DropdownHandling {
	
	@Test
	public void dropdownHandling() {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://web-locators-static-site-qa.vercel.app/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dropdown")));
		dropdown.click();
		
		WebElement dropdown1 = driver.findElement(By.xpath("//div[@class='Dropdown_section1']//select"));
		
		Select select = new Select(dropdown1);
		select.selectByValue("Greece");
		
		List<WebElement> allOptions = select.getOptions();
		
		for(WebElement options : allOptions) {
			
			String text = options.getText();
			
			System.out.println(text);
			
		}	
		
	}
	

}
