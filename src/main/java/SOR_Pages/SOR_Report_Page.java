package SOR_Pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SOR_resources.Utility;

public class SOR_Report_Page extends Utility 
{
	WebDriver driver; //Local variable

	public SOR_Report_Page(WebDriver driver)  //Constructor
	{
		super(driver); //Send Driver to utility 
		this.driver = driver; //Assign driver to Current page
		PageFactory.initElements(driver, this); //Intilization driver to current Webelement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Implicit Wait
	}
	
	//Web element for Report
	
	@FindBy(xpath = "//div[@class='sidebar-open']//button[@id='BtnSubb7']")
	WebElement Click_Report;
	
	@FindBy(xpath = "//div[@class='sidebar-open']//li[@id='submm22']")
	WebElement Report_AePS;
	
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtFromDate']")
	WebElement date_From;
	
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtToDate']")
	WebElement date_To;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement txt_Search_Box;
	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlTranType-container']")
	WebElement dd_Txn_Type;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement add_Grp_Confirmation_Msg; // Insert Successful

	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlTransactionStatus-container']")
	WebElement dd_txn_Stataus;
	
	@FindBy(xpath ="//span[@id='select2-CPHMasterMain_ddlbcCode-container']")
	WebElement dd_bc_name;
	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlAggregator-container']")
	WebElement dd_Agg_Name;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtAgentCode']")
	WebElement txt_agent_Code;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtRRNo']")
	WebElement txt_RRN;
	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlAction-container']")
	WebElement dd_Action;
	
	@FindBy(xpath = "//button[@id='CPHMasterMain_Button1']")
	WebElement btn_search;
	
	@FindBy(xpath = "//span[@id='CPHMasterMain_lblRecordCount']")
	WebElement no_count_Total;
	
	public void selectFromDropdown(WebElement dropdownContainerElement , String searchTerm)
			throws InterruptedException 
	{
		dropdownContainerElement.click();
		Thread.sleep(500);
		txt_Search_Box.sendKeys(searchTerm);
		Thread.sleep(500);
		txt_Search_Box.sendKeys(Keys.ENTER);
		Thread.sleep(500);
	}
	

	public void AePS_Report() throws InterruptedException 
	{
		Click_Report.click();
		Report_AePS.click();
		
		date_From.clear();
		date_From.sendKeys("30-01-2025"); 
		
		if(isAlertPresent()==true)
		{
			if(driver.switchTo().alert().getText().contains("Selected date can not be greater than Current date !!"))
					{
						driver.switchTo().alert().accept();
						System.out.println("Entered dater is not correct format");
					}
		}
		
		
		date_To.clear();
		date_To.sendKeys("01-02-2025"); 
		
		if(isAlertPresent()==true)
		{
			if(driver.switchTo().alert().getText().contains("Selected date can not be greater than Current date !!"))
					{
						driver.switchTo().alert().accept();
						System.out.println("Entered dater is not correct format");
					}
		}
		
		//date_From.sendKeys("2025-01-31");
		//date_To.sendKeys("31-01-2025");
		selectFromDropdown(dd_Txn_Type,"Withdrawal");
		selectFromDropdown(dd_txn_Stataus,"Success");
		selectFromDropdown(dd_bc_name,"Quicksun");
		selectFromDropdown(dd_Agg_Name,"TransactLink");
		txt_agent_Code.sendKeys("TD01");
		txt_RRN.sendKeys("");
		selectFromDropdown(dd_Action,"View");
		btn_search.click();
		
		if(add_Grp_Confirmation_Msg.getText().contains("No Data Found In Search Criteria. Try again"))
		{
			System.out.println(add_Grp_Confirmation_Msg.getText());
			selectFromDropdown(dd_bc_name,"AccountFusion");
			selectFromDropdown(dd_Agg_Name,"FlowSync");
			selectFromDropdown(dd_Txn_Type,"All");
			btn_search.click();
		}
		
		System.out.println(no_count_Total.getText().replaceAll("\\D+", ""));
		
		//String numberOnly = no_count_Total.getText().replaceAll("\\D+", "");
		
	}
	
	
	
}
