package testBase;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {
	
	private static ExtentFactory instance=new ExtentFactory();
	
	//constructor making private to have singleton class concept
	private ExtentFactory() {
		
	}
	
	//method to get instance of singleton class to have global access
	public static ExtentFactory getInstance() {
		return instance;
	}
	
	//factory design pattern=defining separate factory methods
	//for creating objects and create the objects by calling those methods
	
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}
	
	public ExtentTest getExtentTest() {
		return extentTest.get();
	}
	
	public void removeExtentObject() {
		extentTest.remove();	
	}
}