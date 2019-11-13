package testCase1;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import junit.framework.Assert;
import pageObjects.SearchPage;
import testConfigurations.Configure;

public class SearchTab extends Configure {
	
	protected static SearchPage search;
	public SearchTab()
	{
		search=new SearchPage(driver);
	}
	// I have created enter_text as a seperate function with annotation "before" because it is quiet possible that in future we need to check someother TCs by entering different values in the search field
	@Before
	public void enter_text()
	{
		// As I observed that this page was taking time to load so i used implicit wait to wait for the search button to become visible and then click it
		wait.until(ExpectedConditions.visibilityOf(main.get_sbtn_path()));
     	main.get_sbtn_path().click();
     	main.get_sfield_path().sendKeys(object.getProperty("search_value")+Keys.RETURN);

	}
	@Test
	public void testSearchFunctionality()
	{
		

		// SO this is our specific TC which checks that the paragraph section has all the text correctly which we have saved in config.properties file
     	//scroll down so the first link becomes visible
		js.executeScript("window.scrollBy(0,250)", "");
     	wait.until(ExpectedConditions.visibilityOf(search.get_frslt_path()));
     	search.get_frslt_path().click();
     	js.executeScript("window.scrollBy(0,250)", "");
     	String bodyText = search.get_arslt_path().getText();
     	Assert.assertTrue("Text not found!", bodyText.equalsIgnoreCase(object.getProperty("article_text")));
	}
	

}
