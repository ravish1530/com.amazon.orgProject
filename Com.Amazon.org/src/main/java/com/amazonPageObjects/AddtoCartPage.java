package com.amazonPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazonActionDriver.Actoin;
import com.amazonBasePackage.BaseClass;

public class AddtoCartPage extends BaseClass{

	
	Actoin action=new Actoin();
	
	private @FindBy(xpath="//button[@type='button']") WebElement buyproduct;
	
	
	public AddtoCartPage(WebDriver getDriver) {
		
		PageFactory.initElements(getDriver, this);
	}
	

	
	public OrderSummaryPage clickonPlaceOrder() {
		
		action.fluentWait(getDriver(), buyproduct, 20);
		action.scrollByVisibilityOfElement(getDriver(), buyproduct);
		action.JSClick(getDriver(), buyproduct);
		
		return new OrderSummaryPage(getDriver());
		
	}
	
	
}
