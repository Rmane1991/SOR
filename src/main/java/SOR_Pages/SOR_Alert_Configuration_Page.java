package SOR_Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SOR_resources.Utility;

public class SOR_Alert_Configuration_Page extends Utility 
{
	WebDriver driver; //Local variable

	public SOR_Alert_Configuration_Page(WebDriver driver)  //Constructor
	{
		super(driver); //Send Driver to utility 
		this.driver = driver; //Assign driver to Current page
		PageFactory.initElements(driver, this); //Intilization driver to current Webelement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Implicit Wait
	}
	
	//Web element for Report
	
	@FindBy(xpath = "//div[@class='sidebar-open']//button[@id='BtnSubb8']")
	WebElement Click_ApplicationMGmt;
	
	@FindBy(xpath = "//li[@id='submm29']")
	WebElement Click_Alert_Configuration;
	
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_btnAddGroup']")
	WebElement btn_add_Group;
	
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_btnAddRule']")
	WebElement btn_add_Rule;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtGroupName']")
	WebElement txt_group_name;
	
	@FindBy(xpath = "//textarea[@id='CPHMasterMain_txtGroupDescription']")
	WebElement txt_grp_Desc;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement add_Grp_Confirmation_Msg; // Insert Successful

	
	@FindBy(xpath = "//input[@id='CPHMasterMain_btnCreGroup']")
	WebElement btn_submit_Grp;
	
	@FindBy(xpath ="//input[@id='CPHMasterMain_btnCloseGroup']")
	WebElement btn_cancle_Grp;
	

    // Alert Name
    @FindBy(id = "CPHMasterMain_txtRuleName")
    private WebElement txt_AlertName;

    @FindBy(id = "charCountAlertName")
    private WebElement txt_AlertNameCharCount;

    // Group Name
    @FindBy(id = "CPHMasterMain_ddlGroupName")
    private WebElement dd_GroupName;

    // BC Selection
    @FindBy(id = "CPHMasterMain_ddlBClist")
    private WebElement dd_BC;

    // Working Time
    @FindBy(xpath ="//input[@id='CPHMasterMain_txtStartTime']")
    private WebElement txt_StartTime;

    @FindBy(id = "chartxtStartTime")
    private WebElement txt_StartTimeCharCount;

    @FindBy(xpath = "//input[@id='CPHMasterMain_txtEndTime']")
    private WebElement txt_EndTime;

    @FindBy(id = "charCounttxtEndTime")
    private WebElement txt_EndTimeCharCount;

    // Switch
    @FindBy(id = "CPHMasterMain_ddlSwitch")
    private WebElement dd_Switch;

    // Channel
    @FindBy(id = "CPHMasterMain_ddlChannels")
    private WebElement dd_Channel;

    // Description (Hidden)
    @FindBy(id = "CPHMasterMain_txtRuleDescription")
    private WebElement txt_Description;

    // Mobile Number
    @FindBy(xpath ="//input[@id='CPHMasterMain_txtMobile']")
    private WebElement txt_Mobile;

    @FindBy(id = "charCounttxtMobile")
    private WebElement txt_MobileCharCount;

    // Email
    @FindBy(xpath ="//input[@id='CPHMasterMain_txtEmail']")
    private WebElement txt_Email;

    @FindBy(id = "charCounttxtEmail")
    private WebElement txt_EmailCharCount;

    // Email CC
    @FindBy(xpath = "//input[@id='CPHMasterMain_txtEmailCC']")
    private WebElement txt_EmailCC;

    @FindBy(id = "charCounttxtEmailCC")
    private WebElement txt_EmailCCCharCount;

    // Subject
    @FindBy(id = "CPHMasterMain_txtsubject")
    private WebElement txt_Subject;

    @FindBy(id = "charCountSubject")
    private WebElement txt_SubjectCharCount;

    // Alert Mode
    @FindBy(id = "CPHMasterMain_ddlAlertsentOn")
    private WebElement dd_AlertMode;

    // Mail Body (Conditional)
    @FindBy(id = "CPHMasterMain_txtemailBody")
    private WebElement txt_MailBody;

    @FindBy(id = "charCountEmailBody")
    private WebElement txt_MailBodyCharCount;

    // SMS Body (Conditional)
    @FindBy(id = "CPHMasterMain_txtsmsBody")
    private WebElement txt_SMSBody;

    @FindBy(id = "charCountSmSBody")
    private WebElement txt_SMSBodyCharCount;

    // Alert Type
    @FindBy(id = "CPHMasterMain_ddlAlertType")
    private WebElement dd_AlertType;

    // Decline Count
    @FindBy(id = "CPHMasterMain_txtConsicativeDeclineCount")
    private WebElement txt_DeclineCount;

    @FindBy(id = "charDeclineCount")
    private WebElement txt_DeclineCountCharCount;

    // Max Retry Count
    @FindBy(id = "CPHMasterMain_txtmaxRetry")
    private WebElement txt_MaxRetry;

    @FindBy(xpath = "//input[@id='CPHMasterMain_txtmaxRetry']")
    private WebElement txt_MaxRetryCharCount;

