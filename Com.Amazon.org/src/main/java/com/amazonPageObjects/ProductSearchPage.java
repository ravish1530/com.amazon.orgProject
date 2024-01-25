package com.amazonPageObjects;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazonBasePackage.BaseClass;
import com.amazonActionDriver.Actoin;

public class ProductSearchPage extends BaseClass {


	Actoin action=new Actoin();
	

	@FindAll({
			
	@FindBy(xpath="//div[@class=\"_4rR01T\"]") 
	
   
	})List<WebElement> productList;
	
	@FindAll({
		
		@FindBy(xpath="//div[@class=\"col col-7-12\"]")
	})List<WebElement> productdescription;

	@FindAll({
		
		@FindBy(xpath="//div[@class=\"_30jeq3 _1_WHN1\"]")
	})
	List<WebElement> prices;
	
	@FindBy(xpath="//div[text()=\"OPPO Reno11 5G (Wave Green, 256 GB)\"]") WebElement product;
	
	public ProductSearchPage(WebDriver getDriver) {

		PageFactory.initElements(getDriver(), this);
	}

	public List<WebElement> productlist() {

		action.pageLoadTimeOut(getDriver(), 60);
		List<WebElement> lis=productList;
        System.out.println("Products on First Page:"+productList.size());
	

		return lis;
	}


public List<WebElement> productDescription(){
	
	List<WebElement> products=productdescription;
	
	for(WebElement desc:products) {
		
		System.out.print(desc.getText());
	}
	
	System.out.println(" ");
	
	return products;
}
	

public List<WebElement> productPrices(){
	
	List<WebElement> price=prices;
	
	for(WebElement p:price) {
		
		System.out.println(p.getText());
	}
	
	System.out.println(" ");
	return price;
}


  

	public ProductDescriptionPage clickonProduct() {
		
		action.JSClick(getDriver(), product);
		
		 return new ProductDescriptionPage(getDriver());
	}
	
   public boolean isProductAvailable() {
		
		return action.isDisplayed(getDriver(), product);
	}

}
