package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reusableComponents.PropertiesOperation;

public class ExtentReport {
	
	static ExtentReports report;	
	
	public static ExtentReports setupExtentReport() throws Exception {
		
		SimpleDateFormat formatStyle=new SimpleDateFormat("dd-MM-yyyy_mm-ss");
		Date d=new Date();
		String date=formatStyle.format(d);
		
		String filePath=System.getProperty("user.dir")+"/Reports/ExtentReports/ExecutionReport_"+date+".html";
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(filePath);
		report=new ExtentReports();
		report.attachReporter(sparkReporter);
		
		sparkReporter.config().setDocumentTitle("Document Title: Actitime");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setReportName("Report Name: Test Failure Reports");
		
		//adding static content
		report.setSystemInfo("Executed on Environment", PropertiesOperation.getPropertyDataByKey("url"));
		report.setSystemInfo("Executed on Browser", PropertiesOperation.getPropertyDataByKey("browser"));
		report.setSystemInfo("Executed on Operating System", System.getProperty("os.name"));	//check os name
		report.setSystemInfo("Executed User", System.getProperty("user.name"));
		
		return report;
	}

}
