package SOR_testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SOR_Pages.SOR_Login_Page;
import SOR_Pages.SOR_Switch_Configuration_Page;
import SOR_resources.Utility.TextFileLogger;


public class SOR_Switch_ConfigurationTestCase extends Base
{
	SOR_Login_Page SORLp;	
	SOR_Switch_Configuration_Page SORwCp;
	
	
	@BeforeMethod
	public void initalization() throws Exception
	{
		 launchBrowser();
		 SORLp = new SOR_Login_Page(driver);
		 SORwCp = new SOR_Switch_Configuration_Page(driver);
		 TextFileLogger.initializeLogger("Switch_ConfigurationTestCase");
	}
	
	@Test
	public void AddSwitch() throws InterruptedException, IOException 
	{
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
			                         ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		
		SORwCp.addSwitch(getCellValueAsString(sheet.getRow(9).getCell(1)) 
					    ,getCellValueAsString(sheet.getRow(9).getCell(3))
					    ,getCellValueAsString(sheet.getRow(9).getCell(5)));
	}
	
	@AfterMethod
	public void tearDown() throws IOException 
	{
		driver.quit();
		System.out.println("Webdriver Closed ");
		TextFileLogger.closeLogger();
	}
	

}
