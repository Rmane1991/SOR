package SOR_resources_Playwright;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG_PR 
{
    // Method to get the ExtentReports object
    public ExtentReports getReportObject() 
    {
        // Generate a timestamp for the report file name
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        String reportName = "ExtentReport_" + timestamp + ".html";
        
        // Specify the path for the report file
        String path = System.getProperty("user.dir") + "//reports//" + reportName;
        
        // Create the ExtentSparkReporter and set up the report configurations
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Test Cases Report");
        reporter.config().setDocumentTitle("Test Result");
        
        // Create an instance of ExtentReports and attach the reporter
        ExtentReports extend = new ExtentReports();
        extend.attachReporter(reporter);
        
        // Set system information for the report
        extend.setSystemInfo("Tester", "Rajendra");
        
        return extend;
    }
}
