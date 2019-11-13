package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver wd;
	public SearchPage(WebDriver wd1)
	{
		this.wd=wd1;
		PageFactory.initElements(wd, this);
	}
	@FindBy(css=".result-type-client:nth-child(2) .img-fluid")
	private WebElement first_rslt;
	public WebElement get_frslt_path()
	{
		return first_rslt;
	}
	@FindBy(xpath="//*[@id=\"c38886\"]/div/div/p")
	private WebElement article_rslt;
	public WebElement get_arslt_path()
	{
		return article_rslt;
	}
}
