package SOR_Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import SOR_resources.Utility;

public class SOR_BC_Management_Page extends Utility 
{
	WebDriver driver;

	public SOR_BC_Management_Page(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		if (driver.manage().timeouts().getImplicitWaitTimeout().isZero()) 
		{
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
	    }
	}

	@FindBy(xpath = "//button[@id='BtnSubb4']")
	WebElement btnBCManagement;

	@FindBy(xpath = "//*[@id='submm9']/a/div/span[2]")
	WebElement BtnBCRegistration;

	@FindBy(xpath = "//li[@id='submm12']")
	WebElement BtnOnboardBC;

	@FindBy(xpath = "//li[@id='submm13']")
	WebElement BtnOveallBCStatus;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnAddnew']")
	WebElement BtnAddNewBC;

	@FindBy(xpath = "//input[@id='CPHMasterMain_chkAEPS']")
	WebElement ChkAEPS;

	@FindBy(xpath = "//input[@id='CPHMasterMain_chkMATM']")
	WebElement ChkMicroATM;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtFirstName']")
	WebElement txtFirstname_BCRegistration;

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

	public void selectState(String StateName) throws InterruptedException 
	{
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

	public void selectIDProof(String IDname) throws InterruptedException 
	{
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
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement Confirmation_Msg; 

	// Verification

	@FindBy(xpath = "//li[@id='submm11']")
	WebElement BtnVerification;

	@FindBy(xpath = "//div[@id='divDownloadDocgrid']")
	WebElement verificationWin;

	public void BC_Name_Verify(String automationName) 
	{
		String xpath = "//td[text()='" + automationName + "']/preceding-sibling::td/input[@title='Click here to verify']";
		WebElement verifyButton = driver.findElement(By.xpath(xpath));
		verifyButton.click();
	}

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtBCName']")
	WebElement txtnameofBCAtVerification;

	@FindBy(xpath = "//input[@id='CPHMasterMain_rdbtnApproveDecline_0']")
	WebElement chkApproveButton;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtFinalRemarks']")
	WebElement txtremark_BCVerification;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnSubmitDetails']")
	WebElement btnSubmitVerification;
	
	
	
	
	
	public void fetchVireficationDataByBCName(String bcName)
	{
	    WebElement rowElement = searchRowOnPage(bcName);
	    
	    if (rowElement != null) 
	    {
	        String vireficationBy = rowElement.findElement(By.xpath("./td[15]")).getText();
	        String vireficationOn = rowElement.findElement(By.xpath("./td[16]")).getText();
	        String vireficationRemarks = rowElement.findElement(By.xpath("./td[17]")).getText();

	        ConsoleColor.printColored(">> BC Name: " + bcName, ConsoleColor.GREEN);
	        
	        ConsoleColor.printColored(">> Virefication By: " + vireficationBy, ConsoleColor.GREEN);
	        
	        ConsoleColor.printColored(">> Virefication On: " + vireficationOn, ConsoleColor.GREEN);
	      
	        ConsoleColor.printColored(">> Virefication Remarks: " + vireficationRemarks, ConsoleColor.GREEN);
	    } else 
	    {
	        System.out.println("BC Name: " + bcName + " not found on this page or any other pages.");
	    }
	}

	private WebElement searchRowOnPage(String bcName) 
	{
	    try {
	    	
	        WebElement rowElement = driver.findElement(By.xpath("//tr[td[text()='" + bcName + "']]"));
	        return rowElement;
	    } catch (Exception e) {
	        return null;
	    }
	}

	public String fetchStatusByBCName(String bcName) 
	{
		String status = searchOnPage(bcName);
		while (status.equals("Not Found")) 
		{
			try {
				WebElement nextPageLink = getNextPageLink();

				if (nextPageLink != null) 
				{
					nextPageLink.click();
					Thread.sleep(2000);
					status = searchOnPage(bcName);
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
	private String searchOnPage(String bcName) 
	{
		try {
			WebElement rowElement = driver.findElement(By.xpath("//tr[td[text()='" + bcName + "']]"));
			WebElement statusElement = rowElement.findElement(By.xpath("./td[14]"));
			return statusElement.getText();
		} catch (Exception e) 
		{
			return "Not Found";
		}
	}
	
	
	
	private WebElement getNextPageLink() {
	    try {
	        // Locate the next page link that is not disabled
	        WebElement nextPageLink = driver.findElement(By.xpath("//a[contains(@href, 'Page$') and not(contains(@class, 'disabled'))]"));
	        
	        // Check if link leads to a new page (e.g., href contains the next page number)
	        String currentPage = driver.getCurrentUrl();
	        String nextPageHref = nextPageLink.getAttribute("href");
	        
	        // If the href attribute contains the next page link, return the element
	        if (!currentPage.equals(nextPageHref)) {
	            return nextPageLink;
	        } else {
	            return null; // No further pages
	        }
	    } catch (NoSuchElementException e) {
	        return null; // No further pages or link is disabled
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	
	
	
	
	/*
	private WebElement getNextPageLink() 
	{
	    try 
	    {
	        WebElement nextPageLink = driver.findElement(By.xpath("//a[contains(@href, 'Page$') and not(contains(@class, 'disabled'))]"));
	        return nextPageLink;
	    } catch (NoSuchElementException e) 
	    {
	        return null;
	    } catch (Exception e) 
	    {
	        e.printStackTrace();
	        return null;
	    }
	}
	*/

	/*
	private WebElement getNextPageLink() {
		try {
			return driver.findElement(By.xpath("//a[contains(@href, 'Page$')]"));
		} catch (Exception e) 
		{
			return null;
		}
	}
	*/
	
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
    
	public void BC_Registraction(String BCName, String PanNO, String AddharNo, String AccountNo, String IFSC,
			String addres, String Pincode, String State, String District, String City, String EmailID, String ContactNo)
			throws InterruptedException {
		
		try {
			
			String BC_Name_Randam=generateRandomName();
			System.out.println(BC_Name_Randam);
			btnBCManagement.click();
			
			BtnBCRegistration.click();
			Thread.sleep(2000);
			//BtnAddNewBC.click();
			if(isClicked(BtnAddNewBC)==true)
			{
				ConsoleColor.printColored("Ad new BC button Click", ConsoleColor.GREEN);
			}
			else 
			
			{
				ConsoleColor.printColored("Ad new BC button not Click", ConsoleColor.RED);
			}
			ChkAEPS.click();
			txtFirstname_BCRegistration.sendKeys(BC_Name_Randam);
			writeNameToExcel(12,1,BC_Name_Randam);
			Thread.sleep(2000);
			txtPANno_BCRegistration.sendKeys(generateRandomPAN());
			txtAadharno_BCRegistration.sendKeys(generateRandomAadhar());
			txtAccountno_BCRegistration.sendKeys(AccountNo);
			txtIFSCcode_BCRegistration.sendKeys(IFSC);
			txtRegisteredAddress.sendKeys(addres);
			txtPinCode.sendKeys(Pincode);
			
			clickOnPinCodeLBl.click();
			Thread.sleep(3000);
			
			/*
			Thread.sleep(100);
			selectState(State);
			Thread.sleep(100);
			selectDistrict(District);
			Thread.sleep(100);
			selectCity(City);
			*/
			
			txtMaildID.clear();
			txtMaildID.sendKeys(generateRandomEmail());
			txtContactNo.sendKeys(generateRandomMobileNumber());
			Thread.sleep(2000);
			btnsubmit.click();

			Thread.sleep(3000);
			if (isAlertPresent() == true) 
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
			if (isAlertPresent() == true) 
			{
				driver.switchTo().alert().accept();
			}

			chkbuttonforConfirmatiuon.click();
			Thread.sleep(500);
			moveToElementAndClick(BtnSubmitFinal_BC);

			Thread.sleep(1000);
			if (isAlertPresent() == true) 
			{
				driver.switchTo().alert().accept();
			}
			Thread.sleep(2000);
		} catch (Exception e) 
		{
			if (isAlertPresent() == true) 
			{
				System.out.println(driver.switchTo().alert().getText());
			}
			Assert.fail("Test case failed due to an error: " + e.getMessage());
		}

	}
	
	
	public String readNameFromExcel(int row, int column) {
	    String name = ""; // Initialize a variable to hold the name
	    // Implement the logic to read the name from the specified Excel cell
	    // For example:
	    // name = excelSheet.getRow(row).getCell(column).getStringCellValue();
	    return name; // Return the read value
	}

	public void BC_Verification(String BCName) throws InterruptedException 
	{
		Thread.sleep(6000);
		try 
		{
			if (BtnVerification.isDisplayed() == false) 
			{
				btnBCManagement.click();
			}
			BtnVerification.click();
			Thread.sleep(1000);
			BC_Name_Verify(BCName);
			Thread.sleep(1000);
			if (isDisaplyedW(verificationWin, 5) == true) 
			{
				ConsoleColor.printColored("Correct Windows Opened of :- "+BCName, ConsoleColor.GREEN);
				//System.out.println("Windows Displayed");

				if (txtnameofBCAtVerification.getAttribute("value").contains(BCName)) 
				{
					ConsoleColor.printColored("Correct Windows Opened of :- "+BCName, ConsoleColor.GREEN);
					//System.out.println("Correct Windows Opened");
					Thread.sleep(2000);
					chkApproveButton.click();
					txtremark_BCVerification.sendKeys("This is Approved By Automation");
					btnSubmitVerification.click();
				}
				else 
				{
					ConsoleColor.printColored("BC name missmatch :-"+ BCName, ConsoleColor.RED);
				}
				

				if (isAlertPresent() == true) 
				{
					driver.switchTo().alert().accept();
				}
			}
		} catch (Exception e) 
		{
			 ConsoleColor.printColored("BC name Not Found: " + BCName, ConsoleColor.RED);
			 if (isAlertPresent() == true) 
			 {
				 ConsoleColor.printColored(driver.switchTo().alert().getText(), ConsoleColor.RED);
			}
			 
			 Assert.fail("BC name not found: " + BCName);
		}
		

	}
	
	public void On_Board_BC_Status(String Bc_Name) throws InterruptedException 
	{
		Thread.sleep(5000);
		if (BtnVerification.isDisplayed() == false) 
		{
			btnBCManagement.click();
		}
		
		BtnOveallBCStatus.click();
		Thread.sleep(2000);
		String return_Value = fetchStatusByBCName(Bc_Name);
		Thread.sleep(1000);
		
		if(return_Value.contains("Approved"))
		{
			fetchVireficationDataByBCName(Bc_Name);
		//	ConsoleColor.printColored(Bc_Name+" this BC gets :- " +return_Value, ConsoleColor.GREEN);
		}
		/*
		else
		{
			ConsoleColor.printColored(Bc_Name+" this BC gets :- " +return_Value, ConsoleColor.RED);
		}
		*/
		Assert.assertTrue(return_Value.contains("Approved"), Bc_Name + " this BC status is not Approved. Actual status: " + return_Value);
		
		
		System.out.println(return_Value);

	}
	
	public void Blank_Data_BC_Registration() throws InterruptedException 
	{
		SoftAssert softAssert = new SoftAssert();

		btnBCManagement.click();

		BtnBCRegistration.click();
		Thread.sleep(2000);
		if (isClicked(BtnAddNewBC) == true) {
			ConsoleColor.printColored("Ad new BC button Click", ConsoleColor.GREEN);
		}

		// For all Field Blank
		btnsubmit.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {

			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				if (isAlertPresent() == true) {

					if (driver.switchTo().alert().getText()
							.contains("You must enter or select a value in the following fields:")
							&& driver.switchTo().alert().getText().contains("Please enter first name")
							&& driver.switchTo().alert().getText().contains("Please enter pan no")
							&& driver.switchTo().alert().getText().contains("Please enter Aadhaarcard no")
							&& driver.switchTo().alert().getText().contains("Please enter Account Number")
							&& driver.switchTo().alert().getText().contains("Please enter IFSC Code")
							&& driver.switchTo().alert().getText().contains("Please enter registered address")
							&& driver.switchTo().alert().getText().contains("Please enter pincode")
							&& driver.switchTo().alert().getText().contains("Please enter Personal email id")
							&& driver.switchTo().alert().getText().contains("Please enter contact no")) {
						softAssert.assertTrue(true, "All required fields are present in the alert message.");
						TextFileLogger.logMessage("BC registration all field Blank test Case Pass");
					} else {
						softAssert.fail("One or more required fields are missing from the alert message.");
						TextFileLogger.logMessage("BC registration all field Blank test Case Fail");
					}

					driver.switchTo().alert().accept();
				}

			}

		}

		// When ENter First Name
		txtFirstname_BCRegistration.sendKeys("TestExtraNNEW");
		btnsubmit.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				if (isAlertPresent() == true) {
					if (driver.switchTo().alert().getText()
							.contains("You must enter or select a value in the following fields:")
							&& driver.switchTo().alert().getText().contains("Please enter pan no")
							&& driver.switchTo().alert().getText().contains("Please enter Aadhaarcard no")
							&& driver.switchTo().alert().getText().contains("Please enter Account Number")
							&& driver.switchTo().alert().getText().contains("Please enter IFSC Code")
							&& driver.switchTo().alert().getText().contains("Please enter registered address")
							&& driver.switchTo().alert().getText().contains("Please enter pincode")
							&& driver.switchTo().alert().getText().contains("Please enter Personal email id")
							&& driver.switchTo().alert().getText().contains("Please enter contact no")) {
						softAssert.assertTrue(true, "All required fields are present in the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Pass Except Name");
					} else {
						softAssert.fail("One or more required fields are missing from the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Fail Except Name");
					}

					driver.switchTo().alert().accept();
				}

			}

		}

		// When Enter PanCard no
		txtPANno_BCRegistration.sendKeys("CCAPM5696E");
		btnsubmit.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				if (isAlertPresent() == true) {
					if (driver.switchTo().alert().getText()
							.contains("You must enter or select a value in the following fields:")
							&& driver.switchTo().alert().getText().contains("Please enter Aadhaarcard no")
							&& driver.switchTo().alert().getText().contains("Please enter Account Number")
							&& driver.switchTo().alert().getText().contains("Please enter IFSC Code")
							&& driver.switchTo().alert().getText().contains("Please enter registered address")
							&& driver.switchTo().alert().getText().contains("Please enter pincode")
							&& driver.switchTo().alert().getText().contains("Please enter Personal email id")
							&& driver.switchTo().alert().getText().contains("Please enter contact no")) {
						softAssert.assertTrue(true, "All required fields are present in the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Pass Except Name and PanNo");
					} else {
						softAssert.fail("One or more required fields are missing from the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Fail Except Name and PanNo");
					}

					driver.switchTo().alert().accept();
				}

			}

		}

		// When Enter Addhar No
		txtAadharno_BCRegistration.sendKeys("611181463158");
		btnsubmit.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				if (isAlertPresent() == true) {
					if (driver.switchTo().alert().getText()
							.contains("You must enter or select a value in the following fields:")
							&& driver.switchTo().alert().getText().contains("Please enter Account Number")
							&& driver.switchTo().alert().getText().contains("Please enter IFSC Code")
							&& driver.switchTo().alert().getText().contains("Please enter registered address")
							&& driver.switchTo().alert().getText().contains("Please enter pincode")
							&& driver.switchTo().alert().getText().contains("Please enter Personal email id")
							&& driver.switchTo().alert().getText().contains("Please enter contact no")) {
						softAssert.assertTrue(true, "All required fields are present in the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Pass Except Name ,PanNo and Adhar No");
					} else {
						softAssert.fail("One or more required fields are missing from the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Fail Except Name ,PanNo and Adhar No");
					}

					driver.switchTo().alert().accept();
				}

			}

		}

		// When Enter Account No
		txtAccountno_BCRegistration.sendKeys("223456987");
		btnsubmit.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				if (isAlertPresent() == true) {
					if (driver.switchTo().alert().getText()
							.contains("You must enter or select a value in the following fields:")
							&& driver.switchTo().alert().getText().contains("Please enter IFSC Code")
							&& driver.switchTo().alert().getText().contains("Please enter registered address")
							&& driver.switchTo().alert().getText().contains("Please enter pincode")
							&& driver.switchTo().alert().getText().contains("Please enter Personal email id")
							&& driver.switchTo().alert().getText().contains("Please enter contact no")) {
						softAssert.assertTrue(true, "All required fields are present in the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Pass Except Name ,PanNo Adhar No and Account No");
					} else {
						softAssert.fail("One or more required fields are missing from the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Fail Except Name ,PanNo Adhar No and Account No");
					}

					driver.switchTo().alert().accept();
				}

			}

		}

