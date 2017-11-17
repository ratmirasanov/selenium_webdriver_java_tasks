package facebook_page_objects;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class NewsFeedPage {

    // An instance of the browser.
    private final WebDriver driver;

    // Declaration of elements on the News Feed Page using annotations of PageFactory.
    @FindBy(how = How.CSS, using = "._4bl9._42n-")

    private WebElement post_popup;

    @FindBy(how = How.CSS, using = "._1mf._1mj")

    private WebElement message_field;

    @FindBy(how = How.CSS, using = "._1mf7._4jy0._4jy3._4jy1._51sy.selected._42ft")

    private WebElement post_button;

    // This is a constructor.
    public NewsFeedPage(WebDriver driver) {

        this.driver = driver;

    }

    // Method for posting a message on the News Feed Page.
    public void make_post(String message) {

        // Click on the div element for appearing popup window.
        post_popup.click();

        // Fill in the "message" field.
        Actions actions = new Actions(driver);
        actions.moveToElement(message_field);
        actions.click();
        actions.sendKeys(message);
        actions.build().perform();

        // Click on the "post" button.
        post_button.click();

    }

}
