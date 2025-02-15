package SOR_testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SOR_Pages.SOR_Alert_Configuration_Page;
import SOR_Pages.SOR_Login_Page;

import SOR_resources.Utility.TextFileLogger;

public class SOR_Alert_Configuration_TestCase extends Base
{
	SOR_Login_Page SORLp;
	SOR_Alert_Configuration_Page SORAc;

	@BeforeClass
	public void initalization() throws Exception 
	{
		launchBrowser();
		SORLp = new SOR_Login_Page(driver);
		SORAc = new SOR_Alert_Configuration_Page(driver);
		TextFileLogger.initializeLogger("SOR_Admin_Management_Testcase");
	}
	
	

	@Test(priority = 1)
	public void Create_Role() throws Exception 
	{
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) // UserName
									, getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		SORAc.Add_Grpup();
		SORAc.Add_Alert();

	}
	

	@AfterClass
	public void tearDown() throws IOException 
	{
		if (driver != null) {
			driver.quit();
			System.out.println("WebDriver Closed");
			TextFileLogger.closeLogger();
		}
	}
}
