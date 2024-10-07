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

	public void Check_Valid_Credentials(String UserName, String Password) throws InterruptedException 
	{
		txtusername.clear();
		txtusername.sendKeys(UserName);
		txtPWd.clear();
		txtPWd.sendKeys(Password);
		btnsubmit.click();
		Thread.sleep(2000);
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
	
	public void Balnk_UserName(String Password) throws InterruptedException
	{
		txtusername.clear();
		txtPWd.clear();
		txtPWd.sendKeys(Password);
		btnsubmit.click();
		Thread.sleep(2000);
		//System.out.println(lblblankUsername.getText());
		if ((lblblankUsername.getText()).contains("Please Enter Username")) 
		{
			Assert.assertTrue(true);
		} else 
			
		{
			Assert.assertTrue(false);
		}
	}
	
	public void Balnk_Password(String UserName) throws InterruptedException
	{
		txtusername.clear();
		txtusername.sendKeys(UserName);
		txtPWd.clear();
		btnsubmit.click();
		Thread.sleep(2000);
		//System.out.println(lblblankPwd.getText());
		if ((lblblankPwd.getText()).contains("Please Enter Password")) 
		{
			Assert.assertTrue(true);
		} else 
			
		{
			Assert.assertTrue(false);
		}
	}

	public void Invalid_Password(String UserName, String password) throws InterruptedException 
	{
		txtusername.clear();
		txtusername.sendKeys(UserName);
		txtPWd.clear();
		txtPWd.sendKeys(password+"1");
		btnsubmit.click();
		Thread.sleep(2000);
		if(lblblankPwd.getText().contains("Incorrect Username or Password"))
		{
			Assert.assertTrue(true);
		} else 
			
		{
			Assert.assertTrue(false);
		}
	}
		public void Invalid_Username(String UserName, String password) throws InterruptedException 
		{
			txtusername.clear();
			txtusername.sendKeys(UserName+"1");
			txtPWd.clear();
			txtPWd.sendKeys(password);
			btnsubmit.click();
			Thread.sleep(2000);
			if(lblblankPwd.getText().contains("Incorrect Username or Password"))
			{
				Assert.assertTrue(true);
			} else 
				
			{
				Assert.assertTrue(false);
			}
	}
	
	
}
