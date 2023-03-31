package Week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window=new ArrayList<String>(windowHandles);
		String title = driver.switchTo().window(window.get(1)).getTitle();
		System.out.println(title);
		driver.close();
		String title2 = driver.switchTo().window(window.get(0)).getTitle();
		System.out.println(title2);
		driver.quit();
	    
	}

}
