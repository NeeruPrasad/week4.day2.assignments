package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement frame=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		List<WebElement> li=driver.findElements(By.xpath("//li[@class='ui-widget-content ui-selectee']"));
		//System.out.println(li.get(0));
		System.out.println(li.size());
		
		Actions selectAction=new Actions(driver);
		selectAction.clickAndHold(li.get(0)).moveToElement(li.get(3)).release().perform();
		//selectAction.keyDown(Keys.CONTROL).click(li.get(0)).click(li.get(2)).click(li.get(4)).keyUp(Keys.CONTROL).perform();
		
		/*WebElement selectElement1 = driver.findElement(By.xpath("//ol/li[1]"));
		WebElement selectElement2 = driver.findElement(By.xpath("//ol/li[3]"));
		WebElement selectElement3 = driver.findElement(By.xpath("//ol/li[5]"));
		WebElement selectElement4 = driver.findElement(By.xpath("//ol/li[7]"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(selectElement1).clickAndHold().moveToElement(selectElement4).release()
		.perform();
		
		mouse.click(selectElement1)
		.keyDown(Keys.CONTROL)
		.click(selectElement2)
		.click(selectElement3)
		.click(selectElement4)
		.keyUp(Keys.CONTROL)
		.perform();*/
		driver.close();

	}

}
