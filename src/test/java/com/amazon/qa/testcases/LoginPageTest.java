package com.amazon.qa.testcases;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.utilities.ScreenShot;

@Listeners(com.amazon.qa.utilities.Listener.class)
public class LoginPageTest extends BaseClass
{

	public LoginPage loginpage;
	public LoginPageTest()
	{
		super();
		System.out.println("hello");
		//To call TestBase class constructors
	}
	
	@BeforeMethod
	void setup() throws IOException, InterruptedException
	{
		System.out.println("hell011");
		BaseClass.intialization();
		Thread.sleep(3000);
		//ScreenShot.screenshot("url");
		loginpage=new LoginPage();
			
	}
	
	@Test
	void LoginPage() throws IOException, InterruptedException
	{
		loginpage.mousemove();
		//ScreenShot.screenshot("movesmovement");
		Thread.sleep(3000);
		loginpage.login();
	}
	
	
	@AfterMethod
	void browserclose() throws IOException
	{
		driver.close();
		
	}
	
	
}
