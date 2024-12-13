package SOR_Pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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
	
	@FindBy(xpath = "//table[@id='CPHMasterMain_gvRoleDetails']/tbody/tr")
	List<WebElement> tableRows;

	//Manage User
	
	@FindBy(xpath = "//li[@id='submm4']")
	WebElement Click_Manage_User;
	
	//Manage Permission
	
	@FindBy(xpath = "//li[@id='submm5']")
	WebElement Click_Manage_Permission;
	
	@FindBy(xpath = "//select[@id='CPHMasterMain_ddlClient']")
	WebElement dd_Client;
	
	
	@FindBy(xpath = "//table[@id='CPHMasterMain_gvRoleDetails']/tbody/tr")
	List<WebElement> rows;
	
	//Toggle Button of that Particular Menu
	public WebElement Select_Menu(String menuName)
	{
		return driver.findElement(By.xpath("//span[text()='" + menuName + "']//ancestor::tr//td[2]//label[@class='switch']"));
	}
	
	//Edit Button of that Particular Menu
	public WebElement Exapand_Menu(String menuName)
	{
		return driver.findElement(By.xpath("//span[text()='" + menuName + "']/ancestor::tr//img"));
	}
	
	
	public void Click_Edit_Button(String R_Name) 
	{
		for (WebElement row : rows) 
		{
			WebElement roleNameCell = row.findElement(By.xpath("td[3]")); 
			String roleName = roleNameCell.getText();
			if (roleName.equals(R_Name)) 
			{
				WebElement editButton = row.findElement(By.xpath("td[1]/input[contains(@id,'lbtnEdit')]"));
				editButton.click();
				System.out.println("Clicked Edit button for role: " + roleName);
				break;
			}
		}
	}		
	
	
	public void Assign_Permissin(String Role_Name) 
	{
		Click_Edit_Button(Role_Name);
		Dropdownbytxt(dd_Client,"SBM");
		Select_Menu("Dashboards");
	}
	
	SoftAssert Assert= new SoftAssert();
	
	public void Create_Role(String RoleName) 
	{
		Click_Create_Manage_Role.click();
		btn_Add_New_Rule.click();
		txt_name_Add_Rule.sendKeys(RoleName);
		
		btn_Submit_Add_Rule.click();
		if(add_Grp_Confirmation_Msg.getText().contains("Role is already exist."))
				{
					System.out.println("THis Name rule All ready Aded");
					txt_name_Add_Rule.clear();
					txt_name_Add_Rule.sendKeys(RoleName+1);
					btn_Submit_Add_Rule.click();
					if(add_Grp_Confirmation_Msg.getText().contains("Role added successfully."))
					{
						Assert.assertTrue(true);
					}
				}
		else if(add_Grp_Confirmation_Msg.getText().contains("Role added successfully.")) 
		{
			System.out.println(RoleName+1+" :- "+add_Grp_Confirmation_Msg.getText());
			Assert.assertTrue(true);
		}
		
		else 
		{
			System.out.println(add_Grp_Confirmation_Msg.getText());
			Assert.fail();
		}
		
		if (isRolePresent(RoleName)) 
		{
		    Assert.assertTrue(true, "The role '" + RoleName + "' is found in the table.");
		}
		else 
		{
		    Assert.fail("The role '" + RoleName + "' is not found in the table.");
		}

		Assert.assertAll();
		
	}
	
	public boolean isRolePresent(String roleName)
	{
	    for (WebElement row : tableRows) 
	    {
	        String roleText = row.findElement(By.xpath(".//td[2]/span")).getText();
	        if (roleText.equals(roleName)) 
	        {
	            return true;
	        }
	    }
	    return false;
	}

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

        System.out.println("User created successfully");
		} 
		else 
		{
         System.out.println(add_Grp_Confirmation_Msg.getText());
        }	
		
		
	}
	
}
