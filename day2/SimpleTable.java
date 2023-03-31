package Week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimpleTable {
	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS");
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU");
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> column = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr//td[2]"));
		System.out.println(column.size());
		for(int i=0;i<column.size();i++)
		{
			System.out.println(column.get(i).getText());
		}
	}

}
