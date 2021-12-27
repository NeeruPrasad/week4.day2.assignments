package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		WebElement source=driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		Dimension size=driver.findElement(By.xpath("//div[@id='resizable']/div[3]")).getSize();
		Actions builder=new Actions(driver);
		Point location=source.getLocation();
		int x=location.getX();
		int y=location.getY();
		System.out.println(x+" "+y);
	    builder.doubleClick().dragAndDropBy(source,size.getWidth()+100,size.getHeight()+100).perform();
		//driver.close();
	}

}
