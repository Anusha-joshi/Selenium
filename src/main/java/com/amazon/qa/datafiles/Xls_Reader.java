package com.amazon.qa.datafiles;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import jxl.Sheet;
import jxl.biff.WorkbookMethods;
public class Xls_Reader 
{
	public WebDriver driver;

	@Test(dataProvider="mydate")
	public void testdata(String UserName,String Password,String Id)
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\SeleniumServer\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//a[@class='_3Ep39l']")).click();
		
		driver.findElement(By.xpath("//a[@class='oZoRPi']")).click();
		
		
		
		
	}

	@DataProvider(name="mydate")
	public static Object[][] loginData() {
		Object[][] arrayObject = getExcelData("D:\\RESTAPI\\SeleniumPractic\\src\\main\\java\\com\\amazon\\qa\\datafiles\\Data.xls","Data");
		return arrayObject;
	}
	
	
	
	
	
		public static String[][] getExcelData(String fileName, String sheetName) {
			String[][] arrayExcelData = null;
			try {
				FileInputStream fs = new FileInputStream(fileName);
				Workbook wb = Workbook.getWorkbook(fs);
				Sheet sh = wb.getSheet(sheetName);

				int totalNoOfCols = sh.getColumns();
				int totalNoOfRows = sh.getRows();
				
				arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
				
				for (int i= 1 ; i < totalNoOfRows; i++) {

					for (int j=0; j < totalNoOfCols; j++) {
						arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
					}

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				e.printStackTrace();
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				
			
			return arrayExcelData;
		}
	
	
	
}


