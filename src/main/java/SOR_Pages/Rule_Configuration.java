package SOR_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SOR_resources.Utility;

public class Rule_Configuration extends Utility

{
	WebDriver driver;
	
	public Rule_Configuration(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//button[@id='BtnSubb3']//h5[@class='sidebar-headings']")
	WebElement lblRunManagement;
	
	@FindBy(xpath = "//div[@id='subPagess3']//span[text()=' Rule Configuration']")
	WebElement lblRunConfiguration;
	
	@FindBy(xpath = "//div[@id='subPagess3']//span[text()='Switch Configuration']")
	WebElement lblSwitchConfiguration;
	
	/*
	@FindBy(xpath = "")
	WebElement demo;
	
	@FindBy(xpath = "")
	WebElement demo;
	
	@FindBy(xpath = "")
	WebElement demo;
	
	@FindBy(xpath = "")
	WebElement demo;
	
	@FindBy(xpath = "")
	WebElement demo;
	
	@FindBy(xpath = "")
	WebElement demo;
	
	@FindBy(xpath = "")
	WebElement demo;
	*/

}
