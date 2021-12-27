package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder=new Actions(driver);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		//System.out.println("Price of first product="+price);
		
		int cost=Integer.parseInt(price.replaceAll("[^0-9]",""));
		//System.out.println(cost);
		String ratings = driver.findElement(By.xpath("(//div[@class='a-row a-size-small'])[1]//span[2]//span")).getText();
		System.out.println("Ratings for first product="+ratings);
		
		WebElement ofReviews=driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom'])[1]"));
		builder.moveToElement(ofReviews).perform();
		Thread.sleep(2000);
		WebElement stars=driver.findElement(By.xpath("(//span[@class='a-size-base']/a)[2]"));
		builder.moveToElement(stars).perform();
		String star1=stars.getText();
		System.out.println("Percentage of ratings="+star1);
		
		String onePlusPro = driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).getText();
		System.out.println(onePlusPro);
		driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).click();
		 
		WebElement image=driver.findElement(By.xpath("//img[@alt='OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']")); 
		File source=image.getScreenshotAs(OutputType.FILE);
		File destination=new File("./onePlusPhone.png");
		FileUtils.copyFile(source, destination);
		

		Set<String> windowHandles=driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(handles.get(2));
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(5000);
		
		WebElement cart= driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		builder.moveToElement(cart).perform();
		String cart1=cart.getText();
		cart1=cart1.replaceAll("[^0-9]|00$","");
		//System.out.println(cart1);
		int cartTotal=Integer.parseInt(cart1);
		if(cost==cartTotal)
		
		{
			System.out.println("price and cart total equal");
		}
		else
			System.out.println("Not equal");
		
	}

}
