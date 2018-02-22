package appModules;

import org.testng.Assert;

import pageObjects.ManagerHome_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class VerifyTitle_Action {
	public static void Execute(int iTestCaseRow) throws Exception{
		String title = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Title);
		Assert.assertEquals(title, ManagerHome_Page.getTitle());
		Log.info("TItle Verified");
	}
}
