package SOR_Pages_Playwright;

import com.microsoft.playwright.Page;
import com.PageFactory.utility.ConsoleColor;

public class SOR_Rule_Configuration_PR {

    private final Page page;

    // Constructor
    public SOR_Rule_Configuration_PR(Page page) {
        this.page = page;
    }

    // Page locators (in string format)
    private final String lblRuleManagement = "//button[@id='BtnSubb3']//h5[@class='sidebar-headings']";
    private final String lblRunConfiguration = "//div[@id='subPagess3']//span[text()=' Rule Configuration']";
    private final String btnAddGroup = "//input[@id='CPHMasterMain_btnAddGroup']";
    private final String txtGroupName = "//input[@id='CPHMasterMain_txtGroupName']";
    private final String txtGroupDesc = "//textarea[@id='CPHMasterMain_txtGroupDescription']";
    private final String btnSubmitGroup = "//input[@id='CPHMasterMain_btnCreGroup']";
    private final String addGrpConfirmationMsg = "//div[@class='toast-message']";
    private final String verifyGroupAddCount = "//div[@id='pf-list-simple-expansion']";

    // Add Rule locators
    private final String btnAddRule = "//input[@id='CPHMasterMain_btnAddRule']";
    private final String ddSelectGroupName = "//span[@id='select2-CPHMasterMain_ddlGroupName-container']";
    private final String txtRuleName = "//input[@id='CPHMasterMain_txtRuleName']";
    private final String txtRuleDesc = "//textarea[@id='CPHMasterMain_txtRuleDescription']";
    private final String ddAggregator = "//div[@id='selectedItems']";
    private final String ddIIN = "//div[@id='selectedSecondItems']";
    private final String ddChannel = "//span[@id='select2-CPHMasterMain_ddlChannel-container']";
    private final String ddTxnType = "//div[@id='selectedTItems']";
    private final String ddSwitch = "//span[@id='select2-CPHMasterMain_ddlSwitch-container']";
    private final String txtPercentage = "//input[@id='CPHMasterMain_txtPercentage']";
    private final String txtCount = "//input[@id='CPHMasterMain_txtCount']";
    private final String btnSubmitRule = "//input[@id='CPHMasterMain_btnCreateRule']";
    private final String toggleBtnToConvertCount = "//*[@id='Switch']/following-sibling::span[@class='sliderr']";

    // Methods
    public void addGroup(String groupName, String groupDesc) throws InterruptedException {
        page.locator(lblRuleManagement).click();
        page.locator(lblRunConfiguration).click();
        Thread.sleep(5000);
        if (page.locator(btnAddGroup).isVisible()) {
            int beforeAddGroup = page.locator(verifyGroupAddCount).count();
            page.locator(btnAddGroup).click();
            page.locator(txtGroupName).fill(groupName);
            page.locator(txtGroupDesc).fill(groupDesc);
            page.locator(btnSubmitGroup).click();
            Thread.sleep(3000);
            int afterAddGroup = page.locator(verifyGroupAddCount).count();
            if (afterAddGroup - beforeAddGroup == 1 && page.locator(addGrpConfirmationMsg).textContent().contains("Insert Successful")) {
                ConsoleColor.printColored("Group added successfully", ConsoleColor.GREEN);
            } else {
                ConsoleColor.printColored("Failed to add group", ConsoleColor.RED);
            }
        } else {
            ConsoleColor.printColored("Add Group button not visible", ConsoleColor.RED);
        }
    }

    public void addRule(String count) {
        if (!page.locator(btnAddRule).isVisible()) {
            page.locator(lblRuleManagement).click();
            page.locator(lblRunConfiguration).click();
        }

        page.locator(btnAddRule).click();
        page.locator(ddSelectGroupName).click();
        page.locator(txtRuleName).fill("Automation");
        page.locator(txtRuleDesc).fill("Done By Automation");
        page.locator(ddAggregator).click();
        page.locator(ddIIN).click();
        page.locator(ddChannel).click();
        page.locator(ddTxnType).click();
        page.locator(ddSwitch).click();

        if ("Yes".equals(count)) {
            page.locator(toggleBtnToConvertCount).click();
            page.locator(txtCount).fill("200");
        } else {
            page.locator(txtPercentage).fill("50");
        }

        page.locator(btnSubmitRule).click();
        ConsoleColor.printColored("Rule added successfully", ConsoleColor.GREEN);
    }
}
