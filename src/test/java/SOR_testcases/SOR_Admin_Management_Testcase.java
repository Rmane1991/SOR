package SOR_testcases;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SOR_Pages.SOR_Admin_Management_Page;
import SOR_Pages.SOR_Login_Page;
import SOR_resources.Utility.TextFileLogger;

public class SOR_Admin_Management_Testcase extends Base {
	SOR_Login_Page SORLp;
	SOR_Admin_Management_Page SORAMp;

	@BeforeClass
	public void initalization() throws Exception {
		launchBrowser();
		SORLp = new SOR_Login_Page(driver);
		SORAMp = new SOR_Admin_Management_Page(driver);
		TextFileLogger.initializeLogger("SOR_Admin_Management_Testcase");
	}

	@Test(priority = 1)
	public void Create_Role() throws Exception 
	{
		SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)) // UserName
				, getCellValueAsString(sheet.getRow(3).getCell(3)));// Password
		SORAMp.Create_Role();

	}

	@Test(priority = 2, dependsOnMethods = "Create_Role")
	public void Assign_Permission() throws Exception 
	{
		ReadExcel();
		SORAMp.assignRandomPermissions(getCellValueAsString(sheet.getRow(23).getCell(1)) // Role_Name
				, getCellValueAsString(sheet.getRow(12).getCell(1)));// BC_Name
	}

	@Test(priority = 3, dependsOnMethods = "Assign_Permission")
	public void Add_User() throws InterruptedException, IOException 
	{
		SORAMp.Add_User(getCellValueAsString(sheet.getRow(12).getCell(1)) // BC Name
				, getCellValueAsString(sheet.getRow(23).getCell(1))); // Role_Name
	}

	@Test(priority = 4, dependsOnMethods = "Add_User")
	public void Verify_Permission() throws InterruptedException, IOException 
	{
		ReadExcel();
		SORAMp.Verify_Pemission(getCellValueAsString(sheet.getRow(21).getCell(1))); // User Name
	}

	@AfterClass
	public void tearDown() throws IOException {
		if (driver != null) {
			driver.quit();
			System.out.println("WebDriver Closed");
			TextFileLogger.closeLogger();
		}
	}

}
