package appModules.appSubModules.verifyAddNewCustomerForm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.AddCustomer_Page;
import pageObjects.BaseClass;

public class VerifyPinCodeField extends BaseClass{
	
	public VerifyPinCodeField(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public static void pinFieldEmptyCheck() throws Exception {
		AddCustomer_Page.txtbx_Pin().clear();
		AddCustomer_Page.txtbx_Pin().click();
		AddCustomer_Page.txtbx_Pin().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.pinLabel).getText();
		String expected = AddCustomer_Page.pinLabelTextEmpty;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If pin field is empty' Check Passed");
	}
	
	
	public static void pinLabelTextCharacterCheck() throws Exception {
		AddCustomer_Page.txtbx_Pin().clear();
		AddCustomer_Page.txtbx_Pin().click();
		AddCustomer_Page.txtbx_Pin().sendKeys("hkk");
		AddCustomer_Page.txtbx_Pin().sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.pinLabel).getText();
		String expected = AddCustomer_Page.pinLabelTextCharacter;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If pin field data is numeric' Check Passed");
	}
	
	
	public static void pinFieldSpecialCharacterCheck() throws Exception {
		AddCustomer_Page.txtbx_Pin().clear();
		AddCustomer_Page.txtbx_Pin().click();
		AddCustomer_Page.txtbx_Pin().sendKeys("@#");
		AddCustomer_Page.txtbx_Pin().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.pinLabel).getText();
		String expected = AddCustomer_Page.pinLabelTextSpecialCharacter;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If pin field data has Special Character' Check Passed");
	}
	
	
	public static void pinFieldFirstCharSpaceCheck() throws Exception {
		AddCustomer_Page.txtbx_Pin().clear();
		AddCustomer_Page.txtbx_Pin().click();
		AddCustomer_Page.txtbx_Pin().sendKeys(" ");
		AddCustomer_Page.txtbx_Pin().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.pinLabel).getText();
		String expected = AddCustomer_Page.pinLabelTextFirstCharSpace;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If pin field data has First Char as space' Check Passed");
	}
	
	public static void pinLabelTextLesThan6DigitCheck() throws Exception {
		AddCustomer_Page.txtbx_Pin().clear();
		AddCustomer_Page.txtbx_Pin().click();
		AddCustomer_Page.txtbx_Pin().sendKeys(" ");
		AddCustomer_Page.txtbx_Pin().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.pinLabel).getText();
		String expected = AddCustomer_Page.pinLabelTextLesThan6Digit;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If pin field data has less than 6 digit' Check Passed");
	}
}
