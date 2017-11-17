package automation_tests;

import facebook_page_objects.HomePage;
import facebook_page_objects.NewsFeedPage;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class FacebookTest {

    // Class variables.
    private static WebDriver driver = null;

    // Instance variables.
    private HomePage home_page;
    private NewsFeedPage news_feed_page;

    // This method will run before each test in this class.
    @Before
    public void set_up() throws Exception {

        // Create an instance of the browser.
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();

        // Set implicit wait for each element.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open link in the browser.
        driver.get("https://www.facebook.com");

        // Maximize the window of the browser.
        driver.manage().window().maximize();

        // Instantiation HomePage and NewsFeedPage classes.
        home_page = PageFactory.initElements(driver, HomePage.class);
        news_feed_page = PageFactory.initElements(driver, NewsFeedPage.class);

    }

    // This method will run after each test in this class.
    @After
    public void tear_down() throws Exception {

        // Close the browser.
        driver.quit();

    }

    // Method for testing ASSIGNMENT #1.
    @Test
    public void task_1() {

        // Login to the Facebook.
        home_page.login_to_facebook("gfautotesting2@gmail.com", "k4m5ils423ng567nm77i");
        System.out.println("Test 1: User is successfully logged in.");

        // Wait for 5 seconds.
        try {

            Thread.sleep(5000);
        }
        catch(InterruptedException ex) {

            Thread.currentThread().interrupt();

        }

        // Post a message on the news feed.
        news_feed_page.make_post("Hello world!");
        System.out.println("Test 1: Message is successfully posted.");

        // Wait for 5 seconds.
        try {

            Thread.sleep(5000);
        }
        catch(InterruptedException ex) {

            Thread.currentThread().interrupt();

        }

    }

}
