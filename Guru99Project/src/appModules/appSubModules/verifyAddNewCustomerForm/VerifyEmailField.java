package appModules.appSubModules.verifyAddNewCustomerForm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.AddCustomer_Page;
import pageObjects.BaseClass;

public class VerifyEmailField extends BaseClass{
	
	public VerifyEmailField(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public static void mobileFieldEmptyCheck() throws Exception {
		AddCustomer_Page.txtbx_Mobile().clear();
		AddCustomer_Page.txtbx_Mobile().click();
		AddCustomer_Page.txtbx_Mobile().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.mobileLabel).getText();
		String expected = AddCustomer_Page.mobileLabelTextEmpty;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If mobile field is empty' Check Passed");
	}
	
	
	public static void mobileLabelTextCharacterCheck() throws Exception {
		AddCustomer_Page.txtbx_Mobile().clear();
		AddCustomer_Page.txtbx_Mobile().click();
		AddCustomer_Page.txtbx_Mobile().sendKeys("hkk");
		AddCustomer_Page.txtbx_Mobile().sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.mobileLabel).getText();
		String expected = AddCustomer_Page.mobileLabelTextCharacter;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If mobile field data is numeric' Check Passed");
	}
	
	
	public static void mobileFieldSpecialCharacterCheck() throws Exception {
		AddCustomer_Page.txtbx_Mobile().clear();
		AddCustomer_Page.txtbx_Mobile().click();
		AddCustomer_Page.txtbx_Mobile().sendKeys("@#");
		AddCustomer_Page.txtbx_Mobile().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.mobileLabel).getText();
		String expected = AddCustomer_Page.mobileLabelTextSpecialCharacter;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If mobile field data has Special Character' Check Passed");
	}
	
	
	public static void mobileFieldFirstCharSpaceCheck() throws Exception {
		AddCustomer_Page.txtbx_Mobile().clear();
		AddCustomer_Page.txtbx_Mobile().click();
		AddCustomer_Page.txtbx_Mobile().sendKeys(" ");
		AddCustomer_Page.txtbx_Mobile().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.mobileLabel).getText();
		String expected = AddCustomer_Page.mobileLabelTextFirstCharSpace;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If mobile field data has First Char as space' Check Passed");
	}
	
	
}
