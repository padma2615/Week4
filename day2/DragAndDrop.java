package Week4.day2;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
@Test
public class DragAndDrop {

	public  void drag()
	{
		// TODO Auto-generated method stub
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get(" https://jqueryui.com/droppable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement des = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions x=new Actions(driver);
		x.dragAndDrop(src, des).perform();
		

	}

}
