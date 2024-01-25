package com.amazonTestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazonBasePackage.BaseClass;
import com.amazonDataProvider.DataProviders;
import com.amazonPageObjects.AddtoCartPage;
import com.amazonPageObjects.IndexPage;
import com.amazonPageObjects.OrderSummaryPage;
import com.amazonPageObjects.ProductDescriptionPage;
import com.amazonPageObjects.ProductSearchPage;
import com.amazonUtility.Log;

public class OrderSummaryPageTest extends BaseClass{

	
	
	private IndexPage indexPage;	 
    private ProductSearchPage product;
    private ProductDescriptionPage productdescription;
    private AddtoCartPage addtocart;
    private OrderSummaryPage ordersummary;
    
    
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
	
	@Test(dataProvider="searchProduct",dataProviderClass=DataProviders.class)
	public void verifyProduct(String productName) throws InterruptedException {
		
		Log.startTestCase("verifyProduct");
		indexPage= new IndexPage(getDriver());
		
		Log.info("User clicked on searchbox");
		product=indexPage.searchProduct(productName);
		
		productdescription=	product.clickonProduct();
		addtocart=productdescription.selectProduct();
		ordersummary=addtocart.clickonPlaceOrder();
		ordersummary.buyProduct();
		ordersummary.clickonContinuebtn();
		Log.info("Product get displayed");
		Log.endTestCase("verifyProduct");
	}
	
	
}
