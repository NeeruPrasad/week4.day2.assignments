package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.beust.jcommander.JCommander.Builder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//h1[text()='Resizable']")).click();
		 
		
		WebElement frame=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		WebElement source=driver.findElement(By.id("draggable"));
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(source,80,60).perform();
		driver.close();
		
		
		/* driver.switchTo().frame(0);
		 
		 Actions builder = new Actions(driver);
		 
		 Thread.sleep(2000);
		 
		 WebElement resize = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-s']/following-sibling::div[1]"));
		 
		 builder.dragAndDropBy(resize, 50,40).perform();*/
		

	}

}
