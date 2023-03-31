package Week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://html.com/tags/table");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		List<WebElement> data = driver.findElements(By.xpath("(//table)[1]//tr//td[1]"));
		for(int i=0;i<data.size()-1;i++)
		{
			System.out.println(data.get(i).getText());
			
			
		}
	}

}
