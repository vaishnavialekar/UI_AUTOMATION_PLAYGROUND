package basic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	WebDriver driver;

	public Utilities(WebDriver driver) {
		this.driver = driver;
	}

	public File source;
	public TakesScreenshot screenshot;

	// Method to take a screenshot
	public void takeScreenshot(String fileName, WebDriver driver) {

		screenshot = (TakesScreenshot) driver;
		source = screenshot.getScreenshotAs(OutputType.FILE);

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotName = "screenshot_" + timestamp + ".png";
		try {
			FileUtils.copyFile(source,
					new File("C:\\Users\\HP\\Pictures\\SelScreenshot\\SS" + fileName + screenshotName));

		} catch (IOException e) {
			System.out.println("Exception while capturing screenshot");
		}

	}
}
