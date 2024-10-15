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

	public SOR_Rule_Configuration_Page(WebDriver driver) 
	{
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

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlGroupName-container']")
	WebElement DD_Select_Group_Name;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtRuleName']")
	WebElement txtRule_Name;

	@FindBy(xpath = "//textarea[@id='CPHMasterMain_txtRuleDescription']")
	WebElement txtRule_Desc;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement add_Grp_Confirmation_Msg; // Insert Successful

	
	  @FindBy(xpath = "//div[@id='selectedItems']") 
	  WebElement DdAggregator;
	  
	  @FindBy(xpath = "//div[@id='selectedSecondItems']") 
	  WebElement ddIIN;
	  
	  

	  @FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlChannel-container']") 
	  WebElement ddChannel;

	  @FindBy(xpath = "//div[@id='selectedTItems']") 
	  WebElement ddTxn_TYpe;

	  @FindBy(xpath = "//label[@class='switchh']//input[@id='ddlTxn']") 
	  WebElement Switch_Txn_Type;

	  @FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlSwitch-container']") 
	  WebElement ddSwitch;
	  
	  @FindBy(xpath = "//input[@id='CPHMasterMain_txtPercentage']") 
	  WebElement txtpercentage;
	  
	  @FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlTxnTypeFIN-container']") 
	  WebElement dd_FIN_Non_Fin;
	  
	  @FindBy(xpath = "//input[@id='CPHMasterMain_txtCount']")
	  WebElement txtcount;
	  
	  @FindBy(xpath = "//input[@id='CPHMasterMain_btnCreateRule']")
	  WebElement btnSubmit_Rule;
	  
	  @FindBy(xpath = "//input[@id='CPHMasterMain_btnCloseRule']")
	  WebElement btncancle_Rule;
	  
	  @FindBy(xpath = "(//*[text()='Switch Based'])[2]")
	  WebElement txtgrpname;
	  
	  @FindBy(xpath = "//input[@value='BC0003']")
	  WebElement ChkAggselect;
	  
	  @FindBy(xpath = "//input[@value='12123']")
	  WebElement ChkIINselect;
	  
	  @FindBy(xpath = "(//*[text()='AEPS'])[2]")
	  WebElement txtChannelname;
	  
	  @FindBy(xpath = "(//*[text()='Maximus'])[2]")
	  WebElement selectswitch;
	  
	  @FindBy(xpath = "//input[@name='chktxntype' and @value='2']")
	  WebElement chkSelectTXnType;
	  
	  
	  @FindBy(xpath = "//*[@id='Switch']/following-sibling::span[@class='sliderr']")
	  WebElement togglebtnToConvertCount;
	  
	  @FindBy(xpath = "//*[@id='ddlTxn']/following-sibling::span[@class='sliderr']")
	  WebElement togglebtnToConvertFIN_To_NonFIN;
	  
	  
	
  
	  @FindBy(xpath = "//label[@for='RuleName']")
	  WebElement lblRuleConfiguration;
	 
	public void AddGrp(String GRp_Name, String GRp_Desc) 
	{
		lblRuleManagement.click();
		lblRunConfiguration.click();
		if (isDisaplyedW(Btnaddgroup, 2) == true) {
			int beforeaddgroup = verify_Grp_add_Count.size();
			Btnaddgroup.click();
			txtgroupname.sendKeys(GRp_Name);
			TxtGroup_Desc.sendKeys(GRp_Desc);
			BtnsubmitGroup.click();
			int Afteraddgroup = verify_Grp_add_Count.size();

			if (((Afteraddgroup - beforeaddgroup) == 1) && verify_Grp_add.getText().contains("Automation")
					&& add_Grp_Confirmation_Msg.getText().contains("Insert Successful")) {
				System.out.println("Group Add sucessfully");
			}
		}

		else {
			System.out.println("Add Group btn not visible");
		}
	}


	public void addRule(String Count) 
	{
		if (isDisaplyedW(Btnaddrule, 5) == false) 
		{
			lblRuleManagement.click();
			lblRunConfiguration.click();

		}
		else 
		{
			System.out.println("Btn Add rule all ready displayed");
		}
		Btnaddrule.click();
		DD_Select_Group_Name.click();
		txtgrpname.click();
		txtRule_Name.sendKeys("Automation");
		txtRule_Desc.sendKeys("Done By Automation");
		DdAggregator.click();
		ChkAggselect.click();
		lblRuleConfiguration.click();
		ddIIN.click();
		ChkIINselect.click();
		lblRuleConfiguration.click();
		ddChannel.click();
		txtChannelname.click();
		lblRuleConfiguration.click();
		ddTxn_TYpe.click();
		chkSelectTXnType.click();
		lblRuleConfiguration.click();
		ddSwitch.click();
		selectswitch.click();
		lblRuleConfiguration.click();
		
		if(Count.contains("Yes"))
		{
			isClicked(togglebtnToConvertCount);
			//togglebtnToConvertCount.click();
			txtcount.sendKeys("200");
		}
		else 
		{
			txtpercentage.sendKeys("50");
		}
		
		btnSubmit_Rule.click();
		
		
		
	}
}
