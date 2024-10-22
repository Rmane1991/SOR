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

		/*
		//Add BC Into Portal
		SOR_Amp.BC_Registraction
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
		*/
	}
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
		System.out.println("Webdriver Closed ");
	}
	
}
