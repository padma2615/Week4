package Week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assign4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://leafground.com/table.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> obj = driver.findElements(By.xpath("//div[@class='col-12']//tr//td"));
		for(int i=0;i<obj.size();i++)
		{
			System.out.println(obj.get(i).getText());
			
		}
		List<WebElement> obj1 = driver.findElements(By.xpath("//div[@class='col-12']//tr//td[2]"));
		for(int i=0;i<obj1.size();i++)
		{
			System.out.println(obj1.get(i).getText());
	}
		
}
}