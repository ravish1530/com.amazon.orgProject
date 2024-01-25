package com.amazonTestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazonBasePackage.BaseClass;
import com.amazonDataProvider.DataProviders;
import com.amazonPageObjects.AddtoCartPage;
import com.amazonPageObjects.IndexPage;
import com.amazonPageObjects.ProductDescriptionPage;
import com.amazonPageObjects.ProductSearchPage;
import com.amazonUtility.Log;

public class ProductDescriptionTest extends BaseClass {

	
	
	private IndexPage indexPage;	 
    private ProductSearchPage product;
    private ProductDescriptionPage productdescription;
   
    
    
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
	public void productdescriptionTest(String productName) throws InterruptedException {
		
		Log.startTestCase("productdescriptionTest");
		indexPage= new IndexPage(getDriver());
		
		Log.info("User clicked on searchbox");
		product=indexPage.searchProduct(productName);
		
		product.productlist();
		product.productDescription();
		product.productPrices();
		
		
		Log.info("Product get displayed");
		Log.endTestCase("productdescriptionTest");
	}
}
