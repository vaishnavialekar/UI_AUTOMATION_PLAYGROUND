package applicationPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Spicejet_Landing_page {
	WebDriver driver;
	WebDriverWait wait;

	public Spicejet_Landing_page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[name()='circle'])[3]")
	WebElement RoundTrip;
	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement FromTrip;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement ToTrip;
	@FindBy(xpath = "//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79'][normalize-space()='June 2024']")
	static WebElement monthyearvalue;

	@FindBy(xpath = "(//*[name()='path'])[15]")
	static WebElement nextCalendar;

	@FindBy(xpath = "(//div[text()='22'])[1]")
	static WebElement CalendarDate;
//	
//	@FindBy(xpath="(//*[name()='path'])[15]") WebElement nextCalendar;
//	@FindBy(xpath="(//*[name()='path'])[15]") WebElement nextCalendar;
//	@FindBy(xpath="(//*[name()='path'])[15]") WebElement nextCalendar;
//	@FindBy(xpath="(//*[name()='path'])[15]") WebElement nextCalendar;
//	@FindBy(xpath="(//*[name()='path'])[15]") WebElement nextCalendar;
//	@FindBy(xpath="(//*[name()='path'])[15]") WebElement nextCalendar;

	public boolean Hadling_Checkbox() {

		RoundTrip.click();
		return RoundTrip.isSelected();

	}

	public void Handling_DropdownsTo() {
		FromTrip.click();
		FromTrip.click();
		FromTrip.sendKeys("Nagp");
		ToTrip.click();
		ToTrip.click();
		ToTrip.sendKeys("Beng");

	}

	public void Handling_Calendars() {

		SelectDate("July", "2024", "23");

	}

	public static String[] getmonthyearVal(String monthyear) {

//		String month = monthyear.split(" ")[0].trim();
//		String year = monthyear.split(" ")[1].trim();
		return monthyear.split(" ");

	}

	public static void SelectDate(String month, String year, String date) {

		while (!(month.equals("July") && year.equals("2024"))) {

			nextCalendar.click();
			String monthyear = monthyearvalue.getText();
			getmonthyearVal(monthyear);
		}
		CalendarDate.click();

	}

}
