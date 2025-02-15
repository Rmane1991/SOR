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
		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		// Initialize WebDriver with Chrome options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // Optional: maximize browser window
		WebDriver driver = new ChromeDriver(options);

		try {
			// Step 1: Navigate to Bing login page
			driver.get("https://login.live.com");

			// Step 2: Log in using your credentials
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116")));
			emailInput.sendKeys("rmane565@gmail.com");
			// emailInput.sendKeys("pratu9pandit@gmail.com");

			driver.findElement(By.id("idSIButton9")).click();

			Thread.sleep(3000);
			// driver.findElement(By.id("idA_PWD_SwitchToCredPicker")).click();
			// driver.findElement(By.xpath("(//div[@data-testid='mainText'])[2]")).click();
			// Wait for password field
			WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
			passwordInput.sendKeys("Rmane@565");
			// passwordInput.sendKeys("Pratu@999");

			driver.findElement(By.id("idSIButton9")).click();

			/*
			 * WebElement Chkshowagain =
			 * driver.findElement(By.xpath("//input[@id='checkboxField']")); WebElement
			 * btn_accept = driver.findElement(By.xpath("//button[@id='acceptButton']"));
			 * 
			 * 
			 * if(Chkshowagain.isSelected()) {
			 * 
			 * }
			 * 
			 * else { Chkshowagain.click(); btn_accept.click();
			 * 
			 * }
			 */
			// Optional: Handle any two-factor authentication or security prompt
			// driver.findElement(By.id("idSIButton9")).click();

			// Wait for login to complete (check if the user is redirected to the Bing
			// homepage)
			// wait.until(ExpectedConditions.urlContains("bing.com"));

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
				Thread.sleep(2000); // Wait for the search results to load
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("b_algo")));

				// Optional: Add delays if needed to mimic real-user behavior
				Thread.sleep(2000); // wait for 2 seconds between searches
			}

			System.out.println("Completed 90 searches.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

	private static List<String> getSearchQueries() {
		List<String> queries = new ArrayList<>();

		queries.add("How to enhance programming skills in Java?");
		queries.add("Top 10 programming languages to learn in 2025");
		queries.add("Health benefits of exercising every day");
		queries.add("Understanding artificial intelligence");
		queries.add("Smart money-saving strategies for 2025");
		queries.add("Current technology trends to watch out for");
		queries.add("A step-by-step guide to building a website");
		queries.add("Understanding the fundamentals of machine learning");
		queries.add("Tips for staying productive while working remotely");
		queries.add("Must-visit travel destinations in Europe in 2025");
		queries.add("How to ace a job interview?");
		queries.add("Basics of the stock market explained");
		queries.add("Best programming tutorials for absolute beginners");
		queries.add("Sleep hacks for better productivity");
		queries.add("How blockchain technology is changing the world");
		queries.add("Key steps to starting a successful business");
		queries.add("Books to read for personal growth and development");
		queries.add("Real estate investment tips for beginners");
		queries.add("What is quantum computing and how does it work?");
		queries.add("Top online platforms for self-paced learning");
		queries.add("Introduction to deep learning and its applications");
		queries.add("Quick tips to learn a new language faster");
		queries.add("High-demand freelancing opportunities in 2025");
		queries.add("Improving your communication skills for professional success");
		queries.add("How does the internet work in simple terms?");
		queries.add("Introduction to cloud computing");
		queries.add("Guide to mobile app development");
		queries.add("Health benefits of meditation for mental wellness");
		queries.add("How to start a career as a web developer?");
		queries.add("Best productivity apps for enhancing focus in 2025");
		queries.add("The dangers of smoking and how to quit");
		queries.add("Personal budgeting tips for better financial planning");
		queries.add("Understanding the concept of cybersecurity");
		queries.add("How to write a resume that stands out?");
		queries.add("Top 10 movies you shouldn't miss in 2025");
		queries.add("Step-by-step guide to starting a podcast");
		queries.add("Programming languages to focus on in 2025");
		queries.add("Tips for improving your memory retention");
		queries.add("How to generate income online with minimal effort");
		queries.add("Explaining the concept of virtual reality");
		queries.add("How to beat procrastination and stay on track");
		queries.add("Importance of renewable energy for sustainable living");
		queries.add("Building a successful career in today’s job market");
		queries.add("Top podcasts to enhance knowledge in 2025");
		queries.add("How to improve your leadership skills");
		queries.add("Impact of AI on the job market and career opportunities");
		queries.add("Motivational quotes for 2025 to kickstart your year");
		queries.add("Making better decisions in your personal and professional life");
		queries.add("Why mental health awareness is important");
		queries.add("Maximizing your social media presence effectively");
		queries.add("Time management tips to boost productivity");
		queries.add("What exactly is an NFT (Non-Fungible Token)?");
		queries.add("How to relieve stress effectively?");
		queries.add("Innovative tech startups to keep an eye on in 2025");
		queries.add("Growing your Instagram followers organically");
		queries.add("Essential career tips for young professionals");
		queries.add("What is big data and why is it important?");
		queries.add("How to write a business plan that attracts investors?");
		queries.add("Effective diets for sustainable weight loss");
		queries.add("How to create and grow a YouTube channel");
		queries.add("Top strategies for increasing productivity in daily tasks");
		queries.add("Explaining 5G technology and its potential");
		queries.add("Becoming an entrepreneur: Tips and resources");
		queries.add("Best online courses to master programming skills");
		queries.add("Skin care tips for a healthier complexion");
		queries.add("What is the metaverse and how does it work?");
		queries.add("How to boost your IQ and enhance cognitive abilities");
		queries.add("Top online communities for developers in 2025");
		queries.add("Effective networking strategies for career growth");
		queries.add("Understanding Internet of Things (IoT) and its impact");
		queries.add("Developing critical thinking for problem-solving");
		queries.add("Best career paths to consider in 2025");
		queries.add("Learning Python: A beginner's guide");
		queries.add("What is augmented reality and how it differs from VR?");
		queries.add("Steps to land your dream job in today’s market");
		queries.add("Best tools for graphic design in 2025");
		queries.add("Explaining data science and its significance");
		queries.add("How to write and publish a book?");
		queries.add("What are smart homes and their benefits?");
		queries.add("Study tips for effective learning and retention");
		queries.add("Building a successful YouTube career");
		queries.add("What is cryptocurrency and how does it work?");
		queries.add("Leadership skills for a successful career");
		queries.add("Best online business ideas to start in 2025");
		queries.add("The health benefits of yoga for mind and body");
		queries.add("Coping strategies for anxiety and stress");
		queries.add("Gadgets you must try in 2025");
		queries.add("Creating a source of passive income");
		queries.add("Importance of self-care and wellness routines");
		queries.add("How to negotiate your salary like a pro");
		queries.add("What is DevOps and its role in modern software development?");
		queries.add("Creative techniques to boost your creativity");
		queries.add("Differences between augmented reality and virtual reality");
		queries.add("Strategies to increase business sales and revenue");
		queries.add("Understanding gamification and its applications");
		queries.add("How to build a personal brand that stands out");
		queries.add("AI-powered automation and its impact on industries");
		queries.add("Ways to improve focus and concentration");
		queries.add("How to break free from bad habits");
		queries.add("Living a sustainable lifestyle for a better future");
		queries.add("Steps to become a digital nomad in 2025");
		queries.add("How SEO can boost your website’s ranking");
		queries.add("Tips for building a profitable online business");
		queries.add("Best job search websites in 2025 for career seekers");
		queries.add("Understanding emotional intelligence and its benefits");
		queries.add("Staying motivated in 2025: Tips for success");
		queries.add("What is UX/UI design and why does it matter?");
		queries.add("Planning your finances and saving for retirement");
		queries.add("Photography tips to capture better photos");
		queries.add("What are smart contracts and how do they work?");
		queries.add("How to reduce social media addiction and stay focused");
		queries.add("Benefits of green technology for the planet");
		queries.add("Optimizing your mornings for a productive day");
		queries.add("Understanding soft skills and their importance");
		queries.add("How to reduce your carbon footprint effectively");
		queries.add("Writing a business proposal that gets results");

		return queries;
	}

}
