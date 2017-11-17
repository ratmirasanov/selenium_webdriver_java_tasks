package wallethub_page_objects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.JavascriptExecutor;


public class CompanyProfilePage {

    // An instance of the browser.
    private final WebDriver driver;

    // Declaration of elements on the Company Profile Page using annotations of PageFactory.
    @FindBy(how = How.CSS, using = ".wh-rating.rating_5")

    private WebElement rating_choices_field;

    @FindAll(@FindBy(how = How.CSS, using = ".wh-rating-choices-holder>a"))

    private List<WebElement> rating_choices_links;

    // This is a constructor.
    public CompanyProfilePage(WebDriver driver) {

        this.driver = driver;

    }

    // Method for opening Write Review Page on the Company Profile Page.
    public void goto_write_review_page(String rating) {

        // Hide "GET YOUR FREE CREDIT SCORE & REPORT" popup.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('footer_cta').removeAttribute('style');");

        // Hover under rating stars.
        Actions actions = new Actions(driver);
        actions.moveToElement(rating_choices_field);
        actions.build().perform();

        select_needed_rating(rating);

    }

    // Method for selecting a needed rating.
    private void select_needed_rating(String rating) {

        for (WebElement link: rating_choices_links) {

            if (link.getText().equals(rating)) {

                link.click();
                break;

            }

        }

    }

}
