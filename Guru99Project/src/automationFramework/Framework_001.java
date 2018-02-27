package automationFramework;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appModules.SignIn_Action;
import appModules.appSubModules.verifyAddNewCustomerForm.VerifyCityField;
import appModules.appSubModules.verifyAddNewCustomerForm.VerifyMobileField;
import appModules.appSubModules.verifyAddNewCustomerForm.VerifyNameField;
import pageObjects.BaseClass;
import pageObjects.SideMenu;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class Framework_001{
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
  @BeforeTest
  public void beforeMethod() throws Exception {
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
		Log.startTestCase(sTestCaseName);
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		driver = Utils.OpenBrowser(iTestCaseRow);
		
		new BaseClass(driver);  
        }
  
  // This is the starting of the Main Test Case
  @Test
  public void main() throws Exception {
	  // Every exception thrown from any class or method, will be catch here and will be taken care off
	  // For Exception handling please see http://www.toolsqa.com/selenium-webdriver/exception-handling-selenium-webdriver/
	  try{
		  
		SignIn_Action.Execute(iTestCaseRow);
		if(BaseClass.bResult==true){
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
		}else{
			throw new Exception("Test Case Failed because of Verification");
		}
		
	  }catch (Exception e){
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		  Utils.takeScreenshot(driver, sTestCaseName);
		  Log.error(e.getMessage());
		  throw (e);
	  }
		
  }
  /*@Test(dependsOnMethods="main")
  public void clickNewCustomer() throws Exception {
	  SideMenu.lnk_NewCustomer().click();
  }
  @Test(dependsOnMethods="clickNewCustomer")
  public  void cityFieldEmptyCheck() throws Exception {
	  VerifyCityField.cityFieldEmptyCheck();
  }
  @Test(dependsOnMethods="clickNewCustomer")
  public  void cityFieldFirstCharSpaceCheck() throws Exception {
	  VerifyCityField.cityFieldFirstCharSpaceCheck();;
  }
  @Test(dependsOnMethods="clickNewCustomer")
  public  void cityFieldNumericCheck() throws Exception {
	  VerifyCityField.cityFieldNumericCheck();
  }
  @Test(dependsOnMethods="clickNewCustomer")
  public  void cityFieldSpecialCharacterCheck() throws Exception {
	  VerifyCityField.cityFieldSpecialCharacterCheck();
  }*/
  
  @Test(dependsOnMethods="main")
  public void clickNewCustomer() throws Exception {
	  SideMenu.lnk_NewCustomer().click();
  }
  @Test(dependsOnMethods="clickNewCustomer")
  public  void mobileaddressFieldEmptyCheck() throws Exception {
	  VerifyMobileField.mobileFieldEmptyCheck();
  }
  @Test(dependsOnMethods="clickNewCustomer")
  public  void mobileFieldFirstCharSpaceCheck() throws Exception {
	  VerifyMobileField.mobileFieldFirstCharSpaceCheck();;
  }
  @Test(dependsOnMethods="clickNewCustomer")
  public  void mobileFieldNumericCheck() throws Exception {
	  VerifyMobileField.mobileFieldTextCharacterCheck();
  }
  @Test(dependsOnMethods="clickNewCustomer")
  public  void mobileFieldSpecialCharacterCheck() throws Exception {
	  VerifyMobileField.mobileFieldSpecialCharacterCheck();
  }
  
  
  	
  // Its time to close the finish the test case		
  @AfterTest
  public void afterMethod() {
	    // Printing beautiful logs to end the test case
	    Log.endTestCase(sTestCaseName);
	    // Closing the opened driver
	    driver.close();
  		}

}