    // Timer Interval
    @FindBy(id = "CPHMasterMain_txtTimerInterval")
    private WebElement txt_TimerInterval;

    @FindBy(id = "charCountTimerInterval")
    private WebElement txt_TimerIntervalCharCount;

    // Next Interval (Hidden)
    @FindBy(id = "CPHMasterMain_txtNxtInterval")
    private WebElement txt_NextInterval;

    // Column Selection
    @FindBy(id = "CPHMasterMain_ddlColumnSelected")
    private WebElement dd_ColumnSelection;

    // SQL Operator (Conditions)
    @FindBy(id = "CPHMasterMain_ddlConditions")
    private WebElement dd_SQLOperator;
    
    @FindBy(xpath = "//select[@id='CPHMasterMain_ddlResponseCode']")
    WebElement dd_value_Selection;
    
    @FindBy(xpath = "//select[@id='CPHMasterMain_ddlOperator0']")
    WebElement dd_Operator;
    
    
    @FindBy(xpath = "//input[@id='CPHMasterMain_btnAddCondition']")
    WebElement btn_add_condition;
    
    @FindBy(xpath = "//input[@id='CPHMasterMain_btnCreateRule']")
    WebElement btn_Submit_Alert;
    
	/*
	public void selectFromDropdown(WebElement dropdownContainerElement , String searchTerm)
			throws InterruptedException 
	{
		dropdownContainerElement.click();
		Thread.sleep(500);
		txt_Search_Box.sendKeys(searchTerm);
		Thread.sleep(500);
		txt_Search_Box.sendKeys(Keys.ENTER);
		Thread.sleep(500);
	}*/
    
    
    public void Add_Grpup() 
    {
    	Click_ApplicationMGmt.click();
    	Click_Alert_Configuration.click();
    	btn_add_Group.click();
		txt_group_name.sendKeys("Demo_Alert");
		txt_grp_Desc.sendKeys("Done by automation");
		btn_submit_Grp.click();
		
		if (add_Grp_Confirmation_Msg.getText().contains("Successful")) 
		{
		    Assert.assertTrue(true, "Insert was successful.");
		} else 
		{
		    Assert.fail("Group Was not added for alert");
		}
		
	}
    
    public void Add_Alert() throws InterruptedException 
    {
    	if(btn_add_Rule.isDisplayed()==true)
    	{
    		System.out.println("Add alert button visible");
    	}
    	else 
    	{
    		Click_ApplicationMGmt.click();
        	Click_Alert_Configuration.click();
		}
    	
    	btn_add_Rule.click();
    	txt_AlertName.sendKeys("Demo_Alert");
    	Dropdownbytxt(dd_GroupName, "Demo_Alert");
    	Dropdownbytxt(dd_BC, "BCNew");
    	
    	Thread.sleep(500);
    	txt_EndTime.click();
    	txt_StartTime.sendKeys("16:10");
    	Thread.sleep(500);
    	txt_EndTime.click();
    	txt_EndTime.sendKeys("16:20");
    	Thread.sleep(500);
    	Dropdownbytxt(dd_Switch, "Maximus");
    	Thread.sleep(500);
    	Dropdownbytxt(dd_Channel, "AEPS");
    	Thread.sleep(500);
    	txt_Mobile.sendKeys("8275370066");
    	Thread.sleep(500);
    	txt_Email.sendKeys("r@r.com");
    	Thread.sleep(500);
    	txt_EmailCC.sendKeys("rc@r.com");
    	Thread.sleep(500);
    	txt_Subject.sendKeys("Test");
    	Thread.sleep(500);
    	Dropdownbytxt(dd_AlertMode, "Email");
    	Thread.sleep(500);
    	txt_MailBody.sendKeys("Test");
    	Thread.sleep(500);
    	Dropdownbyindex(dd_AlertType, 1);
    	Thread.sleep(500);
    	txt_DeclineCount.sendKeys("5");
    	Thread.sleep(500);
    	txt_MaxRetryCharCount.sendKeys("5");
    	Thread.sleep(500);
    	txt_TimerInterval.sendKeys("5");
    	Thread.sleep(500);
    	Dropdownbyindex(dd_ColumnSelection, 1);
    	Thread.sleep(500);
    	Dropdownbyindex(dd_SQLOperator, 1);
    	Thread.sleep(500);
    	Dropdownbyindex(dd_value_Selection, 1);
    	Thread.sleep(500);
    	btn_add_condition.click();
    	Thread.sleep(500);
    	moveToElementAndClick(btn_Submit_Alert);
    	//Thread.sleep(500);
    	//System.out.println(add_Grp_Confirmation_Msg.getText());

		if (add_Grp_Confirmation_Msg.getText().contains("Insert Successful")) {
			System.out.println(add_Grp_Confirmation_Msg.getText());
			Assert.assertTrue(true, "Insert was successful.");
		} else if (add_Grp_Confirmation_Msg.getText().contains("Record Already Exist")) {
			System.out.println(add_Grp_Confirmation_Msg.getText());
			Assert.assertTrue(true, "This combination Alert all ready Added");
		} else

		{
			System.out.println(add_Grp_Confirmation_Msg.getText());
			Assert.fail("Group Was not added for alert");
		}
	}
	
}
