package com.amazonTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazonBasePackage.BaseClass;
import com.amazonPageObjects.IndexPage;
import com.amazonUtility.Log;
import com.amazonDataProvider.DataProviders;

public class IndexPageTest extends BaseClass{

	private IndexPage indexPage;
	
	
	@Parameters("browser")
	@BeforeMethod 
	public void setup(String browser) {
		launchApp(browser);
		loadConfig();
	}
	
	@AfterMethod
	public void tearDown() {
		//getDriver().quit();
	}
	
	@Test(priority=1)
public void verifyLogo()  {
		
		Log.startTestCase("verifyLogo");
		Log.info("VerifyLogo Test");
		indexPage= new IndexPage(getDriver());
		boolean result=indexPage.verifyLogo();
		Log.info("Logo Is displayed");
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	
	
	@Test(priority=2)
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		Log.info("Verift Title Smoke Test");
		String actTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(actTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Log.endTestCase("verifyTitle");
	}

}
