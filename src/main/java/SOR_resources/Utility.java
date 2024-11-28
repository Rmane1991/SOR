package SOR_resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
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
import org.testng.ITestResult;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

public class Utility {

	WebDriver driver;
	Actions act;

	public Utility(WebDriver driver) 
	{
		super();
		this.driver = driver;
		act = new Actions(driver);
	}

	public void pressEnter() {
		act.sendKeys(Keys.ENTER).build().perform();
	}

	public void pressUpKeys() {
		act.sendKeys(Keys.UP).build().perform();
	}

	public void moveToElementAndClick(WebElement ele)

	{
		act.moveToElement(ele).click().build().perform();
	}

	public void keypress(String a) {
		act.sendKeys(a).build().perform();
	}

	public void doubleClick() {
		act.doubleClick().build().perform();
	}

	public void moveToElementAndDoubleClick(WebElement ele) {
		act.moveToElement(ele).doubleClick().build().perform();
	}

	public void moveToElementAndContextClick(WebElement ele) {
		act.moveToElement(ele).contextClick().build().perform();
	}

	public void doubleClick(WebElement ele) {
		act.doubleClick(ele).build().perform();
	}

	public void contextClick(WebElement ele) {
		act.contextClick(ele).build().perform();
	}

	public void moveToElement(WebElement ele) {
		act.moveToElement(ele).perform();
	}

	public void Dropdown(By drp_Ele, String visible) {
		Select dropdown = new Select((WebElement) drp_Ele);
		dropdown.selectByVisibleText(visible);

	}

	public void Dropdownbytxt(WebElement cat, String visible) {
		Select dropdown = new Select(cat);
		dropdown.selectByVisibleText(visible);
	}

	public void Dropdownbyindex(WebElement cat, int visible) {
		Select dropdown = new Select(cat);
		dropdown.selectByIndex(visible);

	}

