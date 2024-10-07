package SOR_Pages_Playwright;

import com.microsoft.playwright.Page;
import SOR_resources_Playwright.Utility_PR.ConsoleColor;
import org.testng.Assert;

public class SOR_Login_Page_PR 
 {
	Page page;

	public SOR_Login_Page_PR(Page page) 
    {
        this.page = page;
    }
	

    // Locators
    private final String txtusername = "//input[@id='txtUserName']";
    private final String txtPWd = "//input[@id='txtPassword']";
    private final String btnsubmit = "//input[@id='btnLogin']";
    private final String LeftMenu = "//div[@id='accordionExample']";
    private final String lblblankUsername = "//span[@id='RequiredFieldValidator5']"; // Please enter UserName
    private final String lblblankPwd = "//label[@id='lblErrorMsg']"; // Login failed

    
    public void Check_Valid_Credentials(String UserName, String Password) throws InterruptedException 
    {
        page.locator(txtusername).clear();
        Thread.sleep(500);
        page.locator(txtusername).fill(UserName);
        Thread.sleep(500);
        page.locator(txtPWd).clear();
        Thread.sleep(500);
        page.locator(txtPWd).fill(Password);
        Thread.sleep(500);
        page.locator(btnsubmit).click();
        Thread.sleep(2000);
        
        if (page.locator(LeftMenu).isVisible()) 
        {
        	ConsoleColor.printColored("Login Successful With Username :- " + UserName,ConsoleColor.GREEN);
        	//System.out.println("Login Successful With Username :- " + UserName);
            Assert.assertTrue(true);
        } else 
        {
        	ConsoleColor.printColored("Login Failed",ConsoleColor.RED);
        	//  System.out.println("Login Failed");
            Assert.fail("Login failed");
        }
}

    public void Blank_UserName(String Password) {
        page.locator(txtusername).clear();
        page.locator(txtPWd).clear();
        page.locator(btnsubmit).click();

        String actualText = page.locator(lblblankUsername).textContent();
        if (actualText.contains("Please enter UserName")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Username validation message not displayed");
        }
    }

    public void Blank_Password(String UserName) {
        page.locator(txtusername).clear();
        page.locator(txtusername).fill(UserName);
        page.locator(txtPWd).clear();
        page.locator(btnsubmit).click();

       
        String actualText = page.locator(lblblankPwd).textContent();
        if (actualText.contains("Login failed")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Password validation message not displayed");
        }
    }
}
