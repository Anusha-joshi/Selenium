package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.qa.utilities.TimeUtils;
import com.amazon.qa.utilities.WebEvenListner;

public class BaseClass 
{

	public static WebDriver driver;
	public static Properties p;
	public static EventFiringWebDriver e;
	public static WebEvenListner l;
	
	public BaseClass()
	{
		 p=new Properties();
		try {
			FileInputStream fs=new FileInputStream("D:/RESTAPI/SeleniumPractic/src/main/java/com/amazon/qa/config/config.properties");
			p.load(fs);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void intialization()
	{
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\SeleniumServer\\chromedriver.exe");
			driver=new ChromeDriver();		
			
			
			/*
			 * e=new EventFiringWebDriver(driver); l=new WebEvenListner(); e.register(l);
			 * driver=e;
			 */
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(p.getProperty("url"));
		
		
	}
}
   