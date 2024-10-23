package SOR_Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SOR_resources.Utility;

public class SOR_BC_Management_Page extends Utility 
{
	WebDriver driver;

	public SOR_BC_Management_Page(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@FindBy(xpath = "//button[@id='BtnSubb4']")
	WebElement btnBCManagement;

	@FindBy(xpath = "//li[@id='submm9']")
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
	        //System.out.println(">> BC Name: " + bcName);
	        
	        ConsoleColor.printColored(">> Virefication By: " + vireficationBy, ConsoleColor.GREEN);
	        // System.out.println(">> Virefication By: " + vireficationBy);
	        
	        ConsoleColor.printColored(">> Virefication On: " + vireficationOn, ConsoleColor.GREEN);
	        // System.out.println(">> Virefication On: " + vireficationOn);
	      
	        ConsoleColor.printColored(">> Virefication Remarks: " + vireficationRemarks, ConsoleColor.GREEN);
	       // System.out.println(">> Virefication Remarks: " + vireficationRemarks);
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
			btnBCManagement.click();
			BtnBCRegistration.click();
			BtnAddNewBC.click();
			ChkAEPS.click();
			txtFirstname_BCRegistration.sendKeys(BC_Name_Randam);
			writeNameToExcel(12,1,BC_Name_Randam);
			Thread.sleep(1000);
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
			if (isAlertPresent(driver) == true) 
			{
				driver.switchTo().alert().accept();
			}

			Thread.sleep(2000);

			selectIDProof("Pancard");
			SelectFileIDProof.sendKeys("C:\\Users\\rajendra.mane\\Downloads\\NSDL1.png");
			SelectAddressProof("Passport");
			SelectFileAddressProof.sendKeys("C:\\Users\\rajendra.mane\\Downloads\\NSDL1.png");
			SelectSignatureProof("Pancard");
			SelectFileSignatureProof.sendKeys("C:\\Users\\rajendra.mane\\Downloads\\NSDL1.png");
			BtnSubmitProof.click();
			Thread.sleep(500);
			if (isAlertPresent(driver) == true) 
			{
				driver.switchTo().alert().accept();
			}

			chkbuttonforConfirmatiuon.click();
			Thread.sleep(500);
			moveToElementAndClick(BtnSubmitFinal_BC);

			Thread.sleep(1000);
			if (isAlertPresent(driver) == true) 
			{
				driver.switchTo().alert().accept();
			}
			Thread.sleep(2000);
		} catch (Exception e) 
		{
			if (isAlertPresent(driver) == true) 
			{
				System.out.println(driver.switchTo().alert().getText());
			}
			Assert.fail("Test case failed due to an error: " + e.getMessage());
		}

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
				

				if (isAlertPresent(driver) == true) 
				{
					driver.switchTo().alert().accept();
				}
			}
		} catch (Exception e) 
		{
			ConsoleColor.printColored("BC name Not Fount :-"+ BCName, ConsoleColor.RED);
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

}
