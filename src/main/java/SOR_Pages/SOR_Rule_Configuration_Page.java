package SOR_Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SOR_resources.Utility;

public class SOR_Rule_Configuration_Page extends Utility

{
	WebDriver driver;

	public SOR_Rule_Configuration_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='BtnSubb3']//h5[@class='sidebar-headings']")
	WebElement lblRuleManagement;

	@FindBy(xpath = "//div[@id='subPagess3']//span[text()=' Rule Configuration']")
	WebElement lblRunConfiguration;

	@FindBy(xpath = "//div[@id='subPagess3']//span[text()='Switch Configuration']")
	WebElement lblSwitchConfiguration;

	// Add Group

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnAddGroup']")
	WebElement Btnaddgroup;

	@FindBy(xpath = "//h5[@id='exampleModalLabel']")
	WebElement WinAddgroup;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtGroupName']")
	WebElement txtgroupname;

	@FindBy(xpath = "//textarea[@id='CPHMasterMain_txtGroupDescription']")
	WebElement TxtGroup_Desc;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnCreGroup']")
	WebElement BtnsubmitGroup;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnCloseGroup']")
	WebElement BtnCancleGroup;

	@FindBy(xpath = "//div[@id='pf-list-simple-expansion']")
	WebElement verify_Grp_add;
	
	@FindBy(xpath = "//div[@id='pf-list-simple-expansion']")
	List<WebElement> verify_Grp_add_Count;

	
	// Add Rule

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnAddRule']")
	WebElement Btnaddrule;

	@FindBy(xpath = "//ul[@id='select2-CPHMasterMain_ddlGroupName-results']")
	WebElement SelectGroup_Name;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtRuleName']")
	WebElement txtRule_Name;

	@FindBy(xpath = "//textarea[@id='CPHMasterMain_txtRuleDescription']")
	WebElement txtRule_Desc;

	
	  @FindBy(xpath = "//div[@class='toast-message']") 
	  WebElement add_Grp_Confirmation_Msg; //Insert Successful
	  
	  /*
	  @FindBy(xpath = "") WebElement demo;
	  
	  @FindBy(xpath = "") WebElement demo;
	  
	 */

	public void AddGrp() 
	{
		lblRuleManagement.click();
		lblRunConfiguration.click();
		if (isDisaplyedW(Btnaddgroup, 2) == true) 
		{
			int beforeaddgroup=verify_Grp_add_Count.size();
			Btnaddgroup.click();
			txtgroupname.sendKeys("Automation");
			TxtGroup_Desc.sendKeys("This is Done by Automation");
			BtnsubmitGroup.click();
			int Afteraddgroup=verify_Grp_add_Count.size();
			
			if (((Afteraddgroup - beforeaddgroup) == 1) &&  verify_Grp_add.getText().contains("Automation") && add_Grp_Confirmation_Msg.getText().contains("Insert Successful"))
			{
				System.out.println("Group Add sucessfully");
			}
		}
		
		
		else 
		{
		 System.out.println("Add Group btn not visible");	
		}
	}

}
