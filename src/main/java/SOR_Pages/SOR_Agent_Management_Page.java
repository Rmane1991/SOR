package SOR_Pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SOR_resources.Utility;

public class SOR_Agent_Management_Page extends Utility
{

	WebDriver driver;
	
	public SOR_Agent_Management_Page(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlbcCode-container']")
	WebElement selectBusinessCorrespondance;
	
	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlbcCode-results']")
	WebElement txtsearchareaSelectBC;
	
	public void selectBC(String BCName) throws InterruptedException 
	{
		Thread.sleep(500);
		selectBusinessCorrespondance.click();
		Thread.sleep(500);
		txtsearchareaSelectBC.sendKeys(BCName);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlbcCode-results']/li[text()='" + BCName + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
		Thread.sleep(1000);
	}
	
	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlaggregatorCode-container']")
	WebElement selectAggregator;
	
	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlaggregatorCode-results']")
	WebElement txtsearchareaSelectAgg;
	
	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlGender-results']")
	WebElement txtsearchareaSelect_Gender;
	
	public void selectAgg(String AggName) throws InterruptedException 
	{
		Thread.sleep(500);
		selectAggregator.click();
		Thread.sleep(500);
		txtsearchareaSelectAgg.sendKeys(AggName);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlaggregatorCode-results']/li[text()='" + AggName + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlGender-container']")
	WebElement Click_On_Gender;
	
	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlGender-results']")
	WebElement txtSearch_On_Gender;
	
	
	public void select_Gender(String gender) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    int attempts = 0; 
	    
	    while (attempts < 3) 
	    { 
	        try 
	        {
	            WebElement genderDropdown = wait.until(ExpectedConditions.elementToBeClickable(Click_On_Gender));
	            genderDropdown.click();
	            String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlGender-results']/li[text()='" + gender + "']";
	            WebElement genderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath)));
	            genderElement.click();
	            break; 
	        } catch (StaleElementReferenceException e) 
	        {
	            System.out.println("Encountered StaleElementReferenceException. Retrying...");
	            attempts++;
	        }
	    }
	    if (attempts == 3) 
	    {
	        throw new AssertionError("Test case failed due to StaleElementReferenceException on selecting gender after multiple attempts.");
	    }
	}
	
	@FindBy(xpath = "//button[@id='BtnSubb6']")
	WebElement lbl_Agent_Mgmt;

	@FindBy(xpath = "//li[@id='submm18']")
	WebElement lbl_Agent_Registration;

	@FindBy(xpath = "//li[@id='submm19']")
	WebElement lbl_Agent_Verification;

	@FindBy(xpath = "//li[@id='submm20']")
	WebElement lbl_Agent_On_Board_Status;

	@FindBy(xpath = "//li[@id='submm21']")
	WebElement lbl_Agent_Overall_Status;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnAddnew']")
	WebElement btn_add_Agent;


	@FindBy(xpath = "//input[@id='CPHMasterMain_chkAEPS']")
	WebElement ChkAEPS;

	@FindBy(xpath = "//input[@id='CPHMasterMain_chkMATM']")
	WebElement ChkMicroATM;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtFirstName']")
	WebElement txtFirstname_Agent_Registration;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtPANNo']")
	WebElement txtPANno_BCRegistration;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtaadharno']")
	WebElement txtAadharno_BCRegistration;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtAccountNumber']")
	WebElement txtAccountno_BCRegistration;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtIFsccode']")
	WebElement txtIFSCcode_BCRegistration;

	@FindBy(xpath = "//textarea[@id='CPHMasterMain_txtRegisteredAddress']")
	WebElement txtRegisteredAddress;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtPinCode']")
	WebElement txtPinCode;

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlState-container']")
	WebElement txtStatename;

	public void selectState(String StateName) throws InterruptedException {
		Thread.sleep(500);
		txtStatename.click();
		Thread.sleep(500);
		StateSearchArea.sendKeys(StateName);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlState-results']/li[text()='" + StateName + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
	}

	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlState-results']")
	WebElement StateSearchArea;

	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlDistrict-results']")
	WebElement DistrictSearchArea;

	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlCity-results']")
	WebElement CitySearchArea;

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlDistrict-container']")
	WebElement ClickDistrict;

	public void selectDistrict(String DistrictName) throws InterruptedException {
		Thread.sleep(500);
		ClickDistrict.click();
		Thread.sleep(500);
		DistrictSearchArea.sendKeys(DistrictName);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlDistrict-results']/li[text()='" + DistrictName + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
	}

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlCity-container']")
	WebElement ClickCity;

	public void selectCity(String Cityname) throws InterruptedException {
		Thread.sleep(500);
		ClickCity.click();
		Thread.sleep(500);
		CitySearchArea.sendKeys(Cityname);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlCity-results']/li[text()='" + Cityname + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
	}

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtContactNo']")
	WebElement txtContactNo;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtEmailID']")
	WebElement txtMaildID;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnSubmitDetails']")
	WebElement btnsubmit;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnCancel']")
	WebElement btnbACK;

	@FindBy(xpath = "//*[contains(text(),'Pincode')]")
	WebElement clickOnPinCodeLBl;

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlIdentityProof-container']")
	WebElement SelectIdentityProof;

	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlIdentityProof-results']")
	WebElement ID_Proof_SearchArea;

	public void selectIDProof(String IDname) throws InterruptedException {
		Thread.sleep(500);
		SelectIdentityProof.click();
		Thread.sleep(500);
		ID_Proof_SearchArea.sendKeys(IDname);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlIdentityProof-results']/li[text()='" + IDname + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
	}

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlAddressProof-container']")
	WebElement SelectAddressProof;

	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlAddressProof-results']")
	WebElement ID_Address_SearchArea;

	public void SelectAddressProof(String Addname) throws InterruptedException {
		Thread.sleep(500);
		SelectAddressProof.click();
		Thread.sleep(500);
		ID_Address_SearchArea.sendKeys(Addname);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlAddressProof-results']/li[text()='" + Addname + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
	}

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlSignature-container']")
	WebElement SelectSignatureProof;

	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlSignature-results']")
	WebElement ID_Signature_SearchArea;

	public void SelectSignatureProof(String Signname) throws InterruptedException {
		Thread.sleep(500);
		SelectSignatureProof.click();
		Thread.sleep(500);
		ID_Signature_SearchArea.sendKeys(Signname);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlSignature-results']/li[text()='" + Signname + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
	}

	@FindBy(xpath = "//input[@id='CPHMasterMain_flgUplodMyIdProof']")
	WebElement SelectFileIDProof;

	@FindBy(xpath = "//input[@id='CPHMasterMain_flgUplodMyAddressProof']")
	WebElement SelectFileAddressProof;

	@FindBy(xpath = "//input[@id='CPHMasterMain_flgUplodMySignatureProof']")
	WebElement SelectFileSignatureProof;

	@FindBy(xpath = "//input[@id='CPHMasterMain_BtnSubmit']")
	WebElement BtnSubmitProof;

	@FindBy(xpath = "//input[@id='CPHMasterMain_BtnBack']")
	WebElement BtnCancleProof;

	@FindBy(xpath = "//input[@id='CPHMasterMain_ChkConfirmBC']")
	WebElement chkbuttonforConfirmatiuon;

	@FindBy(xpath = "//input[@id='CPHMasterMain_downloadPass']")
	WebElement BtnSubmitFinal_BC;

	// Verification

	@FindBy(xpath = "//li[@id='submm11']")
	WebElement BtnVerification;

	@FindBy(xpath = "//div[@id='divDownloadDocgrid']")
	WebElement verificationWin;

	public void Agent_Name_Verify(String Agent_Name) 
	{
		String xpath = "//tr[td[contains(text(),'" + Agent_Name + "')]]//input[@title='Click here to verify']";
		WebElement verifyButton = driver.findElement(By.xpath(xpath));
		verifyButton.click();
	}

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtAgentName']")
	WebElement txtnameof_Agent_At_Verification;

	@FindBy(xpath = "//input[@id='CPHMasterMain_rdbtnApproveDecline_0']")
	WebElement chkApproveButton;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtFinalRemarks']")
	WebElement txtremark_BCVerification;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnSubmitDetails']")
	WebElement btnSubmitVerification;
	
	
	//From Here need to verify
	
	

	public void fetchVerificationDataBy_Agent_name(String Agent_Name)
	{
	    WebElement rowElement = searchRowOnPage(Agent_Name);
	    
	    if (rowElement != null) 
	    {
	        String vireficationBy = rowElement.findElement(By.xpath("./td[15]")).getText();
	        String vireficationOn = rowElement.findElement(By.xpath("./td[16]")).getText();
	        String vireficationRemarks = rowElement.findElement(By.xpath("./td[17]")).getText();

	        ConsoleColor.printColored(">> BC Name: " + Agent_Name, ConsoleColor.GREEN);
	        //System.out.println(">> BC Name: " + bcName);
	        
	        ConsoleColor.printColored(">> Virefication By: " + vireficationBy, ConsoleColor.GREEN);
	        // System.out.println(">> Virefication By: " + vireficationBy);
	        
	        ConsoleColor.printColored(">> Virefication On: " + vireficationOn, ConsoleColor.GREEN);
	        // System.out.println(">> Virefication On: " + vireficationOn);
	      
	        ConsoleColor.printColored(">> Virefication Remarks: " + vireficationRemarks, ConsoleColor.GREEN);
	       // System.out.println(">> Virefication Remarks: " + vireficationRemarks);
	    } else 
	    {
	        System.out.println("BC Name: " + Agent_Name + " not found on this page or any other pages.");
	    }
	}

	private WebElement searchRowOnPage(String Agent_Name) 
	{
	    try {
	    	
	        WebElement rowElement = driver.findElement(By.xpath("//tr[td[contains(text(),'" + Agent_Name + "')]]"));
	        return rowElement;
	    } catch (Exception e) {
	        return null;
	    }
	}

	
	
	public String fetchStatusBy_Agent_Name(String Agent_Name) 
	{
		String status = searchOnPage(Agent_Name);
		while (status.equals("Not Found")) 
		{
			try {
				WebElement nextPageLink = getNextPageLink();

				if (nextPageLink != null) 
				{
					nextPageLink.click();
					Thread.sleep(2000);
					status = searchOnPage(Agent_Name);
				} else 
				
				{
					break;
				}
				
			} catch (Exception e) 
			
			{
				System.out.println("Error switching pages: " + e.getMessage());
				break;
			}
		}

		return status;
	}

	// Method to search for the bc_name on the current page
	private String searchOnPage(String Agent_Name) 
	{
		try {
			WebElement rowElement = driver.findElement(By.xpath("//tr[td[contains(text(),'" + Agent_Name + "')]]"));
			WebElement statusElement = rowElement.findElement(By.xpath("./td[14]"));
			return statusElement.getText();
		} catch (Exception e) 
		{
			return "Not Found";
		}
	}

	private WebElement getNextPageLink() {
		try {
			return driver.findElement(By.xpath("//a[contains(@href, 'Page$')]"));
		} catch (Exception e) 
		{
			return null;
		}
	}
	
	
	//For verification purpose
	
	/*
	public String fetchStatusByBCName(String bcName) {
		String status = searchOnPage(bcName);

		if (status.equals("Not Found")) {
			try {

				WebElement nextPageLink = driver.findElement(By.xpath("//a[contains(@href, 'Page$2')]"));
				nextPageLink.click();
				Thread.sleep(2000);
				status = searchOnPage(bcName);
			} catch (Exception e) {
				System.out.println("Failed to switch to the second page or second page does not exist.");
			}
		}

		return status;
	}

	// Method to search for the bc_name on the current page
	private String searchOnPage(String bcName) {
		try {

			WebElement rowElement = driver.findElement(By.xpath("//tr[td[text()='" + bcName + "']]"));

			WebElement statusElement = rowElement.findElement(By.xpath("./td[14]"));

			String status = statusElement.getText();

			return status;

		} catch (Exception e) {
			return "Not Found";
		}
	}
	
	*/
	/*
	
	public String fetchStatusByBCName(String bcName) {
		try {
			WebElement rowElement = driver.findElement(By.xpath("//tr[td[text()='" + bcName + "']]"));

			WebElement statusElement = rowElement.findElement(By.xpath("./td[14]"));
			return statusElement.getText();

		} catch (Exception e) {
			System.out.println("No BC_Name found with the name '" + bcName + "'.");
			return "Not Found";
		}
	}
	 */
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtdob']")
	WebElement datepikker;
	
	
	
	public static void selectDate(WebDriver driver, String DDMMYYYY)
{
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter webFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(DDMMYYYY, inputFormat);
        String formattedDate = date.format(webFormat);
        WebElement dateInput = driver.findElement(By.id("CPHMasterMain_txtdob"));
        dateInput.sendKeys(formattedDate);
    }
    
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtcode']")
	WebElement txt_Agent_device_Code;
	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlarea-container']")
	WebElement click_Population_grp;
	
	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlarea-results']")
	WebElement Search_area_Population_grp;
	
	
	public void select_Population_Grp(String Population_Grp) throws InterruptedException 
	{
		Thread.sleep(500);
		click_Population_grp.click();
		Thread.sleep(500);
		Search_area_Population_grp.sendKeys(Population_Grp);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlarea-results']/li[text()='" + Population_Grp + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
	}
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtagentId']")
	WebElement txt_Agent_Code;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtTerminalId']")
	WebElement txt_terminal_id;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtLatitude']")
	WebElement txt_Latitude;
	

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtLongitude']")
	WebElement txt_Longitude;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_CheckBoxagent']")
	WebElement chk_Btn_Shop_details_Same;
	
	public void Agent_Registraction(String BCName, String Agg_Name,String Agent_Name,String Gender,String PanNO, String AddharNo,String DateFormat, 
			String AccountNo,String IFSC,String Device_Code,String Population_Grp,String Agent_code,String Terminal_Id, String Latitude,String Longitude ,
			String addres, String Pincode, String State, String District, String City, String EmailID, String ContactNo)
			throws InterruptedException 
	{
		try {
			String Agent_Name_Randam=generateRandomName();
			writeNameToExcel(18,1,Agent_Name_Randam);
			Thread.sleep(1000);
			lbl_Agent_Mgmt.click();
			lbl_Agent_Registration.click();
			Thread.sleep(2000);
			btn_add_Agent.click();
			selectBC(BCName);
			Thread.sleep(1000);
			selectAgg(Agg_Name);
			ChkAEPS.click();
			txtFirstname_Agent_Registration.sendKeys(Agent_Name_Randam);
			txtPANno_BCRegistration.sendKeys(generateRandomPAN_Third_P());
			Thread.sleep(1000);
			//txtFirstname_BCRegistration.click();
			//txtFirstname_Agent_Registration.clear();
			//txtFirstname_Agent_Registration.sendKeys("AlexBob");
			
			
			Thread.sleep(3000);
			
			select_Gender("Female");
			txtAadharno_BCRegistration.sendKeys(generateRandomAadhar());
			datepikker.sendKeys(DateFormat);
			//selectDate(driver,DateFormat);
			txtAccountno_BCRegistration.sendKeys(AccountNo);
			txtIFSCcode_BCRegistration.sendKeys(IFSC);
			txt_Agent_device_Code.sendKeys(generateCode());
			select_Population_Grp(getRandomPopulationGroup());
			txt_Agent_Code.sendKeys(generateCode());
			txt_terminal_id.sendKeys(generateCode());
			txt_Latitude.sendKeys(Latitude);
			txt_Longitude.sendKeys(Longitude);
			moveToElement(btnsubmit);
			txtRegisteredAddress.sendKeys(addres);
			txtPinCode.sendKeys(Pincode);
			clickOnPinCodeLBl.click();
			/*
			Thread.sleep(100);
			selectState(State);
			Thread.sleep(100);
			selectDistrict(District);
			Thread.sleep(100);
			selectCity(City);
			*/
			Thread.sleep(2000);
			txtMaildID.sendKeys(generateRandomEmail());
			txtContactNo.sendKeys(generateRandomMobileNumber());
			chk_Btn_Shop_details_Same.click();
			Thread.sleep(1000);
			moveToElementAndClick(btnsubmit);
			//btnsubmit.click();

			if (isAlertPresent(driver) == true) 
			{
				driver.switchTo().alert().accept();
			}
			
			Thread.sleep(2000);

			selectIDProof("Pancard");
			SelectFileIDProof.sendKeys("C:\\Users\\rajendra.mane\\Downloads\\NSDL1.png");
			Thread.sleep(2000);
			SelectAddressProof("Passport");
			SelectFileAddressProof.sendKeys("C:\\Users\\rajendra.mane\\Downloads\\NSDL1.png");
			Thread.sleep(2000);
			SelectSignatureProof("Pancard");
			SelectFileSignatureProof.sendKeys("C:\\Users\\rajendra.mane\\Downloads\\NSDL1.png");
			Thread.sleep(2000);
			BtnSubmitProof.click();
			Thread.sleep(500);
			if (isAlertPresent(driver) == true) 
			{
				driver.switchTo().alert().accept();
			}
			Thread.sleep(1500);
			moveToElementAndClick(chkbuttonforConfirmatiuon);
			moveToElementAndClick(BtnSubmitFinal_BC);

			Thread.sleep(500);
			if (isAlertPresent(driver) == true) {
				driver.switchTo().alert().accept();
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			if (isAlertPresent(driver) == true) 
			{
				System.out.println(driver.switchTo().alert().getText());
				throw new AssertionError("Test case failed due to alert presence: " + driver.switchTo().alert().getText());
			}
			else 
			{
		        throw new AssertionError("Test case failed due to an exception: " + e.getMessage(), e);
		    }
		}

	}

	public void Agent_Verification(String Agent_Name) throws InterruptedException 
	{
		Thread.sleep(6000);
		if (lbl_Agent_Verification.isDisplayed() == false) 
		{
			lbl_Agent_Mgmt.click();
		}
		
		lbl_Agent_Verification.click();
		Thread.sleep(1000);
		Agent_Name_Verify(Agent_Name);
		Thread.sleep(1000);
		if (isDisaplyedW(verificationWin, 5) == true) 
		{
			ConsoleColor.printColored("Correct Windows Opened of :- "+Agent_Name, ConsoleColor.GREEN);
			//System.out.println("Windows Displayed");

			if (txtnameof_Agent_At_Verification.getAttribute("value").contains(Agent_Name)) 
			{
				ConsoleColor.printColored("Correct Windows Opened of :- "+Agent_Name, ConsoleColor.GREEN);
				//System.out.println("Correct Windows Opened");
				Thread.sleep(3000);
				chkApproveButton.click();
				txtremark_BCVerification.sendKeys("This is Approved By Automation");
				btnSubmitVerification.click();
			}
			else 
			{
				ConsoleColor.printColored("Aggregator name missmatch :-"+ Agent_Name, ConsoleColor.RED);
			}
			

			if (isAlertPresent(driver) == true) 
			{
				driver.switchTo().alert().accept();
			}
		}

	}
	
	public void On_Board_Agent_Status(String Agent_Name) throws InterruptedException 
	{
		Thread.sleep(5000);
		if (lbl_Agent_Verification.isDisplayed() == false) 
		{
			lbl_Agent_Mgmt.click();
		}
		
		lbl_Agent_Overall_Status.click();
		Thread.sleep(2000);
		String return_Value = fetchStatusBy_Agent_Name(Agent_Name);
		Thread.sleep(1000);
		System.out.println(return_Value);
		
		if(return_Value.contains("Approved"))
		{
			fetchVerificationDataBy_Agent_name(Agent_Name);
		//	ConsoleColor.printColored(Bc_Name+" this BC gets :- " +return_Value, ConsoleColor.GREEN);
		}
		/*
		else
		{
			ConsoleColor.printColored(Bc_Name+" this BC gets :- " +return_Value, ConsoleColor.RED);
		}
		*/
		Assert.assertTrue(return_Value.contains("Approved"), Agent_Name + " this Agent status is not Approved. Actual status: " + return_Value);
		
		
		System.out.println(return_Value);

	}

	
	
	
}
