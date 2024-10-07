package SOR_Pages_Playwright;



import com.microsoft.playwright.Page;

public class Rule_Configuration_PR 

{

    Page page;

    // Locators
    private final String lblRunManagement = "//button[@id='BtnSubb3']//h5[@class='sidebar-headings']";
    private final String lblRunConfiguration = "//div[@id='subPagess3']//span[text()=' Rule Configuration']";
    private final String lblSwitchConfiguration = "//div[@id='subPagess3']//span[text()='Switch Configuration']";

    
    
    public Rule_Configuration_PR(Page page) 
    {
        this.page = page;
    }

    // You can add Playwright interaction methods here. For example:

    public void clickRunManagement() 
    {
        page.locator(lblRunManagement).click();
    }

    public void clickRunConfiguration() 
    {
        page.locator(lblRunConfiguration).click();
    }

    public void clickSwitchConfiguration() 
    {
        page.locator(lblSwitchConfiguration).click();
    }

}
