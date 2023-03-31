package Week4.day2;

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

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://www.myntra.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement men = driver.findElement(By.xpath("(//a[@class='desktop-main'])[1]"));
		Actions mark=new Actions(driver);
		mark.moveToElement(men).perform();
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		String text = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//label[@class='common-customCheckbox vertical-filters-label'][1]")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//div/input[@Class='FilterDirectory-searchInput']")).sendKeys("Duke");
		driver.findElement(By.xpath("(//label[@class=' common-customCheckbox'])")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		Thread.sleep(2000);
		List<WebElement> findElements = driver.findElements(By.xpath("//div/h3[@class='product-brand']"));
		for(int i=0;i<findElements.size();i++)
		{
		System.out.println(findElements.get(i).getText());
		}
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']")).click();
	    driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
	    String price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
	    System.out.println("The first item price : "+price);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Duke Men Navy Blue Puffer Jacket']")).click();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(listWindow.get(1));
		Thread.sleep(2000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest =new File("./snap/img1.png");
		FileUtils.copyFile(source, dest);
		driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-wishlist pdp-button')]")).click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

}
