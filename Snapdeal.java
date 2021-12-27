package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder=new Actions(driver);
		WebElement men=driver.findElement(By.xpath("//a[@class='menuLinks leftCategoriesProduct ']/span[2]"));
		builder.moveToElement(men).perform();
		builder.click(men).perform();
	
		Thread.sleep(1000);
		WebElement sportShoes=driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		builder.moveToElement(sportShoes).perform();
		builder.click(sportShoes).perform();
		
		int count=0;
		WebElement shoesCount=driver.findElement(By.xpath("//h1[contains(text(),'Sports Shoes for Men')]/following-sibling::span"));
		builder.moveToElement(shoesCount).perform();
		String s=shoesCount.getText();
		String s1=s.replaceAll("[^0-9]","");
		int sportShoeCount=Integer.parseInt(s1);
		System.out.println(sportShoeCount);
		
		WebElement sortBy=driver.findElement(By.xpath("//div[contains(text(),'Popularity')]"));
		builder.moveToElement(sortBy).perform();
		sortBy.click();
		
		options.addArguments("--disable-notifications");
		
		Thread.sleep(2000);
		WebElement sortLtH=driver.findElement(By.xpath("(//li[@data-index='1'])[2]"));
		builder.moveToElement(sortLtH).perform();
		sortLtH.click();
		
		Thread.sleep(3000);
		List<WebElement> shoesLtoH=driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer> shoesArray=new ArrayList<Integer>();
				
		for (WebElement webElement : shoesLtoH) {
			
			String shoe=webElement.getText();
			String s2=shoe.replaceAll("[^0-9]","");
			int s3=Integer.parseInt(s2);
			shoesArray.add(s3);
			
		}
		System.out.println(shoesArray);
		List<Integer> shoesArray1=new ArrayList<Integer>(shoesArray);
		Collections.sort(shoesArray1);
		if(shoesArray1.equals(shoesArray))
		{
			System.out.println("Shoes Prices are sorted");
		}
		WebElement fromPrice=driver.findElement(By.name("fromVal"));
		builder.moveToElement(fromPrice).perform();
		fromPrice.clear();
		fromPrice.sendKeys("900");
		
		WebElement toPrice=driver.findElement(By.name("toVal"));
		builder.moveToElement(toPrice).perform();
		toPrice.clear();
		toPrice.sendKeys("1200");
		
		Thread.sleep(1000);

		WebElement go=driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"));
		builder.moveToElement(go).perform();
		go.click();
		
		Thread.sleep(3000);
		WebElement viewMore=driver.findElement(By.xpath("//button[@data-filtername='Color_s']"));
		builder.moveToElement(viewMore).perform();
		viewMore.click();
		
		
		WebElement color=driver.findElement(By.xpath("//label[@for='Color_s-Navy']"));
		builder.moveToElement(color).perform();
		color.click();
		
		Thread.sleep(3000);
		WebElement firstShoe=driver.findElement(By.xpath("//section[@class='js-section clearfix dp-widget dp-fired']//div"));
		WebElement quickView=driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]"));
		//div[contains(text(),'Quick View')])[1]
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(quickView));
		builder.moveToElement(firstShoe).click(quickView).perform();
		
		
		WebElement price=driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		builder.moveToElement(price).perform();
		String price1=price.getText().replaceAll("[^0-9]","");
		
		WebElement discount=driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		builder.moveToElement(discount).perform();
		String discount1=discount.getText();
		
		System.out.println("Price= "+price1);
		System.out.println("Discount="+discount1);
		
		WebElement image=driver.findElement(By.xpath("//img[@itemprop='image']"));
		File source=image.getScreenshotAs(OutputType.FILE);
		File destination=new File("./ShoesImage.png");
		FileUtils.copyFile(source, destination);
		
	}

}
