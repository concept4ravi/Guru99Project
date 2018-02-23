package appModules.appSubModules.verifyAddNewCustomerForm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.AddCustomer_Page;
import pageObjects.BaseClass;
import utility.Log;

public class VerifyNameField extends BaseClass{
	
	public VerifyNameField(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public static void nameFieldEmptyCheck() throws Exception {
		AddCustomer_Page.txtbx_userName().clear();
		AddCustomer_Page.txtbx_userName().click();
		AddCustomer_Page.txtbx_userName().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.unameLabel).getText();
		String expected = AddCustomer_Page.unameLabelTextEmpty;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If name field is empty' Check Passed");
	}
	
	
	public static void nameFieldNumericCheck() throws Exception {
		AddCustomer_Page.txtbx_userName().clear();
		AddCustomer_Page.txtbx_userName().click();
		AddCustomer_Page.txtbx_userName().sendKeys("54548");
		AddCustomer_Page.txtbx_userName().sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.unameLabel).getText();
		String expected = AddCustomer_Page.unameLabelTextNumeric;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If name field data is numeric' Check Passed");
	}
	
	
	public static void nameFieldSpecialCharacterCheck() throws Exception {
		AddCustomer_Page.txtbx_userName().clear();
		AddCustomer_Page.txtbx_userName().click();
		AddCustomer_Page.txtbx_userName().sendKeys("@#");
		AddCustomer_Page.txtbx_userName().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.unameLabel).getText();
		String expected = AddCustomer_Page.unameLabelTextSpecialCharacter;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If name field data has Special Character' Check Passed");
	}
	
	
	public static void nameFieldFirstCharSpaceCheck() throws Exception {
		AddCustomer_Page.txtbx_userName().clear();
		AddCustomer_Page.txtbx_userName().click();
		AddCustomer_Page.txtbx_userName().sendKeys(" ");
		AddCustomer_Page.txtbx_userName().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.unameLabel).getText();
		String expected = AddCustomer_Page.unameLabelTextFirstCharSpace;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If name field data has First Char as space' Check Passed");
	}
}
