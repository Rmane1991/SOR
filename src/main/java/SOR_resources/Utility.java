package SOR_resources;

import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	WebDriver driver;
	Actions act;

	public Utility(WebDriver driver) 
	{
		super();
		this.driver = driver;
		act = new Actions(driver);
	}

	public void pressEnter() 
	{
		act.sendKeys(Keys.ENTER).build().perform();
	}

	public void pressUpKeys() 
	{
		act.sendKeys(Keys.UP).build().perform();
	}

	public void moveToElementAndClick(WebElement ele)

	{
		act.moveToElement(ele).click().build().perform();
	}

	public void keypress(String a) 
	{
		act.sendKeys(a).build().perform();
	}

	public void doubleClick() 
	{
		act.doubleClick().build().perform();
	}

	public void moveToElementAndDoubleClick(WebElement ele) 
	{
		act.moveToElement(ele).doubleClick().build().perform();
	}

	public void moveToElementAndContextClick(WebElement ele) 
	{
		act.moveToElement(ele).contextClick().build().perform();
	}
	
	public void doubleClick(WebElement ele) 
	{
		act.doubleClick(ele).build().perform();
	}

	public void contextClick(WebElement ele) 
	{
		act.contextClick(ele).build().perform();
	}

	public void moveToElement(WebElement ele) 
	{
		act.moveToElement(ele).perform();
	}

	public void Dropdown(By drp_Ele, String visible) 
	{
		Select dropdown = new Select((WebElement) drp_Ele);
		dropdown.selectByVisibleText(visible);

	}

	public void Dropdownbytxt(WebElement cat, String visible) 
	{
		Select dropdown = new Select(cat);
		dropdown.selectByVisibleText(visible);
	}

	public void Dropdownbyindex(WebElement cat, int visible) 
	{
		Select dropdown = new Select(cat);
		dropdown.selectByIndex(visible);

	}

	public boolean isInvisible(WebElement Element, long tm) 
	{
		boolean isDisplayed = false;

		try {

			WebDriverWait wt = new WebDriverWait(driver, Duration.ofMinutes(tm));
			wt.until(ExpectedConditions.invisibilityOf(Element));
			isDisplayed = true;
		} catch (Exception e)

		{
			//e.printStackTrace();
		}

		return isDisplayed;

	}

	public boolean isDisaplyed(By Locator, WebDriver wd, long tm) {
		boolean isDisplayed = false;

		try {
				WebDriverWait wt = new WebDriverWait(wd, Duration.ofSeconds(tm));
			wt.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			isDisplayed = true;
		} catch (Exception e)

		{
			//e.printStackTrace();
		}

		return isDisplayed;
	}

	public void login(WebDriver wd, String url, String User, String Pass) 
	{
		wd.manage().window().maximize();
		wd.findElement(By.id("UserName")).sendKeys(User);
		wd.findElement(By.name("Password")).sendKeys(Pass);
		wd.findElement(By.id("btnLogin")).click();
		System.out.println("Login Sucessfull");
	}

	// Print Message
	public static void print(WebElement Print, String cat, Integer no) 
	{
		String text = Print.getText();
		System.out.println(no + " : " + cat + " " + text);
	}

	// URL Checking
	@SuppressWarnings("deprecation")
	public void checkUrl(WebDriver wd) {

		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		List<WebElement> links = wd.findElements((By.xpath("//ul[@class='nav navbar-nav pull-right']//a")));
		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			url = it.next().getAttribute("href");

			if (url != null && url.endsWith(".aspx")) {
				System.out.println(url);

				try {
					huc = (HttpURLConnection) (new URL(url).openConnection());

					huc.setRequestMethod("HEAD");

					huc.connect();

					respCode = huc.getResponseCode();

					if (respCode >= 400) {
						System.out.println(url + " is a broken link");
					} else {
						System.out.println(url + " :-( Is a valid link)");
					}

				} catch (MalformedURLException e) {
					//e.printStackTrace();
				} catch (IOException e) {
					//e.printStackTrace();
				}
			}
			continue;
		}

	}

	public boolean isVisible(WebElement WebElement, long tm) {
		boolean isVisible = false;

		try {

			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(tm));
			wt.until(ExpectedConditions.visibilityOf(WebElement));
			isVisible = true;
		} catch (Exception e)

		{
			// e.printStackTrace();
		}

		return isVisible;
	}

	public String getScreenshot(String testCaseName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

	public boolean isDisaplyedW(WebElement Ele, long tm) 
	{
		boolean isDisplayed = false;

		try {

			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(tm));
			wt.until(ExpectedConditions.visibilityOf(Ele));
			isDisplayed = true;
		} catch (Exception e)

		{

		}

		return isDisplayed;

	}

	
	public boolean isClickable(WebElement WebElement, long tm) 
	{

		boolean isClickable = false;

		try {

			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(3));
			wt.until(ExpectedConditions.elementToBeClickable(WebElement));
			isClickable = true;
		} catch (Exception e)

		{

		}

		return isClickable;

	}

	public boolean isClicked(WebElement element) 
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch (Exception e) 
		{
			return false;
		}
	}

	public boolean isAlertPresent(WebDriver wd) 
	{
		try {
			wd.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String currentTime() 
	{
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		//SimpleDateFormat format = new SimpleDateFormat("HHMMSS");

		//Date dt = new Date();
		return timestamp;
		//return format.format(dt).toString();
	}

	public int ifFileAvailable() throws InterruptedException 
	{
		File downloadedFilePath = new File(System.getProperty("user.dir") + "\\downloadFiles\\");

		File allFiles[] = downloadedFilePath.listFiles();
		// boolean ifFileNotAvailable = false;
		int len1 = allFiles.length;
		return len1;
	}
	/*
	//Extra
	public static  class ExcelUtils 
	{

	    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	        Object[][] data = new Object[rowCount - 1][colCount];

	        for (int i = 1; i < rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = row.getCell(j);
	                data[i - 1][j] = cell.toString();
	            }
	        }
	        workbook.close();
	        return data;
	    }
	}
*/
}
