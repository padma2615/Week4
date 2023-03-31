package Week4.day2;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assign1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("(//table[@class='table table-bordered table-striped table-hover w-auto'])//tr//td[1]"));
		System.out.println(findElements.size());
		for(int i=0;i<findElements.size();i++)
		{
		System.out.println(findElements.get(i).getText());

	}
		Set<WebElement> obj=new HashSet<WebElement>(findElements);
		System.out.println(obj.size());
		if(findElements.size()==obj.size())
		{
			System.out.println("No Duplicate");
		}
		else
		{
			System.out.println("Duplicate Present");
		}
	}
}


