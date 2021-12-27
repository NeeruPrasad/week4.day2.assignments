package week4.day2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectAllCheckBoxes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("--disable-notifications");
		//options.setHeadless(true);
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> allCheckboxes=driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::input"));
		for (WebElement webElement : allCheckboxes) {
			
			webElement.click();
		}
		
	
		
		

	}

}
