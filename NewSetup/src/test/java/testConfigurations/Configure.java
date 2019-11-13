package testConfigurations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.MainPage;

public class Configure {
		// I have created both these elements in Parent class as I observed that :
		// 1- below are the variables for every TestCase if we extend it further
		// 2- main tabs like search field(for instance) is also common, for example if we even go on contact tab the search field still remain visible so I found it better to place common elements here to make use of inheritance
		protected static WebDriver driver;
		protected static MainPage main;
		protected static WebDriverWait wait;
		protected static Properties object; 
		protected static FileInputStream objfile;
		protected JavascriptExecutor js = ((JavascriptExecutor) driver);
	 	
		// since before and after class is executed only once so I found it reasonable to put launch and close in these annotations because even we extend these testcases the browser opening and closing will be done once
		@BeforeClass
		public static void launchPage()
		{
			
			// saved all data in config.properties, so if in future it needs to be changed it can be edited in properties file
			object=new Properties();
			try {
				objfile=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
				object.load(objfile);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if((object.getProperty("browser")).equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",object.getProperty("driver_path"));
				driver=new ChromeDriver();
				wait=new WebDriverWait(driver,(Integer.valueOf(object.getProperty("wait_time"))));
				main=new MainPage(driver); 
				driver.get(object.getProperty("URL")); // get to the URL
				driver.manage().window().maximize(); //maximize window
				
			}
			else
			{
				// if in future it needs to be changed to firefox we can add the code here
			}
			
			
			
			
		}
		
		@AfterClass 
		public static void ClosePage() 
		{ 

			driver.quit(); 
		}
		    

}
