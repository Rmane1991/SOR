package SOR_resources_Playwright;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.PrintWriter;
import java.nio.file.Paths;


public class listeners_PR implements ITestListener 

{

    String destinationfile;
    ExtentTest test;
    ExtentReportNG_PR ex_Report = new ExtentReportNG_PR();
    ExtentReports reports = ex_Report.getReportObject();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test case start = " + result.getMethod().getMethodName());
        test = reports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) 
    {
    	System.out.println("Test case Pass = " + result.getMethod().getMethodName());
        test.log(Status.PASS, "Test Case PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
        	
            Page page = (Page) result.getTestClass().getRealClass().getField("page").get(result.getInstance());
            
            String screenshotPath = "screenshots/" + result.getMethod().getMethodName() + ".png";
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(screenshotPath)).setType(ScreenshotType.PNG));
            test.addScreenCaptureFromPath(screenshotPath);
            test.log(Status.FAIL, "Test Case Fail");

           
            Throwable throwable = result.getThrowable();
            if (throwable != null) 
            {
                test.log(Status.FAIL, "Exception: " + throwable.getMessage());
                test.log(Status.FAIL, "Stack Trace: " + getStackTrace(throwable));
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        System.out.println("Test Case Fail = " + result.getName());
    }

    // Helper method to capture console logs
    @SuppressWarnings("deprecation")
	private String getStackTrace(Throwable throwable) 
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintWriter pw = new PrintWriter(baos);
        throwable.printStackTrace(pw);
        pw.close();
        return baos.toString();
    }

    @Override
    public void onTestSkipped(ITestResult result) 
    {
        System.out.println("Test Case Skip = " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
    {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) 
    {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) 
    {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) 
    {
        reports.flush();
    }
}
