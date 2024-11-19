package SOR_Pages;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SOR_resources.Utility;

public class SOR_Admin_Management_Page extends Utility 
{

	WebDriver driver;
	
	public SOR_Admin_Management_Page(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	public void selectFromDropdown(WebElement dropdownContainerElement, WebElement txtsercharea, String searchTerm) throws InterruptedException 
	   {
		
		dropdownContainerElement.click();
		    Thread.sleep(500); 
	        txtsercharea.sendKeys(searchTerm);
	        Thread.sleep(500); 
	        txtsercharea.sendKeys(Keys.ENTER);
	        Thread.sleep(500);
	    }
	
	@FindBy(xpath = "(//label[@for='exampleInputEmail1'])[3]")
	WebElement clickonClient;
	
	
	@FindBy(xpath = "//button[@id='BtnSubb2']")
	WebElement Click_Admin_Management;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement add_Grp_Confirmation_Msg; // Insert Successful

	//Create User
	
	@FindBy(xpath = "//li[@id='submm2']")
	WebElement Click_Create_User;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtUserName']")
	WebElement txt_UserName_Create_user;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtEmail']")
	WebElement txt_Email_Create_user;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtMobile']")
	WebElement txt_MobileNo_Create_user;
	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlClient-container']")
	WebElement ddSelect_Client;
	
	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlClient-results']")
	WebElement txt_Search_Area_Select_Client;
	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlRole-container']")
	WebElement ddSelect_Role;
	
	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlRole-results']")
	WebElement txt_Search_Area_Select_Role;
	
	
	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlUserRoleGroup-container']")
	WebElement ddSelect_Role_Group;
	
	@FindBy(xpath = "//input[@aria-controls='select2-CPHMasterMain_ddlUserRoleGroup-results']")
	WebElement txt_Search_Area_Select_Role_Group;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtPassword']")
	WebElement txt_Password_Create_User;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtConfirmPassword']")
	WebElement txt_Confirm_Password_Create_User;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_btnSave']")
	WebElement btn_Save_Create_User;
	
	
	public static String UserName() 
	{
        int minLen = 6;
        int maxLen = 15;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        int usernameLength = minLen + random.nextInt(maxLen - minLen + 1);
        
        StringBuilder username = new StringBuilder(usernameLength);

        for (int i = 0; i < usernameLength; i++) 
        {
            username.append(chars.charAt(random.nextInt(chars.length())));
        }

        return username.toString();
    }
	
	//Create Manage Role
	
	@FindBy(xpath = "//li[@id='submm3']")
	WebElement Click_Create_Manage_Role;
	
	@FindBy(xpath = "//button[@id='CPHMasterMain_lbtnAddRole']")
	WebElement btn_Add_New_Rule;
	
	@FindBy(xpath = "//input[@id='CPHMasterMain_txtRolename']")
	WebElement txt_name_Add_Rule;
	
	@FindBy(xpath = "//button[@id='CPHMasterMain_lbtnNewRole']")
	WebElement btn_Submit_Add_Rule;
	
	
	
	//Manage User
	
	@FindBy(xpath = "//li[@id='submm4']")
	WebElement Click_Manage_User;
	
	//Manage Permission
	
	@FindBy(xpath = "//li[@id='submm5']")
	WebElement Click_Manage_Permission;
	
	
	public void Add_User() throws InterruptedException 
	{
		
		String User_name=UserName();
		String EMail=generateRandomEmail();
		String mobileno= generateRandomMobileNumber();
		writeNameToExcel(21, 1, User_name);
		Thread.sleep(1000);
		Click_Admin_Management.click();
		Thread.sleep(1000);
		Click_Create_User.click();
		Thread.sleep(1000);
		
		//For Select Client and role 
		selectFromDropdown(ddSelect_Client,txt_Search_Area_Select_Client,"ABC");
		selectFromDropdown(ddSelect_Role,txt_Search_Area_Select_Role,"BC");
		selectFromDropdown(ddSelect_Role_Group,txt_Search_Area_Select_Role_Group,"BC");
		
		
		
		if(	isVisible(txt_MobileNo_Create_user, 5)==true)
		{
			txt_MobileNo_Create_user.sendKeys(mobileno);
		}
		else
		{
			System.out.println("Field not visible");
		}
		Thread.sleep(1000);
		txt_Email_Create_user.sendKeys(EMail);
		Thread.sleep(1000);
		txt_UserName_Create_user.sendKeys(User_name);
		Thread.sleep(3000);
		//ddSelect_Client.click();
		txt_Password_Create_User.clear();
		txt_Password_Create_User.click();
		Thread.sleep(1000);
		txt_Password_Create_User.sendKeys("Admin@123");
		Thread.sleep(2000);
		txt_Confirm_Password_Create_User.clear();
		txt_Confirm_Password_Create_User.click();
		txt_Confirm_Password_Create_User.sendKeys("Admin@123");
		Thread.sleep(1500);
		moveToElementAndClick(btn_Save_Create_User);
		//btn_Save_Create_User.click();
		//Thread.sleep(1500);
		if(add_Grp_Confirmation_Msg.getText().contains("User created successfully"))
		{
		Assert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("User created successfully"), "Confirmation message not as expected.");

        System.out.println("Group added successfully");
		} 
		else 
		{
         System.out.println("Add Group button not visible");
        }	
		
		
	}
	
}
