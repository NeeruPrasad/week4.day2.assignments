package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundSortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);

		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		int rowCount=driver.findElements(By.xpath("//table[@id='table_id']//tr")).size();
		System.out.println("Row count="+rowCount);
		
		int cellCount=driver.findElements(By.xpath("//table[@id='table_id']//tr/th")).size();
		System.out.println(cellCount);
		List<String> cellValue=new ArrayList<String>();
		for(int i=1;i<rowCount;i++)
		{
			int cellCount1=driver.findElements(By.xpath("//table[@id='table_id']//tr/th")).size();
			int j=2;
			
			String value=driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr["+i+"]//td["+j+"]")).getText();
			//System.out.println(value);
			cellValue.add(value);
			
		}
		Collections.sort(cellValue);
		System.out.println("Sorted Employee Names="+cellValue);
		
		Actions mouse=new Actions(driver);
		WebElement header=driver.findElement(By.xpath("(//th[@class='sorting'])[1]"));
		mouse.moveToElement(header).click().perform();
		
		List<String> cellValue1=new ArrayList<String>();
		for(int i=1;i<rowCount;i++)
		{
			int cellCount1=driver.findElements(By.xpath("//table[@id='table_id']//tr/th")).size();
			int j=2;
			
			String value=driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr["+i+"]//td["+j+"]")).getText();
			//System.out.println(value);
			cellValue1.add(value);
			
		}
		System.out.println("Sorted Employee Names after header click="+cellValue1);
		if(cellValue1.equals(cellValue))
		{
			System.out.println("Both sorted and header sorted lists are same");
		}
		else
			System.out.println("Both sorted and header sorted lists are not same");
		
	}
}

