package com.amazon.qa.datafiles;

import org.testng.annotations.Test;

public class DataProvider 
{

	@Test
	public void ma()
	{
	Xls_Reader r=new Xls_Reader("D:\\RESTAPI\\SeleniumPractic\\src\\main\\java\\com\\amazon\\qa\\datafiles\\Data.xls");
	for(int i=1;i<r.getRowCount("Data");i++)
	{
		for(int j=0;i<r.getColCount();j++)
		{
			String s=r.getCell(i, j, "Data");
			System.out.print(s);
		}
	}
	}
}
