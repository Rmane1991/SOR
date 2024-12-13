package SOR_testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SOR_Pages.SOR_RuleCreationPage;
import SOR_Pages.SOR_Rule_Configuration_Page;
import SOR_resources.Utility.ConsoleColor;
import SOR_resources.Utility.TextFileLogger;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import SOR_Pages.SOR_Login_Page;

public class SOR_RuleCreationTest extends Base {

    SOR_RuleCreationPage rulePage;
    SOR_Login_Page SORLp;
    SOR_Rule_Configuration_Page SORRcp;
    ATUTestRecorder recorder;
    String className = this.getClass().getSimpleName();
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

    @BeforeClass
    public void setUp() throws Exception 
    {
        launchBrowser();
        SORLp = new SOR_Login_Page(driver);
        rulePage = new SOR_RuleCreationPage(driver);
        SORRcp = new SOR_Rule_Configuration_Page(driver);
        TextFileLogger.initializeLogger("LoginPage_TestCase");
        recorder = new ATUTestRecorder("D:\\Recorder\\", "" + className + "" + timestamp + "", false);
		recorder.start();
    }

    @Test
    public void createRuleCombinations() throws InterruptedException, IOException 
    {
    	
    	 String excelFilePath = "D:\\Workspace\\SOR\\src\\main\\java\\SOR_resources\\Test_DataCopy_New.xlsx";
    	 String sheetName = "Combinations";

    	    // Define headers for the Excel file
    	    Object[] headers = {"Group Name", "Rule Name", "Channel", "Switch Name", "IIN", "Aggregator", "Txn Type", "Status"};
    	
        // Log in with valid credentials
        SORLp.Check_Valid_Credentials(getCellValueAsString(sheet.getRow(3).getCell(1)), // Username
                                      getCellValueAsString(sheet.getRow(3).getCell(3))); // Password

        // Navigate to the rule creation page
        SORRcp.OpenRUlePage_First();
        SORRcp.OpenRUlePage();

        // Fetch available group
        List<String> groupNames = rulePage.getGroupNames().stream()
                .filter(name -> !name.equals("--Select--"))
                .collect(Collectors.toList());

        /*
        List<String> channels = rulePage.getChannels().stream()
                .filter(name -> !name.equals("--Select--"))
                .collect(Collectors.toList());
		*/
        
        // Fetch available Channels
        List<String> channels = rulePage.getChannels().stream()
                .filter(name -> "AEPS".equals(name)) // Retain only "AEPS"
                .collect(Collectors.toList());
        
        // Fetch available Switch
        List<String> switches = rulePage.getSwitches().stream()
                .filter(name -> !name.equals("-- Select --"))
                .collect(Collectors.toList());
        
        // Fetch available IIN
        List<String> iins = rulePage.getIINs(driver).stream()
                .collect(Collectors.toList());
        
        if (iins.contains("ALL")) 
        {
            iins.remove("ALL");
            iins.add("ALL");
        }

        // Fetch available Aggregators
        List<String> aggregators = rulePage.getDropdownOptions_A(rulePage.aggregatorDropdown, driver)
                .stream()
                .filter(name -> List.of("2902","702","All").contains(name))
                .collect(Collectors.toList());
        
        
        // Fetch available txn-type
        List<String> txnTypes = rulePage.getDropdownOptions_T(rulePage.txytypeDropdown, driver)
                .stream()
                .filter(name -> List.of("Withdrawal", "BalanceEnquiry", "MiniStatement","All").contains(name))
                .collect(Collectors.toList());
        
        if (txnTypes.contains("All")) 
        {
            txnTypes.remove("All");
            txnTypes.add("All");
        }
        
        /*
        // Fetch available transaction types dynamically from the page
        List<String> txnTypes = rulePage.getDropdownOptions_T(rulePage.txytypeDropdown, driver)
                .stream()
                .filter(name -> !name.equals("All"))
                .collect(Collectors.toList());
        */
        String percentage = "50"; // Example fixed percentage

        // Iterate over combinations of groups, channels, switches, IINs, aggregators, and transaction types
        for (String groupName : groupNames) 
        {
            for (String channel : channels) 
            {
                for (String switchName : switches) 
                {
                    for (String iin : iins) 
                    {
                        for (String aggregator : aggregators) 
                        {
                            for (String txnType : txnTypes) 
                            {
                                System.out.println("Testing combination: " + groupName + ", " + channel + ", " + switchName + ", " + iin + ", " + aggregator + ", " + txnType);
                                Thread.sleep(500);
                                SORRcp.OpenRUlePage();
                                Thread.sleep(1000);
                                rulePage.selectGroup(groupName);
                                String ruleName = rulePage.generateRandomRuleName(aggregator, iin, txnType);
                                System.out.println("Generated Rule Name: " + ruleName);
                                rulePage.enterRuleName(ruleName);
                                rulePage.enterRuleDescription(ruleName);
                                rulePage.selectAggregators(driver, Collections.singletonList(aggregator));
                                rulePage.selectIIN(driver, Collections.singletonList(iin));
                                rulePage.selectChannel(channel);
                                rulePage.selectTransactionType(driver, Collections.singletonList(txnType));
                                rulePage.selectSwitch(switchName);
                                rulePage.enterPercentage(percentage);
                                rulePage.submitForm();
                                Thread.sleep(1000);
                                String status;
                                if(rulePage.add_Grp_Confirmation_Msg.getText().contains("Insert Successful")==true)
                                {
                                	status = "Success";
                                	Assert.assertTrue(rulePage.add_Grp_Confirmation_Msg.getText().contains("Insert Successful"),
                                	"Rule creation failed for combination: " + groupName + ", " + channel + ", "+ switchName + ", " + iin + ", " + aggregator + ", " + txnType);
								}

								else 
								{
									status = "Failed: " + rulePage.add_Grp_Confirmation_Msg.getText();
									ConsoleColor.printColored(rulePage.add_Grp_Confirmation_Msg.getText(), ConsoleColor.RED);
									ConsoleColor.printColored(ruleName+" :-This Combination rule not added", ConsoleColor.RED);
									//System.out.println(rulePage.add_Grp_Confirmation_Msg.getText());
									Thread.sleep(500);
									if(rulePage.closeButton.isDisplayed()==true)
									{
										rulePage.closeButton.click();
									}
								}
                                
                                writeToExcel(excelFilePath, sheetName, headers, new Object[]
                                		{groupName, ruleName, channel, switchName, iin, aggregator, txnType, status });
                                	
                                Thread.sleep(5000);
                            }
                        }
                    }
                }
            }
        }
    }

    @AfterClass
    public void tearDown() throws IOException, ATUTestRecorderException {
        if (driver != null) {
            driver.quit();
            recorder.stop();
        }
        TextFileLogger.closeLogger();
    }
}
