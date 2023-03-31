package Week4.day2;

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

public class Oneplus {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		System.out.println(findElements.get(0).getText());
		String text4 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		String text = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println("Number of customers:"+text);
		String text2 = driver.findElement(By.xpath("(//span[@class='a-size-base'])[1]")).getText();
		System.out.println("Customer rating:"+text2);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		File screenshotAs=driver.getScreenshotAs(OutputType.FILE);
		File file = new File("./snap/img.png");
		FileUtils.copyFile(screenshotAs, file);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='a-button a-spacing-small a-button-primary a-button-icon natc-enabled']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']")).click();
		driver.findElement(By.id("nav-cart-count")).click();
		String text3 = driver.findElement(By.id("sc-subtotal-amount-buybox")).getText();
		if(text4==text3)
		{
			System.out.println("equal");
		}
		else
		{
			System.out.println("different");
		}
		
	}

}
