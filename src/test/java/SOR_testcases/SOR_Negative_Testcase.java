package SOR_testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SOR_Pages.SOR_BC_Management_Page;
import SOR_Pages.SOR_Login_Page;
import SOR_Pages.SOR_Rule_Configuration_Page;
import SOR_Pages.SOR_Switch_Configuration_Page;
import SOR_resources.Utility.TextFileLogger;

public class SOR_Negative_Testcase extends Base 
{
	SOR_Login_Page SORLp;	
	SOR_Rule_Configuration_Page SORRCp;
	SOR_Switch_Configuration_Page SORSCp;
	SOR_BC_Management_Page SORBMp;
	
	@BeforeClass
	public void initalization() throws Exception
	{
		 launchBrowser();
		 SORLp = new SOR_Login_Page(driver);
		 SORRCp = new SOR_Rule_Configuration_Page(driver);
		 SORSCp = new SOR_Switch_Configuration_Page(driver);
		 SORBMp = new SOR_BC_Management_Page(driver);
		 TextFileLogger.initializeLogger("SOR_Negative_Testcase");
	}
	
	@Test(priority = 1)
	public void Negative_Test_Case_Rule_Mgmt_Page() throws InterruptedException, IOException
	{
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
						     		 ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		SORRCp.Blank_Grp_Name_and_Desc_Blank_Rule_Name_and_Desc();
		SORSCp.Blank_Switch_Name_Blank_Desc();
		SORBMp.Blank_Data_BC_Registration();
	}
	
	 @AfterClass
	    public void tearDown() throws IOException 
	 {
	        if (driver != null) 
	        {
	            driver.quit();
	            System.out.println("WebDriver Closed");
	          TextFileLogger.closeLogger();
	        }
	    }
	
}
