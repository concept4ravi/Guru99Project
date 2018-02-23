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

public class VerifyAddressField extends BaseClass{
	
	public VerifyAddressField(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public static void addressFieldEmptyCheck() throws Exception {
		AddCustomer_Page.txtbx_Address().clear();
		AddCustomer_Page.txtbx_Address().click();
		AddCustomer_Page.txtbx_Address().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.addressLabel).getText();
		String expected = AddCustomer_Page.addressLabelTextEmpty;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If name field is empty' Check Passed");
	}

	public static void addressFieldFirstCharSpaceCheck() throws Exception {
		AddCustomer_Page.txtbx_userName().clear();
		AddCustomer_Page.txtbx_userName().click();
		AddCustomer_Page.txtbx_userName().sendKeys(" ");
		AddCustomer_Page.txtbx_userName().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.unameLabel).getText();
		String expected = AddCustomer_Page.addressLabelTextFirstCharSpace;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If Address field data has First Char as space' Check Passed");
	}
}
