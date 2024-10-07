package SOR_testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SOR_Pages.SOR_Login_Page;
import SOR_Pages.SOR_Rule_Configuration_Page;


public class SOR_Rule_ConfigurationTestCase extends Base 
{
	SOR_Login_Page SORLp;	
	SOR_Rule_Configuration_Page SORRCp;
	
	@BeforeMethod
	public void initalization() throws Exception
	{
		 launchBrowser();
		 SORLp = new SOR_Login_Page(driver);
		 SORRCp = new SOR_Rule_Configuration_Page(driver);
	}
	
	@Test
	public void AddGroup() throws InterruptedException 
	{
		SORLp.Check_Valid_Credentials(sheet.getRow(3).getCell(1).getStringCellValue(),sheet.getRow(3).getCell(3).getStringCellValue());
		SORRCp.AddGrp();
	}
	
}
