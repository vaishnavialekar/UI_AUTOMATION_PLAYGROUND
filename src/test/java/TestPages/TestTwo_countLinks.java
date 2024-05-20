package TestPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import applicationPage.CountLink;
import applicationPage.HomePage;
import basic.Base;

public class TestTwo_countLinks extends Base {
  @Test
  public void CountNoOfLinks() {
	  
	  CountLink Link = new CountLink (driver);
	  System.out.println(  Link.CountLinksOfHomePage());
	
	  Assert.assertEquals( Link.CountLinksOfHomePage(), 27);
	  
	  
  }
  @Test
  
public void BrokenLinks() throws IOException {
	  
	  CountLink Link = new CountLink (driver);
	  Link.BrokenLinks();
	  
	  
  }
	  
  
}
