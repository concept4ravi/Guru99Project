package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class SideMenu extends BaseClass{
	private static WebElement element = null;

	public SideMenu(WebDriver driver){
		super(driver);
	}    
	public static WebElement lnk_NewCustomer() throws Exception{
		try{ 
			element = driver.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a"));
			Log.info("New Customer Link found on Side Bar");
		}catch (Exception e){
			Log.error("New Customer Link not found on Side Bar");
			throw(e);
		}
		return element;
	}

}
