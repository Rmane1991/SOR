package SOR_resources_Playwright;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Utility_PR {

    Page page;

    public Utility_PR(Page page)
    {
        this.page = page;
    }

    // Method to simulate Enter key press
    public void pressEnter() {
        page.keyboard().press("Enter");
    }

    // Method to simulate Arrow Up key press
    public void pressUpKeys() {
        page.keyboard().press("ArrowUp");
    }

    // Move to element and click
    public void moveToElementAndClick(String selector) {
        page.locator(selector).hover();
        page.locator(selector).click();
    }

    // Press specific keys
    public void keypress(String key) {
        page.keyboard().press(key);
    }

    // Double click on a locator
    public void doubleClick(String selector) {
        page.locator(selector).dblclick();
    }

    // Right-click on a locator
    public void contextClick(String selector) {
        page.locator(selector).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }

    // Move to element
    public void moveToElement(String selector) {
        page.locator(selector).hover();
    }

    
    public void dropdownByVisibleText(String selector, String visibleText) {
        Locator dropdown = page.locator(selector);
        dropdown.selectOption(new SelectOption().setLabel(visibleText));
    }

    
    public void dropdownByIndex(String selector, int index) {
        Locator dropdown = page.locator(selector);
        dropdown.selectOption(new SelectOption().setIndex(index));
    }

    // Check element visibility with timeout
    public boolean isVisible(String selector, long timeoutInSeconds) {
        try {
            page.locator(selector).waitFor(new Locator.WaitForOptions().setTimeout(timeoutInSeconds * 1000).setState(WaitForSelectorState.VISIBLE));
            return true;  // If waitFor() succeeds, the element is visible
        } catch (Exception e) {
            e.printStackTrace();
            return false;  // If an exception occurs, the element is not visible
        }
    }

    // Login method
    public void login(String url, String user, String pass) {
        page.navigate(url);
        page.locator("#UserName").fill(user);
        page.locator("input[name='Password']").fill(pass);
        page.locator("#btnLogin").click();
        System.out.println("Login Successful");
    }

    // Print message
    public static void print(Locator locator, String category, Integer no) {
        String text = locator.textContent();
        System.out.println(no + " : " + category + " " + text);
    }

    /*
    // URL checking for broken links
    public void checkUrl() {
        try {
            List<String> links = (List<String>) page.locator("//ul[@class='nav navbar-nav pull-right']//a").evaluateAll("els => els.map(e => e.href)");
            for (String url : links) {
                if (url.endsWith(".aspx")) {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("HEAD");
                    int responseCode = connection.getResponseCode();
                    if (responseCode >= 400) {
                        System.out.println(url + " is a broken link");
                    } else {
                        System.out.println(url + " is a valid link");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 */
    // Capture screenshot
    public String getScreenshot(String testCaseName) throws IOException {
        @SuppressWarnings("unused")
		byte[] screenshotBytes = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("reports/" + testCaseName + ".png")));
        return "reports/" + testCaseName + ".png";
    }

    // Check if element is clickable
    public boolean isClickable(String selector, long timeoutInSeconds) {
        try {
            page.locator(selector).waitFor(new Locator.WaitForOptions().setTimeout(timeoutInSeconds * 1000).setState(WaitForSelectorState.ATTACHED));
            page.locator(selector).click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Check if alert is present
    public boolean isAlertPresent() {
        try {
            page.waitForSelector("alert", new Page.WaitForSelectorOptions().setTimeout(5000));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Get the current timestamp
    public String currentTime() {
        return new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
    }

    // Check if files are available in a directory
    public int ifFileAvailable() {
        File downloadPath = new File(System.getProperty("user.dir") + "\\downloadFiles\\");
        File[] files = downloadPath.listFiles();
        return files != null ? files.length : 0;
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
    
    
}
