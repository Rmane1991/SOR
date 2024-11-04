package SOR_testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import SOR_Pages.SOR_Login_Page;
import SOR_Pages.SOR_Rule_Configuration_Page;


public class SOR_Rule_ConfigurationTestCase extends Base 
{
	SOR_Login_Page SORLp;	
	SOR_Rule_Configuration_Page SORRCp;
	
	@Test(priority = 1)
	public void initalization() throws Exception
	{
		 launchBrowser();
		 SORLp = new SOR_Login_Page(driver);
		 SORRCp = new SOR_Rule_Configuration_Page(driver);
	}
	
	@Test(priority = 2)
	public void AddGroup() throws InterruptedException, IOException 
	{
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
								     ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		SORRCp.AddGrp(getCellValueAsString(sheet.getRow(6).getCell(1)),getCellValueAsString(sheet.getRow(6).getCell(3)));
	}
	
	@Test(priority = 3)
	public void AddRule() throws InterruptedException, IOException 
	{
		//SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
			                        // ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		ReadExcel();
		SORRCp.addRule("Yes",getCellValueAsString(sheet.getRow(6).getCell(1)),getCellValueAsString(sheet.getRow(9).getCell(1)));
	}
	
	@Test(priority = 4)
	public void tearDown() 
	{
		driver.quit();
		System.out.println("Webdriver Closed ");
	}
	
}
