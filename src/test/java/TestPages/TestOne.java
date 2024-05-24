package TestPages;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import applicationPage.HomePage;
import basic.Base;
import basic.Utilities;

public class TestOne extends Base {

	@Test(groups = { "auto" })
	public void Test_URL_and_PageName() {

		System.out.println("Running URL is : " + driver.getCurrentUrl());
		System.out.println("Title of Page is " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "UI Test Automation Playground");

	}

	@Test(priority = 2)
	public void Test_stringVerification() {

		HomePage Text = new HomePage(driver);
		Assert.assertEquals(Text.StringCapture_homePage(),
				"The purpose of this website is to provide a platform for sharpening UI test automation skills. Use it to practice with your test automation tool. Use it to learn test automation techniques.");

	}

	@Test(priority = 3)
	public void Test_DynamicID_Verification() {

		HomePage Text = new HomePage(driver);
		Assert.assertEquals(Text.DynamicID(), "http://www.uitestingplayground.com/dynamicid");

	}

	@Test(priority = 4)
	public void Test_ClassAttribute() {

		HomePage Text = new HomePage(driver);

		Assert.assertEquals(Text.ClassAttribute(), "Primary button pressed");

	}

	@Test(priority = 5)
	public void Test_DelayedResponse() {

		HomePage Text = new HomePage(driver);

		Text.DelayRespons();

	}
	@Test(priority = 6)
	public void ScrollerTest() {
		HomePage Text = new HomePage(driver);
		Text.ScrolltoFooter();
		
		
	}

}
