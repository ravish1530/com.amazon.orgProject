package com.amazonPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazonActionDriver.Actoin;
import com.amazonBasePackage.BaseClass;

public class OrderSummaryPage extends BaseClass{

	
	
	
Actoin action=new Actoin();
	
    private @FindBy(xpath="//input[@class=\"_2IX_2- _3umUoc _3mctLh _17N0em\"]") WebElement Email;

    private @FindBy(xpath="//input[@class=\"_2IX_2- _17N0em\"]") WebElement password;

	private @FindBy(xpath="//button[@class=\"_2KpZ6l _1seccl _3AWRsL\"]") WebElement Continuebtn;
	
	private @FindBy(xpath="//button[@class='_2KpZ6l _1uR9yB _3dESVI']") WebElement Acceptbtn;

	public OrderSummaryPage(WebDriver getDriver) {
		
		PageFactory.initElements(getDriver, this);
	}
	
	public void buyProduct() {
		
//		action.fluentWait(getDriver(), Email, 10);
//		action.type(Email, email);
//		action.type(password, pwd);
		
	}
	
	public void clickonContinuebtn() {
		
		action.fluentWait(getDriver(), Continuebtn, 10);
		action.JSClick(getDriver(), Continuebtn);
		action.JSClick(getDriver(), Acceptbtn);
	}
}
