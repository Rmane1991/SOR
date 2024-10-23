package SOR_testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SOR_Pages.SOR_BC_Management_Page;
import SOR_Pages.SOR_Login_Page;

public class SOR_BC_Management_TestCase extends Base
{
	
	SOR_Login_Page SORLp;
	SOR_BC_Management_Page Sbmp;

	@BeforeMethod
	public void initalization() throws Exception 
	{
		launchBrowser();
		SORLp = new SOR_Login_Page(driver);
		Sbmp = new SOR_BC_Management_Page(driver);
	}
	
	@Test(priority = 1)
	public void Add_BC() throws InterruptedException, IOException 
	{
		//Login InPortal
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
									 ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password

		//Add BC Into Portal
		Sbmp.BC_Registraction
				(
				 getCellValueAsString(sheet.getRow(12).getCell(1)) // BC_name
                ,getCellValueAsString(sheet.getRow(12).getCell(3)) // PanNo
                ,getCellValueAsString(sheet.getRow(12).getCell(5)) // AadhaarNo
                ,getCellValueAsString(sheet.getRow(12).getCell(7)) // AccountNo
                ,getCellValueAsString(sheet.getRow(12).getCell(9)) // IFSCCode
                ,getCellValueAsString(sheet.getRow(12).getCell(11)) // Address
                ,getCellValueAsString(sheet.getRow(12).getCell(13)) // PinCode
                ,getCellValueAsString(sheet.getRow(12).getCell(15)) // State
                ,getCellValueAsString(sheet.getRow(12).getCell(17)) // District
                ,getCellValueAsString(sheet.getRow(12).getCell(19)) // City
                ,getCellValueAsString(sheet.getRow(12).getCell(21)) // EmailID
                ,getCellValueAsString(sheet.getRow(12).getCell(23)) // ContactNo
				 );
		
	}
	
	@Test(priority = 2)//,dependsOnMethods = "Add_BC"
	public void BC_Verification() throws InterruptedException, IOException 
	{
		//Login InPortal
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
									 ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		//BC Verification
		Sbmp.BC_Verification(getCellValueAsString(sheet.getRow(12).getCell(1)));
	}
	
	
	@Test(priority = 3,dependsOnMethods = "Add_BC")
	public void On_Board_BC_Status() throws InterruptedException, IOException 
	{
		//Login InPortal
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
									 ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
	
		Sbmp.On_Board_BC_Status(getCellValueAsString(sheet.getRow(12).getCell(1)));
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
		System.out.println("Webdriver Closed ");
	}
	
	

}
