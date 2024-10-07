package SOR_testcases_Playwright;

/*
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;

public class Base_PR {

	Sheet sheet;
	public Playwright playwright;
	public Browser browser;
	public Page page;
	
	public void ReadExcel() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\SOR_resources_Playwright\\Test_Data.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(2);
	}

	public Page launchBrowser(String browserType) throws Exception {
		ReadExcel();

		playwright = Playwright.create();
		BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);

		switch (browserType.toLowerCase()) {
		case "firefox":
			browser = playwright.firefox().launch(launchOptions);
			break;
		case "chrome":
			browser = playwright.chromium().launch(launchOptions);
			break;
		case "edge":
			browser = playwright.chromium().launch(launchOptions.setChannel("msedge"));
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserType);
		}

		page = browser.newPage();
		page.setDefaultTimeout(10000);
		page.navigate(sheet.getRow(3).getCell(5).getStringCellValue());

		return page;
	}
}
*/

//package SOR_testcases_Playwright;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Base_PR {

    Sheet sheet;
    public Playwright playwright;
    public Browser browser;
    public Page page;
    
    // Method to read Excel data
    public void ReadExcel() throws IOException 
    {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\SOR_resources_Playwright\\Test_Data.xlsx");
        sheet = WorkbookFactory.create(fis).getSheetAt(2);
        fis.close();
    }

    public Page launchBrowser(String browserType) throws Exception 
    {
    	//Read Excel First
        ReadExcel();

        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false);
        BrowserContext context;

        switch (browserType.toLowerCase()) 
        {
            case "firefox":
                browser = playwright.firefox().launch(launchOptions);
                break;
            case "chrome":
                browser = playwright.chromium().launch(launchOptions);
                break;
            case "edge":
                browser = playwright.chromium().launch(launchOptions.setChannel("msedge"));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        /*
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions().setRecordVideoDir(Paths.get("D://Workspace//SOR//Record//" + browserType)).
        setRecordVideoSize(1280, 720);
		context = browser.newContext(contextOptions);
		*/
        
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String videoDirectory = "D://Workspace//SOR//Record//" + browserType + "//" + timeStamp;

        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions().setRecordVideoDir(Paths.get(videoDirectory));
        
        context = browser.newContext(contextOptions);
        page = context.newPage();

        page.setDefaultTimeout(10000);
        page.navigate(sheet.getRow(3).getCell(5).getStringCellValue());

        return page;
    }
    
    public  class ConsoleColor {
		// ANSI escape codes
		public static final String RESET = "\033[0m"; // Text Reset

		// Regular Colors
		public static final String BLACK = "\033[0;30m"; // BLACK
		public static final String RED = "\033[0;31m"; // RED
		public static final String GREEN = "\033[0;32m"; // GREEN
		public static final String YELLOW = "\033[0;33m"; // YELLOW
		public static final String BLUE = "\033[0;34m"; // BLUE
		public static final String PURPLE = "\033[0;35m"; // PURPLE
		public static final String CYAN = "\033[0;36m"; // CYAN
		public static final String WHITE = "\033[0;37m"; // WHITE

		public void printColored(String message, String color) 
		{
			System.out.println(color + message + RESET);
			System.out.println(color +"-->>"+ RESET);
		}
	}
    
}
