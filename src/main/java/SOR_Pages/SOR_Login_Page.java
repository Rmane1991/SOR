package SOR_Pages;

import java.io.IOException;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
//import static org.openqa.selenium.support.locators.RelativeLocator.with;


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

	public SOR_Login_Page(WebDriver driver ) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String className = this.getClass().getSimpleName();
	
	public void Check_Valid_Credentials(String UserName, String Password) throws InterruptedException, IOException 
	{
		TextFileLogger.logMessage("Check_Valid_Credentials TestCase Start");
		txtusername.clear();
		txtusername.sendKeys(UserName);
		txtPWd.clear();
		txtPWd.sendKeys(Password);
		btnsubmit.click();
		Thread.sleep(1000);
		
		/*
		if(isDisaplyedW(LeftMenu, 10)==true)
		{
			System.out.println("Login Sucessfull With Username :- "+UserName);
			Assert.assertTrue(true);
			writeResultToExcel("Pass",2,5);
		}
		
		else
		{
			System.out.println("Login Fail");
			Assert.assertFalse(false);
			if(isDisaplyedW(lblblankPwd, 5)==true)
			{
				writeResultToExcel(lblblankPwd.getText(),2,7);
			}
			writeResultToExcel("Fail",2,5);
		}*/
		
		boolean loginSuccess = false;
		try 
		{
			loginSuccess = isDisaplyedW(LeftMenu, 2);
			Assert.assertTrue(loginSuccess, "Login failed: LeftMenu is not displayed");
			ConsoleColor.printColored("Login Successful With Username :- " + UserName, ConsoleColor.GREEN);
			SpellChecker();
			System.out.println("Done");
			checkUrl();
			
			if (className.contains("SOR_LoginTestCase")) {
				checkUrl();
			}

			else {
				System.out.println("URL All Ready check with Login Test Case");
			}
			TextFileLogger.logMessage("Check_Valid_Credentials TestCase Pass");
			//ExtentReportNG.logMessage("Login Successful With Username :- " + UserName);
		} finally 
		{
			if (loginSuccess) {
				writeResultToExcel("Pass", 2, 5);
			} else {
				ConsoleColor.printColored("Login Failed", ConsoleColor.RED);
				writeResultToExcel("Fail", 2, 5);

				if (isDisaplyedW(lblblankPwd, 5)) {
					writeResultToExcel(lblblankPwd.getText(), 2, 7);
				}
			}
		}
	}
	
	public void Blank_UserName(String Password) throws InterruptedException, IOException
	{
		txtusername.clear();
		txtPWd.clear();
		txtPWd.sendKeys(Password);
		btnsubmit.click();
		Thread.sleep(2000);
		//System.out.println(lblblankUsername.getText());
		if ((lblblankPwd.getText()).contains("Please Enter Username")) 
		{
			Assert.assertTrue(true);
			writeResultToExcel("Pass", 5, 5);
		} else 
			
		{
			writeResultToExcel("Fail", 5, 5);
			Assert.assertFalse(true);
		}
	}
	
	public void Blank_Password(String UserName) throws InterruptedException, IOException
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
			writeResultToExcel("Pass", 5, 5);
		} else 
			
		{
			Assert.assertTrue(false);
			writeResultToExcel("Fail", 5, 5);
		}
	}

	public void Invalid_Password(String UserName, String password) throws InterruptedException, IOException 
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
			writeResultToExcel("Pass", 4, 5);
		} else 
		
		{
			Assert.assertTrue(false);
		}
	}
		public void Invalid_Username(String UserName, String password) throws InterruptedException, IOException 
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
				writeResultToExcel("Pass", 3, 5);
			} else 
				
			{
				Assert.assertTrue(false);
			}
	}
	
	
}
