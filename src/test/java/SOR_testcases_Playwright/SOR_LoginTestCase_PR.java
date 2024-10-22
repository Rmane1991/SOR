package SOR_testcases_Playwright;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SOR_Pages_Playwright.SOR_Login_Page_PR;


public class SOR_LoginTestCase_PR extends Base_PR {

   SOR_Login_Page_PR login_page;

    @BeforeMethod
    @DataProvider(name = "browsers")
    public Object[][] browsers() 
    {
        return new Object[][] {
            { "chrome" },
            { "firefox" },
            { "edge" }
        };
    }

    @Test(priority = 1, dataProvider = "browsers")
    public void Check_Valid_Credentials(String browserType) throws Exception 
    {
        page = launchBrowser(browserType);
        login_page = new SOR_Login_Page_PR(page);
        login_page.Check_Valid_Credentials(sheet.getRow(3).getCell(1).getStringCellValue(), sheet.getRow(3).getCell(3).getStringCellValue());
    }

    @Test(priority = 2, dataProvider = "browsers")
    public void check_Blank_Username(String browserType) throws Exception 
    {
        page = launchBrowser(browserType);
        login_page = new SOR_Login_Page_PR(page);
        login_page.Blank_UserName(sheet.getRow(3).getCell(3).getStringCellValue());
    }

    @Test(priority = 3, dataProvider = "browsers")
    public void check_Blank_Password(String browserType) throws Exception 
    {
        page = launchBrowser(browserType);
        login_page = new SOR_Login_Page_PR(page);
        login_page.Blank_Password(sheet.getRow(3).getCell(1).getStringCellValue());
    }

    @AfterMethod
    public void tearDown() 
    {
        if (browser != null) 
        {
            browser.close(); 
        }
        if (playwright != null) 
        {
            playwright.close(); 
        }
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
				sheet.getRow(5).getCell(7).getStringCellValue(), sheet.getRow(1).getCell(7).getStringCellValue());
	}

	

	
	@Test(priority = 5)
	public void check_Select_Room()

	{
		login_page.Select_Room(sheet.getRow(5).getCell(3).getStringCellValue(),
				sheet.getRow(5).getCell(5).getStringCellValue());
	}
*/
	

}
