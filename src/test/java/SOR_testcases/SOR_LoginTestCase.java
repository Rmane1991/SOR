package SOR_testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SOR_Pages.SOR_Login_Page;

public class SOR_LoginTestCase extends Base 
{

	SOR_Login_Page login_page;
	//CV_SendEmailViaSMTP CVs;
	//WebDriver driver;

	@BeforeMethod
	public void initalization() throws Exception 
	{
		launchBrowser();
		login_page = new SOR_Login_Page(driver);
		//CVs =new CV_SendEmailViaSMTP();
	}
	
	@Test(priority = 1) // ,groups = "smoke"
	public void Check_Valid_Credentials() throws InterruptedException, IOException

	{
		login_page.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) //UserName 
										  ,getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
	}
	
	@Test(priority = 2)
	public void check_Blank_Username() throws InterruptedException, IOException

	{
		login_page.Blank_UserName(getCellValueAsString(sheet.getRow(3).getCell(3)));
	}
	
	@Test(priority = 3)
	public void check_Blank_Password() throws InterruptedException, IOException

	{
		login_page.Blank_Password(getCellValueAsString(sheet.getRow(3).getCell(1)));
	}


	@Test(priority = 4) // , groups = "smoke"
	public void check_InValid_Password() throws InterruptedException, IOException

	{
		login_page.Invalid_Username(getCellValueAsString(sheet.getRow(3).getCell(1)),getCellValueAsString(sheet.getRow(3).getCell(3)));
	}
	
	@Test(priority = 5) // , groups = "smoke"
	public void check_InValid_User_Name() throws InterruptedException, IOException

	{
		login_page.Invalid_Password(getCellValueAsString(sheet.getRow(3).getCell(1)),getCellValueAsString(sheet.getRow(3).getCell(3)));
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
		System.out.println("Webdriver Closed ");
	}

	/*
	@AfterSuite
	public void SendMail() throws InterruptedException 
	{
		Thread.sleep(5000);
		sendEmailWithReport();
		//CVs.SendEmail();
	}
*/
	//@Test(priority = 1)
	/*
	@Test(priority = 1)
    //public void testWithExcelData(String UserName, String Password) {
	public void check_InValid_UserName()

	{
		login_page.Invalid_Username(sheet.getRow(3).getCell(1).getStringCellValue(),sheet.getRow(3).getCell(3).getStringCellValue());
		//login_page.Invalid_Username(UserName,Password,"");
	}

	@Test(priority = 2) // , groups = "smoke"
	public void check_InValid_Password()

	{
		login_page.Invalid_Password(sheet.getRow(5).getCell(3).getStringCellValue(),
		sheet.getRow(5).getCell(7).getStringCellValue(), 
		sheet.getRow(1).getCell(7).getStringCellValue());
	}

	

	
	@Test(priority = 5)
	public void check_Select_Room()

	{
		login_page.Select_Room(sheet.getRow(5).getCell(3).getStringCellValue(),
				sheet.getRow(5).getCell(5).getStringCellValue());
	}
*/
	

}
