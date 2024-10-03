package SOR_testcases_Playwright;

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
