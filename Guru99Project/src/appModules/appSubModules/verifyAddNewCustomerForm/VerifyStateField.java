package appModules.appSubModules.verifyAddNewCustomerForm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.AddCustomer_Page;
import pageObjects.BaseClass;

public class VerifyStateField extends BaseClass{
	
	public VerifyStateField(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public static void emailFieldEmptyCheck() throws Exception {
		AddCustomer_Page.txtbx_Email().clear();
		AddCustomer_Page.txtbx_Email().click();
		AddCustomer_Page.txtbx_Email().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.emailLabel).getText();
		String expected = AddCustomer_Page.emailLabelTextEmpty;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If email field is empty' Check Passed");
	}
	
	
	
	/*
	public static void emailFieldNotValidCheck() throws Exception {
		AddCustomer_Page.txtbx_State().clear();
		AddCustomer_Page.txtbx_State().click();
		AddCustomer_Page.txtbx_State().sendKeys("@#");
		AddCustomer_Page.txtbx_State().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.stateLabel).getText();
		String expected = AddCustomer_Page.stateLabelTextSpecialCharacter;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If state field data has Special Character' Check Passed");
	}*/
	
	
	public static void emailFieldFirstCharSpaceCheck() throws Exception {
		AddCustomer_Page.txtbx_Email().clear();
		AddCustomer_Page.txtbx_Email().click();
		AddCustomer_Page.txtbx_Email().sendKeys(" ");
		AddCustomer_Page.txtbx_Email().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.emailLabel).getText();
		String expected = AddCustomer_Page.emailLabelTextFirstCharSpace;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If email field data has First Char as space' Check Passed");
	}
}
