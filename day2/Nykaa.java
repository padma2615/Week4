package Week4.day2;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement first = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions brand=new Actions(driver);
		brand.moveToElement(first).perform();
		driver.findElement(By.xpath("//div[@id='scroller-container']/div[7]/a[1]")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']/div[2]")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//img[@class='css-11gn9r6']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class=' css-d3w64v'])[1]")).click();
		String text2 = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
		Thread.sleep(1000);
		System.out.println("MRP:"+text2);
		driver.findElement(By.xpath("(//button[@class=' css-1qvy369'])[1]")).click();
		driver.findElement(By.xpath("(//button[@class='css-g4vs13'])")).click();
		driver.switchTo().frame(0);
		
		String text3 = driver.findElement(By.xpath("//span[text()='Proceed']")).getText();
		Thread.sleep(2000);
		System.out.println("GrandTotal:"+text3);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		String text4 = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
		if(text2==text4)
		{
			System.out.println("Same total");
		}
		else
		{
			System.out.println("different amount");
		}
		driver.quit();
		
		
		
				

	}

}
