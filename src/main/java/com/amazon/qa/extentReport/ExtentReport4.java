package com.amazon.qa.extentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport4 
{

	ExtentHtmlReporter extenthtmlreport;
	ExtentReports er;
	ExtentTest test;
	WebDriver driver;
	
	@BeforeTest
	public void setExtent()
	{
		
		System.out.println("hello");
		String dat=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		extenthtmlreport=new ExtentHtmlReporter("D:/RESTAPI/SeleniumPractic/test-output/myhtmlreport+dat.html");
		
		  extenthtmlreport.config().setDocumentTitle("Automation report"); //Title of
		  extenthtmlreport.config().setReportName("Functional");// set the
		  extenthtmlreport.config().setTheme(Theme.DARK);
		  er=new ExtentReports();
		  er.attachReporter(extenthtmlreport); er.setSystemInfo("Name","Anusha Joshi"); 
		  er.setSystemInfo("Environment", "QA");
		 
		
	}
	
	@BeforeMethod
	public void setup()
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
	driver.get("https://www.amazon.com");
	}
	
	@Test(enabled=false)
	public void testi()
	{
		test=er.createTest("Testing title");
		String s=driver.getTitle();
		System.out.println(s);
		Assert.assertTrue(true);
	}
	
	@Test(enabled=false)
	public void urltest()
	{
		test=er.createTest("Url testing");
		String s1=driver.getCurrentUrl();
		System.out.println(s1);
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void newWindow() throws InterruptedException
	{
		test=er.createTest("newwindowtest");

	//String right=Keys.chord(Keys.CONTROL,Keys.RETURN);
WebElement rightclick=driver.findElement(By.linkText("Today's Deals"));
Actions a=new Actions(driver);
	a.contextClick(rightclick).build().perform();
	a.sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
		
		
	}
	
	@AfterMethod()
	public void teardown(ITestResult res) throws IOException
	{
	
		if(res.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,"status is failed"+ res.getName()); //to add name in the report
			test.log(Status.FAIL,"status is failed"+ res.getThrowable());
			System.out.println(res.getName());
			
			
		}
		
		else if(res.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,"status is passed"+ res.getName()); 
			String adpath=screenshot(res.getTestName(),driver);
			test.addScreenCaptureFromPath(adpath);
		}
		
		//driver.close();
	}
	
	@AfterTest
	public void end()
	{
	
		er.flush(); //to close everything
	}
	
	
	public static String screenshot(String screenshotname, WebDriver driver) throws IOException {
		
		String DateName=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination="D:\\RESTAPI\\SeleniumPractic\\target\\ScreenShot\\"+screenshotname+"_"+DateName+".png";
		File f1=new File(destination);
		FileUtils.copyFile(f, f1);
		return destination;
		
		
	}



	
}
