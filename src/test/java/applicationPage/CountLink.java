package applicationPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CountLink {

	WebDriver driver;
	WebDriverWait wait;

	public CountLink(WebDriver driver) {
		this.driver = driver;

	}

	public int CountLinksOfHomePage() {

		List<WebElement> CountOfLink = driver.findElements(By.tagName("a"));
		return CountOfLink.size();

	}

	public void BrokenLinks() throws IOException {
				
		List <WebElement> Links = driver.findElements(By.tagName("a"));		
		for (WebElement i : Links ) {			
						
			String link = i.getAttribute("href");
			
			URL url = new URL(link);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();			
			httpURLConnection.connect();
			
		 if (	httpURLConnection.getResponseCode() ==200) {
		
			 System.out.println(link +" "+ "OK");
			 
		 }		 
		 else {
			 
			 System.out.println(link +" "+ "Broken");
		 }
		 		
			}
		
}
	
}