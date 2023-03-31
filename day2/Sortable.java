package Week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		WebElement Item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement Item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement Item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement Item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		
		Actions sort=new Actions(driver);
		sort.dragAndDrop(Item5, Item1).perform();
		Thread.sleep(2000);
		sort.dragAndDrop(Item3, Item2).perform();
	}

}
