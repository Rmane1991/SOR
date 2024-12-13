package SOR_Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import SOR_resources.Utility;

public class SOR_Switch_Configuration_Page extends Utility 
{

	WebDriver driver;

	public SOR_Switch_Configuration_Page(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@FindBy(xpath = "//button[@id='BtnSubb3']//h5[@class='sidebar-headings']")
	WebElement lblRuleManagement;

	@FindBy(xpath = "//li[@id='submm8']")
	WebElement lblSwitchConfiguration;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnAddSwitch']")
	WebElement BtnAddSwitch;

	@FindBy(xpath = "//input[@id='CPHMasterMain_rptSwitchDetails_btnEdit_0']")
	WebElement EditPercentage;

	@FindBy(xpath = "//input[@id='CPHMasterMain_rptSwitchDetails_txtPercentage_0']")
	WebElement txtboxPercentage; // Get text from that

	@FindBy(xpath = "//input[@id='CPHMasterMain_rptSwitchDetails_btnUpdate_0']")
	WebElement btnUpdatePercentage;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtSwitchName']")
	WebElement txtSwitchname;

	@FindBy(xpath = "//textarea[@id='CPHMasterMain_txtSwitchDescription']")
	WebElement txtSwitchDesc;

	@FindBy(xpath = "//*[@id='Switch']/following-sibling::span[@class='sliderr']")
	WebElement togglebtnToConvertSwitchCount_to_Percentage;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtSwitchPercentage']")
	WebElement txtpercentage;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtCount']")
	WebElement txtCount;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnCreSwitch']")
	WebElement btnSubmitSwitch;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnCloseSwitch']")
	WebElement btnCancleSwitch;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement add_Grp_Confirmation_Msg; // Insert Successful

	@FindBy(xpath = "//span[@id='CPHMasterMain_lblErrorMessage']")
	WebElement ErrorMsgPercentage;

	@FindBy(xpath = "//input[contains(@id, 'txtPercentage')]")
	List<WebElement> percentageFields;

	@FindBy(xpath = "//input[contains(@id, \"btnEdit\")]")
	List<WebElement> editButtons;

	@FindBy(xpath = "//input[contains(@id, 'btnUpdate')]")
	List<WebElement> updateButtons;
	
	//For Enter URL
	
	@FindBy(name = "input_AEPS_2")
	WebElement authRequestInput;

	@FindBy(name = "input_AEPS_3")
	WebElement balanceEnquiryInput;

	@FindBy(name = "input_AEPS_4")
	WebElement cashDepositInput;

	@FindBy(name = "input_AEPS_5")
	WebElement fundTransferInput;

	@FindBy(name = "input_AEPS_6")
	WebElement miniStatementInput;

	@FindBy(name = "input_AEPS_7")
	WebElement purchaseInput;

	@FindBy(name = "input_AEPS_8")
	WebElement withdrawalInput; 
	
	@FindBy(name = "input_AEPS_8")
	WebElement reversalInput; 
	
	public void Blank_Switch_Name_Blank_Desc() throws InterruptedException 
	{
		 if (isDisaplyedW(lblSwitchConfiguration, 2) == false)
		 {
			 lblRuleManagement.click();
		 }
		 
		lblSwitchConfiguration.click();
		Thread.sleep(1500);
		BtnAddSwitch.click();
		Thread.sleep(1500);
		
		//For Blank Switch Name
		moveToElementAndClick(btnSubmitSwitch);
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);//Please Enter Switch Name. Try again
		softAssert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("Please Enter Switch Percentage. Try again"),
				"Confirmation message for blank switch percentage is not as expected.");
		TextFileLogger.logMessage("Blank Switch Percentage TestCase pass");
		Thread.sleep(3000);
		
		//Total % exceed than 100
		txtpercentage.sendKeys("101");
		moveToElementAndClick(btnSubmitSwitch);
		Thread.sleep(2000);
		moveToElement(ErrorMsgPercentage);
		softAssert.assertTrue(ErrorMsgPercentage.getText().contains("Total percentage cannot exceed or less 100%."),
				"Confirmation message for blank switch exceed % is not as expected.");
		TextFileLogger.logMessage("Switch Percentage  more than 100 % TestCase pass");
		Thread.sleep(3000);

		//For fetch percentage
		
		int highestValue = Integer.MIN_VALUE;
		WebElement highestEditButton = null;
		WebElement correspondingUpdateButton = null;
		int indexOfHighestValue = -1;
		for (int i = 0; i < percentageFields.size(); i++) {
			String value = percentageFields.get(i).getDomAttribute("value");

			int percentageValue = Integer.parseInt(value);

			if (percentageValue > highestValue) {
				highestValue = percentageValue;
				highestEditButton = editButtons.get(i);
				correspondingUpdateButton = updateButtons.get(i);
				indexOfHighestValue = i;
			}
		}

