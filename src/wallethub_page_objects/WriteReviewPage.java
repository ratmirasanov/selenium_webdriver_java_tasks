package wallethub_page_objects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.JavascriptExecutor;


public class WriteReviewPage {

    // An instance of the browser.
    private final WebDriver driver;

    // Declaration of elements on the Write Review Page using annotations of PageFactory.
    @FindBy(how = How.CSS, using = ".dropdown-title")

    private WebElement policy_field;

    @FindAll(@FindBy(how = How.CSS, using = ".drop-el>li>a"))

    private List<WebElement> policies_links;

    @FindAll(@FindBy(how = How.CSS, using = "#overallRating>a"))

    private List<WebElement> rating_choices_links;

    @FindBy(how = How.ID, using = "review-content")

    private WebElement message_field;

    @FindBy(how = How.CSS, using = ".btn.blue")

    private WebElement submit_button;

    // This is a constructor.
    public WriteReviewPage(WebDriver driver) {

        this.driver = driver;

    }

    // Method for filling and submitting a form on the Write Review Page.
    public void fill_form_and_submit(String policy, String rating, String message) {

        // Hide "GET YOUR FREE CREDIT SCORE & REPORT" popup.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('footer_cta').removeAttribute('style');");

        select_policy(policy);

        // Wait for 1 seconds.
        try {

            Thread.sleep(1000);
        }
        catch(InterruptedException ex) {

            Thread.currentThread().interrupt();

        }

        select_needed_rating(rating);

        message_field.clear();
        message_field.sendKeys(message);

        submit_button.click();

    }

    // Method for selecting a needed policy.
    private void select_policy(String policy) {

        policy_field.click();

        for (WebElement link: policies_links) {

            if (link.getText().equals(policy)) {

                link.click();
                break;

            }

        }

    }

    // Method for selecting a needed rating.
    private void select_needed_rating(String rating) {

        rating_choices_links.get(Integer.parseInt(rating) - 1).click();

    }

}
