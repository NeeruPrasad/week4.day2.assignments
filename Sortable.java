package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		List<WebElement> li=driver.findElements(By.xpath("//li[@class='ui-state-default ui-sortable-handle']"));
		System.out.println(li.size());
		Actions selectAction=new Actions(driver);
		selectAction.dragAndDrop(li.get(0), li.get(1)).perform();
		selectAction.dragAndDrop(li.get(1), li.get(2)).perform();
		selectAction.dragAndDrop(li.get(3), li.get(1)).perform();
		//selectAction.dragAndDrop(li.get(4), li.get(3)).perform();
	}

}
