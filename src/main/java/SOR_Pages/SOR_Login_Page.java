package SOR_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SOR_resources.Utility;

public class SOR_Login_Page extends Utility
{

	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='txtUserName']")
	WebElement txtusername;
	
	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement txtPWd;
	
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement btnsubmit;
	
	@FindBy(xpath = "//div[@id='accordionExample']")
	WebElement LeftMenu;

	@FindBy(xpath = "//span[@id='RequiredFieldValidator5']")
	WebElement lblblankUsername; //Please enter UserName 
	
	@FindBy(xpath = "//label[@id='lblErrorMsg']")
	WebElement lblblankPwd; //Login failed
	
	public SOR_Login_Page(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Check_Valid_Credentials(String UserName, String Password) 
	{
		txtusername.clear();
		txtusername.sendKeys(UserName);
		txtPWd.clear();
		txtPWd.sendKeys(Password);
		btnsubmit.click();
		
		if(LeftMenu.isDisplayed()==true)
		{
			System.out.println("Login Sucessfull With Username :- "+UserName);
			Assert.assertTrue(true);
		}
		
		else
		{
			System.out.println("Login Fail");
			Assert.assertTrue(false);
		}
	}
	
	public void Balnk_UserName(String Password)
	{
		txtusername.clear();
		txtPWd.clear();
		btnsubmit.click();
		
		//System.out.println(lblblankUsername.getText());
		if ((lblblankUsername.getText()).contains("Please enter UserName")) 
		{
			Assert.assertTrue(true);
		} else 
			
		{
			Assert.assertTrue(false);
		}
	}
	
	public void Balnk_Password(String UserName)
	{
		txtusername.clear();
		txtusername.sendKeys(UserName);
		txtPWd.clear();
		btnsubmit.click();
		//System.out.println(lblblankPwd.getText());
		if ((lblblankPwd.getText()).contains("Login failed")) 
		{
			Assert.assertTrue(true);
		} else 
			
		{
			Assert.assertTrue(false);
		}
	}
	
	
}
