package basic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	public void LaunchBrowser() throws IOException {

		// String browser = null;

		Properties prop = new Properties();

		InputStream input = new FileInputStream("global.properties"); // reading property file
		prop.load(input);
		
		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser"); // selecting which browser to use if given from maven command or property file

		browser = browser.toUpperCase(); // upper casing as if someone enter small case or upper case will not matter

		switch (browser) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("elementId")));

		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("http://www.uitestingplayground.com/");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void CloseBrowser() {

		System.out.println("close");
	}

}