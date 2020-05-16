package com.amazon.qa.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener implements  ITestListener

{

	public void OnTestStart(ITestResult r)
	{
		
		System.out.println("Test Started");
		
	}
	
	public void OnTestSuccess(ITestResult r)
	{
		System.out.println("Test passed");
	}
	
	public void OnTestFailure(ITestResult r)
	{
		System.out.println("Test passed");
	}
	
}
