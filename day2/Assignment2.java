package Week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment2 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> findElements = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
		System.out.println(findElements.size());
		List<WebElement> findElements2 = driver.findElements(By.xpath("//table[@class='attributes-list']//tr//td"));
		System.out.println(findElements2.size());

	}

}