		// When Enter IFSC Code
		txtIFSCcode_BCRegistration.sendKeys("HDFC0000002");
		btnsubmit.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				if (isAlertPresent() == true) {
					if (driver.switchTo().alert().getText()
							.contains("You must enter or select a value in the following fields:")
							&& driver.switchTo().alert().getText().contains("Please enter registered address")
							&& driver.switchTo().alert().getText().contains("Please enter pincode")
							&& driver.switchTo().alert().getText().contains("Please enter Personal email id")
							&& driver.switchTo().alert().getText().contains("Please enter contact no")) {
						softAssert.assertTrue(true, "All required fields are present in the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Pass Except Name ,PanNo Adhar No ,Account No And IFSC Code");
					} else {
						softAssert.fail("One or more required fields are missing from the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Fail Except Name ,PanNo Adhar No ,Account No And IFSC Code");
					}

					driver.switchTo().alert().accept();
				}

			}

		}

		// When Enter Registered Address
		txtRegisteredAddress.sendKeys("Thane Maharashtra");
		btnsubmit.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				if (isAlertPresent() == true) {
					if (driver.switchTo().alert().getText()
							.contains("You must enter or select a value in the following fields:")
							&& driver.switchTo().alert().getText().contains("Please enter pincode")
							&& driver.switchTo().alert().getText().contains("Please enter Personal email id")
							&& driver.switchTo().alert().getText().contains("Please enter contact no")) {
						softAssert.assertTrue(true, "All required fields are present in the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Pass Except Name ,PanNo Adhar No ,Account No ,IFSC Code And Address");
					} else {
						softAssert.fail("One or more required fields are missing from the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case fail Except Name ,PanNo Adhar No ,Account No ,IFSC Code And Address");
					}

					driver.switchTo().alert().accept();
				}

			}

		}

		// When Enter Pincode
		txtPinCode.sendKeys("400701");
		clickOnPinCodeLBl.click();
		Thread.sleep(1000);
		btnsubmit.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				if (isAlertPresent() == true) {
					if (driver.switchTo().alert().getText()
							.contains("You must enter or select a value in the following fields:")
							&& driver.switchTo().alert().getText().contains("Please enter Personal email id")
							&& driver.switchTo().alert().getText().contains("Please enter contact no")) {
						softAssert.assertTrue(true, "All required fields are present in the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Pass Except Name ,PanNo Adhar No ,Account No ,IFSC Code, Address and Pincode");
					} else {
						softAssert.fail("One or more required fields are missing from the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Fail Except Name ,PanNo Adhar No ,Account No ,IFSC Code, Address and Pincode");
					}

					driver.switchTo().alert().accept();
				}

			}

		}

		// When Enter wrong Email-ID
		txtMaildID.sendKeys("rmane5655@@gmail.com");
		Thread.sleep(1000);
		btnsubmit.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				if (isAlertPresent() == true) {
					if (driver.switchTo().alert().getText()
							.contains("You must enter or select a value in the following fields:")
							&& driver.switchTo().alert().getText().contains("Please enter valid Personal email id")
							&& driver.switchTo().alert().getText().contains("Please enter contact no")) {
						softAssert.assertTrue(true, "All required fields are present in the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Pass Except Name ,PanNo Adhar No ,Account No ,IFSC Code, Address ,Pincode,invalid Email ID");
					} else {
						softAssert.fail("One or more required fields are missing from the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case fail Except Name ,PanNo Adhar No ,Account No ,IFSC Code, Address ,Pincode,invalid Email ID");
					}

					driver.switchTo().alert().accept();
				}

			}

		}

		// When Enter Email-ID
		txtMaildID.clear();
		txtMaildID.sendKeys("rmane556@gmail.com");
		Thread.sleep(1000);
		btnsubmit.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				if (isAlertPresent() == true) {
					if (driver.switchTo().alert().getText()
							.contains("You must enter or select a value in the following fields:")
							&& driver.switchTo().alert().getText().contains("Please enter contact no")) {
						softAssert.assertTrue(true, "All required fields are present in the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case Pass Except Name ,PanNo Adhar No ,Account No ,IFSC Code, Address ,Pincode,valid Email ID");
					} else {
						softAssert.fail("One or more required fields are missing from the alert message.");
						TextFileLogger.logMessage("BC registration field Blank test Case fail Except Name ,PanNo Adhar No ,Account No ,IFSC Code, Address ,Pincode,valid Email ID");
					}

					driver.switchTo().alert().accept();
				}

			}

		}

		// When Enter Contact no
		txtContactNo.sendKeys("8275380047");
		Thread.sleep(1000);
		btnsubmit.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
				softAssert.assertTrue(Confirmation_Msg.getText().contains("Please Select Atleast One Service"),
						"Confirmation message for Select service is not as expected.");
				TextFileLogger.logMessage("BC registration to select Service test case Pass");
				// Thread.sleep(1000);
			}
		}

		// When Select Service
		ChkAEPS.click();
		// Thread.sleep(3000);
		isInvisible(Confirmation_Msg, 8);
		btnsubmit.click();
		Thread.sleep(500);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Are You Sure You Want To Save Data?")) {
				driver.switchTo().alert().accept();
				System.out.println(Confirmation_Msg.getText());
				if (isDisaplyedW(Confirmation_Msg, 5) == true) {
					System.out.println(Confirmation_Msg.getText());
					softAssert.assertTrue(Confirmation_Msg.getText().contains("Request Processed for Document Upload."),
							"Confirmation message for Upload Documment as expected.");
					TextFileLogger.logMessage("BC registration to Submit Form and Upload document");
				} else {
					System.out.println("Toast Message Element not visible");
				}
			}
		}

		softAssert.assertAll();

	}

}
