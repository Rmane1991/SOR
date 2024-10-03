package SOR_resources;
 
import java.io.PrintWriter;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
 
public class listeners implements ITestListener {
	String destinationfile;
	ExtentTest test;
	ExtentReportNG ex_Report = new ExtentReportNG();
	ExtentReports reports = ex_Report.getReportObject();
 
	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Test case start = " + result.getMethod().getMethodName());
		test = reports.createTest(result.getMethod().getMethodName());
	}
 
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case PASS");
	}
 
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			WebDriver d = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			String st = GetscreenShot.takescreenshots(d, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(st);
			test.log(Status.FAIL, "Test Case Fail");
 
			// Capture console logs and attach them to the Extent Report
			Throwable throwable = result.getThrowable();
			if (throwable != null) {
				test.log(Status.FAIL, "Exception: " + throwable.getMessage());
				test.log(Status.FAIL, "Stack Trace: " + getStackTrace(throwable));
			}
		} catch (Exception e) {
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
	public void onFinish(ITestContext context) {
		reports.flush();
	}
}