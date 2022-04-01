package Tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseClass {

	public AppiumDriver<MobileElement> driver;
	String platform;
	
	@BeforeClass
	public void setup() {
		
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			
			this.platform = "android";
			
			if (platform.equalsIgnoreCase("android")) {
				caps.setCapability("platformName", "android");
				caps.setCapability("platformVersion", "12");
				caps.setCapability("deviceName", "emulator-5554");
				caps.setCapability("appPackage", "com.jayway.contacts");
				caps.setCapability("appActivity", "com.jayway.contacts.MainActivity");
				caps.setCapability("app", "/Users/armanqa/Mobile Automation/Demo_Appium/appium/Contacts.apk");
				caps.setCapability("fullReset", false);
				caps.setCapability("noReset", true);
			}
			
			else if (platform.equalsIgnoreCase("ios")) {
				caps.setCapability("platformName", "iOS");
				caps.setCapability("platformVersion", "15.4");
				caps.setCapability("deviceName", "iPhone 12");
				caps.setCapability("app", "/Users/armanqa/Mobile Automation/Demo_Appium/appium/ContactsSimulator.app");
				caps.setCapability("fullReset", false);
				caps.setCapability("noReset", true);
			}

			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url,caps);
		}
		
		catch(Exception exp) {
			System.out.println("Cause is: " +exp.getCause());
			System.out.println("Message is: " +exp.getMessage());
			exp.printStackTrace();
		}
	}
	@AfterClass
	public void teardown() {
		System.out.println("this is 3");
		driver.quit();
	}
}
