package SOR_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import SOR_resources.Utility;

public class SOR_Agent_Management_Page extends Utility
{

	WebDriver driver;
	
	public SOR_Agent_Management_Page(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