	public boolean isInvisible(WebElement Element, long tm) 
	{
		boolean isDisplayed = false;

		try 
		{
		    WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(tm));
		    wt.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(Element)));
		    isDisplayed = true;
		} catch (Exception e) 
		{
		    // e.printStackTrace();
		}

		return isDisplayed;
	}


	// For write message to excel with color like if (Pass-green) (Fail-red) 
	public void writeResultToExcel(String result, int rowNumber, int columnNumber) throws IOException {

		String filePath = "D:\\SOR_Data\\SOR_Test_Case.xlsx";
		// String filePath = "File path";

		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);

		Row row = sheet.getRow(rowNumber);
		if (row == null) {
			row = sheet.createRow(rowNumber);
		}

		Cell cell = row.getCell(columnNumber);
		if (cell == null) {
			cell = row.createCell(columnNumber);
		}

		cell.setCellValue(result);

		CellStyle style = workbook.createCellStyle();
		if ("Pass".equalsIgnoreCase(result)) 
		{
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		} 
		else if ("Fail".equalsIgnoreCase(result))
		{
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
		} 
		else if ("In-Process".equalsIgnoreCase(result))
		{
			style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		}
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);

		fis.close();
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
		workbook.close();
	}

	public boolean isDisaplyed(By Locator, WebDriver wd, long tm) {
		boolean isDisplayed = false;

		try {
			WebDriverWait wt = new WebDriverWait(wd, Duration.ofSeconds(tm));
			wt.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			isDisplayed = true;
		} catch (Exception e)

		{
			// e.printStackTrace();
		}

		return isDisplayed;
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
					// e.printStackTrace();
				} catch (IOException e) {
					// e.printStackTrace();
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
		}

		return isVisible;
	}

	public String getScreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	public boolean isDisaplyedW(WebElement Ele, long tm) {
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

	public boolean isClickable(WebElement WebElement, long tm) {

		boolean isClickable = false;

		try {

			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(3));
			wt.until(ExpectedConditions.elementToBeClickable(WebElement));
			isClickable = true;
		} catch (Exception e) {
		}
		return isClickable;
	}

	public boolean isClicked(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String currentTime() {
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		return timestamp;
	}

	public int ifFileAvailable() throws InterruptedException {
		File downloadedFilePath = new File(System.getProperty("user.dir") + "\\downloadFiles\\");

		File allFiles[] = downloadedFilePath.listFiles();
		int len1 = allFiles.length;
		return len1;
	}
	
	public static class ConsoleColor {
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

		public static void printColored(String message, String color) 
		{
			System.out.println(color + message + RESET);
			System.out.println(color +"-->>"+ RESET);
		}
	}
	
	 //For generate randam data
	static Random random = new Random();
	
	public  String generateRandomMobileNumber() 
	{
        
        int firstDigit = 6 + random.nextInt(4); 
        StringBuilder mobileNumber = new StringBuilder(String.valueOf(firstDigit));
        for (int i = 0; i < 9; i++) 
        {
            mobileNumber.append(random.nextInt(10)); 
        }
        return mobileNumber.toString();
    }

	
	public String generateRandomAccountNo() 
	{

		StringBuilder accountNo = new StringBuilder();

        // Ensure the first digit is non-zero
        accountNo.append(random.nextInt(9) + 1);

        // Generate the remaining 18 digits
        for (int i = 0; i < 18; i++) {
            accountNo.append(random.nextInt(10)); // Random digit between 0-9
        }

        return accountNo.toString();
    }
	
	
    // Method to generate a random name
    public String generateRandomName() 
    {
        String[] names = {"John", "Alice", "Bob", "Emma", "Raj", "Priya", "Alex", "Sara"};
        //Random random = new Random();
        return names[random.nextInt(names.length)] + "" + names[random.nextInt(names.length)];
    }

    // Method to generate a random PAN number (format: ABCDE1234F)
    public static String generateRandomPAN() {
        //Random random = new Random();
        StringBuilder pan = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            pan.append((char) ('A' + random.nextInt(26))); 
        }
        for (int i = 0; i < 4; i++) {
            pan.append(random.nextInt(10)); 
        }
        pan.append((char) ('A' + random.nextInt(26))); 
        return pan.toString();
    }
    
    
    
	public  String generateRandomPAN_Third_P() 
	{
        //Random random = new Random();
        StringBuilder pan = new StringBuilder();

        // Start with 'A' as the first character
        pan.append('A');

        // Generate the second and third random uppercase letters
        for (int i = 0; i < 2; i++) {
            pan.append((char) ('A' + random.nextInt(26)));
        }

        // Append 'P' as the fourth character
        pan.append('P');

        // Generate the fifth random uppercase letter
        pan.append((char) ('A' + random.nextInt(26)));

        // Generate the next four random digits
        for (int i = 0; i < 4; i++) {
            pan.append(random.nextInt(10));
        }

        // Append the final random uppercase letter
        pan.append((char) ('A' + random.nextInt(26)));

        return pan.toString();
    }


    // Method to generate a random Aadhar number (12 digits)
    public static String generateRandomAadhar() {
       // Random random = new Random();
        StringBuilder aadhar = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            aadhar.append(random.nextInt(10)); 
        }
        return aadhar.toString();
    }

 // Method to generate a random email ID based on the name
    public  String generateRandomEmail() {
        String[] domains = {"example.com", "test.com", "demo.com"};
        String randomName = generateRandomName(); // Generate random name
       // Random random = new Random();
        return randomName.toLowerCase().replace(" ", ".") + random.nextInt(100) + "@" + domains[random.nextInt(domains.length)];
    }
    
 
 // Write the random name to a specific cell in an existing Excel file
    public void writeNameToExcel(int rowNum, int cellNum, String name) 
    {
    	String filePath = "D:\\Workspace\\SOR\\src\\main\\java\\SOR_resources\\Test_Data.xlsx";
    	
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) 
        {

            Sheet sheet = workbook.getSheet("SOR_Login");
            if (sheet == null) {
                System.out.println("Sheet not found.");
                return;
            }

            Row row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum); // Create a new row if it doesn't exist
            }

            Cell cell = row.createCell(cellNum);
            cell.setCellValue(name); // Write the random name to the specified cell

            // Write the changes to the Excel file
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
                System.out.println("Random name written to cell (" + rowNum + ", " + cellNum + "): " + name);
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    // Method to generate alphanumeric codes that start with a letter and are 4 characters long
        public  String generateCode() {
            String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Define uppercase letters
            String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Define letters and digits

           // Random random = new Random();
            
            // First character should be a letter
            char firstChar = letters.charAt(random.nextInt(letters.length()));
            
            // Generate the remaining 3 characters (letters or digits)
            StringBuilder code = new StringBuilder();
            code.append(firstChar); // Append the first character (letter)
            for (int i = 0; i < 3; i++) 
            {
                code.append(alphanumeric.charAt(random.nextInt(alphanumeric.length())));
            }

            return code.toString(); // Return the final 4-character code
        }
        
        // Define fixed values for population groups
            private  final String[] POPULATION_GROUPS = {"Rural", "Urban", "Semi-Urban", "Metropolitan"};

            // Method to randomly select a population group
            public  String getRandomPopulationGroup() {
               // Random random = new Random();
                
                // Select a random index between 0 and the length of the POPULATION_GROUPS array
                int randomIndex = random.nextInt(POPULATION_GROUPS.length);
                
                // Return the population group at the random index
                return POPULATION_GROUPS[randomIndex];
            }
            
            
            public class TextFileLogger 
            {


                private static XWPFDocument document;
                private static FileOutputStream out;

                // Initialize the Word document
                public static void initializeLogger(String testCaseName) throws IOException 
                {
                	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
                    String dateTime = dtf.format(LocalDateTime.now());
                	String filePath=System.getProperty("user.dir")+"//Logs//" + testCaseName +"_"+ dateTime + ".docx";
                    document = new XWPFDocument();
                    out = new FileOutputStream(filePath);
                }

                // Log a message to the Word document
                public static void logMessage(String message) 
                {
                    XWPFParagraph paragraph = document.createParagraph();
                    XWPFRun run = paragraph.createRun();

                    // Add timestamp and log message
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    run.setText("[" + dtf.format(now) + "] " + message);
                }

                // Save and close the Word document
                public static void closeLogger() throws IOException {
                    document.write(out);
                    out.close();
                    document.close();
                    }
                }
            
    
            public void testCasename(ITestResult result) 
            {
				String r=result.getMethod().getMethodName();
				System.out.println(r);
			}
}