		if (highestEditButton != null) {
			highestEditButton.click();

			if (highestValue > 30) 
			{
				int perValue = Integer.parseInt("10");
				int newValue = highestValue - perValue;
				WebElement highestInputField = percentageFields.get(indexOfHighestValue);
				highestInputField.clear();
				highestInputField.sendKeys(String.valueOf(newValue));
			}

			final int MAX_RETRIES = 4;
			int retries = 0;
			boolean success = false;

			while (retries < MAX_RETRIES) {
				try {
					correspondingUpdateButton = updateButtons.get(indexOfHighestValue);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.elementToBeClickable(correspondingUpdateButton));

					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
							correspondingUpdateButton);

					correspondingUpdateButton.click();
					success = true;
					break;
				} catch (StaleElementReferenceException e)

				{
					retries++;
				} catch (Exception e)

				{
					e.printStackTrace();
					break;
				}
			}

			if (!success) {
				System.out.println("Failed to click the Update button after " + MAX_RETRIES + " attempts.");
			}
		}

		int totalPercentage = 0;

		for (WebElement field : percentageFields) {
			try {
				String valueString = field.getDomAttribute("value");

				int value = Integer.parseInt(valueString);
				totalPercentage += value;
			} catch (Exception e) {
				System.out.println("Error while retrieving percentage value: " + e.getMessage());
			}
		}

		String percent = Integer.toString(100 - totalPercentage);
		txtpercentage.clear();
		txtpercentage.sendKeys(percent);
		moveToElement(btnCancleSwitch);
		moveToElementAndClick(btnSubmitSwitch);
		Thread.sleep(1000);
		softAssert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("Please Enter Switch Name. Try again"),
				"Confirmation message for blank switch description is not as expected.");
		TextFileLogger.logMessage("Blank Switch name TestCase pass");
		Thread.sleep(3000);
		
		//Switch Name
		txtSwitchname.sendKeys("Test_01");
		moveToElementAndClick(btnSubmitSwitch);//Please Enter Switch Name. Try again
		softAssert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("Please Enter Switch Description. Try again"),
		"Confirmation message for blank switch percentage is not as expected.");
		TextFileLogger.logMessage("Blank Switch desc TestCase pass");
		Thread.sleep(3000);
		
		
		//Need this validation After Name
		moveToElement(txtSwitchDesc);
		txtSwitchDesc.sendKeys("Test");
		moveToElementAndClick(btnSubmitSwitch);
		softAssert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("Please Enter Txn Type Url. Try again"),
				"Confirmation message for blank switch URL is not as expected.");
		TextFileLogger.logMessage("Blank URL TestCase pass");
		Thread.sleep(3000);
		moveToElementAndClick(btnCancleSwitch);
		Thread.sleep(2000);
		 softAssert.assertAll();
		
	}
	

	@SuppressWarnings("deprecation")
	public void addSwitch(String SwitchName, String SwitchDesc, String per) throws InterruptedException 
	{
		lblRuleManagement.click();
		lblSwitchConfiguration.click();
		BtnAddSwitch.click();
		
		
		int highestValue = Integer.MIN_VALUE;
	    WebElement highestEditButton = null;
	    WebElement correspondingUpdateButton = null;
	    int indexOfHighestValue = -1;

	    // Find the highest percentage value and corresponding buttons
	    for (int i = 0; i < percentageFields.size(); i++) {
	        String value = percentageFields.get(i).getDomAttribute("value");
	        int percentageValue = Integer.parseInt(value);

	        if (percentageValue > highestValue) {
	            highestValue = percentageValue;
	            highestEditButton = editButtons.get(i);
	            correspondingUpdateButton = updateButtons.get(i);
	            indexOfHighestValue = i;
	        }
	    }

	    if (highestEditButton != null) {
	        highestEditButton.click();

	        if (highestValue > 30) {
	            int perValue = Integer.parseInt(per);
	            int newValue = highestValue - perValue;

	            WebElement highestInputField = percentageFields.get(indexOfHighestValue);
	            highestInputField.clear();
	            highestInputField.sendKeys(String.valueOf(newValue));
	        }

	        final int MAX_RETRIES = 4;
	        int retries = 0;
	        boolean success = false;

	        while (retries < MAX_RETRIES) {
	            try {
	                correspondingUpdateButton = updateButtons.get(indexOfHighestValue);
	                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	                wait.until(ExpectedConditions.elementToBeClickable(correspondingUpdateButton));

	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
	                        correspondingUpdateButton);

	                correspondingUpdateButton.click();
	                success = true;
	                break;
	            } catch (StaleElementReferenceException e) {
	                retries++;
	            } catch (Exception e) {
	                e.printStackTrace();
	                break;
	            }
	        }

	        if (!success) {
	            System.out.println("Failed to click the Update button after " + MAX_RETRIES + " attempts.");
	        }
	    }

	    
	    List<WebElement> percentageFields = driver.findElements(By.xpath("//input[@type='number']"));

	    int totalPercentage = 0;
	    
	    for (WebElement field : percentageFields) {
	        try {
	            
	            if (!field.isDisplayed()) {
	                System.out.println("Hidden element skipped: " + field.getAttribute("id"));
	                continue; 
	            }

	            String valueString = field.getDomAttribute("value");
	            System.out.println("Visible element value: " + valueString);

	            if (valueString == null || valueString.trim().isEmpty()) 
	            {
	                System.out.println("Empty or null value found. Skipping...");
	                continue;
	            }
	            
	            int value = Integer.parseInt(valueString.trim());
	            totalPercentage += value;
	        } catch (Exception e) {
	            System.out.println("Error processing field: " + e.getMessage());
	        }
	    }

	    // Print the total percentage
	    System.out.println("Total Percentage (Visible Elements Only): " + totalPercentage);

		String Switch_Name= generateRandomName();
		txtSwitchname.sendKeys(Switch_Name);
		writeNameToExcel(9, 1, Switch_Name);
		txtSwitchDesc.sendKeys(Switch_Name);
		String percent = Integer.toString(100 - totalPercentage);
		txtpercentage.sendKeys(percent);
		Thread.sleep(2000);
		
		if(Switch_Name.contains("Maximus"))
		{
			authRequestInput.clear();
			authRequestInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
			balanceEnquiryInput.clear();
	        balanceEnquiryInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
	        cashDepositInput.clear();
	        cashDepositInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
	        fundTransferInput.clear();
	        fundTransferInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
	        moveToElement(reversalInput);
	        miniStatementInput.clear();
	        miniStatementInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
	        purchaseInput.clear();
	        purchaseInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
	        withdrawalInput.clear();
	        withdrawalInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
	        reversalInput.clear();
	        reversalInput.sendKeys("http://172.19.10.32:8666/api/AEPS/ReversalRequest");
		}
		else
		{
		authRequestInput.clear();
		authRequestInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
		balanceEnquiryInput.clear();
        balanceEnquiryInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
        cashDepositInput.clear();
        cashDepositInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
        fundTransferInput.clear();
        fundTransferInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
        moveToElement(withdrawalInput);
        miniStatementInput.clear();
        miniStatementInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
        purchaseInput.clear();
        purchaseInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
        withdrawalInput.clear();
        withdrawalInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
		}
        Thread.sleep(2000);
		moveToElementAndClick(btnSubmitSwitch);

		if (add_Grp_Confirmation_Msg.getText().contains("Insert Successful")) 
		{
			System.out.println("Switch Added Sucessfull");
		}
		
		else if(add_Grp_Confirmation_Msg.getText().contains("Switch Name Already Exists. Try again"))
		{
			isInvisible(add_Grp_Confirmation_Msg,10);
			System.out.println("This switch name all ready Present Trying second attempt");
			moveToElement(txtSwitchname);
			txtSwitchname.clear();
			String Switch_Name1=generateRandomName();
			txtSwitchname.sendKeys(Switch_Name1);
			writeNameToExcel(9, 1, Switch_Name1);
			txtSwitchDesc.clear();
			txtSwitchDesc.sendKeys(Switch_Name1);
			
			if(Switch_Name.contains("Maximus"))
			{
				authRequestInput.clear();
				authRequestInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
				balanceEnquiryInput.clear();
		        balanceEnquiryInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
		        cashDepositInput.clear();
		        cashDepositInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
		        fundTransferInput.clear();
		        fundTransferInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
		        moveToElement(reversalInput);
		        miniStatementInput.clear();
		        miniStatementInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
		        purchaseInput.clear();
		        purchaseInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
		        withdrawalInput.clear();
		        withdrawalInput.sendKeys("http://172.25.52.170:4555/AEPS/MaxReqMiniState");
		        reversalInput.clear();
		        reversalInput.sendKeys("http://172.19.10.32:8666/api/AEPS/ReversalRequest");
				
			}
			else
			{
				authRequestInput.clear();
				authRequestInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
				balanceEnquiryInput.clear();
		        balanceEnquiryInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
		        cashDepositInput.clear();
		        cashDepositInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
		        fundTransferInput.clear();
		        fundTransferInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
		        moveToElement(withdrawalInput);
		        miniStatementInput.clear();
		        miniStatementInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
		        purchaseInput.clear();
		        purchaseInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
		        withdrawalInput.clear();
		        withdrawalInput.sendKeys("http://172.25.52.170:4555/AEPS/ReqBalEnq");
			}
	        Thread.sleep(2000);
			moveToElementAndClick(btnSubmitSwitch);
			if (add_Grp_Confirmation_Msg.getText().contains("Insert Successful")) 
			{
				System.out.println("Switch Added Sucessfull");
			}
			
		}
	}

}
