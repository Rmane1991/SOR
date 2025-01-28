package SOR_resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;

public class BingAutomation {
    public static void main(String[] args) {
        // Path to your ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver with Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");  // Optional: maximize browser window
        WebDriver driver = new ChromeDriver(options);

        try {
            // Step 1: Navigate to Bing login page
            driver.get("https://login.live.com");

            // Step 2: Log in using your credentials
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116")));
            //emailInput.sendKeys("rmane565@gmail.com");
            emailInput.sendKeys("aakashsinghtomar55@gmail.com");

            driver.findElement(By.id("idSIButton9")).click();

            Thread.sleep(3000);
          //  driver.findElement(By.id("idA_PWD_SwitchToCredPicker")).click();
          //  driver.findElement(By.xpath("(//div[@data-testid='mainText'])[2]")).click();
            // Wait for password field
            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
            //passwordInput.sendKeys("Rmane@565");
            passwordInput.sendKeys("Aakash@22345");

            driver.findElement(By.id("idSIButton9")).click();
            
            /*
            WebElement Chkshowagain = driver.findElement(By.xpath("//input[@id='checkboxField']"));
            WebElement btn_accept = driver.findElement(By.xpath("//button[@id='acceptButton']"));
          
            
            if(Chkshowagain.isSelected())
            {
            	
            }
            
            else 
            {
            	Chkshowagain.click();
            	btn_accept.click();
            	
			}
	*/
            // Optional: Handle any two-factor authentication or security prompt
            // driver.findElement(By.id("idSIButton9")).click();

            // Wait for login to complete (check if the user is redirected to the Bing homepage)
          //  wait.until(ExpectedConditions.urlContains("bing.com"));

            // Step 3: Perform 90 searches with different queries
            List<String> searchQueries = getSearchQueries();

            for (int i = 0; i < 90; i++) {
                // Open the Bing search page
                driver.get("https://www.bing.com");

                // Wait for the search input to be visible
                WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

                // Perform the search using different queries
                searchInput.clear();
                searchInput.sendKeys(searchQueries.get(i));
                searchInput.submit();
                Thread.sleep(2000);                // Wait for the search results to load
               // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("b_algo")));

                // Optional: Add delays if needed to mimic real-user behavior
                Thread.sleep(2000);  // wait for 2 seconds between searches
            }

            System.out.println("Completed 90 searches.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static List<String> getSearchQueries()
{
        List<String> queries = new ArrayList<>();
        
        queries.add("How to improve Java programming skills?");
        queries.add("Top 10 programming languages in 2025");
        queries.add("Benefits of daily exercise");
        queries.add("What is artificial intelligence?");
        queries.add("Best ways to save money in 2025");
        queries.add("What are the latest trends in technology?");
        queries.add("How to create a website from scratch");
        queries.add("What is machine learning?");
        queries.add("How to stay productive while working from home");
        queries.add("Top destinations to visit in Europe");
        queries.add("How to prepare for a job interview");
        queries.add("What is the stock market?");
        queries.add("Top programming tutorials for beginners");
        queries.add("How to get a good night’s sleep");
        queries.add("What is blockchain technology?");
        queries.add("How to start a successful business");
        queries.add("Best books to read for personal development");
        queries.add("How to invest in real estate");
        queries.add("What is quantum computing?");
        queries.add("Best online learning platforms");
        queries.add("What is deep learning?");
        queries.add("How to learn a new language quickly");
        queries.add("Top freelancing opportunities in 2025");
        queries.add("How to improve your communication skills");
        queries.add("How does the internet work?");
        queries.add("What is cloud computing?");
        queries.add("How to develop mobile apps");
        queries.add("What are the top health benefits of meditation?");
        queries.add("How to become a web developer?");
        queries.add("Best productivity apps for 2025");
        queries.add("What are the dangers of smoking?");
        queries.add("How to create a personal budget");
        queries.add("What is cybersecurity?");
        queries.add("How to write a good resume");
        queries.add("Top 10 movies of 2025");
        queries.add("How to start a podcast");
        queries.add("Best programming languages to learn for 2025");
        queries.add("How to improve your memory");
        queries.add("How to make money online");
        queries.add("What is virtual reality?");
        queries.add("How to overcome procrastination");
        queries.add("What is renewable energy?");
        queries.add("How to build a successful career");
        queries.add("Top 10 podcasts to listen to in 2025");
        queries.add("How to become a better leader");
        queries.add("How does AI impact the job market?");
        queries.add("Best motivational quotes for 2025");
        queries.add("How to make better decisions");
        queries.add("What is the importance of mental health?");
        queries.add("How to use social media effectively");
        queries.add("How to improve your time management skills");
        queries.add("What is an NFT?");
        queries.add("How to get rid of stress");
        queries.add("Top 10 tech startups to watch in 2025");
        queries.add("How to get more followers on Instagram");
        queries.add("Best career tips for young professionals");
        queries.add("What is big data?");
        queries.add("How to create a business plan");
        queries.add("What is the best diet for weight loss?");
        queries.add("How to start a YouTube channel");
        queries.add("Best productivity strategies");
        queries.add("What is 5G technology?");
        queries.add("How to become an entrepreneur");
        queries.add("What are the best online courses for programming?");
        queries.add("How to take care of your skin");
        queries.add("What is the metaverse?");
        queries.add("How to increase your IQ");
        queries.add("Best online communities for developers");
        queries.add("How to network effectively");
        queries.add("What is Internet of Things (IoT)?");
        queries.add("How to develop critical thinking skills");
        queries.add("Best career options for 2025");
        queries.add("How to learn Python");
        queries.add("What is augmented reality?");
        queries.add("How to get your dream job");
        queries.add("Best free online tools for graphic design");
        queries.add("What is data science?");
        queries.add("How to write a book");
        queries.add("What is a smart home?");
        queries.add("Best tips for studying effectively");
        queries.add("How to start a successful YouTube channel");
        queries.add("What is a cryptocurrency?");
        queries.add("How to improve your leadership skills");
        queries.add("Top online business ideas");
        queries.add("What are the benefits of yoga?");
        queries.add("How to deal with anxiety");
        queries.add("Best gadgets for 2025");
        queries.add("How to make passive income");
        queries.add("What is self-care?");
        queries.add("How to negotiate salary effectively");
        queries.add("What is DevOps?");
        queries.add("How to boost creativity");
        queries.add("What is augmented reality vs virtual reality?");
        queries.add("How to increase sales in your business");
        queries.add("What is gamification?");
        queries.add("How to build a personal brand");
        queries.add("What is AI-powered automation?");
        queries.add("Best ways to improve focus");
        queries.add("How to get rid of bad habits");
        queries.add("What is a sustainable lifestyle?");
        queries.add("How to become a digital nomad");
        queries.add("What is SEO (Search Engine Optimization)?");
        queries.add("How to build an online business");
        queries.add("Best job search websites for 2025");
        queries.add("What is emotional intelligence?");
        queries.add("How to stay motivated in 2025");
        queries.add("What is UX/UI design?");
        queries.add("How to save for retirement");
        queries.add("How to take better photos");
        queries.add("What is a smart contract?");
        queries.add("How to get rid of social media addiction");
        queries.add("What is green technology?");
        queries.add("How to make the most of your morning");
        queries.add("What are soft skills?");
        queries.add("How to reduce your carbon footprint");
        queries.add("How to write a business proposal");
        return queries;
    }

}

