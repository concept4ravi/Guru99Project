package appModules.appSubModules.verifyAddNewCustomerForm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.AddCustomer_Page;
import pageObjects.BaseClass;

public class VerifyCityField extends BaseClass{
	
	public VerifyCityField(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public static void cityFieldEmptyCheck() throws Exception {
		AddCustomer_Page.txtbx_City().clear();
		AddCustomer_Page.txtbx_City().click();
		AddCustomer_Page.txtbx_City().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.cityLabel).getText();
		String expected = AddCustomer_Page.cityLabelTextEmpty;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If city field is empty' Check Passed");
	}
	
	
	public static void cityFieldNumericCheck() throws Exception {
		AddCustomer_Page.txtbx_City().clear();
		AddCustomer_Page.txtbx_City().click();
		AddCustomer_Page.txtbx_City().sendKeys("54548");
		AddCustomer_Page.txtbx_City().sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.cityLabel).getText();
		String expected = AddCustomer_Page.cityLabelTextNumeric;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If city field data is numeric' Check Passed");
	}
	
	
	public static void cityFieldSpecialCharacterCheck() throws Exception {
		AddCustomer_Page.txtbx_City().clear();
		AddCustomer_Page.txtbx_City().click();
		AddCustomer_Page.txtbx_City().sendKeys("@#");
		AddCustomer_Page.txtbx_City().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.cityLabel).getText();
		String expected = AddCustomer_Page.cityLabelTextSpecialCharacter;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If city field data has Special Character' Check Passed");
	}
	
	
	public static void cityFieldFirstCharSpaceCheck() throws Exception {
		AddCustomer_Page.txtbx_City().clear();
		AddCustomer_Page.txtbx_City().click();
		AddCustomer_Page.txtbx_City().sendKeys(" ");
		AddCustomer_Page.txtbx_City().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		String actual = AddCustomer_Page.label_Message(AddCustomer_Page.cityLabel).getText();
		String expected = AddCustomer_Page.cityLabelTextFirstCharSpace;
		Assert.assertEquals(actual, expected);
		Reporter.log("'If city field data has First Char as space' Check Passed");
	}
}
