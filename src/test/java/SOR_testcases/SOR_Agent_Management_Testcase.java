package SOR_testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SOR_Pages.SOR_Agent_Management_Page;
import SOR_Pages.SOR_Login_Page;

public class SOR_Agent_Management_Testcase extends Base
{
	SOR_Login_Page SORLp;
	SOR_Agent_Management_Page SOR_Amp;

	@BeforeMethod
	public void initalization() throws Exception 
	{
		launchBrowser();
		SORLp = new SOR_Login_Page(driver);
		SOR_Amp = new SOR_Agent_Management_Page(driver);
	}
	
	
	@Test(priority = 1)
	public void Add_BC() throws InterruptedException, IOException 
	{
		//Login InPortal
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
									 ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password

		
		//Add BC Into Portal
		SOR_Amp.Agent_Registraction
				(
				 getCellValueAsString(sheet.getRow(12).getCell(1)) // BC_name
				,getCellValueAsString(sheet.getRow(15).getCell(1)) // Agg_Name
				,getCellValueAsString(sheet.getRow(18).getCell(1)) // Agent_Name
				,getCellValueAsString(sheet.getRow(18).getCell(3)) // Gender
                ,getCellValueAsString(sheet.getRow(18).getCell(5)) // PanNo
                ,getCellValueAsString(sheet.getRow(18).getCell(7)) // AadhaarNo
                ,getCellValueAsString(sheet.getRow(18).getCell(9)) // Date Format
                ,getCellValueAsString(sheet.getRow(18).getCell(11)) // AccountNo
                ,getCellValueAsString(sheet.getRow(18).getCell(13)) // IFSCCode
                ,getCellValueAsString(sheet.getRow(18).getCell(15)) // Device_Code
                ,getCellValueAsString(sheet.getRow(18).getCell(17)) // Population_Grp
                ,getCellValueAsString(sheet.getRow(18).getCell(19)) // Agent_Code
                ,getCellValueAsString(sheet.getRow(18).getCell(21)) // Terminal_ID
                ,getCellValueAsString(sheet.getRow(18).getCell(23)) // Latitude
                ,getCellValueAsString(sheet.getRow(18).getCell(25)) // Longitude
                ,getCellValueAsString(sheet.getRow(18).getCell(27)) // Address
                ,getCellValueAsString(sheet.getRow(18).getCell(29)) // PinCode
                ,getCellValueAsString(sheet.getRow(18).getCell(31)) // State
                ,getCellValueAsString(sheet.getRow(18).getCell(33)) // District
                ,getCellValueAsString(sheet.getRow(18).getCell(35)) // City
                ,getCellValueAsString(sheet.getRow(18).getCell(37)) // EmailID
                ,getCellValueAsString(sheet.getRow(18).getCell(39)) // ContactNo
				 );
		
	}
	
	
	@Test(priority = 2 ,dependsOnMethods = "Add_BC")
	public void BC_Verification() throws InterruptedException, IOException 
	{
		//Login InPortal
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
									 ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		//BC Verification
		SOR_Amp.Agent_Verification(getCellValueAsString(sheet.getRow(12).getCell(1)));
	}
	
	
	@Test(priority = 3)
	public void On_Board_BC_Status() throws InterruptedException, IOException 
	{
		//Login InPortal
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
									 ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
	
		SOR_Amp.On_Board_Agent_Status(getCellValueAsString(sheet.getRow(12).getCell(1)));
	}
	
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
		System.out.println("Webdriver Closed ");
	}
	
}
