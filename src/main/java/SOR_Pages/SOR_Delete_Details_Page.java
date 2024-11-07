package SOR_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SOR_resources.Utility;

public class SOR_Delete_Details_Page extends Utility {

	WebDriver driver;

	public SOR_Delete_Details_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Switch

	@FindBy(xpath = "//button[@id='BtnSubb3']//h5[@class='sidebar-headings']")
	WebElement lblRuleManagement;

	@FindBy(xpath = "//div[@id='subPagess3']//span[text()=' Rule Configuration']")
	WebElement lblRunConfiguration;

	@FindBy(xpath = "//div[@id='subPagess3']//span[text()='Switch Configuration']")
	WebElement lblSwitchConfiguration;

	// Add Group

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnAddGroup']")
	WebElement Btnaddgroup;

	@FindBy(xpath = "//h5[@id='exampleModalLabel']")
	WebElement WinAddgroup;

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtGroupName']")
	WebElement txtgroupname;

	@FindBy(xpath = "//textarea[@id='CPHMasterMain_txtGroupDescription']")
	WebElement TxtGroup_Desc;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnCreGroup']")
	WebElement BtnsubmitGroup;

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

	// Click three dot

	public WebElement getDropdownButtonByName(String Name) {
		String xpath = "//div[contains(@class, 'list-group-item-header') and .//div[@class='list-group-item-heading' and normalize-space(text())='"
				+ Name + "']]//button[@id='dropdownKebabRight9']";
		return driver.findElement(By.xpath(xpath));
	}

	// Edit
	public WebElement getEditButtonByName(String Editname) {
		String xpath = "//div[contains(@class, 'list-group-item-header') and .//div[@class='list-group-item-heading' and normalize-space(text())='"
				+ Editname + "']]//a[contains(@id, 'btnEdit')]";
		return driver.findElement(By.xpath(xpath));
	}

	// Delete
	public WebElement getDeleteButtonByName(String Deletename) {
		String xpath = "//div[contains(@class, 'list-group-item-header') and .//div[@class='list-group-item-heading' and normalize-space(text())='"
				+ Deletename + "']]//a[contains(@id, 'LinkButton1')]";
		return driver.findElement(By.xpath(xpath));
	}

	// Expand Group

	public WebElement getExpandButtonByName(String Group_Name) {
		String xpath = "//div[contains(@class, 'list-group-item-header') and .//div[@class='list-group-item-heading' and normalize-space(text())='"
				+ Group_Name + "']]//div[@class='list-view-pf-expand']";
		return driver.findElement(By.xpath(xpath));
	}

	// Method to find the edit button based on the rule name
	public void clickEditButtonByRuleName(String ruleName) {
		try {
			WebElement editButton = driver.findElement(By.xpath(
					"//div[contains(@class, 'list-group-item-header_Next')]//div[contains(@class, 'list-view-pf-main-info')]//div[contains(text(),'"
							+ ruleName
							+ "')]/ancestor::div[contains(@class, 'list-group-item-header_Next')]//a[contains(text(), 'Edit')]"));
			editButton.click();
			System.out.println("Clicked on Edit button for rule: " + ruleName);
		} catch (Exception e) {
			Assert.fail("Edit button not found for rule: " + ruleName);
		}
	}

	// Method to find the delete button based on the rule name
	public void clickDeleteButtonByRuleName(String ruleName) {
		try {
			WebElement deleteButton = driver.findElement(By.xpath(
					"//div[contains(@class, 'list-group-item-header_Next')]//div[contains(@class, 'list-view-pf-main-info')]//div[contains(text(),'"
							+ ruleName
							+ "')]/ancestor::div[contains(@class, 'list-group-item-header_Next')]//a[contains(text(), 'Delete')]"));
			deleteButton.click();
			System.out.println("Clicked on Delete button for rule: " + ruleName);
		} catch (Exception e) {
			Assert.fail("Delete button not found for rule: " + ruleName);
		}
	}

	@FindBy(xpath = "//span[@id='select2-CPHMasterMain_ddlSwitch-container']")
	WebElement Click_TO_Select_Switch_name;

	@FindBy(xpath = "//imput@aria-controls='select2-CPHMasterMain_ddlSwitch-results']")
	WebElement txt_search_area_Switch_Name;

	public void select_Switch_Name(String Swith_Name) throws InterruptedException {
		Thread.sleep(500);
		Click_TO_Select_Switch_name.click();
		Thread.sleep(500);
		// txt_search_area_GrpName.sendKeys(GRpName);
		String dynamicXpath = "//ul[@id='select2-CPHMasterMain_ddlSwitch-results']/li[text()='" + Swith_Name + "']";
		WebElement districtElement = driver.findElement(By.xpath(dynamicXpath));
		districtElement.click();

	}

