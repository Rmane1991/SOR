package SOR_Pages_Playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.PageFactory.utility.ConsoleColor;

public class SOR_Switch_Configuration_Page_PR {

    // Page object instance
    private final Page page;

    // Constructor
    public SOR_Switch_Configuration_Page_PR(Page page) {
        this.page = page;
    }

    // Page locators (in string format)
    private final String lblRuleManagement = "//button[@id='BtnSubb3']//h5[@class='sidebar-headings']";
    private final String lblSwitchConfiguration = "//li[@id='submm8']";
    private final String btnAddSwitch = "//input[@id='CPHMasterMain_btnAddSwitch']";
    private final String txtSwitchName = "//input[@id='CPHMasterMain_txtSwitchName']";
    private final String txtSwitchDesc = "//textarea[@id='CPHMasterMain_txtSwitchDescription']";
    private final String txtPercentage = "//input[@id='CPHMasterMain_txtSwitchPercentage']";
   // private final String txtCount = "//input[@id='CPHMasterMain_txtCount']";
    private final String btnSubmitSwitch = "//input[@id='CPHMasterMain_btnCreSwitch']";
    //private final String btnCancelSwitch = "//input[@id='CPHMasterMain_btnCloseSwitch']";
    private final String addGrpConfirmationMsg = "//div[@class='toast-message']";
    //private final String errorMsgPercentage = "//span[@id='CPHMasterMain_lblErrorMessage']";
    private final String percentageFields = "//input[contains(@id, 'txtPercentage')]";
    private final String editButtons = "//input[contains(@id, 'btnEdit')]";
    private final String updateButtons = "//input[contains(@id, 'btnUpdate')]";

    // Method to add a switch
    public void addSwitch(String switchName, String switchDesc, int per) {
        page.locator(lblRuleManagement).click();  // Click Rule Management label
        page.locator(lblSwitchConfiguration).click();  // Click Switch Configuration label
        page.locator(btnAddSwitch).click();  // Click Add Switch button

        int highestValue = Integer.MIN_VALUE;
        Locator highestEditButton = null;
        Locator correspondingUpdateButton = null;
        int indexOfHighestValue = -1;

        // Find the highest percentage value
        Locator percentageLocator = page.locator(percentageFields);
        Locator editButtonLocator = page.locator(editButtons);
        Locator updateButtonLocator = page.locator(updateButtons);

        for (int i = 0; i < percentageLocator.count(); i++) {
            String value = percentageLocator.nth(i).inputValue();
            int percentageValue = Integer.parseInt(value);

            if (percentageValue > highestValue) {
                highestValue = percentageValue;
                highestEditButton = editButtonLocator.nth(i);
                correspondingUpdateButton = updateButtonLocator.nth(i);
                indexOfHighestValue = i;
            }
        }

        // Edit the highest percentage value
        if (highestEditButton != null) {
            highestEditButton.click();

            if (highestValue > 30) {
                int newValue = highestValue - per;
                Locator highestInputField = percentageLocator.nth(indexOfHighestValue);
                highestInputField.fill(String.valueOf(newValue));
            }

            // Retry mechanism for clicking the update button
            final int MAX_RETRIES = 4;
            int retries = 0;
            @SuppressWarnings("unused")
			boolean success = false;

            while (retries < MAX_RETRIES) {
                try {
                    correspondingUpdateButton.scrollIntoViewIfNeeded();
                    correspondingUpdateButton.click();
                    success = true;
                    break;
                } catch (Exception e) {
                    retries++;
                    if (retries >= MAX_RETRIES) {
                        ConsoleColor.printColored("Failed to click the Update button after " + MAX_RETRIES + " attempts.", ConsoleColor.RED);
                        break;
                    }
                }
            }
        }

        // Calculate the remaining percentage
        int totalPercentage = 0;
        for (int i = 0; i < percentageLocator.count(); i++) {
            try {
                String valueString = percentageLocator.nth(i).inputValue();
                int value = Integer.parseInt(valueString);
                totalPercentage += value;
            } catch (Exception e) {
                ConsoleColor.printColored("Error while retrieving percentage value: " + e.getMessage(), ConsoleColor.RED);
            }
        }

        // Fill in the switch details
        page.locator(txtSwitchName).fill(switchName);
        page.locator(txtSwitchDesc).fill(switchDesc);
        String percent = Integer.toString(100 - totalPercentage);
        page.locator(txtPercentage).fill(percent);

        // Submit the switch
        page.locator(btnSubmitSwitch).click();

        // Verify the successful addition
        String confirmationMessage = page.locator(addGrpConfirmationMsg).textContent();
        if (confirmationMessage.contains("Insert Successful")) {
            ConsoleColor.printColored("Switch added successfully", ConsoleColor.GREEN);
        } else {
            ConsoleColor.printColored("Switch addition failed", ConsoleColor.RED);
        }
    }
}
