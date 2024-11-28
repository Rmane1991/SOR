package SOR_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SOR_resources.Utility;

import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class SOR_RuleCreationPage extends Utility {

	// Locators for form elements
	@FindBy(id = "CPHMasterMain_ddlGroupName")
	private WebElement groupNameDropdown;

	@FindBy(id = "CPHMasterMain_ddlChannel")
	private WebElement channelDropdown;

	@FindBy(id = "CPHMasterMain_ddlSwitch")
	private WebElement switchDropdown;

	@FindBy(id = "CPHMasterMain_txtPercentage")
	private WebElement percentageTextbox;

	@FindBy(id = "CPHMasterMain_txtRuleName")
	private WebElement ruleNameTextbox;

	@FindBy(id = "CPHMasterMain_txtRuleDescription")
	private WebElement ruleDescriptionTextbox;

	@FindBy(xpath = "(//div[@class='multi-select-container'])[1]")
	public WebElement aggregatorDropdown;

	@FindBy(xpath = "(//div[@class='multi-select-container'])[3]")
	public WebElement txytypeDropdown;

	@FindBy(xpath = "//label[@for='lblSwitch']")
	WebElement lblswitch;

	@FindBy(xpath = "(//div[@class='multi-select-container'])[2]")
	public WebElement IINDropdown;

	// @FindBy(id = "CPHMasterMain_ddlTxnType")
	// public WebElement txnTypeDropdown;

	@FindBy(id = "CPHMasterMain_btnCreateRule")
	private WebElement saveButton;

	@FindBy(id = "CPHMasterMain_btnCloseRule")
	public WebElement closeButton;

	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement add_Grp_Confirmation_Msg; // Insert Successful

	WebDriver driver;

	public void selectTransactionType(WebDriver driver, List<String> txnTypesToSelect) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Open the transaction type dropdown
			txytypeDropdown.click();

			// Wait for all options to be visible
			List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.cssSelector("div#TDropdownItems label input[name='chktxntype']"))); // Update the selector if
																							// needed

			// Iterate over the transaction types to select
			for (String txnType : txnTypesToSelect) {
				boolean isSelected = false; // Flag to check if the transaction type was found
				for (WebElement option : options) {
					// Fetch the label text of the current option
					String labelText = option.findElement(By.xpath("./parent::label")).getText();
					if (labelText.equals(txnType)) {
						isSelected = true; // Mark as found
						if (!option.isSelected()) { // Only select if not already selected
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
							try {
								option.click(); // Attempt to click
							} catch (Exception clickException) {
								// If regular click fails, attempt a JavaScript click
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
							}
						}
						System.out.println("Selected Transaction Type: " + labelText);
						break;
					}
				}
				// Log if the transaction type was not found
				if (!isSelected) {
					System.err.println("Transaction Type not found: " + txnType);
				}
			}
		} catch (Exception e) {
			System.err.println("Error selecting transaction types: " + e.getMessage());
		} finally {
			// Attempt to close the dropdown if it is open
			try {
				lblswitch.click();
				// txytypeDropdown.click();
			} catch (Exception e) {
				// Safely ignore if dropdown cannot be closed
			}
		}
	}

	public void selectRandomAggregators(WebDriver driver) {
		try {
			aggregatorDropdown.click(); // Open the dropdown

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.cssSelector("div#dropdownItems label input[name='chkAggregator']")));

			// Randomly select an aggregator
			Random random = new Random();
			int randomIndex = random.nextInt(options.size()); // Get a random index
			WebElement selectedOption = options.get(randomIndex);

			String aggregatorText = selectedOption.findElement(By.xpath("./parent::label")).getText();
			if (!selectedOption.isSelected()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectedOption);
				selectedOption.click(); // Select the aggregator
			}
			System.out.println("Randomly selected Aggregator: " + aggregatorText);

		} catch (Exception e) {
			System.err.println("Error selecting random aggregator: " + e.getMessage());
		} finally {
			aggregatorDropdown.click(); // Close the dropdown
		}
	}

	// Select a specific channel from the dropdown
	public void selectChannel(String channelName) {
		try {
			// Wait for the channel dropdown to be visible and then click it
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(channelDropdown)).click();

			// Find the options in the dropdown
			List<WebElement> channelOptions = channelDropdown.findElements(By.tagName("option"));

			// Loop through the options and select the one matching channelName
			for (WebElement option : channelOptions) {
				if (option.getText().equals(channelName)) {
					option.click();
					System.out.println("Selected Channel: " + channelName);
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Error selecting channel: " + e.getMessage());
		}
	}

	// Select a specific group from the dropdown
	public void selectGroup(String groupName) {
		try {
			// Wait for the group dropdown to be visible and then click it
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(groupNameDropdown)).click();

			// Find the options in the dropdown
			List<WebElement> groupOptions = groupNameDropdown.findElements(By.tagName("option"));

			// Loop through the options and select the one matching groupName
			for (WebElement option : groupOptions) {
				if (option.getText().equals(groupName)) {
					option.click();
					System.out.println("Selected Group: " + groupName);
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Error selecting group: " + e.getMessage());
		}
	}

	// Constructor
	public SOR_RuleCreationPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	// Fetch dropdown options dynamically
	public List<String> getDropdownOptions(WebElement dropdown) {
		List<String> optionsList = new ArrayList<>();
		List<WebElement> options = dropdown.findElements(By.tagName("option"));
		for (WebElement option : options) {
			optionsList.add(option.getText());
		}
		return optionsList;
	}

	// Fetch aggregator options dynamically
	public List<String> getDropdownOptions_A(WebElement dropdown, WebDriver driver) {
		List<String> optionsList = new ArrayList<>();
		try {
			dropdown.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.cssSelector("div#dropdownItems label input[name='chkAggregator']")));
			for (WebElement option : options) {
				String optionText = option.findElement(By.xpath("./parent::label")).getText();
				optionsList.add(optionText);
			}
		} catch (Exception e) {
			System.err.println("Error fetching aggregator options: " + e.getMessage());
		} finally {
			dropdown.click(); // Ensure dropdown is closed
		}
		return optionsList;
	}

	// Fetch aggregator options dynamically
	public List<String> getDropdownOptions_T(WebElement dropdown, WebDriver driver) {
		List<String> optionsList = new ArrayList<>();
		try {
			dropdown.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.cssSelector("div#TDropdownItems label input[name='chktxntype']")));
			for (WebElement option : options) {
				String optionText = option.findElement(By.xpath("./parent::label")).getText();
				optionsList.add(optionText);
			}
		} catch (Exception e) {
			System.err.println("Error fetching aggregator options: " + e.getMessage());
		} finally {
			dropdown.click(); // Ensure dropdown is closed
		}
		return optionsList;
	}

	// Select specific or random aggregators
	public void selectAggregators(WebDriver driver, List<String> aggregatorsToSelect) {
		try {
			aggregatorDropdown.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.cssSelector("div#dropdownItems label input[name='chkAggregator']")));

			for (String aggregator : aggregatorsToSelect) {
				boolean isSelected = false;
				for (WebElement option : options) {
					String labelText = option.findElement(By.xpath("./parent::label")).getText();
					if (labelText.equals(aggregator)) {
						isSelected = true;
						if (!option.isSelected()) {
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
							try {
								option.click();
							} catch (Exception e) {
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
							}
						}
						System.out.println("Selected Aggregator: " + labelText);
						break;
					}
				}
				if (!isSelected) {
					System.err.println("Aggregator not found: " + aggregator);
				}
			}
		} catch (Exception e) {
			System.err.println("Error selecting aggregators: " + e.getMessage());
		} finally {
			aggregatorDropdown.click(); // Ensure dropdown is closed
		}
	}

	// Fetch IIN options dynamically
	public List<String> getIINs(WebDriver driver) {
		List<String> iinList = new ArrayList<>();
		WebElement iinDropdown = driver.findElement(By.id("selectedSecondItems")); // Adjust the ID as necessary
		iinDropdown.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.cssSelector("div#secondDropdownItems label input[name='chkiin']"))); // Adjust this selector if
																						// necessary
		for (WebElement option : options) {
			String optionText = option.findElement(By.xpath("./parent::label")).getText();
			iinList.add(optionText);
		}
		iinDropdown.click();
		return iinList;
	}

	/*
	 * // Select a specific IIN from the dropdown public void selectIIN(WebDriver
	 * driver, List<String> list) { WebElement iinDropdown =
	 * driver.findElement(By.id("selectedSecondItems")); // Adjust the ID as
	 * necessary iinDropdown.click(); WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(10)); List<WebElement> options =
	 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	 * By.cssSelector("div#secondDropdownItems label input[name='chkiin']"))); //
	 * Adjust this selector if necessary for (WebElement option : options) { String
	 * labelText = option.findElement(By.xpath("./parent::label")).getText(); if
	 * (labelText.equals(list)) { try { if (!option.isSelected()) { option.click();
	 * } System.out.println("Selected IIN: " + labelText); } catch (Exception e) {
	 * System.err.println("Failed to select IIN '" + labelText + "': " +
	 * e.getMessage()); } break; } } iinDropdown.click(); }
	 */

	public void selectIIN(WebDriver driver, List<String> iinsToSelect) {
		try {
			IINDropdown.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Get the list of available IIN options
			List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.cssSelector("div#secondDropdownItems label input[name='chkiin']"))); // Adjust this selector if
																							// necessary

			// Iterate over the list of IINs to select
			for (String iin : iinsToSelect) {
				boolean isSelected = false;

				// Iterate through the options to find the matching IIN
				for (WebElement option : options) {
					String labelText = option.findElement(By.xpath("./parent::label")).getText();
					if (labelText.equals(iin)) {
						isSelected = true;
						if (!option.isSelected()) {
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option); // Scroll
																														// to
																														// option
							try {
								option.click(); // Click to select
							} catch (Exception e) {
								// Fallback to JS click if normal click fails
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
							}
						}
						System.out.println("Selected IIN: " + labelText);
						break;
					}
				}
				if (!isSelected) {
					System.err.println("IIN not found: " + iin);
				}
			}
		} catch (Exception e) {
			System.err.println("Error selecting IINs: " + e.getMessage());
		} finally {
			// Close the dropdown (optional)
			IINDropdown.click();
		}
	}

	// Select random transaction type from dropdown
	public void selectRandomTxnType() {
		List<WebElement> txnOptions = txytypeDropdown.findElements(By.tagName("option")).stream()
				.filter(option -> !option.getText().equals("--Select--")).collect(Collectors.toList());

		if (!txnOptions.isEmpty()) {
			int randomIndex = new Random().nextInt(txnOptions.size());
			WebElement randomOption = txnOptions.get(randomIndex);
			randomOption.click();
			System.out.println("Selected Transaction Type: " + randomOption.getText());
		} else {
			System.err.println("No valid transaction types available.");
		}
	}

	// Fetch group names dynamically from the dropdown
	public List<String> getGroupNames() {
		return getDropdownOptions(groupNameDropdown);
	}

	// Fetch channels dynamically from the dropdown
	public List<String> getChannels() {
		return getDropdownOptions(channelDropdown);
	}

	// Fetch switches dynamically from the dropdown
	public List<String> getSwitches() {
		return getDropdownOptions(switchDropdown);
	}

	// Select transaction type (txnType) from a dropdown
	public void selectTransactionType(String txnType) {
		txytypeDropdown.findElement(By.xpath("//option[text()='" + txnType + "']")).click();
	}

	// Generate random rule name
	/*
	 * public String generateRandomRuleName() { return "Rule_" +
	 * System.currentTimeMillis(); }
	 */

	public String generateRandomRuleName(String aggName, String iin, String txnType) {
		// Generate a random rule name based on AGGname, IIN, and txnType
		return aggName + "_" + iin + "_" + txnType + "";
	}

	// Enter rule name
	public void enterRuleName(String ruleName) {
		ruleNameTextbox.clear();
		ruleNameTextbox.sendKeys(ruleName);
	}

	// Enter rule description
	public void enterRuleDescription(String description) {
		ruleDescriptionTextbox.clear();
		ruleDescriptionTextbox.sendKeys(description);
	}

	// Select switch
	public void selectSwitch(String switchName) {
		switchDropdown.findElement(By.xpath("//option[text()='" + switchName + "']")).click();
	}

	// Enter percentage
	public void enterPercentage(String percentage) {
		percentageTextbox.clear();
		percentageTextbox.sendKeys(percentage);
	}

	// Submit the form
	public void submitForm() {
		saveButton.click();
	}

	// Close the rule creation form
	public void closeForm() {
		closeButton.click();
	}
}
