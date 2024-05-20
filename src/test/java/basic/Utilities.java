package basic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	WebDriver driver;

	public Utilities(WebDriver driver) {
		this.driver = driver;
	}

	// Method to take a screenshot
	public void takeScreenshot(String fileName) {
		try {

			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("C:\\Users\\HP\\Pictures\\SelScreenshot\\SS" + fileName + ".jpeg"));

		} catch (IOException e) {
			System.out.println("Exception while capturing screenshot");
		}

	}
}
