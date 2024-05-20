package basic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	WebDriverWait wait;

	
	@BeforeClass
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("elementId")));

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("http://www.uitestingplayground.com/");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void CloseBrowser() {

		System.out.println("close");
	}

}