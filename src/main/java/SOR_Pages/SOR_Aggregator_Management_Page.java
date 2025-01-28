package SOR_Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SOR_resources.Utility;

public class SOR_Aggregator_Management_Page extends Utility
{

	WebDriver driver;
	
	public SOR_Aggregator_Management_Page(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@FindBy(xpath = "//*[@id='BtnSubb5']/div/h5")
	WebElement lblAgg_Mgmt;
	
	@FindBy(xpath = "//*[@id='submm14']/a/div/span[2]")
	WebElement lbl_Registration_Agg;
	
	@FindBy(xpath = "//*[@id='submm15']/a/div/span[2]")
	WebElement lbl_Verification_Agg;

	@FindBy(xpath = "//*[@id='submm16']/a/div/span[2]")
	WebElement lbl_Onboard_Agg;

	@FindBy(xpath = "//*[@id='submm17']/a/div/span[2]")
	WebElement lbl_Overall_Agg;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_btnAddnew']")
	WebElement btnaddnew_Agg_Registration;
	
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
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_chkAEPS']")
	WebElement chk_AEPS;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_chkdmt']")
	WebElement chk_DMT;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_chkMATM']")
	WebElement chk_MicroATM;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtFirstName']")
	WebElement txt_Agg_Name;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtPANNo']")
	WebElement txt_Pan_No_Agg;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtaadharno']")
	WebElement txt_Aadhaar_NO_Agg;
	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddleducation-container']")
	WebElement SelectEducationField;
	
	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddleducation-results']")
	WebElement txtsearcharea_SelectEduaction;

	public void selectQulification(String Qualification) throws InterruptedException 
	{
		Thread.sleep(500);
		SelectEducationField.click();
		Thread.sleep(500);
		txtsearcharea_SelectEduaction.sendKeys(Qualification);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddleducation-results']/li[text()='" + Qualification + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
	}
	
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtAccountNumber']")
	WebElement txt_account_No_Agg;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtIFsccode']")
	WebElement txt_Ifsc_Agg;
	
	@FindBy(xpath = "//textarea[@id='CPHMasterMain_txtRegisteredAddress']")
	WebElement txt_Registred_Area_Agg;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtPinCode']")
	WebElement txt_Pincode;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtEmailID']")
	WebElement txt_EmailID_Agg;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtContactNo']")
	WebElement txt_ContactNo_Agg;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_btnSubmitDetails']")
	WebElement btn_Submit_Agg;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_btnCancel']")
	WebElement btn_Back_Agg;
	

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
		Thread.sleep(500);
	}

	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlState-results']")
	WebElement StateSearchArea;

	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlDistrict-results']")
	WebElement DistrictSearchArea;

	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlCity-results']")
	WebElement CitySearchArea;

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlDistrict-container']")
	WebElement ClickDistrict;

	public void selectDistrict(String DistrictName) throws InterruptedException 
	{
		Thread.sleep(500);
		ClickDistrict.click();
		Thread.sleep(500);
		DistrictSearchArea.sendKeys(DistrictName);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlDistrict-results']/li[text()='" + DistrictName + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
		Thread.sleep(500);
	}

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlCity-container']")
	WebElement ClickCity;

