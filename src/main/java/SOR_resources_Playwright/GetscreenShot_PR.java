package SOR_resources_Playwright;

import com.microsoft.playwright.Page;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetscreenShot_PR 
{
    public static String takescreenshots(Page page, String testname) throws IOException
    {
        // Get the current timestamp
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        
        // Define the screenshot path
        String dest = System.getProperty("user.dir") + "//screenshot//" + testname + "_" + timestamp + ".png";
        
        // Take the screenshot and save it to the destination path
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(dest))); // Removing the screenshot type
        
        return dest;
    }
}
