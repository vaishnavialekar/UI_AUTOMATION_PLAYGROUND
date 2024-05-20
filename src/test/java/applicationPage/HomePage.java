package applicationPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	 WebDriver driver;
	 WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);


	}
	
	@FindBy (xpath = "//div[@role='alert']/span") WebElement AlertText;
	@FindBy(linkText ="Dynamic ID") WebElement DynamicIDElement;
	@FindBy (linkText="Home") WebElement HomePageRedirection;
	
	@FindBy (linkText = "Class Attribute") WebElement  ClassAttributeElement;
	@FindBy (xpath="//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]") WebElement ClassAttributeButtonElement;
	@FindBy (linkText="Load Delay") WebElement LoadDelayElement;
	@FindBy (xpath = "button[@type='button']") WebElement LoadDelayButtonElement;

	public String StringCapture_homePage() {

		String PurposeDisclaimer1 = AlertText.getText();		
		return PurposeDisclaimer1;	
}
	
	public String DynamicID() {
		
		DynamicIDElement.click();
		 String CurrentURL= driver.getCurrentUrl();
		//driver.findElement(By.xpath("//button[@type='button']")).click();
		 HomePageRedirection.click();
		return CurrentURL;
	}
	
	public String ClassAttribute() {
		
		ClassAttributeElement.click();
		ClassAttributeButtonElement.click();
		String AlertTEXT=  driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		HomePageRedirection.click();
		return AlertTEXT;
		
	}
		
	
	
	public void DelayRespons() {
		
		LoadDelayElement.click();
			
		LoadDelayButtonElement.click();
		HomePageRedirection.click();
		
	}
	
	}
	
	
	
	
	
	
	

