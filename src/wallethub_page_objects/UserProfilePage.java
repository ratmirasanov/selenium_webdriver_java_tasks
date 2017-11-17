package wallethub_page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class UserProfilePage {

    // An instance of the browser.
    private final WebDriver driver;

    // Declaration of elements on the User Profile Page using annotations of PageFactory.
    @FindBy(how = How.CSS, using = ".activity.activity-first")

    private WebElement activity_post_field;

    @FindBy(how = How.CSS, using = ".reviews p")

    private WebElement reviews_post_field;

    // This is a constructor.
    public UserProfilePage(WebDriver driver) {

        this.driver = driver;

    }

    // Method for checking that added review is displayed on the User Profile Page / Activity.
    public boolean is_displayed_review_on_activity() {

        return activity_post_field.isDisplayed();

    }

    // Method for checking that added review is displayed on the User Profile Page / Reviews.
    public boolean is_displayed_review_on_reviews() {

        return reviews_post_field.isDisplayed();

    }

}
