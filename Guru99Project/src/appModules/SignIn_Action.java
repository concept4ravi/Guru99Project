package appModules;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.Home_Page;
import pageObjects.ManagerHome_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

// This is called Modularization, when we club series of actions in to one Module
// For Modular Driven Framework, please see http://www.toolsqa.com/modular-driven/   
public class SignIn_Action {
	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
	// iTestcaseRow is passed as an Argument to this method, so that it can used inside this method
	// For use of Functions & Parameters, please see http://www.toolsqa.com/function-parameters/
	public static void Execute(int iTestCaseRow) throws Exception{
		// Storing the UserName in to a String variable and Getting the UserName from Test Data Excel sheet
		// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
		// Constant.Col_UserName is the column number for UserName column in the Test Data sheet
		// Please see the Constant class in the Utility Package
		// For Use of Constant Variables, please see http://www.toolsqa.com/constant-variables/
		String sUserUId = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
		// Here we are sending the UserName string to the UserName Textbox on the LogIN Page
		// This is call Page Object Model (POM)
		// For use of POM, please see http://www.toolsqa.com/page-object-model/
		Home_Page.txtbx_userId().sendKeys(sUserUId);
		// Printing the logs for what we have just performed
		Log.info(sUserUId+" is entered in UserId text box" );

		String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
		Home_Page.txtbx_Password().sendKeys(sPassword);
		Log.info(sPassword+" is entered in Password text box" );

		Home_Page.btn_Login().click();
		Log.info("Click action is performed on Login button");
		if(Utils.isAlertPresent()){
			Utils.acceptAlert();
			Log.info("A popup 'User or Password is not Valid' is shown");
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
		}else {
			String title = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Title);
			Assert.assertEquals(title, ManagerHome_Page.getTitle());
			Log.info("Title Verified");
			if(ManagerHome_Page.txt_managerId().getText().contains(sUserUId)) {
				Log.info("Verification Complete");
				Reporter.log("SignIn Action is successfully perfomred");
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
			}
			else {
				Log.info("Verification InComplete");
				Reporter.log("SignIn Action Failed");
				ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
			}
		}

		// This is another type of logging, with the help of TestNg Reporter log
		// This has to be very carefully used, you should only print the very important message in to this
		// This will populate the logs in the TestNG HTML reports
		// I have used this Reporter log just once in this whole module 


	}
}
