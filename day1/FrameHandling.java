package Week4.day1;

import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class FrameHandling {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert obj = driver.switchTo().alert();
		obj.accept();
		String text = obj.getText();
		System.out.println(text);
		//obj.accept();
	}

}
