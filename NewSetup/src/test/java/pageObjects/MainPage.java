package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	WebDriver wd;
	public MainPage(WebDriver wd1)
	{
		this.wd=wd1;
		PageFactory.initElements(wd, this);
	}
	@FindBy(css=".icon-search")
	private WebElement search_btn;
	public WebElement get_sbtn_path()
	{
		return search_btn;
	}

	@FindBy(id="search")
	private WebElement search_field;
	public WebElement get_sfield_path()
	{
		return search_field;
	}

	

}
