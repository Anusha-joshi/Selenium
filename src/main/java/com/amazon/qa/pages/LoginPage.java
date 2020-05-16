
package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.BaseClass;

public class LoginPage extends BaseClass
{
	
	@FindBy(xpath="//a[@id='nav-link-accountList']//span[@class='nav-icon nav-arrow']")
	@CacheLookup // this stores webelement in the cache memoery, so that we we run it will not fetch xpath from DOM , ISNTEAD it woll take from cache from memory, so that performance will increase
	WebElement moveelement;
	
	@FindBy(xpath="//a[@class='nav-action-button' and @data-nav-ref='nav_signin']//span[text()='Sign in']")
	WebElement siginbutton;
	
	@FindBy(id="ap_email")
	WebElement userid;
	
	@FindBy(id="continue")
	WebElement continuebutton;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement SignInButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		//Above line is for to intialize all this mentioned in FindBy with driver
	}
	
	//Need to define action methods
	
	public void mousemove() throws InterruptedException
	{
	
		Actions a=new Actions(driver);
		a.moveToElement(moveelement).perform();
		Thread.sleep(3000);
	}
	
	public  void login() throws InterruptedException
	{
		
		Thread.sleep(3000);
		siginbutton.click();
		userid.sendKeys(p.getProperty("username"));
		continuebutton.click();
		password.sendKeys("Anu_2020");
		SignInButton.click();
		
	}


			
	

}