	public void selectCity(String Cityname) throws InterruptedException 
	{
		Thread.sleep(500);
		ClickCity.click();
		Thread.sleep(500);
		CitySearchArea.sendKeys(Cityname);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlCity-results']/li[text()='" + Cityname + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
		Thread.sleep(500);
	}
	
	
	
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
		Thread.sleep(500);
	}

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlAddressProof-container']")
	WebElement SelectAddressProof;

	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlAddressProof-results']")
	WebElement ID_Address_SearchArea;

	public void SelectAddressProof(String Addname) throws InterruptedException 
	{
		Thread.sleep(500);
		SelectAddressProof.click();
		Thread.sleep(500);
		ID_Address_SearchArea.sendKeys(Addname);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlAddressProof-results']/li[text()='" + Addname + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
		Thread.sleep(500);
	}

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlSignature-container']")
	WebElement SelectSignatureProof;

	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlSignature-results']")
	WebElement ID_Signature_SearchArea;

	public void SelectSignatureProof(String Signname) throws InterruptedException 
	{
		Thread.sleep(500);
		SelectSignatureProof.click();
		Thread.sleep(500);
		ID_Signature_SearchArea.sendKeys(Signname);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlSignature-results']/li[text()='" + Signname + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();
		Thread.sleep(500);
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
	
	@FindBy(xpath = "//*[contains(text(),'Pincode')]")
	WebElement clickOnPinCodeLBl;
	
	@FindBy(xpath = "//div[@id='divDownloadDocgrid']")
	WebElement verificationWin;
	
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
	        String vireficationBy = rowElement.findElement(By.xpath("./td[13]")).getText();
	        String vireficationOn = rowElement.findElement(By.xpath("./td[14]")).getText();
	        String vireficationRemarks = rowElement.findElement(By.xpath("./td[15]")).getText();

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
			WebElement statusElement = rowElement.findElement(By.xpath("./td[12]"));
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
	
	
	
	public void Agg_Name_Verify(String Agg_Name) 
	{
		String xpath = "//td[text()='" + Agg_Name + "']/preceding-sibling::td/input[@title='Click here to verify']";
		WebElement verifyButton = driver.findElement(By.xpath(xpath));
		verifyButton.click();
	}
	
	
	public void Add_Agg(String BCName,String Agg_Name, String PanNO, String AddharNo, String Qualification, String AccountNo, String IFSC,
			String addres, String Pincode, String State, String District, String City, String EmailID, String ContactNo) throws InterruptedException 
	{
		String Agg_Name_Randam=generateRandomName();
		lblAgg_Mgmt.click();
		lbl_Registration_Agg.click();
		btnaddnew_Agg_Registration.click();
		selectBC(BCName);
		Thread.sleep(1000);
		if(chk_AEPS.isSelected()==true)
		{
		 System.out.println("Channel All ready Selected");	
		}
		else 
		{
			chk_AEPS.click();
		}
		txt_Agg_Name.sendKeys(Agg_Name_Randam);
		writeNameToExcel(15,1,Agg_Name_Randam);
		Thread.sleep(3000);
		txt_Pan_No_Agg.sendKeys(generateRandomPAN());
		txt_Aadhaar_NO_Agg.sendKeys(generateRandomAadhar());
		selectQulification(Qualification);
		txt_account_No_Agg.sendKeys(generateRandomAccountNo());
		txt_Ifsc_Agg.sendKeys(IFSC);
		txt_Registred_Area_Agg.sendKeys(addres);
		txt_Pincode.sendKeys(Pincode);
		clickOnPinCodeLBl.click();
		Thread.sleep(1000);
		/*
		Thread.sleep(100);
		selectState(State);
		Thread.sleep(100);
		selectDistrict(District);
		Thread.sleep(100);
		selectCity(City);
		*/
		txt_EmailID_Agg.clear();
		txt_EmailID_Agg.sendKeys(generateRandomEmail());
		txt_ContactNo_Agg.sendKeys(generateRandomMobileNumber());
		btn_Submit_Agg.click();
		
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
		scrollToElementAndClick(BtnSubmitFinal_BC);

		Thread.sleep(500);
		if (isAlertPresent() == true) 
		{
			driver.switchTo().alert().accept();
		}
		Thread.sleep(2000);
		
	}
	
	public void Agg_Verification(String Agg_Name) throws InterruptedException 
	{
		Thread.sleep(6000);
		if (lbl_Verification_Agg.isDisplayed() == false) 
		{
			lblAgg_Mgmt.click();
		}
		lbl_Verification_Agg.click();
		Thread.sleep(1000);
		Agg_Name_Verify(Agg_Name);
		Thread.sleep(1000);
		if (isDisaplyedW(verificationWin, 5) == true) 
		{
			ConsoleColor.printColored("Windows Displayed", ConsoleColor.GREEN);

			if (txtnameofBCAtVerification.getDomProperty("value").contains(Agg_Name)) 
			{
				ConsoleColor.printColored("Correct Windows Opened of :- "+Agg_Name, ConsoleColor.GREEN);
				Thread.sleep(2000);
				chkApproveButton.click();
				txtremark_BCVerification.sendKeys("This is Approved By Automation");
				btnSubmitVerification.click();
			}
			else 
			{
				ConsoleColor.printColored("Aggregator name missmatch :-"+ Agg_Name, ConsoleColor.RED);
			}

			if (isAlertPresent() == true) 
			{
				driver.switchTo().alert().accept();
			}
		}

	}
	
	public void On_Board_Agg_Status(String Agg_Name) throws InterruptedException 
	{
		Thread.sleep(6000);
		if (lbl_Verification_Agg.isDisplayed() == false) 
		{
			lblAgg_Mgmt.click();
		}
		lbl_Overall_Agg.click();
		Thread.sleep(2000);
		String return_Value = fetchStatusByBCName(Agg_Name);
		Thread.sleep(1000);
		
		if(return_Value.contains("Approved"))
		{
			fetchVireficationDataByBCName(Agg_Name);
		//	ConsoleColor.printColored(Bc_Name+" this BC gets :- " +return_Value, ConsoleColor.GREEN);
		}
		/*
		else
		{
			ConsoleColor.printColored(Bc_Name+" this BC gets :- " +return_Value, ConsoleColor.RED);
		}
		*/
		Assert.assertTrue(return_Value.contains("Approved"), Agg_Name + " this BC status is not Approved. Actual status: " + return_Value);
		
		ConsoleColor.printColored(return_Value, ConsoleColor.GREEN);
		System.out.println(return_Value);

	}
	
	
}
