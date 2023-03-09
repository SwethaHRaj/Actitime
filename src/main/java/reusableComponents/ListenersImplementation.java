 package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testBase.ExtentFactory;
import testBase.ExtentReport;
import testBase.WebDriverFactory;

public class ListenersImplementation implements ITestListener{  //continue
	
	static ExtentReports report;
			ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtentTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().log(Status.PASS, "Test Case:"+result.getMethod().getMethodName()+" is Passed");
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, "Test Case:"+result.getMethod().getMethodName()+" is Failed");
		ExtentFactory.getInstance().getExtentTest().log(Status.FAIL, result.getThrowable());
		
		SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		Date date=new Date();
		String formatedDate=format.format(date);                                            
		                                                               
		//String random=result.getName();
		TakesScreenshot t=(TakesScreenshot) WebDriverFactory.getInstance().getWebDriver();
		File src=t.getScreenshotAs(OutputType.FILE);
		String filePath=System.getProperty("user.dir")+"/Reports/Screenshots/Screenshot_"+formatedDate+".png";
		File des=new File(filePath);
		try {
			FileUtils.copyFile(src, des);
			
		} 
		catch (IOException e) {
		}	
		try {
			ExtentFactory.getInstance().getExtentTest().addScreenCaptureFromPath(filePath,"failure screenshot");
			ExtentFactory.getInstance().removeExtentObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtentTest().log(Status.SKIP, "Test Case:"+result.getMethod().getMethodName()+" is Skipped");
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}    

	@Override
	public void onStart(ITestContext context) {
		try {
			report=ExtentReport.setupExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	
}
