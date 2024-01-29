 package com.amazonPageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazonBasePackage.BaseClass;
import com.amazonActionDriver.Actoin;

public class ProductDescriptionPage extends BaseClass {

	
	Actoin action=new Actoin();
	
	
	
	
private	@FindBy(xpath="//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]") WebElement addtocart;

	public ProductDescriptionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	public AddtoCartPage selectProduct() throws InterruptedException {
		
		action.fluentWait(getDriver(), addtocart, 30);
		action.JSClick(getDriver(), addtocart);
		
		return new AddtoCartPage(getDriver());
	}
}
