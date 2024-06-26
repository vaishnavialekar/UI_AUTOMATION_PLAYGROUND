package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	WebDriverWait wait;
	public ExtentReports exReport;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	public Properties prop;
	public TakesScreenshot screenshot;
	public File source;

	public WebDriver InitializeDriver() throws IOException {

		prop = new Properties();

		InputStream input = new FileInputStream("global.properties"); // reading property file
		prop.load(input);

		exReport = new ExtentReports();
		spark = new ExtentSparkReporter("Spark.html");
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Functional Testing");
		spark.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
		spark.config().setEncoding("utf-8");
		exReport.attachReporter(spark);

		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser"); // selecting which browser to use if given from maven command or property
												// file

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
		return driver;

	}

	public void TakeScreenshot(String TestName, WebDriver driver) throws IOException {

		screenshot = (TakesScreenshot) driver;
		source = screenshot.getScreenshotAs(OutputType.FILE);

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotName = "screenshot_" + timestamp + ".png";
		File File = new File("C:\\Users\\HP\\Pictures\\SelScreenshot\\SS" + TestName + screenshotName);
		FileUtils.copyFile(source,File);
		

		
	}

	@BeforeClass
	public void LaunchBrowser() throws IOException {
		driver = InitializeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void CloseBrowser() {
		// driver.close();
		exReport.flush();
		System.out.println("close");
	}

}