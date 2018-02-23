package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class AddCustomer_Page extends BaseClass{
	
	private static WebElement element = null;
	public static By uname = By.name("name");
	public static By unameLabel = By.id("message");
	public static By addressLabel = By.id("message3");
	public static By cityLabel = By.id("message4");
	public static By stateLabel = By.id("message5");
	public static By pinLabel = By.id("message6");
	public static By mobileLabel = By.id("message7");
	public static By emailLabel = By.id("message9");
	public static By passwordLabel = By.id("message18");
	
	
//	Labels related to User Name Field	
	public static final String unameLabelTextEmpty = "Customer name must not be blank";
	public static final String unameLabelTextNumeric = "Numbers are not allowed";
	public static final String unameLabelTextSpecialCharacter = "Special characters are not allowed";
	public static final String unameLabelTextFirstCharSpace = "First character can not have space";

//	Labels related to Address Field
	public static final String addressLabelTextEmpty = "Address Field must not be blank";
	public static final String addressLabelTextFirstCharSpace = "First character can not have space";
	
	
	public AddCustomer_Page(WebDriver driver) {
		super(driver);
		
	}
	
	public static WebElement txtbx_userName() throws Exception{
		try{ 
			element = driver.findElement(By.name("name"));
			Log.info("User name text box is found on the Home Page");
		}catch (Exception e){
			Log.error("User name text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtbx_Address() throws Exception{
		try{ 
			element = driver.findElement(By.name("addr"));
			Log.info("Address text box is found on the Home Page");
		}catch (Exception e){
			Log.error("Address text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}
	
	
	public static WebElement txtbx_City() throws Exception{
		try{ 
			element = driver.findElement(By.name("city"));
			Log.info("City text box is found on the Home Page");
		}catch (Exception e){
			Log.error("City text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}
	

	public static WebElement label_Message(By by) throws Exception{
		try{ 
			element = driver.findElement(by);
		}catch (Exception e){
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtbx_State() throws Exception{
		try{ 
			element = driver.findElement(By.name("state"));
			Log.info("State text box is found on the Home Page");
		}catch (Exception e){
			Log.error("State text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtbx_Pin() throws Exception{
		try{ 
			element = driver.findElement(By.name("pinno"));
			Log.info("Pin No text box is found on the Home Page");
		}catch (Exception e){
			Log.error("Pin No text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtbx_Email() throws Exception{
		try{ 
			element = driver.findElement(By.name("pinno"));
			Log.info("Pin No text box is found on the Home Page");
		}catch (Exception e){
			Log.error("Pin No text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtbx_Password() throws Exception{
		try{ 
			element = driver.findElement(By.name("pinno"));
			Log.info("Password text box is found on the Home Page");
		}catch (Exception e){
			Log.error("Password text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement btn_Submit() throws Exception{
		try{ 
			element = driver.findElement(By.name("pinno"));
			Log.info("Submit button is found on the Home Page");
		}catch (Exception e){
			Log.error("Submit button text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}
	
	public static WebElement txtbx_Mobile() throws Exception{
		try{ 
			element = driver.findElement(By.name("telephoneno"));
			Log.info("Mobile text box is found on the Home Page");
		}catch (Exception e){
			Log.error("Mobile text box is not found on the Home Page");
			throw(e);
		}
		return element;
	}
	


}
