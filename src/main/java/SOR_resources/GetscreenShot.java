package SOR_resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetscreenShot 
{
	public static String takescreenshots(WebDriver d, String testname) throws IOException
	{
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		 TakesScreenshot tks = (TakesScreenshot)d;
		 File src = tks.getScreenshotAs(OutputType.FILE);
		 String dest = System.getProperty("user.dir")+"//screenshot//"+testname+"_"+timestamp+".png";
		// String dest = System.getProperty("user.dir")+"//screenshot//"+testname+"_"+System.currentTimeMillis()+".png";		 
		 File dest1 = new File(dest);
		 FileUtils.copyFile(src, dest1);
		 return dest;
	}

}
