package SOR_Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SOR_resources.Utility;

public class SOR_Switch_Configuration_Page extends Utility 
{

	WebDriver driver;

	public SOR_Switch_Configuration_Page(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
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

	public void addSwitch(String SwitchName, String SwitchDesc, String per) {
		lblRuleManagement.click();
		lblSwitchConfiguration.click();
		BtnAddSwitch.click();

		int highestValue = Integer.MIN_VALUE;
		WebElement highestEditButton = null;
		WebElement correspondingUpdateButton = null;
		int indexOfHighestValue = -1;

		for (int i = 0; i < percentageFields.size(); i++) {
			String value = percentageFields.get(i).getAttribute("value");

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
				String valueString = field.getAttribute("value");

				int value = Integer.parseInt(valueString);
				totalPercentage += value;
			} catch (Exception e) {
				System.out.println("Error while retrieving percentage value: " + e.getMessage());
			}
		}

		String Switch_Name=generateRandomName();
		txtSwitchname.sendKeys(Switch_Name);
		writeNameToExcel(9, 1, Switch_Name);
		txtSwitchDesc.sendKeys(Switch_Name);
		String percent = Integer.toString(100 - totalPercentage);
		txtpercentage.sendKeys(percent);
		moveToElementAndClick(btnSubmitSwitch);

		if (add_Grp_Confirmation_Msg.getText().contains("Insert Successful")) {
			System.out.println("Switch Added Sucessfull");
		}
	}

}
