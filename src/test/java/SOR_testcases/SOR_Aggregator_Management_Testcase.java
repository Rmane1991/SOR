package SOR_testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SOR_Pages.SOR_Aggregator_Management_Page;
import SOR_Pages.SOR_Login_Page;
import SOR_resources.Utility.TextFileLogger;

public class SOR_Aggregator_Management_Testcase extends Base
{
	SOR_Login_Page SOR_Lp;
	SOR_Aggregator_Management_Page SOR_Amp;

	@BeforeClass
	//@Test(priority = 0)
	public void initalization() throws Exception 
	{
		launchBrowser();
		SOR_Lp = new SOR_Login_Page(driver);
		SOR_Amp = new SOR_Aggregator_Management_Page(driver);
		TextFileLogger.initializeLogger("SOR_Aggregator_Management_Testcase");
	}

	@Test(priority = 1)
	public void Add_Agg() throws InterruptedException, IOException 
	{
		//Login InPortal
		SOR_Lp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
									  ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		
		//Add Agg Into Portal
		SOR_Amp.Add_Agg( getCellValueAsString(sheet.getRow(12).getCell(1)) // BC_name
					    ,getCellValueAsString(sheet.getRow(15).getCell(1)) // Agg_Name
                	    ,getCellValueAsString(sheet.getRow(15).getCell(3)) // PanNo
                        ,getCellValueAsString(sheet.getRow(15).getCell(5)) // AadhaarNo
                        ,getCellValueAsString(sheet.getRow(15).getCell(7)) // Education
                        ,getCellValueAsString(sheet.getRow(15).getCell(9)) // AccountNo
                        ,getCellValueAsString(sheet.getRow(15).getCell(11)) // IFSCCode
                        ,getCellValueAsString(sheet.getRow(15).getCell(13)) // Address
                        ,getCellValueAsString(sheet.getRow(15).getCell(15)) // PinCode
                        ,getCellValueAsString(sheet.getRow(15).getCell(17)) // State
                        ,getCellValueAsString(sheet.getRow(15).getCell(19)) // District
                        ,getCellValueAsString(sheet.getRow(15).getCell(21)) // City
                        ,getCellValueAsString(sheet.getRow(15).getCell(23)) // EmailID
                        ,getCellValueAsString(sheet.getRow(15).getCell(25)) // ContactNo
					);
	}
	
	
	@Test(priority = 2 ,dependsOnMethods = "Add_Agg")
	public void Agg_Verification() throws InterruptedException, IOException 
	
	{
		//Login InPortal
		//SOR_Lp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
		//							 ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		//Agg Verification
		ReadExcel();
		Thread.sleep(5000);
		SOR_Amp.Agg_Verification(getCellValueAsString(sheet.getRow(15).getCell(1)));//Agg_name
	}
	
	
	@Test(priority = 3)
	public void On_Board_Agg_Status() throws InterruptedException, IOException 
	{
		//Login InPortal
		//SOR_Lp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
			//						  ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
	
		SOR_Amp.On_Board_Agg_Status(getCellValueAsString(sheet.getRow(15).getCell(1))); //Agg_name
	}
	
	@AfterClass
	//@Test(priority = 4)
	public void tearDown() throws IOException 
	{
		 if (driver != null) {
	            driver.quit();
	            System.out.println("WebDriver Closed");
	            TextFileLogger.closeLogger();
	        }
	}
	
}
