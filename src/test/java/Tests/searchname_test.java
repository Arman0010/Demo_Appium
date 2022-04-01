package Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import Pages.contactsearchpage;

public class searchname_test extends BaseClass{

	@Test(priority = 1,enabled=true)
	
	public void SearchSara() throws InterruptedException {
		Thread.sleep(2000);
		contactsearchpage contactsearchpage = new contactsearchpage(driver);
		contactsearchpage.search("Sara Alston");
		String name = contactsearchpage.validsearchresult();
		AssertJUnit.assertEquals(name, "Sara Alston");
	}
	
	@Test(priority = 2,enabled=false, dependsOnMethods = {"SearchSara"})

	public void SearchTamim() throws InterruptedException {
		contactsearchpage contactsearchpage = new contactsearchpage(driver);
		contactsearchpage.search("tamim");
		String expected_text;
		
		if (super.platform == "ios")
			expected_text = "No Results";
		else
			expected_text = "No contacts found with \"tamim\" in the name";
		
		String actual_text = contactsearchpage.invalidsearchresult();
		AssertJUnit.assertEquals(actual_text, expected_text);
		
	}
}
