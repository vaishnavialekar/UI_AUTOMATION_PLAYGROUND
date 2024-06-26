package TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import applicationPage.Spicejet_Landing_page;
import basic.Base;

public class TestSpicejet extends Base {
	@Test(priority=1)
	public void Test_checkBox () {
		
		Spicejet_Landing_page checkbox = new Spicejet_Landing_page(driver);
		 Assert.assertEquals(checkbox.Hadling_Checkbox(),true);
	
	}
	@Test(priority=2)
	
	public void Test_Dropdowns() {
		new  Spicejet_Landing_page(driver).Handling_DropdownsTo();
		
	}
	@Test(priority=3)
	public void Test_Calendars() {
		
		new Spicejet_Landing_page(driver).Handling_Calendars();
		
	
			}
	
	
	
	
	}

	

