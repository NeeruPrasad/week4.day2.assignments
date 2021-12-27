package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder=new Actions(driver);
		WebElement brands=driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).perform();
		
		WebElement searchBrands=driver.findElement(By.id("brandSearchBox"));
		searchBrands.sendKeys("L'Oreal Paris",Keys.ENTER);
		WebElement lp=driver.findElement(By.linkText("L'Oreal Paris"));
		builder.moveToElement(lp).perform();
		lp.click();
		
		Thread.sleep(1000);
		String title=driver.getTitle();
		System.out.println(title);
		
		WebElement popularity=driver.findElement(By.xpath("//button[@class=' css-p2rfnw']"));
		builder.moveToElement(popularity).perform();
		popularity.click();
		
		WebElement radioCustomerTop=driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]"));
		builder.moveToElement(radioCustomerTop).perform();
		radioCustomerTop.click();
		
		WebElement category=driver.findElement(By.xpath("//span[text()='Category']"));
		builder.moveToElement(category).perform();
		category.click();
		
		WebElement hair=driver.findElement(By.xpath("//span[text()='Hair']"));
		builder.moveToElement(hair).perform();
		hair.click();
		
		
		WebElement haircare=driver.findElement(By.xpath("//span[text()='Hair Care']"));
		builder.moveToElement(haircare).perform();
		haircare.click();
		
		
		WebElement shampoo=driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']//div[2]"));
		builder.moveToElement(shampoo).perform();
		shampoo.click();
		
		
		WebElement concern=driver.findElement(By.xpath("//span[text()='Concern']"));
		builder.moveToElement(concern).perform();
		concern.click();
		
		WebElement colorProtection=driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']//div[2]"));
		builder.moveToElement(colorProtection).perform();
		Thread.sleep(1000);
		colorProtection.click();
		
		WebElement filterShampoo=driver.findElement(By.xpath("//span[@class='filter-value']"));
		if(filterShampoo.getText().equals("Shampoo"))
		{
			System.out.println("Shampoo Filter applied");
			
		}
		else
		{
			System.out.println("Shampoo Filter not applied");
		}
		
		WebElement protectShampoo=driver.findElement(By.xpath("(//div[@class='css-1rd7vky'])/div"));
		builder.moveToElement(protectShampoo).perform();
		protectShampoo.click();
		
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> handles=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(handles.get(2));
		
		WebElement size=driver.findElement(By.xpath("//select[@title='SIZE']"));
		builder.moveToElement(size).perform();
		size.click();
		
		
		//WebElement size1=driver.findElement(By.xpath("//div[@class='css-df8xcp']//option[@value='0']"));
		//builder.moveToElement(size1).perform();
		//builder.click(size1).perform();
		
		Thread.sleep(2000);
		WebElement price=driver.findElement(By.xpath("//span[@class='css-1888qy']/following-sibling::span"));
		builder.moveToElement(price).perform();
		price.click();
		
		String price1=price.getText();
		String price2= price1.replaceAll("[^0-9]","");
		System.out.println("L'Oreal Paris Colour Protect Shampoo Price= "+price2);
		
		WebElement addBag=driver.findElement(By.xpath("//span[@class='btn-text']"));
		builder.moveToElement(addBag).perform();
		addBag.click();
		
		
		
		WebElement bag=driver.findElement(By.xpath("//span[@class='cart-count']"));
		builder.moveToElement(bag).perform();
		bag.click();
		
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(frame);
		
		WebElement grandTotal=driver.findElement(By.xpath("(//div[@class='value'])[4]"));
		builder.moveToElement(grandTotal).perform();
		String totalPrice=grandTotal.getText();
		String tp=totalPrice.replaceAll("[^0-9]", "");
		System.out.println("tp="+tp);
		
		
		WebElement proceed=driver.findElement(By.xpath("//span[text()='PROCEED']"));
		builder.moveToElement(proceed).perform();
		proceed.click();
		
		
		WebElement guest=driver.findElement(By.xpath("//button[@class='btn full big']"));
		builder.moveToElement(guest).perform();
		guest.click();
		

		WebElement comparePrice=driver.findElement(By.xpath("(//div[@class='value']/span)[2]"));
		builder.moveToElement(comparePrice).perform();
		String finalPrice=comparePrice.getText();
		String fp=finalPrice.replaceAll("[^0-9]","");
		System.out.println("fp="+fp);
		if(tp.equals(fp))
		{
			System.out.println("Grand Total is equal to Final total");
		}
		else
		{
			System.out.println("Grand Total is not equal to Final total");
		}
		driver.quit();
	
	
	}

}
