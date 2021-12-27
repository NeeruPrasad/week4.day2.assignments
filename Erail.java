package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			ChromeDriver driver=new ChromeDriver(options);

			driver.get("https://erail.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			WebElement source=driver.findElement(By.id("txtStationFrom"));
			source.clear();
			source.sendKeys("ms");
			source.sendKeys(Keys.TAB);
			
			WebElement destiny=driver.findElement(By.id("txtStationTo"));
			destiny.clear();
			destiny.sendKeys("mdu");
			destiny.sendKeys(Keys.TAB);
			
			driver.findElement(By.id("chkSelectDateOnly")).click();		
			
			int rowCount=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
			List<String> trainNames=new ArrayList<String>();
			
			for(int i=1;i<=rowCount;i++)
			{
				int cellCount=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td")).size();
				int j=2;
				String trainName=driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td["+j+"]")).getText();
				trainNames.add(trainName);
				
			}
			
			Set<String> uniqueTrainNames=new LinkedHashSet<String>(trainNames);
			
			if(trainNames.size()==uniqueTrainNames.size())
			{
				System.out.println("There are no duplicate trains");
				
			}
			else
				System.out.println("There are duplicate trains");
			
			
			
			
			
			
			
	}

}
