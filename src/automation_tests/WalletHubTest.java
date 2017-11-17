package automation_tests;

import wallethub_page_objects.HomePage;
import wallethub_page_objects.LoginPage;
import wallethub_page_objects.CompanyProfilePage;
import wallethub_page_objects.WriteReviewPage;
import wallethub_page_objects.UserProfilePage;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertTrue;


public class WalletHubTest {

    // Class variables.
    private static WebDriver driver = null;

    // Instance variables.
    private HomePage home_page;
    private LoginPage login_page;
    private CompanyProfilePage company_profile_page;
    private WriteReviewPage write_review_page;
    private UserProfilePage user_profile_page;

    // This method will run before each test in this class.
    @Before
    public void set_up() throws Exception {

        // Create an instance of the browser.
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();

        // Set implicit wait for each element.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open link in the browser.
        driver.get("https://wallethub.com");

        // Maximize the window of the browser.
        driver.manage().window().maximize();

        // Instantiation HomePage, NewsFeedPage and CompanyProfilePage classes.
        home_page = PageFactory.initElements(driver, HomePage.class);
        login_page = PageFactory.initElements(driver, LoginPage.class);
        company_profile_page = PageFactory.initElements(driver, CompanyProfilePage.class);
        write_review_page = PageFactory.initElements(driver, WriteReviewPage.class);
        user_profile_page = PageFactory.initElements(driver, UserProfilePage.class);

    }

    // This method will run after each test in this class.
    @After
    public void tear_down() throws Exception {

        // Close the browser.
        driver.quit();

    }

    // Method for testing ASSIGNMENT #2.
    @Test
    public void task_2() {

        // Go to Login page.
        home_page.goto_login_page();

        // Login to the WalletHub.
        login_page.login_to_wallethub("gfautotesting2@gmail.com", "k4m5ils423ng567nm7Z*");
        System.out.println("Test 2: User is successfully logged in.");

        // Wait for 3 seconds.
        try {

            Thread.sleep(3000);
        }
        catch(InterruptedException ex) {

            Thread.currentThread().interrupt();

        }

        // Open link in the browser.
        driver.get("http://wallethub.com/profile/test_insurance_company");

        // Wait for 3 seconds.
        try {

            Thread.sleep(3000);
        }
        catch(InterruptedException ex) {

            Thread.currentThread().interrupt();

        }

        // Redirect to the Write Review Page.
        company_profile_page.goto_write_review_page("5");

        // Wait for 3 seconds.
        try {

            Thread.sleep(3000);
        }
        catch(InterruptedException ex) {

            Thread.currentThread().interrupt();

        }

        // Submit a review.
        write_review_page.fill_form_and_submit("Health", "5","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        System.out.println("Test 2: Review is successfully submitted.");

        // Wait for 3 seconds.
        try {

            Thread.sleep(3000);
        }
        catch(InterruptedException ex) {

            Thread.currentThread().interrupt();

        }

        // Open link in the browser, where "ratmira" is username.
        driver.get("https://wallethub.com/profile/ratmira");

        assertTrue(user_profile_page.is_displayed_review_on_activity());
        System.out.println("Test 2: Review is displayed on the User Profile / Activity.");

        // Open link in the browser, where "ratmira" is username.
        driver.get("https://wallethub.com/profile/ratmira/reviews/");

        assertTrue(user_profile_page.is_displayed_review_on_reviews());
        System.out.println("Test 2: Review is displayed on the User Profile / Reviews.");

        // Wait for 3 seconds.
        try {

            Thread.sleep(3000);
        }
        catch(InterruptedException ex) {

            Thread.currentThread().interrupt();

        }

    }

}
