package test1;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.ListOfUsersPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.ManageDepartmentsPageObjects;
import reusableComponents.ExcelOperations;
import testBase.BaseClass;
import testBase.ExtentFactory;

public class EndToEnd extends BaseClass{
	
	LoginPageObjects loginPageObject=new LoginPageObjects();
	HomePageObjects homePageObject=new HomePageObjects();
	ListOfUsersPageObjects listOfUsersPageObject=new ListOfUsersPageObjects();
	ManageDepartmentsPageObjects manageDepartmentsPageObject=new ManageDepartmentsPageObjects();
	
	ExcelOperations excel=new ExcelOperations("Sheet1");
	
	
	@Test(dataProvider = "data")
	public void test1(Object ob) throws Exception {
		
		HashMap<String,String> testData=(HashMap<String, String>) ob;
		
		ExtentFactory.getInstance().getExtentTest().info("test data for this test is "+testData);
		
		loginPageObject.login(testData.get("username"), testData.get("password"));
		//homePageObject.checkHomePageNavigation();
		Thread.sleep(1000);
		homePageObject.clickOnMenu(testData.get("Menu"));
		Thread.sleep(1000);
		listOfUsersPageObject.checkListOfUsersPageNavigation();
		Thread.sleep(1000);
		listOfUsersPageObject.clickOnButton(testData.get("Button"));
		Thread.sleep(1000);
		manageDepartmentsPageObject.createDepartmentAndValidate(testData.get("DepartmentName"));
	}     
	
	@DataProvider(name="data") 
	public Object[][] test1DataProvider() throws Exception {
		Object[][] ob=new Object[excel.getRowCount()][1];
		HashMap<String,String> hm;
		for(int i=0;i<excel.getRowCount();i++) {
			hm=excel.getTestDataInMap(i+1);
			ob[i][0]=hm;
		}
		return ob;
	
	}
}

	
