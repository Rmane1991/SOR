package SOR_testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SOR_Pages.SOR_Login_Page;
import SOR_Pages.SOR_Switch_Configuration_Page;


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
	}
	
	
	
	@Test
	public void AddSwitch() throws InterruptedException 
	{
		SORLp.Check_Valid_Credentials(sheet.getRow(3).getCell(1).getStringCellValue(),sheet.getRow(3).getCell(3).getStringCellValue());
		SORwCp.addSwitch(sheet.getRow(9).getCell(1).getStringCellValue() ,sheet.getRow(9).getCell(3).getStringCellValue(),(int) sheet.getRow(9).getCell(5).getNumericCellValue());
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
		System.out.println("Webdriver Closed ");
	}
	

}