	@FindBy(xpath = "//input[@id='CPHMasterMain_txtSwitchName']")
	WebElement txt_Switch_Name;

	@FindBy(xpath = "//textarea[@id='CPHMasterMain_txtSwitchDescription']")
	WebElement txt_Switch_Desc;

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnCreSwitch']")
	WebElement btn_Submit_Switch;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement Confirmation_Msg; // Insert Successful

	@FindBy(xpath = "//input[@id='CPHMasterMain_btnCreateRule']")
	WebElement btn_Submit_Add_Rule;

	public void delete_Switch() {
		lblRuleManagement.click();
		lblSwitchConfiguration.click();
		WebElement dropdownButton = getDropdownButtonByName("Edited_New");
		dropdownButton.click();
		WebElement deleteButton = getDeleteButtonByName("Edited_New");
		deleteButton.click();
		if (Confirmation_Msg.getText().contains("Delete Successful")) {
			System.out.println("Switch deleted sucessfully");
		}

		else {
			System.out.println(Confirmation_Msg.getText());

		}
	}

	public void Edit_Switch() {
		lblRuleManagement.click();
		lblSwitchConfiguration.click();
		WebElement dropdownButton = getDropdownButtonByName("Test_Switch");
		dropdownButton.click();
		WebElement editButton = getEditButtonByName("Test_Switch");
		editButton.click();
		txt_Switch_Name.clear();
		txt_Switch_Name.sendKeys("Edited_New");
		txt_Switch_Desc.clear();
		txt_Switch_Desc.sendKeys("Edited_New");
		moveToElementAndClick(btn_Submit_Switch);

		if (Confirmation_Msg.getText().contains("Update Successful")) {
			System.out.println("Group updated sucessfully");
		}

		else {
			System.out.println(Confirmation_Msg.getText());
		}

	}

	public void delete_Group() {
		lblRuleManagement.click();
		lblRunConfiguration.click();
		WebElement dropdownButton = getDropdownButtonByName("Edited_Grp");
		dropdownButton.click();
		WebElement deleteButton = getDeleteButtonByName("Edited_Grp");
		deleteButton.click();
		if (Confirmation_Msg.getText().contains("Delete Successful")) {
			System.out.println("Group deleted sucessfully");
		}

		else {
			System.out.println(Confirmation_Msg.getText());
		}
	}

	public void Edit_Group() {
		lblRuleManagement.click();
		lblRunConfiguration.click();
		WebElement dropdownButton = getDropdownButtonByName("Test_Grp");
		dropdownButton.click();
		WebElement editButton = getEditButtonByName("Test_Grp");
		editButton.click();
		txtgroupname.clear();
		txtgroupname.sendKeys("Edited_Grp");
		TxtGroup_Desc.clear();
		TxtGroup_Desc.sendKeys("Edited_Grp");
		BtnsubmitGroup.click();
		if (Confirmation_Msg.getText().contains("Update Successful")) {
			System.out.println("Group updated sucessfully");
		}

		else {
			System.out.println(Confirmation_Msg.getText());

		}
	}

	public void delete_Rule() {
		lblRuleManagement.click();
		lblRunConfiguration.click();
		getExpandButtonByName("Edited");
		WebElement dropdownButton = getExpandButtonByName("Test_Grp");
		dropdownButton.click();

		WebElement threedots = getDropdownButtonByName("Edited_Grp");
		threedots.click();

		WebElement deleteButton = getDeleteButtonByName("Edited_Rule");
		deleteButton.click();
		if (Confirmation_Msg.getText().contains("Delete Successful")) {
			System.out.println("Rule deleted sucessfully");
		}

		else {
			System.out.println(Confirmation_Msg.getText());
		}
	}

	public void Edit_Rule() throws InterruptedException {
		lblRuleManagement.click();
		lblRunConfiguration.click();
		// getExpandButtonByName("Test_Grp");
		WebElement dropdownButton = getExpandButtonByName("Test_Grp");
		dropdownButton.click();

		WebElement threedots = getDropdownButtonByName("Test_Rule");
		threedots.click();

		clickEditButtonByRuleName("Test_Rule");

		// WebElement editButton = getEditButtonByName("Test_Rule");
		// editButton.click();
		txtRule_Name.clear();
		txtRule_Name.sendKeys("Edited_Rule");
		txtRule_Desc.clear();
		txtRule_Desc.sendKeys("Edited_Rule");
		btn_Submit_Add_Rule.click();

		if (Confirmation_Msg.getText().contains("Select")) {
			select_Switch_Name("");
		}

		if (Confirmation_Msg.getText().contains("Update Successful")) {
			System.out.println("Rule updated sucessfully");
		}

		else {
			System.out.println(Confirmation_Msg.getText());

		}
	}

}
