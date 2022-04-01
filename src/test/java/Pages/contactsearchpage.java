package Pages;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class contactsearchpage {

	public contactsearchpage(AppiumDriver<MobileElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@CacheLookup
	@AndroidFindBy (id = "main_search")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSearchField[@name=\"Search for contact\"]")
	MobileElement searchField;
	
	public void search(String name) {
		searchField.clear();
		searchField.sendKeys(name);
	}
	
	public void search1(String name) {
		searchField.clear();
		searchField.sendKeys(name);
	}
	
	
	@CacheLookup
	@AndroidFindBy (id = "name")
	@iOSXCUITFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"Sara Alston\"])[1]")
	MobileElement validsearchresult;
	
	public String validsearchresult() {
		String name = validsearchresult.getText();
		return name;
	}
	
	
	@CacheLookup
	@AndroidFindBy (id = "main_text")
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"No Results\"]")
	MobileElement invalidsearchresult;
	
	public String invalidsearchresult() {
		String name = invalidsearchresult.getText();
		return name;
	}
	
}
