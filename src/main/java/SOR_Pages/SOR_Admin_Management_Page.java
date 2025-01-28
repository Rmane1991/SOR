package SOR_Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import SOR_resources.Utility;

public class SOR_Admin_Management_Page extends Utility {

	WebDriver driver;

	public SOR_Admin_Management_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public void selectFromDropdown(WebElement dropdownContainerElement, WebElement txtsercharea, String searchTerm)
			throws InterruptedException {
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

	// Create User

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
	
	

	@FindBy(xpath = "//span[@id='lblWelcome']")
	WebElement btnClick_Username;

	@FindBy(xpath = "//a[@id='LbLoginStatus']")
	WebElement btn_LogOut;

	@FindBy(xpath = "//input[@id='txtUserName']")
	WebElement txt_Username;

	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement txt_Password;

	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement Btn_Submit;

	@FindBy(xpath = "//input[@id='txtold']")
	WebElement txt_Old_Pwd;

	@FindBy(xpath = "//input[@id='txtnew']")
	WebElement pwd_new;

	@FindBy(xpath = "//input[@id='txtconfirm']")
	WebElement Confirm_pwd_new;

	@FindBy(xpath = "//input[@id='txtOTPFirstLogin']")
	WebElement txt_Otp_Win;

	@FindBy(xpath = "//input[@id='chkConfimartion']")
	WebElement chk_Agree;

	@FindBy(xpath = "//input[@id='btnChangePwd']")
	WebElement btn_Change_Pwd;

	@FindBy(xpath = "//span[@id='lblWelcome']")
	WebElement lblWelcome;

	@FindBy(xpath = "//div[@id='accordionExample']")
	WebElement LeftMenu;

	@FindBy(xpath = "//div[@id='accordionExample']")
	WebElement List_Menu;
	

	// Create Manage Role

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

	@FindBy(xpath = "//button[@id='CPHMasterMain_btnEditRole']")
	WebElement btn_update_Permission;

	// Manage User

	@FindBy(xpath = "//li[@id='submm4']")
	WebElement Click_Manage_User;

	// Manage Permission

	@FindBy(xpath = "//li[@id='submm5']")
	WebElement Click_Manage_Permission;

	@FindBy(xpath = "//select[@id='CPHMasterMain_ddlClient']")
	WebElement dd_Client;

	@FindBy(xpath = "//table[@id='CPHMasterMain_gvRoleDetails']/tbody/tr")
	List<WebElement> rows;
	
	
	public String UserName() 
	{
		int minLen = 6;
		int maxLen = 15;
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		int usernameLength = minLen + random.nextInt(maxLen - minLen + 1);

		StringBuilder username = new StringBuilder(usernameLength);

		for (int i = 0; i < usernameLength; i++) {
			username.append(chars.charAt(random.nextInt(chars.length())));
		}

		return username.toString();
	}

	
	// Toggle Button of that Particular Menu
	public WebElement Select_Menu(String menuName) 
	{
		return driver.findElement(By.xpath("//span[text()='" + menuName + "']//ancestor::tr//td[2]//label[@class='switch']"));
	}

	/*
	public WebElement Click_Edit_Button(String roleName) 
	{
		return driver.findElement(By.xpath("//td[text()='" + roleName + "']/ancestor::tr//input[contains(@title, 'Edit role')]"));
	}
	*/
	
	//For Edit button if not found on first page then revisit on next page so on
	
	public WebElement Click_Edit_Button(String roleName) 
	{
		WebElement editButton = null;
		boolean found = false;

		while (!found) {
			try {
				editButton = driver.findElement(By.xpath("//td[text()='" + roleName + "']/ancestor::tr//input[contains(@title, 'Edit role')]"));
				found = true;
			} catch (Exception e) {
				List<WebElement> nextPageLink = driver.findElements(By.xpath("//td/a[contains(@href, '__doPostBack')]"));

				if (!nextPageLink.isEmpty()) 
				{
					nextPageLink.get(0).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				} 
				else 
				{
					break;
				}
			}
		}

		if (editButton == null) 
		{
			throw new NoSuchElementException("Role with name '" + roleName + "' not found on any page.");
		}

		return editButton;
	}
	
	List<String> selectedPermissions;

	public void assignRandomPermissions(String Role_Name, String BC_Name) throws InterruptedException {

		Click_Manage_Permission.click();
		Thread.sleep(2000);
		Click_Edit_Button(Role_Name).click();
		Thread.sleep(2000);
		Dropdownbytxt(dd_Client, BC_Name);
		selectedPermissions = getMenuList();

		if (!selectedPermissions.contains("Dashboards")) {
			selectedPermissions.add("Dashboards");
		}

		List<String> permissionsWithoutDashboards = new ArrayList<>(selectedPermissions);
		permissionsWithoutDashboards.remove("Dashboards");

		Collections.shuffle(permissionsWithoutDashboards);

		selectedPermissions.clear();
		selectedPermissions.add("Dashboards");
		selectedPermissions.addAll(permissionsWithoutDashboards);

		int rowID = 27;
		int columnID = 3;

		for (String menuName : selectedPermissions) {
			try {
				WebElement menuElement = Select_Menu(menuName);
				if (menuElement != null) {
					Thread.sleep(2000);
					moveToElementAndClick(menuElement);
					Thread.sleep(2000);
					System.out.println("Assigned permission: " + menuName);
					writeNameToExcel(rowID, columnID++, menuName);
				}
			} catch (Exception e) {
				System.out.println("Failed to assign permission: " + menuName + " - " + e.getMessage());
			}
		}

		Thread.sleep(2000);
		moveToElementAndClick(btn_update_Permission);
		Thread.sleep(1000);
		// btn_update_Permission.click(); //SUCCESS

		if (add_Grp_Confirmation_Msg.getText().contains("SUCCESS")) {
			ConsoleColor.printColored("Assign Permission with message :- " + add_Grp_Confirmation_Msg.getText(),
					ConsoleColor.GREEN);
			Assert.assertTrue(true);
		}

		else {
			ConsoleColor.printColored(add_Grp_Confirmation_Msg.getText(), ConsoleColor.RED);
			Assert.fail();
		}
	}

	public List<String> getMenuList() {
		// Create three different sets of permissions
		List<String> set1 = new ArrayList<>(List.of("Dashboards", "Admin Management", "Rule Management"));

		List<String> set2 = new ArrayList<>(
				List.of("Dashboards", "BC Management", "Aggregator Management", "Agent Management"));

		List<String> set3 = new ArrayList<>(List.of("Dashboards", "Reports", "Application Management", "Upload"));

		// Add the sets to a list
		List<List<String>> permissionSets = new ArrayList<>();
		permissionSets.add(set1);
		permissionSets.add(set2);
		permissionSets.add(set3);

		// Randomly select one of the sets
		Random rand = new Random();
		int randomSetIndex = rand.nextInt(permissionSets.size());

		System.out.println(
				"Selected permission set: Set " + (randomSetIndex + 1) + " - " + permissionSets.get(randomSetIndex));

		// Return the randomly selected set
		return permissionSets.get(randomSetIndex);
	}

	// Edit Button of that Particular Menu
	public WebElement Exapand_Menu(String menuName) {
		return driver.findElement(By.xpath("//span[text()='" + menuName + "']/ancestor::tr//img"));
	}

	SoftAssert Assert = new SoftAssert();

	public void Create_Role() throws InterruptedException {
		String RoleName = generateRandomRoleName();

		Click_Admin_Management.click();
		Thread.sleep(1000);
		Click_Create_Manage_Role.click();
		Thread.sleep(1000);
		btn_Add_New_Rule.click();
		Thread.sleep(2000);
		txt_name_Add_Rule.sendKeys(RoleName);
		Thread.sleep(1000);
		btn_Submit_Add_Rule.click();

		if (add_Grp_Confirmation_Msg.getText().contains("Role is already exist.")) {
			System.out.println("THis Name rule All ready Aded");
			txt_name_Add_Rule.clear();
			txt_name_Add_Rule.sendKeys(RoleName + 1);
			btn_Submit_Add_Rule.click();
			if (add_Grp_Confirmation_Msg.getText().contains("Role added successfully.")) {
				Assert.assertTrue(true);
				writeNameToExcel(23, 1, RoleName + 1);
			}
		} else if (add_Grp_Confirmation_Msg.getText().contains("Role added successfully.")) {
			System.out.println(RoleName + 1 + " :- " + add_Grp_Confirmation_Msg.getText());
			writeNameToExcel(23, 1, RoleName);
			Assert.assertTrue(true);
		}

		else {
			System.out.println(add_Grp_Confirmation_Msg.getText());
			Assert.fail();
		}

		if (isRolePresent(RoleName)) {
			Assert.assertTrue(true, "The role '" + RoleName + "' is found in the table.");
			ConsoleColor.printColored(RoleName + ":- This Role name Present into table ", ConsoleColor.GREEN);
		} else {
			Assert.fail("The role '" + RoleName + "' is not found in the table.");
			ConsoleColor.printColored(RoleName + ":- This Role name is not Present into table ", ConsoleColor.RED);
		}

		Assert.assertAll();

	}

	/*
	public boolean isRolePresent(String roleName) throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> roleElements = driver.findElements(By.xpath(".//td[2]/span"));

		for (WebElement roleElement : roleElements) {
			String roleText = roleElement.getText();
			if (roleText.equals(roleName)) {
				return true;
			}
		}
		return false;
	}*/
	
	
	public boolean isRolePresent(String roleName) throws InterruptedException {
	    while (true) {
	        // Wait and get the list of roles on the current page
	        Thread.sleep(1000);
	        List<WebElement> roleElements = driver.findElements(By.xpath(".//td[2]/span"));

	        // Check if the role is present on the current page
	        for (WebElement roleElement : roleElements) {
	            String roleText = roleElement.getText();
	            if (roleText.equals(roleName)) {
	                return true; // Role found
	            }
	        }

	        // Locate the next page link using the anchor tag with a JavaScript function
	        List<WebElement> nextPageButton = driver.findElements(By.xpath("//td/a[contains(@href, '__doPostBack') and text()='2']"));
	        if (!nextPageButton.isEmpty() && nextPageButton.get(0).isDisplayed()) {
	            nextPageButton.get(0).click(); // Navigate to the next page
	            Thread.sleep(1000); // Allow time for the next page to load
	        } else {
	            break; // Exit the loop if no next page is available
	        }
	    }

	    return false; // Role not found on any page
	}


	public boolean isUser(String UserName) {
		List<WebElement> roleElements = driver.findElements(By.xpath(".//td[2]"));

		for (WebElement roleElement : roleElements) {
			String roleText = roleElement.getText();
			if (roleText.equals(UserName)) {
				return true;
			}
		}
		return false;
	}

	public void Add_User(String BC_Name, String Role_Name) throws InterruptedException {

		String User_name = UserName();
		String EMail = generateRandomEmail();
		String mobileno = generateRandomMobileNumber();
		writeNameToExcel(21, 1, User_name);
		Thread.sleep(1000);
		// Click_Admin_Management.click();
		Thread.sleep(1000);
		Click_Create_User.click();
		Thread.sleep(1000);

		// For Select Client and role
		selectFromDropdown(ddSelect_Client, txt_Search_Area_Select_Client, BC_Name);
		selectFromDropdown(ddSelect_Role, txt_Search_Area_Select_Role, "BC");
		selectFromDropdown(ddSelect_Role_Group, txt_Search_Area_Select_Role_Group, Role_Name);

		if (isVisible(txt_MobileNo_Create_user, 5) == true) {
			txt_MobileNo_Create_user.sendKeys(mobileno);
		} else {
			System.out.println("Field not visible");
		}
		Thread.sleep(1000);
		txt_Email_Create_user.sendKeys(EMail);
		Thread.sleep(1000);
		txt_UserName_Create_user.sendKeys(User_name);
		Thread.sleep(3000);
		// ddSelect_Client.click();
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
		// btn_Save_Create_User.click();
		// Thread.sleep(1500);
		if (add_Grp_Confirmation_Msg.getText().contains("User created successfully")) {
			Assert.assertTrue(add_Grp_Confirmation_Msg.getText().contains("User created successfully"),
					"Confirmation message not as expected.");

			System.out.println("User created successfully");
		} else {
			System.out.println(add_Grp_Confirmation_Msg.getText());
		}

		Thread.sleep(2000);
		Click_Manage_User.click();
		Thread.sleep(2000);

		if (isUser(User_name) == true) {
			Assert.assertTrue(true, "This  User :- '" + User_name + "' is found in the table.");
			ConsoleColor.printColored(User_name + ":- This craeted User Present into table ", ConsoleColor.GREEN);
		} else {
			Assert.assertTrue(false, "This  User :- '" + User_name + ": is found in the table.");
			ConsoleColor.printColored(User_name + ":- This craeted User is not  Present into table ", ConsoleColor.RED);

		}

	}

	public void Verify_Pemission(String Username) throws InterruptedException {
		btnClick_Username.click();
		btn_LogOut.click();
		txt_Username.clear();
		txt_Username.sendKeys(Username);
		txt_Password.clear();
		txt_Password.sendKeys("Admin@123");
		Btn_Submit.click();
		Thread.sleep(2000);
		
		if (isAlertPresent()) {

			if (driver.switchTo().alert().getText()
					.contains("OTP has been sent to Registered Mobile Number/Email Id.")) {
				driver.switchTo().alert().accept();
			}
		}

		txt_Old_Pwd.clear();
		txt_Old_Pwd.sendKeys("Admin@123");
		pwd_new.clear();
		pwd_new.sendKeys("Admin@321");
		Confirm_pwd_new.clear();
		Confirm_pwd_new.sendKeys("Admin@321");
		txt_Otp_Win.clear();
		txt_Otp_Win.sendKeys("123456");
		chk_Agree.click();
		btn_Change_Pwd.click();
		Thread.sleep(1000);
		if (isAlertPresent() == true) {
			if (driver.switchTo().alert().getText().contains("Password has been changed successfully.")) {
				driver.switchTo().alert().accept();
			}

		}

		txt_Username.clear();
		txt_Username.sendKeys(Username);
		txt_Password.clear();
		txt_Password.sendKeys("Admin@321");
		Btn_Submit.click();

		try {
			Assert.assertEquals(lblWelcome.getText(), "Welcome " + Username, "Welcome message validation failed!");
			// writeResultToExcel("Pass", 2, 5);
			ConsoleColor.printColored("Login Successful With Username :- " + Username, ConsoleColor.GREEN);
		} catch (AssertionError e)

		{
			// System.out.println("Test failed! The displayed message is: " +
			// lblWelcome.getText());
			// writeResultToExcel("Fail", 2, 5);
			ConsoleColor.printColored("Login Failed With Username :- " + Username, ConsoleColor.RED);
			
			//ConsoleColor.printColored(driver.getCurrentUrl(), ConsoleColor.RED);
		}

		// For verify Permission

		List<WebElement> menuItems = List_Menu.findElements(By.xpath(".//h5"));
		List<String> displayedPermissions = new ArrayList<>();
		for (WebElement item : menuItems) {
			displayedPermissions.add(item.getText().trim());
		}

		System.out.println("Selected Permissions: " + selectedPermissions);
		System.out.println("Displayed Permissions: " + displayedPermissions);

		for (String permission : selectedPermissions) {
			if (!displayedPermissions.contains(permission)) {
				System.out.println("Permission '" + permission + "' is not visible in the menu.");
				Assert.fail("Permission '" + permission + "' is not visible in the menu.");
			}
		}

	}
}
