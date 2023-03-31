package Week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class drag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement src = driver.findElement(By.id("form:conpnl"));
		Actions drag=new Actions(driver);
		
		WebElement src1 = driver.findElement(By.xpath("//div[@id='form:drag']"));
		WebElement des = driver.findElement(By.xpath("//div[@id='form:drop_header']"));
		Actions obj=new Actions(driver);
		drag.dragAndDrop(src, des).perform();
		obj.dragAndDrop(src1, des).perform();
		
		
		
		

	}

}
