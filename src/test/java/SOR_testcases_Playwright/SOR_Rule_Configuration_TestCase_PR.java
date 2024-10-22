package SOR_testcases_Playwright;


import SOR_Pages_Playwright.SOR_Login_Page_PR;
import SOR_Pages_Playwright.SOR_Rule_Configuration_PR;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SOR_Rule_Configuration_TestCase_PR extends Base_PR
{
	SOR_Rule_Configuration_PR SORRCp;
    SOR_Login_Page_PR login_page;

    @BeforeMethod
    @DataProvider(name = "browsers")
    public Object[][] browsers() 
    {
        return new Object[][] {
            { "chrome" }
            /*,
            { "firefox" },
            { "edge" }*/
        };
    }

    @Test (priority = 1, dataProvider = "browsers")
    public void AddGroup(String browserType) throws Exception 
    {
    	page = launchBrowser(browserType);
        login_page = new SOR_Login_Page_PR(page);
        SORRCp = new SOR_Rule_Configuration_PR(page);
    	login_page.Check_Valid_Credentials(sheet.getRow(3).getCell(1).getStringCellValue(),sheet.getRow(3).getCell(3).getStringCellValue()); 
        SORRCp.addGroup(sheet.getRow(6).getCell(1).getStringCellValue(),sheet.getRow(6).getCell(3).getStringCellValue()); 
    }

    @Test (priority = 2, dataProvider = "browsers")
    public void AddRule(String browserType) throws Exception 
    {
    	page = launchBrowser(browserType);
        login_page = new SOR_Login_Page_PR(page);
        SORRCp = new SOR_Rule_Configuration_PR(page);
        login_page.Check_Valid_Credentials(sheet.getRow(3).getCell(1).getStringCellValue(),sheet.getRow(3).getCell(3).getStringCellValue()); 
        SORRCp.addRule("Yes"); 
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
}
