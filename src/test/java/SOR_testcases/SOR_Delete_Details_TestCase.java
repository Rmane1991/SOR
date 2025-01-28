package SOR_testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SOR_Pages.SOR_Delete_Details_Page;
import SOR_Pages.SOR_Login_Page;


public class SOR_Delete_Details_TestCase extends Base
{

	SOR_Login_Page SORLp;	
	SOR_Delete_Details_Page SORDDp;
	
	@BeforeMethod
	@Test(priority = 1)
	public void initalization() throws Exception
	{
		 launchBrowser();
		 SORLp = new SOR_Login_Page(driver);
		 SORDDp = new SOR_Delete_Details_Page(driver);
	}
	
	//@Test(priority = 2) //Done
	public void Edit_Switch() throws Exception 
	{
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
								     ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		SORDDp.Edit_Switch(sheet.getRow(3).getCell(7).getStringCellValue());
		
	}
	
	//@Test(priority = 3) //Done
	public void Delete_Switch() throws InterruptedException, IOException 
	{
		//SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
		//	     ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		SORDDp.delete_Switch();
	}
	
	@Test(priority = 6) //Done
	public void Edit_Group() throws InterruptedException, IOException 
	{
		//SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
		//						     ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		SORDDp.Edit_Group();
	}
	
	@Test(priority = 7)
	public void Delete_Group() throws InterruptedException, IOException 
	{
		//SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
			//     ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		SORDDp.delete_Group();
	}
	
	@Test(priority = 4)
	public void Edit_Rule() throws Exception 
	{
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
								     ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		SORDDp.Edit_Rule();
		
	}
	
	@Test(priority = 5)
	public void Delete_Rule() throws Exception 
	{
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
		     ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		SORDDp.delete_Rule();
	}
	
	
	@AfterMethod
	@Test(priority = 8)
	public void tearDown() 
	{
		driver.quit();
		System.out.println("Webdriver Closed ");
	}
	
	
}
