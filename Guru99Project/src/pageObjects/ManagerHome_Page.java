package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
public class ManagerHome_Page extends BaseClass{
	private static WebElement element = null;

	public ManagerHome_Page(WebDriver driver){
		super(driver);
	}    
	public static WebElement txt_managerId() throws Exception{
		try{ 
			element = driver.findElement(By.xpath("//tr[3]/td"));
			Log.info("Manager Id text found on the Manager Page");
		}catch (Exception e){
			Log.error("Manager Id text not found on the Manager Page");
			throw(e);
		}
		return element;
	}
}
