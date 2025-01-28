package SOR_Pages;

import java.io.IOException;
import java.time.Duration;

//import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement Alert_Toast_Msg; // Insert Successful
	
	@FindBy(xpath = "//span[@id='lblWelcome']")
    WebElement lblWelcome;

	public SOR_Login_Page(WebDriver driver ) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}

	String className = this.getClass().getSimpleName();
	
	public void Check_Valid_Credentials(String UserName, String Password) throws Exception 
	{
		TextFileLogger.logMessage("Check_Valid_Credentials TestCase Start");
		txtusername.clear();
		txtusername.sendKeys(UserName);
		txtPWd.clear();
		txtPWd.sendKeys(Password);
		btnsubmit.click();;
		
		try 
		{
		  Assert.assertEquals(lblWelcome.getText(), "Welcome " + UserName, "Welcome message validation failed!");
		    writeResultToExcel("Pass", 2, 5);
		    
		    String dbURL = "jdbc:postgresql://172.25.52.70:5432/Proxima";
	        String dbUser = "postgres";
	        String dbPassword = "P@ss1234";
	        String query = "select count(1) from aepsbanktransactiondetail;";
		    
	        String dbValue = getValueFromDB(dbURL, dbUser, dbPassword, query);
	        System.out.println(dbValue);
		    //getValueFromDB();
		    ConsoleColor.printColored("Login Successful With Username :- " + UserName, ConsoleColor.GREEN);
		} catch (AssertionError e) 
		
		{
		    System.out.println("Test failed! The displayed message is: " + lblWelcome.getText());
		    writeResultToExcel("Fail", 2, 5);
		    ConsoleColor.printColored("Login Failed With Username :- " + UserName, ConsoleColor.RED);
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
