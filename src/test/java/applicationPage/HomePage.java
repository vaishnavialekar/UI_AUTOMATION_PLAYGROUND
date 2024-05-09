package applicationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	 WebDriver driver;

	
	public HomePage(WebDriver driver) {
		this.driver = driver;

	}



	public String StringCapture_homePage() {

		String PurposeDisclaimer1 = driver.findElement(By.xpath("//div[@role='alert']/span")).getText();		
		return PurposeDisclaimer1;
	
}
	public String DynamicID() {
		
		driver.findElement(By.linkText("Dynamic ID")).click();
		 String CurrentURL= driver.getCurrentUrl();
		//driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.linkText("Home")).click();
		return CurrentURL;
	}
	

}