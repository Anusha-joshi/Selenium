package com.amazon.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.amazon.qa.base.BaseClass;

public class ScreenShot extends BaseClass

{

	public static void screenshot(String screenshotname, WebDriver driver) throws IOException {
		
		String DateName=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File f1=new File("D:\\RESTAPI\\SeleniumPractic\\target\\ScreenShot\\"+"_"+screenshotname+"_"+DateName+".png");
		FileUtils.copyFile(f, f1);
		
		
	}
	
}
