package SOR_Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import SOR_resources.Utility;

public class SOR_Rule_Configuration_Page extends Utility

{
	WebDriver driver;

	public SOR_Rule_Configuration_Page(WebDriver driver) throws IOException 
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
	
	@FindBy(xpath = "//button[@id='toggleButton']")
	WebElement toggle_Btn;

	@FindBy(xpath = "//h5[@id='exampleModalLabel']")
	WebElement WinAddgroup;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtGroupName']")
	WebElement txtgroupname;

	@FindBy(xpath = "//textarea[@id='CPHMasterMain_txtGroupDescription']")
	WebElement TxtGroup_Desc;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnCreGroup']")
	WebElement BtnsubmitGroup;
	
	@FindBy(xpath = "//img[@id='progressImage1']")
	WebElement BArprogress;

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

	  

	  @FindBy(xpath = "//select[@id='CPHMasterMain_ddlChannel']") 
	  WebElement ddChannel;

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
	  
	  @FindBy(xpath = "//input[@value='2902']")
	  WebElement ChkAggselect;
	  
	  @FindBy(xpath = "//input[@value='678900']")
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
	
	  @FindBy(xpath = "//select[@id='CPHMasterMain_ddlGroupName']")
	  WebElement Click_TO_Select_GRPname;
	  
	  @FindBy(xpath = "//h5[@id='exampleModalLabelR']")
	  WebElement formofaddrule;
		
		//@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlGroupName-results']")
		//WebElement txt_search_area_GrpName;
		
		/*
		public void select_GRpName(String GRpName) throws InterruptedException 
		{
			Thread.sleep(500);
			Click_TO_Select_GRPname.click();
			Thread.sleep(500);
			//txt_search_area_GrpName.sendKeys(GRpName);
			String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlGroupName-results']/li[text()='" + GRpName + "']";
			WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
			districtElement.click();
			
		}
		*/
		
		  @FindBy(xpath = "//select[@id='CPHMasterMain_ddlSwitch']")
			WebElement Click_TO_Select_Switch_name;
			
			//@FindBy(xpath = "//imput@aria-controls='select2-CPHMasterMain_ddlSwitch-results']")
			//WebElement txt_search_area_Switch_Name;
		/*
		public void select_Switch_Name(String Swith_Name) throws InterruptedException 
		{
			Thread.sleep(500);
			Click_TO_Select_Switch_name.click();
			Thread.sleep(500);
			//txt_search_area_GrpName.sendKeys(GRpName);
			String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlSwitch-results']/li[text()='" + Swith_Name + "']";
			WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
			districtElement.click();
			
		}
	  */
	
	  @FindBy(xpath = "//label[@for='RuleName']")
	  WebElement lblRuleConfiguration;
	 
	  public void Blank_Grp_Name_and_Desc_Blank_Rule_Name_and_Desc() throws InterruptedException 
	  {
	        SoftAssert softAssert = new SoftAssert();
	        
	       TextFileLogger.logMessage("Blank group Name TestCase Start");

	        // Step 1: Navigate to the page
	        lblRuleManagement.click();
	        lblRunConfiguration.click();
	        
	        // Step 2: Check if the 'Add Group' button is displayed, if not, click toggle button
	        if (isDisaplyedW(Btnaddgroup, 2) == false) 
	        {
	           // TextFileLogger.logMessage("Add group button not displayed. Clicking on toggle button.");
	            toggle_Btn.click();
	            
	            // Step 3: After toggling, check if 'Add Group' button is visible
	            if (isDisaplyedW(Btnaddgroup, 2) == true) {
	                //System.out.println("Add group button is visible");
	                Btnaddgroup.click();

	                // Step 4: Test case for blank Group Name
	                BtnsubmitGroup.click();
	                softAssert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("Please Enter Group Name. Try again"),
	                        "Confirmation message for blank group name is not as expected.");
	                Thread.sleep(2000);
	                TextFileLogger.logMessage("Blank Group Name TestCase pass");
	                // Step 5: Test case for blank Group Description
	                txtgroupname.sendKeys("Test");
	                BtnsubmitGroup.click();
	                softAssert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("Please Enter Group Description. Try again"),
	                        "Confirmation message for blank group description is not as expected.");
	                TextFileLogger.logMessage("Blank Group Desc TestCase pass");
	                Thread.sleep(2000);
	                // Step 6: Cancel the group creation
	                BtnCancleGroup.click();
	            }
	            
