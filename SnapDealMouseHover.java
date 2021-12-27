package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealMouseHover {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder=new Actions(driver);
		WebElement men=driver.findElement(By.xpath("//li[@class='navlink hoverIn']//span[2]"));
		builder.moveToElement(men).perform();
		builder.click(men).perform();
	
		Thread.sleep(1000);
		WebElement shirts=driver.findElement(By.xpath("//a[@class='rightMenuLink noHasTagWidth dp-widget-link visibleRgtBlkLnk']/span[text()='Shirts']"));
		builder.moveToElement(shirts).perform();
		builder.click(shirts).perform();
		

		WebElement quickView=driver.findElement(By.xpath("//p[text()='Gritstones Cotton Blend Pink Shirt Single']"));
		builder.moveToElement(quickView).perform();
		
		builder.click(quickView).perform();
		
		
		
		

	}

}
