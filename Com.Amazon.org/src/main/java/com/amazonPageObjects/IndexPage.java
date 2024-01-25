package com.amazonPageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.amazonBasePackage.BaseClass;
import com.amazonActionDriver.Actoin;

public class IndexPage extends BaseClass{

	Actoin action=new Actoin();
	
   @FindBy(xpath="//img[@src=\"https://static-assets-web.flixcart.com/batman-returns/batman-returns/p/images/fkheaderlogo_exploreplus-44005d.svg\"]") WebElement logo;
   
   @FindBy(xpath="//input[@title=\"Search for Products, Brands and More\"]") WebElement searchbox;
   
   @FindBy(xpath="//button[@type=\"submit\"]") WebElement searchbtn;
   
   
   
   
  
   public IndexPage(WebDriver getDriver) {
	   
	   PageFactory.initElements(getDriver(), this);
   }
   
   
   public boolean verifyLogo() {
	   
	  return  logo.isDisplayed();
   }
   
   public ProductSearchPage searchProduct(String productName) {
	   
	   action.fluentWait(getDriver(), searchbox, 40);
	   action.JSClick(getDriver(), searchbox);
	   action.type(searchbox, productName);
	   action.JSClick(getDriver(), searchbtn);
	   
	   return new ProductSearchPage(getDriver());
	  
   }
   
   public String verifyTitle() {
	   
	   String mytitle=getDriver().getTitle();
	   return mytitle;
   }
   
   
}