	            if (isDisaplyedW(Btnaddgroup, 2) == false) 
		        {
		           // TextFileLogger.logMessage("Add group button not displayed. Clicking on toggle button.");
		            toggle_Btn.click();
		            Btnaddrule.click();
		            btnSubmit_Rule.click();
		            
		            softAssert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("Please Enter Rule Name. Try again"),
	                        "Confirmation message for blank rule name is not as expected.");
		            TextFileLogger.logMessage("Blank Rule Name TestCase pass");
	                txtRule_Name.sendKeys("Test");
	                
	                btnSubmit_Rule.click();
	                softAssert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("Please Enter Rule Description. Try again"),
	                        "Confirmation message for blank rule name is not as expected.");
	                TextFileLogger.logMessage("Blank Rule Desc TestCase pass");
	                btncancle_Rule.click();
		            
		        }   
	            
	        }

	        // Step 7: Trigger all soft assertions
	        softAssert.assertAll();
	    }
  
	public void AddGrp(String GRp_Name, String GRp_Desc) throws IOException, InterruptedException 
	{
		
		TextFileLogger.logMessage("Add Group Test Case Start");
		String Grp_Name_Randam=generateRandomName();
		lblRuleManagement.click();
		lblRunConfiguration.click();
		//if (isDisaplyedW(Btnaddgroup, 2) == false) 
		//{
			//TextFileLogger.logMessage("Add group button not displaed Click on toggle button");
			//toggle_Btn.click();
			//if (isDisaplyedW(Btnaddgroup, 2) == true) 
			//{
				//System.out.println("Add group button visible");
				Btnaddgroup.click();
				Thread.sleep(3000);
				txtgroupname.sendKeys(Grp_Name_Randam);
				writeNameToExcel(6,1,Grp_Name_Randam);
				Thread.sleep(1000);
				TxtGroup_Desc.sendKeys(GRp_Desc);
				Thread.sleep(1000);
				BtnsubmitGroup.click();
				//Thread.sleep(5000);
				isVisible(add_Grp_Confirmation_Msg, 20);
				//if(add_Grp_Confirmation_Msg.isDisplayed()==true)
				//{
					if(add_Grp_Confirmation_Msg.getText().contains("Insert Successful"))	
					{
						Assert.assertTrue(true);
					}
					
					else if (add_Grp_Confirmation_Msg.getText().contains("Group Name Already Exists. Try again"))
			        {
						System.out.println("This group name all ready exist");
			        	BtnCancleGroup.click();
			        	Thread.sleep(1000);
			        }
				//}
				
				//else 
				//{
				 //System.out.println("Takes Too much time response from DB");	
				//}
				
				//TextFileLogger.logMessage("Click On Add group");
			//}
			
			//else 
			//{
			 //System.out.println("Still button not visible");	
			//}
			
			
			/*	
	        Assert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("Insert Successful")||add_Grp_Confirmation_Msg.getText().contains
	        		("Group Name Already Exists. Try again"), "Confirmation message not as expected.");
	        */
			
	        //TextFileLogger.logMessage("Add Group Test Case Pass");
	       // System.out.println("Group added successfully");
	   // } //else {
	       
	        //System.out.println("Add Group button not visible");
	       // Assert.fail("Add Group button was not visible, cannot proceed with the group addition.");
	        //TextFileLogger.logMessage("Add Group Test Case Fail");
	    //}			
	}

	public void OpenRUlePage_First() throws InterruptedException 
	{
		Thread.sleep(500);
		lblRuleManagement.click();
		lblRunConfiguration.click();
		Thread.sleep(500);
	}
	
	public void OpenRUlePage() throws InterruptedException 
	{
		if (isDisaplyedW(Btnaddrule, 2) == false && isDisaplyedW(formofaddrule, 2) == false) 
		{
			toggle_Btn.click();
			Thread.sleep(500);
			Btnaddrule.click();
		}
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
	}
	
	// For Aggregator

	@FindBy(xpath = "//div[@id='selectedItems']")
	WebElement DdAggregator;

	@FindBy(xpath = "//input[@id='searchBox']")
	WebElement txt_SerchArea_Aggregator;

	// IIn

	@FindBy(xpath = "//div[@id='selectedSecondItems']")
	WebElement ddIIN;

	@FindBy(xpath = "//input[@id='secondSearchBox']")
	WebElement txt_SerchArea_IIN;

	// Txn-Type

	@FindBy(xpath = "//div[@id='selectedTItems']")
	WebElement ddTxn_TYpe;

	@FindBy(xpath = "//input[@id='TSearchBox']")
	WebElement txt_Txn_TYpe;
	
	public void selectCheckboxFromDropdown(WebElement dropdownContainerElement, WebElement txtSearchArea, String valueToSelect) throws InterruptedException 
	{
	    // Click to open the dropdown
	    dropdownContainerElement.click();
	    Thread.sleep(2000); // Wait for dropdown to expand

	    // Clear and enter the search term
	    txtSearchArea.clear();
	    txtSearchArea.sendKeys(valueToSelect);
	    Thread.sleep(1000); // Wait for filtering

	    // Locate the checkbox based on the value and click it
	    WebElement checkbox = driver.findElement(By.xpath(".//input[@type='checkbox' and @value='" + valueToSelect + "']"));
	    if (!checkbox.isSelected()) {
	        checkbox.click();
	    }
	    Thread.sleep(1000); // Ensure the selection registers
	}
	
	

	public void addRule(String Count,String GRp_Name,String Switch_Name) throws InterruptedException, IOException 
	{
		Thread.sleep(5000);
		if (isDisaplyedW(Btnaddrule, 1) == false) 
		{
			lblRuleManagement.click();
			lblRunConfiguration.click();

		}
		else 
		{
			System.out.println("Btn Add rule all ready displayed");
		}
		
		/*
		if (isDisaplyedW(Btnaddrule, 2) == false) 
		{
			toggle_Btn.click();
			Thread.sleep(500);
			Btnaddrule.click();
		}
		*/
		//DD_Select_Group_Name.click();
		//txtgrpname.click();
		Btnaddrule.click();
		Thread.sleep(2000);
		Dropdownbytxt(Click_TO_Select_GRPname, GRp_Name);
	//	select_GRpName(GRp_Name);
		Thread.sleep(2000);
		txtRule_Name.sendKeys(generateRandomName());
		
		txtRule_Desc.sendKeys("Done By Automation");
		
		selectCheckboxFromDropdown(DdAggregator,txt_SerchArea_Aggregator,"2822");
		
		//DdAggregator.click();
		//ChkAggselect.click();
		lblRuleConfiguration.click();
		
		selectCheckboxFromDropdown(ddIIN,txt_SerchArea_IIN,"121233");
		//ddIIN.click();
		//ChkIINselect.click();
		lblRuleConfiguration.click();
		
		//ddChannel.click();
		//txtChannelname.click();
		
		Dropdownbytxt(ddChannel,"DMT");
		lblRuleConfiguration.click();
		
		//selectCheckboxFromDropdown(ddTxn_TYpe,txt_Txn_TYpe,"AuthRequest");
		
		ddTxn_TYpe.click();
		chkSelectTXnType.click();
		lblRuleConfiguration.click();
		/*
		ddSwitch.click();
		selectswitch.click();
		*/
		Dropdownbyindex(Click_TO_Select_Switch_name, 1);
		//Dropdownbytxt(Click_TO_Select_Switch_name, Switch_Name);
		//select_Switch_Name(Switch_Name);
		
		lblRuleConfiguration.click();
		
		if(Count.contains("Yes"))
		{
			isClicked(togglebtnToConvertCount);
			txtcount.sendKeys("200");
		}
		else 
		{
			txtpercentage.sendKeys("50");
		}
		
		btnSubmit_Rule.click();
		//isInvisible(BArprogress, 15);
		
		
		if(isInvisible(BArprogress, 20)==true)
		{
			//Thread.sleep(2000);
			if(add_Grp_Confirmation_Msg.getText().contains("Insert Successful"))
			{
			Assert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("Insert Successful"), "Confirmation message not as expected.");

	        System.out.println("Rule added successfully");
			} 
			else 
			{
	         System.out.println("Rule add button not visible");
	        }	
		}
		
		else 
		{
		 System.out.println("Takes Too much time response from DB");	
		}
		
		
		
		
	}
	
}
