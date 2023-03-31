package Week4.day1;

import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PromptAlert {
public static void main(String[] args) throws InterruptedException {
	
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	ChromeDriver driver=new ChromeDriver(option);
	driver.get("https://www.leafground.com/alert.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
	Alert obj = driver.switchTo().alert();
	String text = obj.getText();
	System.out.println(text);
	obj.sendKeys("padma");
	Thread.sleep(2000);
	obj.accept();
	 String text3 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
	
	System.out.println(text3);
	
}
}
