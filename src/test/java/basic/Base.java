package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;

	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();

		 driver = new ChromeDriver();
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("elementId")));

		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 		 
		driver.get("http://www.uitestingplayground.com/");
		driver.manage().window().maximize();
	
	}

	@AfterTest
	public void CloseBrowser() {

		System.out.println("close");
	}

}