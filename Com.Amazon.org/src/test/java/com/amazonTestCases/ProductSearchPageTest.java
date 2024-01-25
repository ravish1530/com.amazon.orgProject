package com.amazonTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazonPageObjects.IndexPage;
import com.amazonPageObjects.ProductSearchPage;
import com.amazonUtility.Log;
import com.amazonBasePackage.BaseClass;
import com.amazonDataProvider.DataProviders;

public class ProductSearchPageTest extends BaseClass {

	private IndexPage indexPage;	 
    private ProductSearchPage product;
	
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
	
	@Test(dataProvider="searchProduct", dataProviderClass=DataProviders.class)
	public void verifyProductlist(String productName) {
		
		Log.startTestCase("verifyProductlist");
		indexPage= new IndexPage(getDriver());
		
		Log.info("User clicked on searchbox");
		product=indexPage.searchProduct(productName);
		
		product.productlist();
		product.productDescription();
		product.productPrices();
		
		boolean result=product.isProductAvailable();
		
		
		Assert.assertTrue(result);
		
		Log.endTestCase("verifyProductlist");
	}
	
	
}
