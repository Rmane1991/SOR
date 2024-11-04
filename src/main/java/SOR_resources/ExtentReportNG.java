package SOR_resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG 
{

	private static ExtentReports extent;
    private static ExtentTest test;
	
	//Changes Done by rajendra 28/02/2024
	public ExtentReports getReportObject() 
		  {
				String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
				String reportName = "Extentreport_"+timestamp+".html";
				String path = System.getProperty("user.dir")+"//reports//"+reportName;
				ExtentSparkReporter reporter= new ExtentSparkReporter(path);
				reporter.config().setReportName("Test Cases Report");
				reporter.config().setDocumentTitle("Test Result");
			    ExtentReports extend = new ExtentReports();
				extend.attachReporter(reporter);
				extend.setSystemInfo("Tester", "Rajendra");
				return extend ;
			}

public static void setTest(ExtentTest currentTest) {
    test = currentTest;
}

public static void logMessage(String message) 
{
    System.out.println(message);

    if (test != null) {
        test.log(Status.INFO, message);
    }
}

public static ExtentReports getExtent() {
	return extent;
}

public static void setExtent(ExtentReports extent) {
	ExtentReportNG.extent = extent;
}

}