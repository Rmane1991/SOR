package SOR_testcases;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AppiumTest {
    public static void main(String[] args) throws MalformedURLException  
    {
        // Set desired capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "com.example.yourapp");
        caps.setCapability("appActivity", "com.example.yourapp.MainActivity");

        // Initialize AndroidDriver without type parameter and WebElement instead of MobileElement
        @SuppressWarnings("deprecation")
		URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, caps);

        // Your test logic here, for example, interacting with an element
        WebElement element = driver.findElement(By.id("elementId"));

        element.click();

        // Quit the driver
        driver.quit();
    }
}
