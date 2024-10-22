package SOR_testcases_Playwright;


import SOR_Pages_Playwright.SOR_Login_Page_PR;
import SOR_Pages_Playwright.SOR_Switch_Configuration_Page_PR;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SOR_Switch_Configuration_TestCase_PR extends Base_PR 
{

    SOR_Login_Page_PR SORLp;
    SOR_Switch_Configuration_Page_PR SORwCp;

    @BeforeMethod
    @DataProvider(name = "browsers")
    public Object[][] browsers() 
    {
        return new Object[][] 
        {
            { "chrome" }
            /*,
            { "firefox" },
            { "edge" }
            */
        };
    }
    

    @Test (priority = 1, dataProvider = "browsers")
    public void AddSwitch(String browserType) throws Exception 
    {
    	page = launchBrowser(browserType);
    	SORLp = new SOR_Login_Page_PR(page);
        SORwCp = new SOR_Switch_Configuration_Page_PR(page);
    	SORLp.Check_Valid_Credentials(sheet.getRow(3).getCell(1).getStringCellValue(),sheet.getRow(3).getCell(3).getStringCellValue());
		SORwCp.addSwitch(sheet.getRow(9).getCell(1).getStringCellValue() ,sheet.getRow(9).getCell(3).getStringCellValue(),(int) sheet.getRow(9).getCell(5).getNumericCellValue());
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
