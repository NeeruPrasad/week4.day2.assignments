package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder=new Actions(driver);
		WebElement men=driver.findElement(By.xpath("//a[text()='Men']"));	
		WebElement jackets=driver.findElement(By.xpath("(//a[text()='Jackets'])[1]"));
		builder.moveToElement(men).pause(Duration.ofSeconds(2)).click(jackets).perform();
		
		
		WebElement totalJacketsCount=driver.findElement(By.xpath("//span[@class='title-count']"));
		String tJC=totalJacketsCount.getText().replaceAll("[^0-9]", "");
		int totalJ=Integer.parseInt(tJC);
		System.out.println(totalJ);
		
		WebElement totalJacketsCount1=driver.findElement(By.xpath("//span[@class='categories-num']"));
		String tJC1=totalJacketsCount1.getText().replaceAll("[^0-9]", "");
		int totalJ1=Integer.parseInt(tJC1);
		System.out.println(totalJ1);
		WebElement totalRainJacketsCount=driver.findElement(By.xpath("(//span[@class='categories-num'])[2]"));
		String tRJC=totalRainJacketsCount.getText().replaceAll("[^0-9]", "");
		int totalRJ=Integer.parseInt(tRJC);
		System.out.println(totalRJ);
		
		int total=totalJ1+totalRJ;
		if(totalJ==total)
		{
			System.out.println("Jackets count equal");
		}
		else
			System.out.println("Jackets count not equal");
		
		WebElement checkJackets=driver.findElement(By.xpath("//input[@value='Jackets']/following-sibling::div"));
		builder.moveToElement(checkJackets).click().perform();
		
		WebElement more=driver.findElement(By.xpath("//div[@class='brand-more']"));
		builder.moveToElement(more).click().perform();
		
		WebElement typeDuke=driver.findElement(By.xpath("//input[@placeholder='Search brand']"));
		builder.moveToElement(typeDuke).sendKeys("Duke").click().perform();
		

		WebElement checkDuke=driver.findElement(By.xpath("//input[@value='Duke']/following-sibling::div"));
		builder.moveToElement(checkDuke).click().perform();
		
		WebElement closePop=driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']"));
		builder.moveToElement(closePop).click().perform();
		
		List<WebElement> title=driver.findElements(By.xpath("//ul[@class='results-base']//h3[@class='product-brand']"));
		boolean flag=true;
		for (WebElement eachProd : title)
		{
			String dukeTitle=eachProd.getText();	
		
			if(dukeTitle.contains("Duke"))
			{
				flag=true;
			
			}
			else
				flag=false;
		}
		if(flag)
		{
			System.out.println("All Duke Products");
		}
		else
			
		{
			System.out.println("Non Duke Products are there");
		}
		
		WebElement sort=driver.findElement(By.xpath("//span[text()='Recommended']"));
		WebElement discount=driver.findElement(By.xpath("//input[@value='discount']/.."));
		builder.moveToElement(sort).moveToElement(discount).click().perform();
		
		WebElement firstProdPrice=driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]"));
		builder.moveToElement(firstProdPrice).click().perform();
		
		String price=firstProdPrice.getText().replaceAll("[^0-9]", "");
		System.out.println("First Product Price="+price);
		
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(handles.get(2));
		
		WebElement image=driver.findElement(By.xpath("(//div[@class='image-grid-image'])[1]"));
		File source=image.getScreenshotAs(OutputType.FILE);
		File destination=new File("./DukeJacket.png");
		FileUtils.copyFile(source, destination);
		
		WebElement wishlist=driver.findElement(By.xpath("//span[text()='WISHLIST']"));
		builder.moveToElement(wishlist).click().perform();
		
		driver.quit();
	}

}
